package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Email;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.resultsqldto.CandidateResume;
import br.com.codecode.workix.rest.BaseEndpoint;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("/candidates")
public class CandidateEndpoint extends BaseEndpoint {

	@Inject
	@Push
	private Notification pushNotification;

	@Inject
	@Email
	private Notification mailNotification;

	@Authorize
	@POST
	@Consumes("application/json")
	public Response create(Candidate entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(CandidateEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@Authorize
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Candidate entity = em.find(Candidate.class, id);
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
		TypedQuery<Candidate> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Candidate c WHERE c.id = :entityId ORDER BY c.id",
						Candidate.class);
		findByIdQuery.setParameter("entityId", id);
		Candidate entity;
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
	public List<Candidate> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Candidate> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Candidate c ORDER BY c.id",
				Candidate.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Candidate> results = findAllQuery.getResultList();
		return results;
	}

	@Authorize
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Candidate entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Candidate.class, id) == null) {
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
	@Path("/short_list")
	@Produces("application/json")
	public List<CandidateResume> listAllCandidateResume(@QueryParam("start") Integer startPosition,
								   @QueryParam("max") Integer maxResult) {
		Query findAllQuery = em.createNativeQuery(
				"SELECT c.id, c.name, r.objective FROM candidates c INNER JOIN resumes r ON c.id = r.candidate_id ORDER BY c.id", "CandidateResumeResult"
				);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<CandidateResume> results = findAllQuery.getResultList();
		return results;
	}

	@Authorize
	@POST
	@Path("notify")
	@Consumes("application/json")
	public Response notify(br.com.codecode.workix.rest.dto.in.Notification entity) {
		if (entity.type.equals("mail")){
			mailNotification.doSendMessage(entity.user, entity.title, entity.message);
		} else if (entity.type.equals("push")){
			pushNotification.doSendMessage(entity.user, entity.title, entity.message);
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}

		return Response.ok().build();
	}
}
