package br.com.codecode.workix.cdi.dao.implementations.persist;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Company;

/**
 * DAO Implementation for Candidate
 * 
 * @since 1.0
 * @version 1.0
 * @see BaseDao
 * @see Crud
 */
@Persist
public class CandidateDao extends BaseDao implements Crud<Candidate> {

   
    private static final long serialVersionUID = -4430675125218575581L;

    @Override
    public void save(Candidate entity) {
	em.persist(entity);
    }

    @Override
    public void deleteById(long id) {
	Candidate entity = em.find(Candidate.class, id);
	if (entity != null) {
	    em.remove(entity);
	}
    }

    @Override
    public Candidate findById(long id) {
	return em.find(Candidate.class, id);
    }

    @Override
    public Candidate update(Candidate entity) {
	return em.merge(entity);
    }

    @Override
    public List<Candidate> listAll(Integer startPosition, Integer maxResult) {

	TypedQuery<Candidate> findAllQuery = em.createQuery("SELECT DISTINCT c FROM Candidate c ORDER BY c.id",
		Candidate.class);

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
    public Candidate findByIdOrdened(long id) throws NotImplementedYetException, NoResultException {
        TypedQuery<Candidate> findByIdQuery = em
                .createQuery("SELECT DISTINCT c FROM Candidate c WHERE c.id = :id ORDER BY c.id", Candidate.class);
        findByIdQuery.setParameter("id", id);
        return findByIdQuery.getSingleResult();
    }

    @Override
    public Candidate findByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
    }

}
