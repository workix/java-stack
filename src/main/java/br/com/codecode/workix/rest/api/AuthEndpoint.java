package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.*;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.in.FirebaseAuthToken;
import br.com.codecode.workix.rest.dto.out.DefaultError;
import br.com.codecode.workix.rest.dto.out.JWTPayload;
import br.com.codecode.workix.rest.dto.out.JWTToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

@Stateless
@Path("/auth")
public class AuthEndpoint extends BaseEndpoint {
    @Inject
    private JwtParser jwtParser;

    @Inject
    private JwtBuilder jwtBuilder;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(FirebaseAuthToken firebaseAuthToken)
    {
        try{
            TypedQuery<User> findQuery = em.createQuery("SELECT DISTINCT u FROM User u WHERE u.firebaseUUID = :firebaseUUID AND u.email = :email ORDER BY u.id", User.class);
            findQuery.setParameter("firebaseUUID", firebaseAuthToken.firebaseUUID);
            findQuery.setParameter("email", firebaseAuthToken.email);

            User user = findQuery.getSingleResult();

                String jwtToken = jwtBuilder
                        .setId(user.getFirebaseUUID())
                        .setSubject(user.getEmail())
                        .compact();

                return Response.status(Response.Status.OK).entity(new JWTToken(jwtToken)).build();


        } catch(NoResultException ex) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new DefaultError("Dados de autenticação inválidos")).build();
        } catch (Exception ex){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new DefaultError(ex)).build();
        }
    }

    @GET
    @Path("/me")
    @Produces(MediaType.APPLICATION_JSON)
    public Response aboutMe(@Context HttpHeaders headers) {
        String authorization = headers.getRequestHeader("Authorization").get(0);
        String jwtToken = authorization.substring("Bearer".length()).trim();
        String jpqlCompany = "SELECT c FROM Company c LEFT JOIN FETCH c.user WHERE c.user.firebaseUUID = :fbUUID";
        String jpqlCandidate = "SELECT c FROM Candidate c LEFT JOIN FETCH c.user WHERE c.user.firebaseUUID = :fbUUID";

        Person entity;

        try {
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(jwtToken);

            TypedQuery<Company> findCompany = em.createQuery(jpqlCompany, Company.class);
            findCompany.setParameter("fbUUID", claimsJws.getBody().getId());

            try {
                entity = findCompany.getSingleResult();
            }catch (NoResultException ex){
                TypedQuery<Candidate> findCandidate = em.createQuery(jpqlCandidate, Candidate.class);
                findCandidate.setParameter("fbUUID", claimsJws.getBody().getId());
                entity = findCandidate.getSingleResult();
            }


            return Response.status(Response.Status.OK).entity(new JWTPayload(claimsJws.getBody(), entity)).build();
        }catch (Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }
    }
}
