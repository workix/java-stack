package br.com.codecode.workix.cdi.dao;

import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.interfaces.Persistable;

import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.List;

/**
 * Markup Interface <br>
 * Abstract BaseCrud Interface With Minimal Functions
 * 
 * @author felipe
 * @param <T>
 *            Any Entity witch implements Persistable and Serializable
 * @see Persistable
 * @see Serializable
 */
public abstract interface BaseCrud<T extends Persistable & Serializable> {

    /**
     * Create Current Entity in Database
     * 
     * @param entity
     *            Save/Persist a Entity in Database
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public void save(T entity);

    /**
     * Update Entity in Database
     * 
     * @param entity
     *            Update/Merge a Entity in Database
     * @return Updated Entity
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public T update(T entity);

    /**
     * Localize Entity by Id
     * 
     * @param id
     *            Fetch for Entity by id Field
     * @return Fetched Entity
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public T findById(long id) throws NotImplementedYetException;

    /**
     * Localize Entity by Id and Delete
     * 
     * @param id
     *            Fetch for Entity by id Field and Delete
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     * @throws IllegalArgumentException
     *             if incorrect id is provided
     */
    public void deleteById(long id) throws NotImplementedYetException, IllegalArgumentException;

    /**
     * List Registers of an Entity between Start and End Index
     * 
     * @param start
     *            Start Position
     * @param end
     *            End Delimiter
     * @return List of Results
     * @throws NotImplementedYetException
     *             if Methods is Not Implemented Yet
     */
    public List<T> listAll(Integer start, Integer end);
}
