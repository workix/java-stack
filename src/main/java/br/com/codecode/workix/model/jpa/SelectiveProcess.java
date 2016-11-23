package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.model.interfaces.Persistable;
import br.com.codecode.workix.model.interfaces.Traceable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings({"unchecked","unused"})
@Table(name="Selective_Process")
@Entity
public class SelectiveProcess extends Observable implements Observer, Traceable, Persistable, Serializable{

	private static final long serialVersionUID = -5336099006523168288L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@XmlTransient
	@Version
	@Column
	private int version;

	@XmlTransient
	@Column(nullable = false)
	private String uuid;

	@XmlTransient	
	@Column	
	private Timestamp createdAt;

	@XmlTransient	
	@Column		
	private Timestamp updatedAt;

	@NotNull
	@ManyToOne(optional=false)
	private Job job;	

	@NotNull
	@JoinTable(name="Selective_Process_Candidates")
	@OneToMany(fetch = FetchType.EAGER)	
	private Set<Candidate> candidates;

	@Column
	private boolean active;	

	@Column
	private Timestamp disabledAt;

	@Min(1)
	@Column(nullable = false)
	private int maxCandidates;

	public SelectiveProcess() {
		configure();		
	}

	private void configure(){		
		this.addObserver(this);
		active = true;
		candidates = new HashSet<>();		
	}

	@Override
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	private int getVersion() {
		return this.version;
	}

	private void setVersion(final int version) {
		this.version = version;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectiveProcess other = (SelectiveProcess) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(final Job job) {
		this.job = job;
	}

	public Set<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
		notifyChanges();
	}

	public boolean isActive() {
		return active;
	}

	private void setActive(boolean active) {

		if(!active){
			disabledAt = Timestamp.from(Instant.now());
		}

		this.active = active;

		notifyChanges();
	}

	public int getMaxCandidates() {
		return maxCandidates;
	}

	public void setMaxCandidates(int maxCandidates) {
		this.maxCandidates = maxCandidates;
	}

	private boolean isElegible(){
		System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
		System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates+ "]");
		return (candidates.size() < maxCandidates);
	}

	public boolean isInProcess(Candidate candidate){
		System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)) );
		return (candidates.contains(candidate));
	}

	private void countCandidates(Set<Candidate> collection){		
		maxCandidates = collection.size();	
	}

	public int countCandidates(){
		return maxCandidates - candidates.size();
	}

	public boolean registerCandidate(Candidate candidate){

		boolean b = false;

		if((isActive()) && (isElegible()) && (!isInProcess(candidate))){

			candidates.add(candidate);			

			System.out.println(candidate.getName() + " Registered with Success");

			b = true;

		}else{

			System.out.println(candidate.getName() + " Cannot Registered");

			b = false;
		}

		notifyChanges(candidates);

		return b;

	}

	private void notifyChanges(){		
		notifyObservers();
		setChanged();
	}

	private void notifyChanges(Object object){		
		notifyObservers(object);
		setChanged();
	}

	@Override
	public String toString() {
		return "SelectiveProcess [active=" + active + ", maxCandidates=" + maxCandidates + "]";
	}

	@Override
	public void update(Observable observable, Object object) {	

		if(observable instanceof SelectiveProcess){			

			if(active = isElegible()){

				if(object instanceof Collection<?>){								

					countCandidates((Set<Candidate>) object);

				}

			}else{				
				if (disabledAt != null)
					System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
			}

		}
	}

	@PrePersist
	@Override
	public void prepareToPersist(){
		Traceable.super.prepareToPersist();	
	}	

	@Override
	public void generateUUID(){
		uuid = UUID.randomUUID().toString();
	}

	@Override
	public void insertTimeStamp(){
		createdAt = Timestamp.from(Instant.now());
	}

	@PreUpdate
	@Override
	public void updateTimeStamp(){
		updatedAt = Timestamp.from(Instant.now());
	}

}