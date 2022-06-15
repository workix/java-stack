package br.com.codecode.workix.jaas.models;

import br.com.codecode.workix.interfaces.Persistable;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * JAAS Base Entity Only For Share Common Fields
 * 
 * @author felipe
 * @see Persistable
 * @see Serializable
 */
@MappedSuperclass
abstract class JAASBase implements Persistable, Serializable {

    private static final long serialVersionUID = 8234434925475474481L;

    long id;

    @Override
    public void setId(Long id) {
	this.id = id;
    }
    
    
    public JAASBase(){}
}