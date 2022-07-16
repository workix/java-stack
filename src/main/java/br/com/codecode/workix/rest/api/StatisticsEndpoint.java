package br.com.codecode.workix.rest.api;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jaxrs.interfaces.Authorize;
import br.com.codecode.workix.jpa.models.*;
import br.com.codecode.workix.rest.BaseEndpoint;
import br.com.codecode.workix.rest.dto.out.Statistic;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Stateless
@Path("/statistics")
public class StatisticsEndpoint extends BaseEndpoint {

    @Inject
    @Generic
    private Crud<Job> jobDao;

    @Inject
    @Generic
    private Crud<Company> companyDao;

    @Inject
    @Generic
    private Crud<Candidate> candidateDao;

    @Inject
    @Generic
    private Crud<Resume> resumeDao;

    @Authorize
    @GET
    @Produces("application/json")
    public Statistic listStats() {
        int counterJobs, counterCandidates, counterEmployeers, counterResumes;

        counterJobs = jobDao.countRegisters("jobs").intValue();

        counterEmployeers = companyDao.countRegisters("companies").intValue();

        counterCandidates = candidateDao.countRegisters("candidates").intValue();

        counterResumes = resumeDao.countRegisters("resumes").intValue();

        Statistic statistic = new Statistic(counterCandidates, counterJobs, counterResumes, counterEmployeers);
        return statistic;
    }

}
