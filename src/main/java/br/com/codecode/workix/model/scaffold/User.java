package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.BaseEntity;
import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.interfaces.Persistable;

@Entity
public class User extends BaseEntity implements Persistable{

	private static final long serialVersionUID = -610648880358327958L;

	@Column
	private boolean active;
	
	@NotEmpty
	@Email
	@Column(nullable = false,unique=true)
	private String email;

	@Column
	private String firebaseUUID;
	
	@Column
	private String firebaseMessageToken;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public User(){}	

	public User(@NotNull UserBuilder userBuilder){

		this.active = userBuilder.active;

		this.email = userBuilder.email;

		this.firebaseUUID = userBuilder.firebaseUUID;

		this.firebaseMessageToken = userBuilder.firebaseMessageToken;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirebaseUUID() {
		return firebaseUUID;
	}

	public void setFirebaseUUID(String firebaseUUID) {
		this.firebaseUUID = firebaseUUID;
	}

	public String getFirebaseMessageToken() {
		return firebaseMessageToken;
	}

	public void setFirebaseMessageToken(String firebaseMessageToken) {
		this.firebaseMessageToken = firebaseMessageToken;
	}	

	public String getUniqueID(){
		return super.getUuid();
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}

	/**
	 * Builder InnerClass for User 
	 * @category Builder
	 * @author felipe
	 *
	 */
	public static class UserBuilder implements Buildable<User> {	

		private boolean active;

		private String email;

		private String firebaseUUID;

		private String firebaseMessageToken;		

		private UserBuilder(){}		

		public UserBuilder(boolean active, String email) {
			this();
			this.active = active;
			this.email = email;
		}

		public UserBuilder(boolean active, String email, String firebaseUUID, String firebaseMessageToken) {
			this(active,email);			
			this.firebaseUUID = firebaseUUID;
			this.firebaseMessageToken = firebaseMessageToken;
		}		
		
		/**
		 * @param active the active to set
		 */
		public UserBuilder setActive(boolean active) {
			this.active = active;
			return this;
		}

		/**
		 * @param email the email to set
		 */
		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * @param firebaseUUID the firebaseUUID to set
		 */
		public UserBuilder setFirebaseUUID(String firebaseUUID) {
			this.firebaseUUID = firebaseUUID;
			return this;
		}

		/**
		 * @param firebaseMessageToken the firebaseMessageToken to set
		 */
		public UserBuilder setFirebaseMessageToken(String firebaseMessageToken) {
			this.firebaseMessageToken = firebaseMessageToken;
			return this;
		}

		@Override
		public User build()
		{
			return new User(this);
		}



	}	

}