package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.out.DefaultError;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * 
 */
@Stateless
@Path("/users")
public class UserEndpoint extends BaseEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		try {
			em.persist(entity);
		} catch (Exception ex){
			return Response.status(Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
		}
		return Response.status(Status.CREATED).entity(entity).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		User entity = em.find(User.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") long id) {
		TypedQuery<User> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT u FROM User u WHERE u.id = :entityId ORDER BY u.id",
						User.class);
		findByIdQuery.setParameter("entityId", id);
		User entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<User> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<User> results = findAllQuery.getResultList();
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
		if (em.find(User.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.ok(entity).build();
	}
}
