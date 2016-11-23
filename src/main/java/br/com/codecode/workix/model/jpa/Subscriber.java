package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.interfaces.Persistable;

/**
 * 
 * @author felipe
 *
 */
@Entity
public class Subscriber implements Persistable, Serializable{

	private static final long serialVersionUID = 6675137603968146834L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@NotEmpty
	@Email	
	@Column(nullable = false,unique = true)
	private String email;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Subscriber(){}	

	public Subscriber(@NotNull Builder builder){

		this.email = builder.email;
	}

	@Override
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Subscriber [email=" + email + "]";
	}

	/**
	 * Builder InnerClass for Subscriber 
	 * @category Builder
	 * @author felipe
	 *
	 */
	public static class Builder implements Buildable<Subscriber> {

		private String email;
		
		private Builder(){}

		public Builder(String email) {
			this();
			this.email = email;
		}		

		/**
		 * @param email the email to set
		 */
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		@Override
		public Subscriber build() {

			return new Subscriber(this);
		}

	}




}