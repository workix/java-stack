package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.out.CompanyLogo;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */
@Stateless

@Path("/companies")
public class CompanyEndpoint extends BaseEndpoint {
	/*@PersistenceContext(unitName = "MySqlDS")
	private EntityManager em;*/

	@POST
	@Consumes("application/json")
	public Response create(Company entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(CompanyEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") long id) {
		Company entity = em.find(Company.class, id);
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
		TypedQuery<Company> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Company c WHERE c.id = :entityId ORDER BY c.id",
						Company.class);
		findByIdQuery.setParameter("entityId", id);
		Company entity;
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
	public List<Company> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Company> findAllQuery = em
				.createQuery("SELECT DISTINCT c FROM Company c ORDER BY c.id",
						Company.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Company> results = findAllQuery.getResultList();
		return results;
	}

	@GET
	@Path(value = "/logos")
	@Produces("application/json")
	public List<CompanyLogo> listRandomLogos(@QueryParam("start") Integer startPosition,
											 @QueryParam("max") Integer maxResult) {
		Query q = em.createNativeQuery("SELECT id,name,logo FROM companies ORDER BY RAND()");

		if (startPosition != null) {
			q.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			q.setMaxResults(maxResult);
		}

		final List<Object[]> rows = q.getResultList();
		List<CompanyLogo> results = new ArrayList<>();
		rows.stream().forEach(r -> results.add(new CompanyLogo(Long.parseLong(r[0].toString()), r[1].toString(), r[2].toString())) );
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") long id, Company entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id != entity.getId()) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Company.class, id) == null) {
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
