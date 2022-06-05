package br.com.codecode.workix.rest.android;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.config.JAXRSConfiguration;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.jpa.models.User;

/**
 * This Class is a Simple StandAlone Endpoint for Android Uses
 * 
 * @see JAXRSConfiguration
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Stateless
@Path("save")
public class SaveOrUpdateEndpoint {

    @Inject
    private Event<User> alertNewUser;

    @Inject
    @Generic
    private Crud<User> daoUser;

    @Inject
    @Generic
    private Crud<Candidate> daoCandidate;

    @Inject
    @Generic
    private Crud<Resume> daoResume;

    @Path("user")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(User user) {

	try {

	    user = daoUser.saveOrUpdate(user);

	    alertNewUser.fire(user);

	} catch (IllegalArgumentException e) {

	    e.printStackTrace();

	    return Response.status(Status.INTERNAL_SERVER_ERROR).build();

	} catch (NotImplementedYetException e) {

	    e.printStackTrace();

	    return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	return Response.ok(user).build();
    }

    @Path("candidate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Candidate candidate) {

	try {

	    candidate = daoCandidate.saveOrUpdate(candidate);

	} catch (IllegalArgumentException e) {

	    e.printStackTrace();

	    return Response.status(Status.INTERNAL_SERVER_ERROR).build();

	} catch (NotImplementedYetException e) {

	    e.printStackTrace();

	    return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	return Response.ok(candidate).build();
    }

    @Path("resume")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Resume resume) {

	try {

	    resume = daoResume.saveOrUpdate(resume);

	} catch (IllegalArgumentException e) {

	    e.printStackTrace();

	    return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	} catch (NotImplementedYetException e) {

	    e.printStackTrace();

	    return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	return Response.ok(resume).build();
    }

}
