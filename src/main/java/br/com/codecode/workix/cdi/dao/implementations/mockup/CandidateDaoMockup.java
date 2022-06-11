package br.com.codecode.workix.cdi.dao.implementations.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Mockup;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Candidate;

/**
 * Mockup Class for Demonstration Only
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see BaseDaoMockup
 * @see Crud
 */
@Mockup
public class CandidateDaoMockup extends BaseDaoMockup implements Crud<Candidate> {

   
    private static final long serialVersionUID = -405041688690426708L;

    @Inject
    private Event<Candidate> alertNewVisit;

    @Override
    public void save(Candidate entity) {
	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getName() + SAVEMESSAGE));
    }

    @Override
    public Candidate update(Candidate entity) {

	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getName() + UPDATEMESSAGE));

	return entity;
    }

    @Override
    public void deleteById(long id) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

    @Override
    public Candidate findById(long id) {

	Candidate c = em.find(Candidate.class, id);

	if (c != null) {
	    alertNewVisit.fire(c);
	}

	return c;
    }

    @Override
    public List<Candidate> listAll(Integer start, Integer end) {

	TypedQuery<Candidate> findAllQuery = em.createQuery("SELECT DISTINCT c FROM Candidate c ORDER BY c.id",
		Candidate.class);

	findAllQuery.setFirstResult(start);

	findAllQuery.setMaxResults(end);

	return findAllQuery.getResultList();
    }

    @Override
    public BigInteger countRegisters(String entityName) {
	return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + entityName)
		.getSingleResult();
    }

    @Override
    public Candidate findByIdOrdened(long id) throws NotImplementedYetException, NoResultException {
        throw new NotImplementedYetException();
    }

    @Override
    public Candidate findByUuid(String uuid) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

}
