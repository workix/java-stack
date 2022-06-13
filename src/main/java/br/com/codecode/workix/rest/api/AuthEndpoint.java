package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.in.FirebaseAuthToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    private final String CHAVE = "TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpIGVsaXQsIHNlZCBlaXVzbW9kIHRlbXBvciBpbmNpZHVudCB1dCBsYWJvcmUgZXQgZG9sb3JlIG1hZ25hIGFsaXF1YS4gVXQgZW5pbSBhZCBtaW5pbSB2ZW5pYW0sIHF1aXMgbm9zdHJ1bSBleGVyY2l0YXRpb25lbSB1bGxhbSBjb3Jwb3JpcyBzdXNjaXBpdCBsYWJvcmlvc2FtLCBuaXNpIHV0IGFsaXF1aWQgZXggZWEgY29tbW9kaSBjb25zZXF1YXR1ci4gUXVpcyBhdXRlIGl1cmUgcmVwcmVoZW5kZXJpdCBpbiB2b2x1cHRhdGUgdmVsaXQgZXNzZSBjaWxsdW0gZG9sb3JlIGV1IGZ1Z2lhdCBudWxsYSBwYXJpYXR1ci4gRXhjZXB0ZXVyIHNpbnQgb2JjYWVjYXQgY3VwaWRpdGF0IG5vbiBwcm9pZGVudCwgc3VudCBpbiBjdWxwYSBxdWkgb2ZmaWNpYSBkZXNlcnVudCBtb2xsaXQgYW5pbSBpZCBlc3QgbGFib3J1bS4=";

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(FirebaseAuthToken firebaseAuthToken)
    {
        try{
            if(
                    firebaseAuthToken.email.equals("frmichetti@gmail.com")
                    &&
                    firebaseAuthToken.firebaseMessageToken.equals("123456789")
                    &&
                    firebaseAuthToken.firebaseUUID.equals("123456789")
            )
            {
                SecretKey key = Keys.hmacShaKeyFor(CHAVE.getBytes(StandardCharsets.UTF_8));

                String jwtToken = Jwts.builder()
                        .setSubject(firebaseAuthToken.email)
                        .setIssuer("localhost:8080")
                        .setIssuedAt(new Date())
                        .setExpiration(
                                Date.from(
                                        LocalDateTime.now().plusMinutes(15L)
                                                .atZone(ZoneId.systemDefault())
                                                .toInstant()))
                        .signWith(key).compact();

                return Response.status(Response.Status.OK).entity(jwtToken).build();
            }
            else
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Dados de autenticação inválidos").build();
        }
        catch(Exception ex)
        {
            return Response.status(
                            Response.Status.INTERNAL_SERVER_ERROR
                    ).entity(ex.getMessage())
                    .build();
        }
    }
}
