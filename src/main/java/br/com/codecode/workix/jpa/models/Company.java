package br.com.codecode.workix.jpa.models;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Company JPA with Inherited Fields and Methods 
 * @see Person
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Entity
@Table(name = "companies")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Company extends Person {
   
    private static final long serialVersionUID = 47663377480544994L;

    private String description;
    
    private Long id, cnpj;
    
    private String segment;

	private String logo;

	private List<SocialMedia> medias;

	/**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Company(){}
    
    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Company
     */
    private Company(Builder builder) {	
	this.cnpj = builder.getCnpj();
	this.segment = builder.getSegment();
	this.setName(builder.getName());	
	this.setContact(builder.getContact());
	this.setLocale(builder.getLocale());
	this.setUser(builder.getUser());
	this.setLogo(builder.getLogo());
    }

    /**
     * Creates builder to build {@link Company}.
     * @return created builder
     */
    @JsonIgnore
    public static Builder builder() {
	return new Builder();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Company))
	    return false;
	Company other = (Company) obj;
	if (id != other.id)
	    return false;
	return true;
    }

    @Column(nullable = false, unique = true)
    public Long getCnpj() {
	return cnpj;
    }

    /**
     * @return the description
     */
    @Column(columnDefinition = "text")        
    public String getDescription() {
        return description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public Long getId() {
	return this.id;
    }

    @Column(nullable = true)
    public String getSegment() {
	return segment;
    }

	@Column(nullable = true)
	public String getLogo(){
		return logo;
	}
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    public void setCnpj(Long cnpj) {
	this.cnpj = cnpj;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setId(Long id) {
	this.id = id;
    }

    public void setSegment(String companySegment) {
	this.segment = companySegment;
    }

	public void setLogo(String logo) {
		this.logo = logo;
	}
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "companies_medias", joinColumns = @JoinColumn(name = "id"))
	public List<SocialMedia> getMedias() {
		return medias;
	}

	public void setMedias(List<SocialMedia> medias) {
		this.medias = medias;
	}

    /**
     * Builder to build {@link Company}.
     */    
    public static final class Builder extends Company implements Buildable<Company> {

	private static final long serialVersionUID = -2850736800336558944L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {}

	/**
	 * @return a new Company
	 */
	@Override
	public Company build() {
	    return new Company(this);
	}

	public Builder withCnpj(Long cnpj) {
	    super.cnpj = cnpj;
	    return this;
	}

	public Builder withContact(Contact contact) {
	    super.setContact(contact);
	    return this;
	}

	public Builder withDescription(String description) {
	    super.description = description;
	    return this;
	}

	public Builder withLocale(Locale locale) {
	    super.setLocale(locale);
	    return this;
	}

	public Builder withName(String name) {
	    super.setName(name);
	    return this;
	}

	public Builder withSegment(String segment) {
	    super.segment = segment;
	    return this;
	}

	public Builder withUser(User user) {
	    super.setUser(user);
	    return this;
	}
	public Builder withLogo(String logo){
		super.setLogo(logo);
		return this;
	}
    }

}