package br.com.codecode.workix.jpa.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;
import br.com.codecode.workix.jaxrs.converter.LocalDateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Selective Process JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Observable
 * @see Observer
 * @see Traceable
 * @see Persistable
 * @see Serializable
 */
@Entity
@Table(name = "selective_processes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class SelectiveProcess extends Observable implements Observer, Traceable, Persistable, Serializable {
   
    private static final long serialVersionUID = -5336099006523168288L;

    @Column
    private boolean active;

    @JoinTable(name = "selective_processes_candidates",
	    joinColumns = @JoinColumn(name = "sp_id"), inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Candidate> candidates;

    @Column
    private LocalDateTime createdAt;

    @JsonSerialize
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Column
    private LocalDateTime disabledAt;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Column
    private LocalDateTime expire;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    private Job job;

    @Column(nullable = false)
    private int maxCandidates;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Column
    private LocalDateTime start;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Column
    private LocalDateTime updatedAt;

    @Column(updatable = false, nullable = false)
    private String uuid;

    public void addCandidate(Candidate candidate){
        if(this.candidates == null){
            this.candidates = new HashSet<>();
        }
        this.candidates.add(candidate);
    }

    public void removeCandidate(Candidate candidate){
        this.candidates.remove(candidate);
    }

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SelectiveProcess(){}

    public int countCandidates() {
	return maxCandidates - candidates.size();
    }

    private void countCandidates(Set<Candidate> collection) {
	maxCandidates = collection.size();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (!(obj instanceof SelectiveProcess)) {
	    return false;
	}
	SelectiveProcess other = (SelectiveProcess) obj;
	if (id != other.id) {
	    return false;
	}
	return true;
    }

    @Override
    public void generateUUID() {
	uuid = UUID.randomUUID().toString();
    }

    public Set<Candidate> getCandidates() {
	return this.candidates;
    }

    /**
     * @return the expire
     */
    public LocalDateTime getExpire() {
	return expire;
    }

    @Override
    public Long getId() {
	return this.id;
    }

    public Job getJob() {
	return this.job;
    }

    public int getMaxCandidates() {
	return maxCandidates;
    }

    /**
     * @return the start
     */
    public LocalDateTime getStart() {
	return start;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {
	this.addObserver(this);
	active = true;
	candidates = new HashSet<>();
    }

    @Override
    public void insertTimeStamp() {
	createdAt = LocalDateTime.now();
    }

    public boolean isActive() {
	return active;
    }

    private boolean isElegible() {
	System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
	System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
	return (candidates.size() < maxCandidates);
    }

    public boolean isInProcess(Candidate candidate) {
	System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)));
	return (candidates.contains(candidate));
    }

    private void notifyChanges() {
	notifyObservers();
	setChanged();
    }

    private void notifyChanges(Object object) {
	notifyObservers(object);
	setChanged();
    }

    @PrePersist
    @Override
    public void prepareToPersist() {
	Traceable.super.prepareToPersist();
    }

    public boolean registerCandidate(Candidate candidate) {

	boolean b = false;

	if ((isActive()) && (isElegible()) && (!isInProcess(candidate))) {

	    candidates.add(candidate);

	    System.out.println(candidate.getName() + " Registered with Success");

	    b = true;

	} else {

	    System.out.println(candidate.getName() + " Cannot Registered");

	    b = false;

        // throw new RuntimeException(candidate.getName() + " Cannot Registered");
	}

	notifyChanges(candidates);

	return b;

    }

    public void setActive(boolean active) {

	if (!active) {
	    disabledAt = LocalDateTime.now();
	}

	this.active = active;

	notifyChanges();
    }

    public void setCandidates(Set<Candidate> candidates) {
	this.candidates = candidates;
	notifyChanges();
    }

    /**
     * @param expire
     *            the expire to set
     */
    public void setExpire(LocalDateTime expire) {
	this.expire = expire;
    }

    @Override
    public void setId(Long id) {
	this.id = id;
    }

    public void setJob(final Job job) {
	this.job = job;
    }

    public void setMaxCandidates(int maxCandidates) {
	this.maxCandidates = maxCandidates;
    }

    /**
     * @param start
     *            the start to set
     */
    public void setStart(LocalDateTime start) {
	this.start = start;
    }

    @Override
    public void update(Observable observable, Object object) {

	if (observable instanceof SelectiveProcess) {

	    if (active == isElegible()) {
            if (object instanceof Collection<?>) {
                countCandidates((Set<Candidate>) object);
            }
	    } else {
		if (disabledAt != null)
		    System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
            throw new RuntimeException("Max candidates Reached - Disabled Process at " + disabledAt);
	    }

	}
    }

    @PreUpdate
    @Override
    public void updateTimeStamp() {
	updatedAt = LocalDateTime.now();
    }

}