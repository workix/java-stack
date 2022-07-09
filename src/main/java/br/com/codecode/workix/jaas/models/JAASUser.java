package br.com.codecode.workix.jaas.models;

import br.com.codecode.workix.jaas.PassGenerator;

import javax.inject.Inject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Set;

/**
 * Only for JAAS security
 * 
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
@Entity
@Table(name = "JAAS_User")
@XmlRootElement
public class JAASUser extends JAASBase {

	private static final long serialVersionUID = -1917498851904653016L;

	private String login;

	@Inject
	private transient PassGenerator passGenerator;

	private String password;

	private Set<JAASRole> roles;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public JAASUser() {
	}

	private JAASUser(Builder builder) {
		this.login = builder.login;
		this.password = builder.password;
		this.roles = builder.roles;
		this.passGenerator = builder.passGenerator;
	}

	/**
	 * Creates builder to build {@link JAASUser}.
	 * 
	 * @return created builder
	 */
	@XmlTransient
	public static Builder builder() {
		return new Builder();
	}

	@PrePersist
	@PreUpdate
	private void encode() {
		this.password = passGenerator.generate(this.password);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	@Override
	public Long getId() {
		return id;
	}

	@Column(unique = true)
	public String getLogin() {
		return login;
	}

	@Column
	public String getPassword() {
		return password;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "JAAS_Roles", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_name"))
	public Set<JAASRole> getRoles() {
		return roles;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Set<JAASRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "JAASUser [login=" + login +
                ", roles=" + roles + "]";
	}

	/**
	 * Builder to build {@link JAASUser}.
	 */
	public static final class Builder {

		private String login;

		private PassGenerator passGenerator;

		private String password;

		private Set<JAASRole> roles;

		private Builder(){}

		public JAASUser build() {
			return new JAASUser(this);
		}

		public Builder withLogin(String login) {
			this.login = login;
			return this;
		}

		public Builder withPassGenerator(PassGenerator passGenerator) {
			this.passGenerator = passGenerator;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder withRoles(Set<JAASRole> roles) {
			this.roles = roles;
			return this;
		}
	}

}
