package br.com.codecode.workix.rest.dto.out;

import br.com.codecode.workix.jpa.models.Company;

public class CompanyCreated {
    public Company company;
    public JWTToken jwt;

    public CompanyCreated(Company company, JWTToken token) {
        this.company = company;
        this.jwt = token;
    }
}
