package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.jpa.resultsqldto.ResumeWithCandidateShort;
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
import java.util.List;

/**
 * 
 */
@Stateless
@Path("/resumes")
public class ResumeEndpoint extends BaseEndpoint {

	@Inject
	@Generic
	private Crud<Resume> resumeDao;

	@POST
	@Consumes("application/json")
	public Response create(Resume entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(ResumeEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Resume entity = em.find(Resume.class, id);
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
		TypedQuery<Resume> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM Resume r LEFT JOIN FETCH r.candidate WHERE r.id = :entityId ORDER BY r.id",
						Resume.class);
		findByIdQuery.setParameter("entityId", id);
		Resume entity;
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
	public List<Resume> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Resume> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM Resume r LEFT JOIN FETCH r.candidate ORDER BY r.id",
						Resume.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Resume> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Resume entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Resume.class, id) == null) {
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
	@Path("/list_with_candidates_short")
	@Produces("application/json")
	public List<ResumeWithCandidateShort> listAllResumeWithCandidateShort(@QueryParam("start") Integer startPosition,
												  @QueryParam("max") Integer maxResult) {
		Query findAllQuery = em
				.createNamedQuery("ResumesWithCandidate");
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<ResumeWithCandidateShort> results = findAllQuery.getResultList();
		return results;
	}

	@GET
	@Path("/list_with_candidates_short_paginated")
	@Produces("application/json")
	public PaginatedList<ResumeWithCandidateShort> listAllResumeWithCandidateShortPaginated(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit) {

		BigInteger totalRows = resumeDao.countRegisters("resumes");

		Paginator paginator = new Paginator(limit, page, totalRows.intValue());

		int totalPages = paginator.getTotalPages();

		int start = paginator.getStart();

		int end = paginator.getEnd();

		Query findAllQuery = em.createNamedQuery("ResumesWithCandidate");

		List<ResumeWithCandidateShort> resumes = findAllQuery.setFirstResult(start -1).setMaxResults(end).getResultList();

		PaginatedList<ResumeWithCandidateShort> paginatedList = new PaginatedList<>(resumes,paginator.getStart(),paginator.getEnd(),paginator.getTotalPages(),paginator.getCurrentPage(),paginator.getLimitRows(),paginator.getMaxRows());


		return paginatedList;
	}
}
