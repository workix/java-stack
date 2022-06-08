package br.com.codecode.workix.jpa.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Subscriber JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 */
@Entity
@Table(name = "subscribers")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Subscriber extends MyEntity {

   
    private static final long serialVersionUID = 6675137603968146834L;

    private String email;

    private long id;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Subscriber(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate New Subscriber
     */
    public Subscriber(Builder builder) {	
	this.setEmail(builder.getEmail());
    }

    /**
     * Creates builder to build {@link Subscriber}.
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    /**
     * @return the email
     */
    @NotEmpty
    @Column
    public String getEmail() {
	return email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }


    /**
     * Builder NestedClass for {@link Subscriber}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see Subscriber
     */
    public final static class Builder extends Subscriber implements Buildable<Subscriber> {

	private static final long serialVersionUID = -7750971468814207111L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return a new Subscriber
	 */
	@Override
	public Subscriber build() {

	    return new Subscriber(this);
	}

	/**
	 * @param email
	 *            the email to set
	 * @return Builder
	 */
	public Builder withEmail(String email) {
	    this.setEmail(email);
	    return this;
	}	

    }

}
