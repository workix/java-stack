package br.com.codecode.workix.jpa.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.jaxrs.converter.LocalDateAdapter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Experience JPA Embeddable
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Experience implements Serializable {

    private static final long serialVersionUID = -6311235469498858665L;

    private String description;

    private String employerName;

    private LocalDate endDate;

    private String jobTitle;

    private LocalDate startDate;

	private String responsibilities;
	
	@Column
	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	/**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Experience(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Experience
     */
    public Experience(Builder builder) {

	this.employerName = builder.getEmployerName();

	this.jobTitle = builder.getJobTitle();

	this.startDate = builder.getStartDate();

	this.endDate = builder.getEndDate();

    }

    /**
     * Creates builder to build {@link Experience}.
     * @return created builder
     */
    @JsonIgnore
    public static Builder builder() {
	return new Builder();
    }

    @Lob
    @Column
    public String getDescription() {
	return description;
    }

    @Column(name="employer_name")
    public String getEmployerName() {
	return employerName;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @Column(name="end_date")    
    public LocalDate getEndDate() {
	return endDate;
    }

    @Column(name="job_title")
    public String getJobTitle() {
	return jobTitle;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @Column(name="start_date")
    public LocalDate getStartDate() {
	return startDate;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setEmployerName(String employerName) {
	this.employerName = employerName;
    }

    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }

    public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
    }

    public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
    }

    /**
     * Builder NestedClass for {@link Experience}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see Experience
     */
    public final static class Builder extends Experience implements Buildable<Experience> {

	private static final long serialVersionUID = -1322208401535756846L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}	

	/**
	 * @return Return a new Experience
	 */
	@Override
	public Experience build() {

	    return new Experience(this);
	}

	/**
	 * @param description
	 *            the description to set
	 * @return Builder
	 */
	public Builder withDescription(String description) {
	    this.setDescription(description);
	    return this;
	}

	/**
	 * @param employerName
	 *            the employerName to set
	 * @return Builder
	 */
	public Builder withEmployerName(String employerName) {
	    this.setEmployerName(employerName);
	    return this;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 * @return Builder
	 */
	public Builder withEndDate(LocalDate endDate) {
	    this.setEndDate(endDate);
	    return this;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 * @return Builder
	 */
	public Builder withJobTitle(String jobTitle) {
	    this.setJobTitle(jobTitle);
	    return this;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 * @return Builder
	 */
	public Builder withStartDate(LocalDate startDate) {
	    this.setStartDate(startDate);
	    return this;
	}

    }

}
