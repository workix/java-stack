package br.com.codecode.workix.cdi.dao.implementations.persist;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.SelectiveProcess;

/**
 * DAO for Selective Process
 * 
 * @since 1.0
 * @version 1.0
 * @see BaseDao
 * @see Crud
 */
@Persist
public class SelectiveProcessDao extends BaseDao implements Crud<SelectiveProcess> {

   
    private static final long serialVersionUID = 5942334208981147237L;

    @Override
    public void save(SelectiveProcess entity) {
	em.persist(entity);
    }

    @Override
    public void deleteById(long id) {
	SelectiveProcess entity = em.find(SelectiveProcess.class, id);
	if (entity != null) {
	    em.remove(entity);
	}
    }

    @Override
    public SelectiveProcess findById(long id) {
	return em.find(SelectiveProcess.class, id);
    }

    @Override
    public SelectiveProcess update(SelectiveProcess entity) {
	return em.merge(entity);
    }

    @Override
    public List<SelectiveProcess> listAll(Integer startPosition, Integer maxResult) {

	TypedQuery<SelectiveProcess> findAllQuery = em.createQuery(
		"SELECT DISTINCT s FROM SelectiveProcess s LEFT JOIN FETCH s.job LEFT JOIN FETCH s.employeer LEFT JOIN FETCH s.candidates ORDER BY s.id",
		SelectiveProcess.class);

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
    public SelectiveProcess findByIdOrdened(long id) throws NotImplementedYetException, NoResultException {
        TypedQuery<SelectiveProcess> findByIdQuery = em
                .createQuery("SELECT DISTINCT sp FROM SelectiveProcess sp WHERE sp.id = :id ORDER BY sp.id", SelectiveProcess.class);
        findByIdQuery.setParameter("id", id);
        return findByIdQuery.getSingleResult();
    }

    @Override
    public SelectiveProcess findByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
    }

}
