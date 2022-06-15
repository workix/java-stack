package br.com.codecode.workix.dto;


import java.util.Date;

public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private Date birthDate;

    private Long id, cpf;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate(){}

    public Date getBirthDate() {
        return birthDate;
    }

    public Long getCpf() {
        return cpf;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
        birthDate = new Date();
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Candidate [id=" +
                id +
                ", cpf=" +
                cpf +
                ", birthDate=" +
                birthDate +
                "]" +
                " User [" +
                super.getUser().getEmail() +
                "]";
    }

}