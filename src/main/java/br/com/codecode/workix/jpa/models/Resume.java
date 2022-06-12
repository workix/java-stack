package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.jpa.resultsqldto.CandidateResume;
import br.com.codecode.workix.jpa.resultsqldto.ResumeWithCandidateShort;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Resume JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 */
@Entity
@Table(name = "resumes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
@SqlResultSetMapping(name="ResumeWithCandidateShortResult",
		classes={
				@ConstructorResult(
						targetClass= ResumeWithCandidateShort.class,
						columns={
								@ColumnResult(name="id", type=Long.class),
								@ColumnResult(name="objective", type = String.class),
								@ColumnResult(name = "carrerLevel", type = Integer.class),
								@ColumnResult(name = "presence", type = Integer.class),
								@ColumnResult(name = "candidateId", type = Long.class),
								@ColumnResult(name="name", type=String.class),
								})})
@NamedNativeQuery(
		name="ResumesWithCandidate",
		query="SELECT r.id, r.objective, r.carrerLevel, r.presence , c.id as candidateId, c.name FROM resumes r INNER JOIN candidates c on r.candidate_id = c.id ORDER BY r.id",
		resultSetMapping = "ResumeWithCandidateShortResult")
public class Resume extends MyEntity {
   
    private static final long serialVersionUID = 7569771700044121495L;

	private CarrerLevel carrerLevel;

	private Presence presence;

	/**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    private Candidate candidate;

    /**
     * One {@link Resume} To Many {@link Education}
     */
    private Set<Education> educations;

    /**
     * One {@link Resume} To Many {@link Experience}
     */
    private Set<Experience> experiences;

    private long id;

    private String objective, content;

    /**
     * One {@link Resume} To Many {@link Skill}
     */    
    private Set<Skill> skills;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Resume() {}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Resume
     */
    private Resume(Builder builder) {	
	this.candidate = builder.getCandidate();
	this.objective = builder.getObjective();
	this.content = builder.getContent();
	this.experiences = builder.getExperiences();
	this.educations = builder.getEducations();
	this.skills = builder.getSkills();
    }

    /**
     * Creates builder to build {@link Resume}.
     * @return created builder
     */
    public static Builder builder() {
	return new Builder();
    }

    public void addEducation(Education education) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations.add(education);
    }

    public void addExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.add(experience);
    }

    public void addSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.add(skill);

    }
	@Enumerated(EnumType.ORDINAL)
	@Column
	public CarrerLevel getCarrerLevel() {
		return carrerLevel;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column
	public Presence getPresence() {
		return presence;
	}


	@OneToOne(fetch = FetchType.EAGER, optional = false)
    public Candidate getCandidate() {
	return candidate;
    }

	@Lob
	@Column
    public String getContent() {
	return content;
    }

	public void setCarrerLevel(CarrerLevel carrerLevel) {
		this.carrerLevel = carrerLevel;
	}

	public void setPresence(Presence presence) {
		this.presence = presence;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "resumes_educations", joinColumns = @JoinColumn(name = "id"))
    public Set<Education> getEducations() {
	return educations;
    }

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "resumes_experiences", joinColumns = @JoinColumn(name = "id"))
    public Set<Experience> getExperiences() {
	return experiences;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	@Override
    public long getId() {
	return this.id;
    }

	@Column
	public String getObjective() {
	return objective;
    }

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "resumes_skills", joinColumns = @JoinColumn(name = "id"))
    public Set<Skill> getSkills() {
	return skills;
    }

	/**
	 * Initialize Fields for CDI Injection
	 */
	@PostConstruct
	private void init() {
		educations = new HashSet<>();
		experiences = new HashSet<>();
		skills = new HashSet<>();
	}

    public void removeEducation(Education education) {
	this.educations.remove(education);
    }

    public void removeExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.remove(experience);
    }

    public void removeSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.remove(skill);
    }

    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setEducations(Set<Education> educations) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations = educations;
    }

    public void setExperiences(Set<Experience> experiences) {
	this.experiences = experiences;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    public void setObjective(String objective) {
	this.objective = objective;
    }

    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }

    /**
     * Builder to build {@link Resume}.
     */    
    public static final class Builder extends Resume implements Buildable<Resume>{

	private static final long serialVersionUID = -5218494421810694002L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return a new Resume
	 */
	@Override
	public Resume build() {
	    return new Resume(this);
	}

	public Builder withCandidate(Candidate candidate) {
	    super.candidate = candidate;
	    return this;
	}

	public Builder withContent(String content) {
	    super.content = content;
	    return this;
	}

	public Builder withEducations(Set<Education> educations) {
	    super.educations = educations;
	    return this;
	}

	public Builder withExperiences(Set<Experience> experiences) {
	    super.experiences = experiences;
	    return this;
	}	

	public Builder withObjective(String objective) {
	    super.objective = objective;
	    return this;
	}

	public Builder withSkills(Set<Skill> skills) {
	    super.skills = skills;
	    return this;
	}
    }

}