package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.resultsqldto.CandidateResume;

/**
 * Candidate JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 * @see Person
 * @author felipe
 * @see Person
 * @since 1.0
 * @version 1.1
 */
@Entity
@Table(name = "candidates")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
@SqlResultSetMapping(name="CandidateResumeResult",
        classes={
                @ConstructorResult(
                        targetClass= CandidateResume.class,
                        columns={
                                @ColumnResult(name="id", type=Long.class),
                                @ColumnResult(name="name", type=String.class),
                                @ColumnResult(name="objective", type = String.class)})})
public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private LocalDate birthDate;

    private Long id, cpf;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate(){}


    @Column(nullable = false, name = "birth_date")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Column(nullable = false, unique = true)
    public Long getCpf() {
        return cpf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {

    }

    public void setBirthDate(LocalDate birthDate) {
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