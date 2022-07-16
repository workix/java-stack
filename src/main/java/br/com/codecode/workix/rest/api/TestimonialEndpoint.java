package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.Testimonial;
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
@Path("/testimonials")
public class TestimonialEndpoint extends BaseEndpoint {

	@Authorize
	@POST
	@Consumes("application/json")
	public Response create(Testimonial entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(TestimonialEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@Authorize
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Testimonial entity = em.find(Testimonial.class, id);
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
		TypedQuery<Testimonial> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT t FROM Testimonial t LEFT JOIN FETCH t.author WHERE t.id = :entityId ORDER BY t.id",
						Testimonial.class);
		findByIdQuery.setParameter("entityId", id);
		Testimonial entity;
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
	public List<Testimonial> listAll(
			@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Testimonial> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT t FROM Testimonial t LEFT JOIN FETCH t.author ORDER BY t.id",
						Testimonial.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Testimonial> results = findAllQuery.getResultList();
		return results;
	}

	@Authorize
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Testimonial entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Testimonial.class, id) == null) {
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
