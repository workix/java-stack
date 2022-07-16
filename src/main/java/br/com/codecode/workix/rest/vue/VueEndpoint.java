package br.com.codecode.workix.rest.vue;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.*;

import br.com.codecode.workix.rest.BaseEndpoint;

import br.com.codecode.workix.rest.dto.in.CreateCandidate;
import br.com.codecode.workix.rest.dto.in.CreateCompany;
import br.com.codecode.workix.rest.dto.in.UpdateCandidateCompany;
import br.com.codecode.workix.rest.dto.in.ValidateCPF;
import br.com.codecode.workix.rest.dto.out.*;
import br.com.codecode.workix.validation.CPFValidator;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Authorize
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

    @Authorize
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

    @Authorize
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

    @Authorize
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

    @Authorize
    @POST
    @Path("/create_or_update_job_by_token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrUpdateJob(@Context HttpHeaders headers, Job job) {

        String authorization = headers.getRequestHeader("Authorization").get(0);
        String jwtToken = authorization.substring("Bearer".length()).trim();
        Jws<Claims> claimsJws;
        try {
            claimsJws = jwtParser.parseClaimsJws(jwtToken);
        }catch (ExpiredJwtException ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }

        if (!claimsJws.getBody().getId().equals(job.getCompany().getUser().getFirebaseUUID()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        if(job.getId() == null){
            em.persist(job);
        } else {
            em.merge(job);
        }

        return Response.status(Response.Status.OK).entity(job).build();
    }

    @Authorize
    @POST
    @Path("/create_or_update_sp_by_token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrUpdateSP(@Context HttpHeaders headers, SelectiveProcess sp) {

        String authorization = headers.getRequestHeader("Authorization").get(0);
        String jwtToken = authorization.substring("Bearer".length()).trim();
        Jws<Claims> claimsJws;
        try {
            claimsJws = jwtParser.parseClaimsJws(jwtToken);
        }catch (ExpiredJwtException ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(new DefaultError(ex)).build();
        }

        if (!claimsJws.getBody().getId().equals(sp.getJob().getCompany().getUser().getFirebaseUUID()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        if(sp.getId() == null){
            em.persist(sp);
        } else {
            em.merge(sp);
        }

        return Response.status(Response.Status.OK).entity(sp).build();
    }

    @Authorize
    @POST
    @Path("/validate_cpf")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateCPF(ValidateCPF validateCPF) {

        boolean isValid = CPFValidator.validate(validateCPF.cpf);

        return Response.ok().entity(new Valid(isValid)).build();
    }
}
