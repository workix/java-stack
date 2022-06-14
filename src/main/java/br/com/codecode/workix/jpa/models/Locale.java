package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.enums.Estate;
import br.com.codecode.workix.interfaces.Buildable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Locale JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 * @author felipe
 * @see Serializable
 * @since 1.0
 * @version 1.1
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Locale implements Serializable {
   
    private static final long serialVersionUID = -607806075186010186L;

    private String city;

    private Estate estate;

    private String neighborhood;

    private String number;

    private String street;

    private long zipCode;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Locale() {}

    /**
     * Creates builder to build {@link Locale}.
     * @return created builder
     */
	@JsonIgnore
	public static Builder builder() {
	return new Builder();
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Locale
     */
    public Locale(Builder builder) {
	this.zipCode = builder.getZipCode();
	this.city = builder.getCity();
	this.neighborhood = builder.getNeighborhood();
	this.street = builder.getStreet();
	this.number = builder.getNumber();
	this.estate = builder.getEstate();
    }

	@Column
	public String getCity() {
	return city;
    }

	@Enumerated(EnumType.STRING)
	@Column
    public Estate getEstate() {
	return estate;
    }

	@Column
    public String getNeighborhood() {
	return neighborhood;
    }

	@Column
    public String getNumber() {
	return number;
    }

	@Column
    public String getStreet() {
	return street;
    }

	@Column
	public long getZipCode() {
	return zipCode;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public void setEstate(Estate estate) {
	this.estate = estate;
    }

    public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public void setZipCode(long zipCode) {
	this.zipCode = zipCode;
    }

    @Override
    public String toString() {	
	return city +
            ", " +
            estate;
    }

    /**
     * Builder NestedClass for {@link Locale}
     * 
     * @author felipe
     * @see Buildable
     * @see Locale
     */
    public static class Builder extends Locale implements Buildable<Locale> {

	private static final long serialVersionUID = -9170730109070112523L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return Return a new Locale
	 */
	@Override
	public Locale build() {
	    return new Locale(this);
	}

	public Builder withCity(String city) {
	    this.setCity(city);
	    return this;
	}

	public Builder withEstate(Estate estate) {
	    this.setEstate(estate);
	    return this;
	}

	public Builder withNeighborhood(String neighborhood) {
	    this.setNeighborhood(neighborhood);
	    return this;
	}

	public Builder withNumber(String number) {
	    this.setNumber(number);
	    return this;
	}

	public Builder withStreet(String street) {
	    this.setStreet(street);
	    return this;
	}

	public Builder withZipCode(long zipCode) {
	    this.setZipCode(zipCode);
	    return this;
	}

    }




}
