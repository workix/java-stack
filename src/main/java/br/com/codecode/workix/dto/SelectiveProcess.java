package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;

import java.io.Serializable;
import java.util.*;

public class SelectiveProcess extends Observable implements Observer, Traceable, Persistable, Serializable {

    private static final long serialVersionUID = -5336099006523168288L;

    private boolean active;

    private Set<Candidate> candidates;

    private Date disabledAt;

    private Date expire;

    private Long id;

    private Job job;

    private int maxCandidates;

    private Date start;

    private int version;

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
        String uuid = UUID.randomUUID().toString();
    }

    public Set<Candidate> getCandidates() {
        return this.candidates;
    }

    /**
     * @return the expire
     */
    public Date getExpire() {
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
    public Date getStart() {
        return start;
    }

    protected int getVersion() {
        return this.version;
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
    private void init() {
        this.addObserver(this);
        active = true;
        candidates = new HashSet<>();
    }

    @Override
    public void insertTimeStamp() {
        Date createdAt = new Date();
    }

    public boolean isActive() {
        return active;
    }

    private boolean isElegible() {
        System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
        System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
        return (candidates.size() < maxCandidates);
    }

    private boolean isInProcess(Candidate candidate) {
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
        }

        notifyChanges(candidates);

        return b;

    }

    public void setActive(boolean active) {

        if (!active) {
            disabledAt = new Date();
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
    public void setExpire(Date expire) {
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
    public void setStart(Date start) {
        this.start = start;
    }

    protected void setVersion(final int version) {
        this.version = version;
    }

    @Override
    public void update(Observable observable, Object object) {

        if (observable instanceof SelectiveProcess) {

            if (active = isElegible()) {

                if (object instanceof Collection<?>) {

                    countCandidates((Set<Candidate>) object);

                }

            } else {
                if (disabledAt != null)
                    System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
            }

        }
    }

    @Override
    public void updateTimeStamp() {
        Date updatedAt = new Date();
    }

}