package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.in.FirebaseAuthToken;
import br.com.codecode.workix.rest.dto.out.DefaultError;
import br.com.codecode.workix.rest.dto.out.JWTPayload;
import br.com.codecode.workix.rest.dto.out.JWTToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.ejb.Stateless;
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
    private final String CHAVE = "ABCDEFGHIJ123456789ABCDEFGHIJ123456789ABCDEFGHIJ123456789ABCDEFGHIJ123456789";

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

                SecretKey key = Keys.hmacShaKeyFor(CHAVE.getBytes(StandardCharsets.UTF_8));

                String jwtToken = Jwts.builder()
                        .setId(user.getFirebaseUUID())
                        .setSubject(user.getEmail())
                        .setIssuer("localhost:8080")
                        .setIssuedAt(new Date())
                        .setExpiration(
                                Date.from(
                                        LocalDateTime.now().plusMinutes(15L)
                                                .atZone(ZoneId.systemDefault())
                                                .toInstant()))
                        .signWith(key).compact();

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
        SecretKey key = Keys.hmacShaKeyFor(CHAVE.getBytes(StandardCharsets.UTF_8));

        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken);

            return Response.status(Response.Status.OK).entity(new JWTPayload(claimsJws.getBody())).build();
        }catch (Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }
    }
}
