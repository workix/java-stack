package br.com.codecode.workix.cdi.dao.implementations.persist;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.User;

/**
 * DAO for Job
 * 
 * @since 1.0
 * @version 1.0
 * @see BaseDao
 * @see Crud
 */
@Persist
public class UserDao extends BaseDao implements Crud<User> {

   
    private static final long serialVersionUID = 4029639665489024760L;

    @Inject
    private Event<User> alertNewUser;

    @Override
    public void save(User entity) {

	em.persist(entity);

	alertNewUser.fire(entity);

    }

    @Override
    public void deleteById(long id) throws IllegalArgumentException {
	User entity = em.find(User.class, id);
        if (entity == null) {
            throw new IllegalArgumentException(String.format("User with id: %s not found", id));
        } else {
            em.remove(entity);
        }
    }

    @Override
    public User findById(long id) {
	return em.find(User.class, id);
    }

    @Override
    public User update(User entity) throws OptimisticLockException {
	return em.merge(entity);
    }

    @Override
    public List<User> listAll(Integer startPosition, Integer maxResult) {

	TypedQuery<User> findAllQuery = em.createQuery("SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }

	return findAllQuery.getResultList();
    }

    @Override
    public BigInteger countRegisters(String entityName) {

	return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + entityName)
		.getSingleResult();
    }

    @Override
    public User findByIdOrdened(long id) throws NotImplementedYetException, NoResultException {
        TypedQuery<User> findByIdQuery = em
                .createQuery("SELECT DISTINCT u FROM User u WHERE u.id = :id ORDER BY u.id", User.class);
        findByIdQuery.setParameter("id", id);
        return findByIdQuery.getSingleResult();
    }

    @Override
    public User findByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
    }

}
