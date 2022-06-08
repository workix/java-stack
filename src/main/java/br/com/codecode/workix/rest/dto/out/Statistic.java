package br.com.codecode.workix.rest.dto.out;

public class Statistic {
    public int members;
    public int jobs;
    public int resumes;
    public int companies;

    public Statistic(int members, int jobs, int resumes, int companies) {
        this.members = members;
        this.jobs = jobs;
        this.resumes = resumes;
        this.companies = companies;
    }
}
