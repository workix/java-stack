package br.com.codecode.workix.jpa.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.interfaces.Persistable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Comment JPA with Inherited Fields and Methods
 * 
 * @see MyEntity
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Comment extends MyEntity implements Persistable {
   
    private static final long serialVersionUID = 7358996279677908814L;


    private String email;    

    private long id;

    private String name;

    private String text;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Comment(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Comment
     */
    private Comment(Builder builder) {	
	this.email = builder.getEmail();
	this.name = builder.getName();
	this.text = builder.getText();
    }

    /**
     * Creates builder to build {@link Comment}.
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
    @Email
    @Column
    public String getEmail() {
	return email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {	
	return id;
    }

    /**
     * @return the name
     */
    @NotEmpty
    @Column
    public String getName() {
	return name;
    }

    /**
     * @return the text
     */
    @NotEmpty
    @Column
    @Lob
    public String getText() {
	return text;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public void setId(long id) {
	this.id = id;	
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
	this.text = text;
    }

    /**
     * Builder to build {@link Comment}.
     */

    public static final class Builder extends Comment implements Buildable<Comment> {

	private static final long serialVersionUID = 5724281033461828110L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return a new Comment
	 */
	@Override
	public Comment build() {
	    return new Comment(this);
	}

	public Builder withEmail(String email) {
	    super.email = email;
	    return this;
	}	

	public Builder withName(String name) {
	    super.name = name;
	    return this;
	}

	public Builder withText(String text) {
	    super.text = text;
	    return this;
	}
    }

}
