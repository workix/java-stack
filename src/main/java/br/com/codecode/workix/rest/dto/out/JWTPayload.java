package br.com.codecode.workix.rest.dto.out;

import br.com.codecode.workix.jpa.models.Person;
import io.jsonwebtoken.Claims;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JWTPayload {
    public String jti;
    public String sub;
    public String iss;
    public LocalDateTime iat;
    public LocalDateTime exp;
    public String type;
    public Person owner;



    public JWTPayload(Claims body, Person owner) {
        this.jti = body.getId();
        this.sub = body.getSubject();
        this.iss = body.getIssuer();
        this.iat = body.getIssuedAt().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        this.exp = body.getExpiration().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        this.type = owner.getClass().getSimpleName();
        this.owner = owner;
    }
}
