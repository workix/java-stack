package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.interfaces.Notificable;


public class User extends MyEntity implements Notificable {

	private static final long serialVersionUID = -610648880358327958L;

	private boolean active;

	private String email, firebaseUUID, firebaseMessageToken;

	private Long id;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public User(){}

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 *
	 * @see Buildable
	 * @param builder
	 *            Builder for Generate a New User
	 */
	public User(Builder builder) {
		this.active = builder.isActive();
		this.email = builder.getEmail();
		this.firebaseUUID = builder.getFirebaseUUID();
		this.firebaseMessageToken = builder.getFirebaseMessageToken();
	}


	/**
	 * Creates builder to build {@link User}.
	 *
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getFirebaseMessageToken() {
		return firebaseMessageToken;
	}

	@Override
	public String getFirebaseUUID() {
		return firebaseUUID;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setFirebaseMessageToken(String firebaseMessageToken) {
		this.firebaseMessageToken = firebaseMessageToken;
	}

	@Override
	public void setFirebaseUUID(String firebaseUUID) {
		this.firebaseUUID = firebaseUUID;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Builder NestedClass for {@link User}
	 *
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 * @see User
	 * @see Buildable
	 */
	public final static class Builder extends User implements Buildable<User> {

		private static final long serialVersionUID = -7766145008890656904L;

		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}

		/**
		 * Return a New User
		 */
		@Override
		public User build() {
			return new User(this);
		}

		/**
		 * @param active
		 *            the active to set
		 * @return Builder
		 */
		public Builder withActive(boolean active) {
			this.setActive(active);
			return this;
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

		/**
		 * @param firebaseMessageToken
		 *            the firebaseMessageToken to set
		 * @return Builder
		 */
		public Builder withFirebaseMessageToken(String firebaseMessageToken) {
			this.setFirebaseMessageToken(firebaseMessageToken);
			return this;
		}

		/**
		 * @param firebaseUUID
		 *            the firebaseUUID to set
		 * @return Builder
		 */
		public Builder withFirebaseUUID(String firebaseUUID) {
			this.setFirebaseUUID(firebaseUUID);
			return this;
		}

	}

}