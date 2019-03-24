package br.com.codecode.workix.rest.android;

import br.com.codecode.workix.config.JAXRSConfiguration;
import br.com.codecode.workix.core.common.jdk7.Token;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Contact;
import br.com.codecode.workix.jpa.models.Locale;
import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.rest.BaseEndpoint;
import io.swagger.annotations.*;

import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Date;

/**
 * Login JaxRs Endpoint
 *
 * @author felipe
 * @version 1.1
 * @see JAXRSConfiguration
 * @since 1.0
 */
@Api
@Path("login")
public class LoginEndpoint extends BaseEndpoint {

    @ApiOperation(
            value = "do a Login with firebase token",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Login with success",
                    response = Candidate.class,
                    responseHeaders = @ResponseHeader(name = "Location", description = "uri of login", response = String.class)),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = String.class,
                    responseHeaders = @ResponseHeader(name = "Location", description = "uri of login", response = String.class)),
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized",
                    response = String.class,
                    responseHeaders = @ResponseHeader(name = "Location", description = "uri of login", response = String.class))})
    @POST
    @Path("firebaselogin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response doLogin(@ApiParam(value = "Token", name = "token", required = true) Token token) {

        System.out.println("[doLogin]");

        System.out.println("[IN <--]");

        if (token == null) {

            return Response.status(Status.BAD_REQUEST).build();

        } else if ((token.getKey().equals("")) || (token.getKey().isEmpty())) {

            System.err.println("!!! Unauthorized !!!");

            return Response.status(Status.UNAUTHORIZED).build();

        }

        System.out.println(token);

        User user;

        try {

            user = em.createQuery("select u from User u where u.firebaseUUID=:firebaseUUID", User.class)
                    .setParameter("firebaseUUID", token.getKey()).getSingleResult();

        } catch (NoResultException nre) {

            user = null;

            System.err.println(nre);

        }

        if (user == null) {

            final String response = "{\"action\":\"rebuild\"}";

            System.err.println(response);

            return Response.ok(response).build();

        }

        Candidate candidate;

        try {

            candidate = em.createQuery("select c from Candidate c where c.user=:user", Candidate.class)
                    .setParameter("user", user).getSingleResult();

        } catch (NoResultException nre) {

            candidate = null;

            System.err.println(nre);

        }

        System.out.println("[OUT -->]");

        if (candidate == null) {

            candidate = new Candidate();

            candidate.setBirthDate(new Date());

            candidate.setUser(user);

            candidate.setLocale(new Locale());

            candidate.setContact(new Contact());

            System.out.println(candidate.toString());

            return Response.ok(candidate).build();

        }

        System.out.println(candidate.toString());

        return Response.ok(candidate).build();

    }

}
