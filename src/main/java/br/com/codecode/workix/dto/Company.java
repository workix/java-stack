package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Buildable;

public class Company extends Person {

	private static final long serialVersionUID = 47663377480544994L;

	private String description;

	private Long id, cnpj;

	private String segment;

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
	}

	/**
	 * Creates builder to build {@link Company}.
	 * @return created builder
	 */
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

	public Long getCnpj() {
		return cnpj;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public String getSegment() {
		return segment;
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

		public Builder withCnpj(long cnpj) {
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
	}

}