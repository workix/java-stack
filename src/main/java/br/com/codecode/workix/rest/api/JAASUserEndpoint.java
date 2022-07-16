package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jaas.models.JAASUser;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.rest.BaseEndpoint;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * 
 */
@Stateless
@Path("/jaas_users")
public class JAASUserEndpoint extends BaseEndpoint {
	@Authorize
	@POST
	@Consumes("application/json")
	public Response create(JAASUser entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(JAASUserEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@Authorize
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		JAASUser entity = em.find(JAASUser.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@Authorize
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") long id) {
		TypedQuery<JAASUser> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT j FROM JAASUser j LEFT JOIN FETCH j.roles WHERE j.id = :entityId ORDER BY j.id",
						JAASUser.class);
		findByIdQuery.setParameter("entityId", id);
		JAASUser entity;
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

	@Authorize
	@GET
	@Produces("application/json")
	public List<JAASUser> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<JAASUser> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT j FROM JAASUser j LEFT JOIN FETCH j.roles ORDER BY j.id",
						JAASUser.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<JAASUser> results = findAllQuery.getResultList();
		return results;
	}

	@Authorize
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, JAASUser entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(JAASUser.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
