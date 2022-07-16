package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Skill JPA Embeddable
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
public class Skill implements Serializable {
   
    private static final long serialVersionUID = -5975419980185059163L;

    private String skillName;

	private Integer months;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Skill(){}
	
    @Column
	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	/**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Skill
     */
    public Skill(Builder builder) {
	this.setSkillName(builder.getSkillName());
    }

    /**
     * Creates builder to build {@link Skill}.
     * @return created builder
     */    
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    /**
     * @return the Skill Name
     */
    @Column(name="skill_name")
    public String getSkillName() {
	return this.skillName;
    }

    /**
     * @param skillName
     *            the Skill Name to set
     */
    public void setSkillName(String skillName) {
	this.skillName = skillName;
    }


    /**
     * Builder NestedClass for {@link Skill}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see Skill
     */
    public final static class Builder extends Skill implements Buildable<Skill> {

	private static final long serialVersionUID = -2784926262850261658L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * Return a new Skill
	 */
	@Override
	public Skill build() {
	    return new Skill(this);
	}

	/**
	 * @param skillName
	 *            the skillName to set
	 * @return Builder
	 */
	public Builder withSkillName(String skillName) {
	    this.setSkillName(skillName);
	    return this;
	}

    }

}
