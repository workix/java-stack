package br.com.codecode.workix.rest.dto.out;

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


    public JWTPayload(Claims body) {
        this.jti = body.getId();
        this.sub = body.getSubject();
        this.iss = body.getIssuer();
        this.iat = body.getIssuedAt().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        this.exp = body.getExpiration().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();;
    }
}
