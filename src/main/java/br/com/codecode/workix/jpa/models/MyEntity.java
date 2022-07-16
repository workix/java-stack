package br.com.codecode.workix.jpa.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import br.com.codecode.workix.interfaces.Persistable;
import br.com.codecode.workix.interfaces.Traceable;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * MyEntity JPA with Inherited Fields and Methods <br>
 * Base abstract Class for Share common Fields <br>
 * All inherited classes MUST contain<br>
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr> 
 * <th>{@link #version}</th>
 * <th>{@link #createdAt}</th>
 * <th>{@link #updatedAt}</th>
 * <th>{@link #uuid}</th>
 * </tr>
 * </table>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Traceable
 * @see Persistable
 * @see Serializable
 */
@MappedSuperclass
abstract class MyEntity implements Traceable, Persistable, Serializable {
   
    private final static long serialVersionUID = -5791260209364116790L;
    
    private LocalDateTime createdAt, updatedAt;
  
    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public MyEntity(){}

    @Override
    public void generateUUID() {
	this.setUuid(UUID.randomUUID().toString());
    }
    @JsonSerialize
    @Column(updatable = false, nullable = false, name = "created_at")    
    private LocalDateTime getCreatedAt() {
	return createdAt;
    }

    @JsonSerialize
    @Column(name = "updated_at")
    private LocalDateTime getUpdatedAt() {
	return updatedAt;
    }

    @Column(updatable = false, nullable = false)
    public String getUuid() {
	return uuid;
    }

    @Override
    public void insertTimeStamp() {
	this.setCreatedAt(LocalDateTime.now());
    }

    @PrePersist
    @Override
    public void prepareToPersist() {
        setUpdatedAt(LocalDateTime.now());
	    Traceable.super.prepareToPersist();
    }

    private void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
    }

    private void setUuid(String uuid) {
	this.uuid = uuid;
    }

    @PreUpdate
    @Override
    public void updateTimeStamp() {
	this.setUpdatedAt(LocalDateTime.now());
    }

}
