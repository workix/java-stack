package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Person JPA with Inherited Fields and Methods <br>
 * Abstract Class for share common Fields with {@link Company} and
 * {@link Candidate}
 * 
 * @author felipe
 * @see MyEntity
 * @since 1.0
 * @version 1.1 
 * @see <a href="http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">
 * DeSerializing Abstract Types</a>
 */
@MappedSuperclass
public abstract class Person extends MyEntity {
   
    private static final long serialVersionUID = 703693002246144451L;
    
    private String name;

    private User user;

    private Contact contact;

    private Locale locale;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Person(){}

    @JsonDeserialize(as = Contact.class)
    @Embedded
    public Contact getContact() {
	return contact;
    }

    @JsonDeserialize(as = Locale.class)
    @Embedded
    public Locale getLocale() {
	return locale;
    }

    @NotEmpty
    @Column(nullable = false)
    public String getName() {
	return name;
    }

    @JsonDeserialize(as = User.class)
    @OneToOne(optional = false)
    public User getUser() {
	return user;
    }

    public void setContact(Contact contact) {
	this.contact = contact;
    }

    public void setLocale(Locale locale) {
	this.locale = locale;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setUser(User user) {
	this.user = user;
    }

}
