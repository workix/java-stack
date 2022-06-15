package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Buildable;


public class Subscriber extends MyEntity {

	private static final long serialVersionUID = 6675137603968146834L;

	private String email;

	private Long id;

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
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	@Override
	public Long getId() {
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
	public void setId(Long id) {
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
