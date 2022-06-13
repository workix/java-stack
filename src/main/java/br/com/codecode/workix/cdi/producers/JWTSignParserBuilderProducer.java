package br.com.codecode.workix.cdi.producers;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@ApplicationScoped
public class JWTSignParserBuilderProducer {
    private final String CHAVE = "ABCDEFGHIJ123456789ABCDEFGHIJ123456789ABCDEFGHIJ123456789ABCDEFGHIJ123456789";
    private final SecretKey key = Keys.hmacShaKeyFor(CHAVE.getBytes(StandardCharsets.UTF_8));

    @Produces
    @RequestScoped
    @Factory
    @Default
    public JwtBuilder getJwtSignBuilder() {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuer("localhost:8080")
                .setIssuedAt(new Date())
                .setExpiration(
                        Date.from(
                                LocalDateTime.now().plusMinutes(15L)
                                        .atZone(ZoneId.systemDefault())
                                        .toInstant()))
                .signWith(key);

        return jwtBuilder;
    }

    @Produces
    @RequestScoped
    @Factory
    @Default
    public JwtParser getJwtParserBuilder(){
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        return  jwtParser;
    }
}
