package br.com.codecode.workix.rest.vue;

import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.api.JobEndpoint;
import br.com.codecode.workix.rest.dto.in.CreateCandidate;
import br.com.codecode.workix.rest.dto.out.CandidateCreated;
import br.com.codecode.workix.rest.dto.out.DefaultError;
import br.com.codecode.workix.rest.dto.out.JWTToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Stateless
@Path("/vue")
public class VueEndpoint extends BaseEndpoint {

    private final String CHAVE = "ABCDEFGHIJ123456789ABCDEFGHIJ123456789ABCDEFGHIJ123456789ABCDEFGHIJ123456789";

    @POST
    @Path("/create_candidate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCandidate(CreateCandidate entity) {

        try {
            User u = User.builder()
                    .withEmail(entity.email)
                    .withActive(true)
                    .withFirebaseUUID(entity.firebaseUUID)
                    .build();

            em.persist(u);

            Candidate c = new Candidate();
            c.setBirthDate(Date.from(entity.birthDate.atZone(ZoneId.systemDefault()).toInstant()));
            c.setName(entity.name);
            c.setCpf(entity.cpf);
            c.setUser(u);
            em.persist(c);

            SecretKey key = Keys.hmacShaKeyFor(CHAVE.getBytes(StandardCharsets.UTF_8));

            String jwtToken = Jwts.builder()
                    .setId(u.getFirebaseUUID())
                    .setSubject(u.getEmail())
                    .setIssuer("localhost:8080")
                    .setIssuedAt(new Date())
                    .setExpiration(
                            Date.from(
                                    LocalDateTime.now().plusMinutes(15L)
                                            .atZone(ZoneId.systemDefault())
                                            .toInstant()))
                    .signWith(key).compact();

            return Response.status(Response.Status.CREATED).entity(new CandidateCreated(c, new JWTToken(jwtToken))).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }
    }
}
