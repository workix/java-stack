package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.Comment;
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
@Path("/comments")
public class CommentEndpoint extends BaseEndpoint {

	@POST
	@Consumes("application/json")
	public Response create(Comment entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(CommentEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Comment entity = em.find(Comment.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") long id) {
		TypedQuery<Comment> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Comment c WHERE c.id = :entityId ORDER BY c.id",
						Comment.class);
		findByIdQuery.setParameter("entityId", id);
		Comment entity;
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
	@Produces("application/json")
	public List<Comment> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Comment> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Comment c ORDER BY c.id",
						Comment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Comment> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Comment entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Comment.class, id) == null) {
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

	@GET
	@Path("/recents")
	@Produces("application/json")
	public List<Comment> listAllRecents(@QueryParam("start") Integer startPosition,
								 @QueryParam("max") Integer maxResult) {
		TypedQuery<Comment> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Comment c ORDER BY c.createdAt DESC",
						Comment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Comment> results = findAllQuery.getResultList();
		return results;
	}
}
