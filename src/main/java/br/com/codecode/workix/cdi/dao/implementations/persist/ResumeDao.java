package br.com.codecode.workix.cdi.dao.implementations.persist;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.jpa.models.User;

/**
 * DAO for Resume
 * 
 * @since 1.0
 * @version 1.0
 * @see BaseDao
 * @see Crud
 */
@Persist
public class ResumeDao extends BaseDao implements Crud<Resume> {

   
    private static final long serialVersionUID = 4029639665489024760L;

    @Inject
    private Event<Resume> alertNewResume;

    @Override
    public void save(Resume entity) {

	em.persist(entity);

	alertNewResume.fire(entity);

    }

    @Override
    public void deleteById(long id) {
	Resume entity = em.find(Resume.class, id);
	if (entity != null) {
	    em.remove(entity);
	}
    }

    @Override
    public Resume findById(long id) {
	return em.find(Resume.class, id);
    }

    @Override
    public Resume update(Resume entity) {
	return em.merge(entity);
    }

    @Override
    public List<Resume> listAll(Integer startPosition, Integer maxResult) {

	TypedQuery<Resume> findAllQuery = em.createQuery("SELECT DISTINCT r FROM Resume r ORDER BY r.id", Resume.class);

	findAllQuery.setFirstResult(startPosition);

	findAllQuery.setMaxResults(maxResult);

	return findAllQuery.getResultList();
    }

    @Override
    public BigInteger countRegisters(String entityName) {
	return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + entityName)
		.getSingleResult();
    }

    @Override
    public Resume findByIdOrdened(long id) throws NotImplementedYetException, NoResultException {
        TypedQuery<Resume> findByIdQuery = em
                .createQuery("SELECT DISTINCT r FROM Resume r WHERE r.id = :id ORDER BY r.id", Resume.class);
        findByIdQuery.setParameter("id", id);
        return findByIdQuery.getSingleResult();
    }

    @Override
    public Resume findByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
    }
}
