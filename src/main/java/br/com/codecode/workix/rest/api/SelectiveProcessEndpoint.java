package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jpa.models.SelectiveProcess;
import br.com.codecode.workix.jsf.util.helper.Paginator;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.in.SubscribeCandidateJob;
import br.com.codecode.workix.rest.dto.in.SubscribeCandidateSP;
import br.com.codecode.workix.rest.dto.out.DefaultError;
import br.com.codecode.workix.rest.dto.out.PaginatedList;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
@Stateless
@Path("/selective_processes")
public class SelectiveProcessEndpoint extends BaseEndpoint {

	@Inject
	@Generic
	private Crud<SelectiveProcess> spDao;

	@Inject
	private JwtParser jwtParser;

	@Authorize
	@POST
	@Consumes("application/json")
	public Response create(SelectiveProcess entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(SelectiveProcessEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@Authorize
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		SelectiveProcess entity = em.find(SelectiveProcess.class, id);
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
		TypedQuery<SelectiveProcess> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SelectiveProcess s LEFT JOIN FETCH s.candidates LEFT JOIN FETCH s.job WHERE s.id = :entityId ORDER BY s.id",
						SelectiveProcess.class);
		findByIdQuery.setParameter("entityId", id);
		SelectiveProcess entity;
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
	public List<SelectiveProcess> listAll(
			@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<SelectiveProcess> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SelectiveProcess s LEFT JOIN FETCH s.candidates LEFT JOIN FETCH s.job ORDER BY s.id",
						SelectiveProcess.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<SelectiveProcess> results = findAllQuery.getResultList();
		return results;
	}

	@Authorize
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, SelectiveProcess entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(SelectiveProcess.class, id) == null) {
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
	@Path("/my_selective_processes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSelectiveProcess(@Context HttpHeaders headers) {
		String authorization = headers.getRequestHeader("Authorization").get(0);
		String jwtToken = authorization.substring("Bearer".length()).trim();
		Jws<Claims> claimsJws;
		try {
			claimsJws = jwtParser.parseClaimsJws(jwtToken);
		} catch (ExpiredJwtException ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
		}

		TypedQuery<SelectiveProcess> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT sp FROM SelectiveProcess sp LEFT JOIN FETCH sp.job  j LEFT JOIN FETCH j.company c JOIN FETCH c.user u WHERE u.firebaseUUID = :firebaseUUID ORDER BY j.id",
						SelectiveProcess.class);
		findByIdQuery.setParameter("firebaseUUID", claimsJws.getBody().getId());
		List<SelectiveProcess> sps;
		try {
			sps = findByIdQuery.getResultList();
		} catch (NoResultException nre) {
			sps = new ArrayList<>();
		}

		return Response.status(Status.OK).entity(sps).build();
	}

	@Authorize
	@GET
	@Path("/my_selective_processes_subscribed")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSelectiveProcessSubscribed(@Context HttpHeaders headers) {
		String authorization = headers.getRequestHeader("Authorization").get(0);
		String jwtToken = authorization.substring("Bearer".length()).trim();
		Jws<Claims> claimsJws;
		try {
			claimsJws = jwtParser.parseClaimsJws(jwtToken);
		} catch (ExpiredJwtException ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
		}

		TypedQuery<SelectiveProcess> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT sp FROM SelectiveProcess sp LEFT JOIN FETCH sp.job  j LEFT JOIN FETCH sp.candidates c JOIN FETCH c.user u WHERE u.firebaseUUID = :firebaseUUID ORDER BY j.id",
						SelectiveProcess.class);
		findByIdQuery.setParameter("firebaseUUID", claimsJws.getBody().getId());
		List<SelectiveProcess> sps;
		try {
			sps = findByIdQuery.getResultList();
		} catch (NoResultException nre) {
			sps = new ArrayList<>();
		}

		return Response.status(Status.OK).entity(sps).build();
	}

	@Authorize
	@POST
	@Path("/subscribe")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response subscribe(SubscribeCandidateSP subscribe) {
		SelectiveProcess sp = em.find(SelectiveProcess.class, subscribe.spId);

		if (sp == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		Candidate candidate = em.find(Candidate.class, subscribe.candidateId);

		if (candidate == null){
			return Response.status(Status.BAD_REQUEST).build();
		}

		boolean registered = sp.registerCandidate(candidate);

		if (registered){
			// sp.addCandidate(candidate);

			em.persist(sp);
		} else{
			return Response.status(Status.BAD_REQUEST)
					.entity(new DefaultError("Candidate not subscribed"))
					.build();
		}

		return Response.ok().entity(sp).build();
	}

	@Authorize
	@GET
	@Path("/paginated")
	@Produces("application/json")
	public PaginatedList<SelectiveProcess> listAllPaginated(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit) {

		BigInteger totalRows = spDao.countRegisters("selective_processes");

		Paginator paginator = new Paginator(limit, page, totalRows.intValue());

		int totalPages = paginator.getTotalPages();

		int start = paginator.getStart();

		int end = paginator.getEnd();

		List<SelectiveProcess> sps = spDao.listAll(start - 1, limit);

		PaginatedList<SelectiveProcess> paginatedList = new PaginatedList<>(sps, paginator.getStart(), paginator.getEnd(), paginator.getTotalPages(), paginator.getCurrentPage(), paginator.getLimitRows(), paginator.getMaxRows());

		return paginatedList;
	}

}
