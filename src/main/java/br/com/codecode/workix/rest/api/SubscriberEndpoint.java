package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.Subscriber;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.out.Subscribe;

import javax.ejb.Stateless;
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
@Path("/subscribers")
public class SubscriberEndpoint extends BaseEndpoint {

	@POST
	@Consumes("application/json")
	public Response create(Subscriber entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(SubscriberEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Subscriber entity = em.find(Subscriber.class, id);
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
		TypedQuery<Subscriber> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM Subscriber s WHERE s.id = :entityId ORDER BY s.id",
						Subscriber.class);
		findByIdQuery.setParameter("entityId", id);
		Subscriber entity;
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
	public List<Subscriber> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Subscriber> findAllQuery = em.createQuery(
				"SELECT DISTINCT s FROM Subscriber s ORDER BY s.id",
				Subscriber.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Subscriber> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Subscriber entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Subscriber.class, id) == null) {
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

	@POST
	@Path("/subscribe")
	@Consumes("application/json")
	@Produces("application/json")
	public Subscribe subscribe(Subscriber entity) {
		Subscribe subscribe;
		Query selectID = em.createNativeQuery("SELECT id FROM subscribers WHERE email = :email")
				.setParameter("email", entity.getEmail());
		try {
			BigInteger singleResult = (BigInteger) selectID.getSingleResult();
			if (singleResult != null) {
				entity.setId(singleResult.longValue());
				em.remove(em.getReference(Subscriber.class, entity.getId()));
				subscribe = new Subscribe(false, entity.getEmail() + " foi desinscrito com sucesso!");
			} else{
				em.persist(entity);
				subscribe = new Subscribe(true, entity.getEmail() + " foi inscrito com sucesso!");
			}
		}catch (NoResultException e){
			em.persist(entity);
			subscribe = new Subscribe(true, entity.getEmail() + " foi inscrito com sucesso!");
		}

		return subscribe;
	}
}
