package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.Form;
import br.com.codecode.workix.rest.BaseEndpoint;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Stateless
@Path("/forms")
public class FormEndpoint extends BaseEndpoint {

	@Authorize
    @POST
    @Consumes("application/json")
    public Response create(Form entity) {
        em.persist(entity);
        return Response.created(
                UriBuilder.fromResource(FormEndpoint.class)
                        .path(String.valueOf(entity.getId())).build()).build();
    }

    @Authorize
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") long id) {
        Form entity = em.find(Form.class, id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @Authorize
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Response findById(@PathParam("id") long id) {
        TypedQuery<Form> findByIdQuery = em
                .createQuery(
                        "SELECT DISTINCT f FROM Form f WHERE f.id = :entityId ORDER BY f.id",
                        Form.class);
        findByIdQuery.setParameter("entityId", id);
        Form entity;
        try {
            entity = findByIdQuery.getSingleResult();
        } catch (NoResultException nre) {
            entity = null;
        }
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }

    @Authorize
    @GET
    @Produces("application/json")
    public List<Form> listAll(@QueryParam("start") Integer startPosition,
                                    @QueryParam("max") Integer maxResult) {
        TypedQuery<Form> findAllQuery = em.createQuery(
                "SELECT DISTINCT f FROM Form f ORDER BY f.id",
                Form.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        final List<Form> results = findAllQuery.getResultList();
        return results;
    }

    @Authorize
    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    public Response update(@PathParam("id") long id, Form entity) {
        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (id != entity.getId()) {
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        }
        if (em.find(Form.class, id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
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
