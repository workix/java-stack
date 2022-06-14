package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;

import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.out.DefaultError;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * 
 */
@Stateless
@Path("/users")
public class UserEndpoint extends BaseEndpoint {

	@Inject
	@Generic
	private Crud<User> userDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		try {
			userDao.save(entity);
		} catch (Exception ex){
			return Response.status(Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
		}
		return Response.status(Status.CREATED).entity(entity).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("id") long id) {
		try {
			userDao.deleteById(id);
		} catch (IllegalArgumentException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (NotImplementedYetException e){
			return Response.status(Status.NOT_IMPLEMENTED).entity(new DefaultError(e)).build();
		}
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") long id) {
		User entity;
		try {
			entity = userDao.findByIdOrdened(id);
		} catch (NoResultException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (NotImplementedYetException e){
			return Response.status(Status.NOT_IMPLEMENTED).entity(new DefaultError(e)).build();
		}
		return Response.ok(entity).build();
	}
	// @Authorize
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {

		final List<User> results = userDao.listAll(startPosition, maxResult);
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") long id, User entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		try {
			if (userDao.findById(id) == null) {
				return Response.status(Status.NOT_FOUND).build();
			}
			entity = userDao.update(entity);
		} catch (NotImplementedYetException e) {
			return Response.status(Status.NOT_IMPLEMENTED).entity(new DefaultError(e)).build();
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.ok(entity).build();
	}
}
