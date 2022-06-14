package br.com.codecode.workix.rest.dto.in;

import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Company;

public class UpdateCandidateCompany {
    public Candidate candidate;
    public Company company;
}
