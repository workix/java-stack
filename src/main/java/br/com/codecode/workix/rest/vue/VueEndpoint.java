package br.com.codecode.workix.rest.vue;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.models.*;

import br.com.codecode.workix.rest.BaseEndpoint;

import br.com.codecode.workix.rest.dto.in.CreateCandidate;
import br.com.codecode.workix.rest.dto.in.CreateCompany;
import br.com.codecode.workix.rest.dto.in.UpdateCandidateCompany;
import br.com.codecode.workix.rest.dto.out.CandidateCreated;
import br.com.codecode.workix.rest.dto.out.CompanyCreated;
import br.com.codecode.workix.rest.dto.out.DefaultError;
import br.com.codecode.workix.rest.dto.out.JWTToken;
import io.jsonwebtoken.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Stateless
@Path("/vue")
public class VueEndpoint extends BaseEndpoint {

    @Inject
    private JwtBuilder jwtBuilder;

    @Inject
    private JwtParser jwtParser;

    @Inject
    @Persist
    private Crud<User> userDao;

    @Inject
    @Generic
    private Crud<Candidate> candidateDao;

    @Inject
    @Generic
    private Crud<Company> companyDao;

    @POST
    @Path("/create_candidate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCandidate(CreateCandidate entity) {

        try {
            User u = User.builder()
                    .withEmail(entity.email)
                    .withActive(true)
                    .withFirebaseUUID(entity.firebaseUUID)
                    .build();

            userDao.save(u);

            Candidate c = new Candidate();
            c.setBirthDate(entity.birthDate.toLocalDate());
            c.setName(entity.name);
            c.setCpf(entity.cpf);
            c.setUser(u);

            candidateDao.save(c);

            String jwtToken = jwtBuilder
                    .setId(u.getFirebaseUUID())
                    .setSubject(u.getEmail())
                    .compact();

            return Response.status(Response.Status.CREATED).entity(new CandidateCreated(c, new JWTToken(jwtToken))).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }
    }

    @POST
    @Path("/create_company")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompany(CreateCompany entity) {
        try {
            User u = User.builder()
                    .withEmail(entity.email)
                    .withActive(true)
                    .withFirebaseUUID(entity.firebaseUUID)
                    .build();

            userDao.save(u);

            Company c = Company.builder().withCnpj(entity.cnpj).withName(entity.name).withUser(u).build();

            companyDao.save(c);

            String jwtToken = jwtBuilder
                    .setId(u.getFirebaseUUID())
                    .setSubject(u.getEmail())
                    .compact();

            return Response.status(Response.Status.CREATED).entity(new CompanyCreated(c, new JWTToken(jwtToken))).build();

        }catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }
    }

    @PUT
    @Path("/update_by_token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Context HttpHeaders headers, UpdateCandidateCompany updateCandidateCompany) {

        String authorization = headers.getRequestHeader("Authorization").get(0);
        String jwtToken = authorization.substring("Bearer".length()).trim();
        Jws<Claims> claimsJws;
        try {
            claimsJws = jwtParser.parseClaimsJws(jwtToken);
        }catch (ExpiredJwtException ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }

        Person entity;

        if(updateCandidateCompany.candidate != null){
            entity = updateCandidateCompany.candidate;
        } else if (updateCandidateCompany.company != null) {
            entity = updateCandidateCompany.company;
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (entity == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!claimsJws.getBody().getId().equals(entity.getUser().getFirebaseUUID()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        if(entity.getClass() == Candidate.class){
            if (em.find(Candidate.class, entity.getId()) == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }else {
            if (em.find(Company.class, entity.getId()) == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }

        try {
            User user = em.merge(entity.getUser());
            entity = em.merge(entity);
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new DefaultError(e)).build();
        }

        return Response.status(Response.Status.OK).entity(entity).build();
    }

    @POST
    @Path("/create_or_update_resume_by_token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrUpdateResume(@Context HttpHeaders headers, Resume resume) {

        String authorization = headers.getRequestHeader("Authorization").get(0);
        String jwtToken = authorization.substring("Bearer".length()).trim();
        Jws<Claims> claimsJws;
        try {
            claimsJws = jwtParser.parseClaimsJws(jwtToken);
        }catch (ExpiredJwtException ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }

        if (!claimsJws.getBody().getId().equals(resume.getCandidate().getUser().getFirebaseUUID()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        if(resume.getId() == null){
            em.persist(resume);
        } else {
            em.merge(resume);
        }

        return Response.status(Response.Status.OK).entity(resume).build();
    }
}
