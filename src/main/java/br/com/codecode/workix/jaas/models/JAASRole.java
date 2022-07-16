/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.jaas.models;

import br.com.codecode.workix.interfaces.Buildable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Only for JAAS security
 * 
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
@Entity
@Table(name = "jaas_role")
@XmlRootElement
public class JAASRole implements Serializable {

    private static final long serialVersionUID = -3259219990958750371L;

    private String name;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public JAASRole() {
    }

    private JAASRole(Builder builder) {
	this.name = builder.getName();
    }

    /**
     * Creates builder to build {@link JAASRole}.
     * 
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    @Id
    @Column(unique = true, nullable = false)
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /**
     * Builder to build {@link JAASRole}.
     * 
     * @see Buildable
     * @see JAASRole
     */
    public static final class Builder extends JAASRole
    implements
    Buildable<JAASRole> {

	/**
	 * @serialField
	 *                  Default Auto Generated Serial
	 */
	private static final long serialVersionUID = -6819879310880521871L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	@Override
	public JAASRole build() {
	    return new JAASRole(this);
	}

	public Builder withName(String name) {
	    super.name = name;
	    return this;
	}
    }  

}
