package br.com.codecode.workix.cdi.dao.implementations.persist;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.models.Candidate;

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
    public List<Candidate> listAll(int startPosition, int maxResult) {

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
    public Candidate findByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
    }

}
