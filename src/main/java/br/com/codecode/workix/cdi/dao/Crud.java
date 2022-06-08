package br.com.codecode.workix.cdi.dao;

import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.interfaces.Persistable;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Concrete Crud Interface for CDI Implementation Uses
 * 
 * @author felipe
 * @since 1.0
 * @param <T> Any Entity witch implements Persistable and Serializable
 * @see BaseCrud
 * @see Persistable 
 * @see Serializable 
 */
public interface Crud<T extends Persistable & Serializable> extends BaseCrud<T> {

    /**
     * Save Or Update Currenty Entity Based on Id
     * 
     * @param entity
     *            Entity Passed to Persist or Update
     * @return Managed Entity
     * @throws IllegalArgumentException
     *             if Entity is Null
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    default public T saveOrUpdate(T entity) throws IllegalArgumentException, NotImplementedYetException {

	if (entity == null) throw new IllegalArgumentException("Entity Passed to Persist is Null");

	if (entity.getId() == 0)
	    save(entity);
	else
	    update(entity);

	return entity;
    }

    /**
     * Fetch for {@link Persistable} Entities with Id
     * 
     * @param uuid
     *            Fetch for Entity by UUID Field
     * @return Fetched Entity
     * @throws NotImplementedYetException
     *             if Method is Not Implemented Yet
     */
    public T findByUuid(String uuid) throws NotImplementedYetException;

    /**
     * Count Registers on Database
     * 
     * @return Total Rows of Entity
     * @throws NotImplementedYetException
     *             if Method is Not Implemented Yet
     */
    // public BigInteger countRegisters();

    /**
     * Count Registers on Database
     * @param entityName
     * @return Total Rows of Entity
     * @throws NotImplementedYetException
     *             if Method is Not Implemented Yet
     */
    public BigInteger countRegisters(String entityName);
}
