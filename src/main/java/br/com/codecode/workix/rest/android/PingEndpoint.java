package br.com.codecode.workix.rest.android;

import br.com.codecode.workix.config.JAXRSConfiguration;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Ping JaxRs Endpoint
 * 
 * @see JAXRSConfiguration
 * @author felipe
 * @since 1.1
 * @version 1.1
 */

@Path("ping")
public class PingEndpoint {

    @POST
    @Path("test")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    @Produces(MediaType.APPLICATION_JSON)
    public Response doTest(String string) {
	
	System.out.println(string);

	if (string == null || string.isEmpty()) {

	    return Response.status(Status.BAD_REQUEST).build(); 

	}
	
	return Response.ok(string).build();

    }
}    
