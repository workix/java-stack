package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.Blog;

import br.com.codecode.workix.jsf.util.helper.Paginator;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.out.BlogTimePeriod;
import br.com.codecode.workix.rest.dto.out.PaginatedList;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
@Stateless

@Path("/blogs")
public class BlogEndpoint extends BaseEndpoint {

	@Inject
	@Generic
	private Crud<Blog> blogDao;

	@Authorize
	@POST
	@Consumes("application/json")
	public Response create(Blog entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(BlogEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@Authorize
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

	@Authorize
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

	@Authorize
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

	@Authorize
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

	@Authorize
	@GET
	@Path("/categories")
	@Produces("application/json")
	public List<String> listAllCategories() {
		Query nativeQuery = em.createNativeQuery("SELECT DISTINCT category FROM blogs_categories bc");

		final List<String> results = nativeQuery.getResultList();
		return results;
	}

	@Authorize
	@GET
	@Path("/time_periods")
	@Produces("application/json")
	public List<BlogTimePeriod> listTimePeriods() {
		Query nativeQuery = em.createNativeQuery("SELECT EXTRACT(YEAR FROM (b.created_at)) as year, EXTRACT(MONTH FROM(b.created_at)) as month from blogs b GROUP BY EXTRACT(YEAR FROM(b.created_at)), EXTRACT(MONTH FROM(b.created_at));");

		final List<Object[]> rows = nativeQuery.getResultList();

		ArrayList<BlogTimePeriod> blogTimePeriods = new ArrayList<>();

		rows.stream().forEach(r -> blogTimePeriods.add(new BlogTimePeriod(Integer.parseInt(r[0].toString()), Integer.parseInt(r[1].toString()))));
		return blogTimePeriods;
	}

	@Authorize
	@GET
	@Path("/recents")
	@Produces("application/json")
	public List<Blog> listAllRecents(@QueryParam("start") Integer startPosition,
							  @QueryParam("max") Integer maxResult) {
		TypedQuery<Blog> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT b FROM Blog b LEFT JOIN FETCH b.author ORDER BY b.createdAt DESC",
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

	@Authorize
	@GET
	@Path("/paginated")
	@Produces("application/json")
	public PaginatedList<Blog> listAllPaginated(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit) {

		BigInteger totalRows = blogDao.countRegisters("blogs");

		Paginator paginator = new Paginator(limit, page, totalRows.intValue());

		int totalPages = paginator.getTotalPages();

		int start = paginator.getStart();

		int end = paginator.getEnd();

		List<Blog> blogs = blogDao.listAll(start - 1, limit);

		PaginatedList<Blog> paginatedList = new PaginatedList<>(blogs,paginator.getStart(),paginator.getEnd(),paginator.getTotalPages(),paginator.getCurrentPage(),paginator.getLimitRows(),paginator.getMaxRows());

		return paginatedList;
	}
}
