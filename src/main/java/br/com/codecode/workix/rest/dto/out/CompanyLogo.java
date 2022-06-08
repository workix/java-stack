package br.com.codecode.workix.rest.dto.out;

public class CompanyLogo {
    public long id;
    public String name;
    public String logo;

    public CompanyLogo(long id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }
}
