package br.com.codecode.workix.jpa.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Testimonial JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 */
@Entity
@Table(name = "testimonials")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Testimonial extends MyEntity {

   
    private static final long serialVersionUID = 9143527358797800527L;

    private Author author;

    private Long id;

    private String picture;

    private String signature;

    private String text;


    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Testimonial(){}   

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Testimonial
     */
    private Testimonial(Builder builder) {
	this.author = builder.getAuthor();	
	this.picture = builder.getPicture();
	this.signature = builder.getSignature();
	this.text = builder.getText();
    }


    /**
     * Creates builder to build {@link Testimonial}.
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }


    /**
     * @return the author
     */
    @NotNull
    @OneToOne
    public Author getAuthor() {
	return author;
    }


    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public Long getId() {
	return this.id;
    }


    @NotEmpty
    @Column
    public String getPicture() {
	return picture;
    }


    /**
     * @return the signature
     */
    @NotEmpty
    @Column
    public String getSignature() {
	return signature;
    }


    /**
     * @return the text
     */
    @NotEmpty
    @Lob
    @Column
    public String getText() {
	return text;
    }


    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
	this.author = author;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Long id) {
	this.id = id;
    }


    public void setPicture(String picture) {
	this.picture = picture;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
	this.signature = signature;
    }


    /**
     * @param text the text to set
     */
    public void setText(String text) {
	this.text = text;
    }

    /**
     * Builder to build {@link Testimonial}.
     */    
    public static final class Builder extends Testimonial implements Buildable<Testimonial>  {

	private static final long serialVersionUID = 136923846936951445L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * Return a New Testimonial
	 */
	@Override
	public Testimonial build() {
	    return new Testimonial(this);
	}

	public Builder withAuthor(Author author) {
	    super.author = author;
	    return this;
	}

	public Builder withId(long id) {
	    super.id = id;
	    return this;
	}

	public Builder withPicture(String picture) {
	    super.picture = picture;
	    return this;
	}

	public Builder withSignature(String signature) {
	    super.signature = signature;
	    return this;
	}

	public Builder withText(String text) {
	    super.text = text;
	    return this;
	}
    }


}
