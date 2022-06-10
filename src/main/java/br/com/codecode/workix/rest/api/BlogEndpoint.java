package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.Blog;
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

@Path("/blogs")
public class BlogEndpoint extends BaseEndpoint {
	/*@PersistenceContext(unitName = "MySqlDS")
	private EntityManager em;*/

	@POST
	@Consumes("application/json")
	public Response create(Blog entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(BlogEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Blog entity = em.find(Blog.class, id);
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
		TypedQuery<Blog> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT b FROM Blog b LEFT JOIN FETCH b.author WHERE b.id = :entityId ORDER BY b.id",
						Blog.class);
		findByIdQuery.setParameter("entityId", id);
		Blog entity;
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
	public List<Blog> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Blog> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT b FROM Blog b LEFT JOIN FETCH b.author ORDER BY b.id",
						Blog.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Blog> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Blog entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Blog.class, id) == null) {
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
	@Path("/categories")
	@Produces("application/json")
	public List<String> listAllCategories() {
		Query nativeQuery = em.createNativeQuery("SELECT DISTINCT category FROM blogs b");

		final List<String> results = nativeQuery.getResultList();
		return results;
	}
}
