package br.com.codecode.workix.rest.vue;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Company;

import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.rest.BaseEndpoint;

import br.com.codecode.workix.rest.dto.in.CreateCandidate;
import br.com.codecode.workix.rest.dto.in.CreateCompany;
import br.com.codecode.workix.rest.dto.out.CandidateCreated;
import br.com.codecode.workix.rest.dto.out.CompanyCreated;
import br.com.codecode.workix.rest.dto.out.DefaultError;
import br.com.codecode.workix.rest.dto.out.JWTToken;
import io.jsonwebtoken.JwtBuilder;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.time.ZoneId;
import java.util.Date;

@Stateless
@Path("/vue")
public class VueEndpoint extends BaseEndpoint {

    @Inject
    private JwtBuilder jwtBuilder;

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
            c.setBirthDate(Date.from(entity.birthDate.atZone(ZoneId.systemDefault()).toInstant()));
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
}
