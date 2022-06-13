package br.com.codecode.workix.rest.dto.out;

import br.com.codecode.workix.jpa.models.Candidate;

public class CandidateCreated {
    public Candidate candidate;
    public JWTToken jwt;

    public CandidateCreated(Candidate candidate, JWTToken token) {
        this.candidate = candidate;
        this.jwt = token;
    }
}
