package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;

import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jsf.util.helper.Paginator;
import br.com.codecode.workix.rest.BaseEndpoint;
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
@Path("/jobs")
public class JobEndpoint extends BaseEndpoint {

	@Inject
	@Generic
	private Crud<Job> jobDao;
	@POST
	@Consumes("application/json")
	public Response create(Job entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(JobEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Job entity = em.find(Job.class, id);
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
		TypedQuery<Job> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT j FROM Job j LEFT JOIN FETCH j.company WHERE j.id = :entityId ORDER BY j.id",
						Job.class);
		findByIdQuery.setParameter("entityId", id);
		Job entity;
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
	public List<Job> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Job> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT j FROM Job j LEFT JOIN FETCH j.company ORDER BY j.id",
						Job.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Job> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Job entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Job.class, id) == null) {
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
	@Path(value = "/feature")
	@Produces("application/json")
	public List<Job> listAllWithFeature(@QueryParam("start") Integer startPosition,
							 @QueryParam("max") Integer maxResult, @QueryParam("feature") boolean feature) {
		String sql;

		if(feature){
			sql = "SELECT DISTINCT j FROM Job j LEFT JOIN FETCH j.company WHERE j.feature = true ORDER BY j.id";
		}else{
			sql = "SELECT DISTINCT j FROM Job j LEFT JOIN FETCH j.company ORDER BY j.id";
		}

		TypedQuery<Job> findAllQuery = em.createQuery(sql, Job.class);

		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Job> results = findAllQuery.getResultList();
		return results;
	}

	@GET
	@Path(value = "/random_featured")
	@Produces("application/json")
	public Job getRandomFeature() {
		String sql = "SELECT j FROM Job j LEFT JOIN FETCH j.company WHERE j.feature = true ORDER BY RAND()";

		TypedQuery<Job> findQuery = em.createQuery(sql, Job.class);

		final List<Job> result = findQuery.setMaxResults(1).getResultList();
		return result.get(0);
	}

	@GET
	@Path("/company/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public List<Job> findByCompanyId(@PathParam("id") long id) {
		TypedQuery<Job> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT j FROM Job j LEFT JOIN FETCH j.company WHERE j.company.id = :companyId ORDER BY j.id",
						Job.class);
		findByIdQuery.setParameter("companyId", id);
		List<Job> entities;
		try {
			entities = findByIdQuery.getResultList();
		} catch (NoResultException nre) {
			entities = new ArrayList<>();
		}

		return entities;
	}

	@GET
	@Path("/paginated")
	@Produces("application/json")
	public PaginatedList<Job> listAllPaginated(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit) {

		BigInteger totalRows = jobDao.countRegisters("jobs");

		Paginator paginator = new Paginator(limit, page, totalRows.intValue());

		int totalPages = paginator.getTotalPages();

		int start = paginator.getStart();

		int end = paginator.getEnd();

		List<Job> jobs = jobDao.listAll(start - 1, limit);

		PaginatedList<Job> paginatedList = new PaginatedList<>(jobs,paginator.getStart(),paginator.getEnd(),paginator.getTotalPages(),paginator.getCurrentPage(),paginator.getLimitRows(),paginator.getMaxRows());

		return paginatedList;
	}
}
