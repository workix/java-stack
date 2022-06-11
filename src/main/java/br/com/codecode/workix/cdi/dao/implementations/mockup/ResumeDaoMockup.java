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
import br.com.codecode.workix.jpa.models.Resume;

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
public class ResumeDaoMockup extends BaseDaoMockup implements Crud<Resume> {

   
    private static final long serialVersionUID = -7123666749649316280L;

    @Inject
    private Event<Resume> alertNewResume;

    @Override
    public void save(Resume entity) {

	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getObjective() + SAVEMESSAGE));

	alertNewResume.fire(entity);

    }

    @Override
    public Resume update(Resume entity) {

	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getObjective() + UPDATEMESSAGE));

	return entity;
    }

    @Override
    public void deleteById(long id) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

    @Override
    public Resume findById(long id) {
	return em.find(Resume.class, id);
    }

    @Override
    public List<Resume> listAll(Integer start, Integer end) {
	TypedQuery<Resume> findAllQuery = em.createQuery("SELECT DISTINCT r FROM Resume r ORDER BY r.id", Resume.class);

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
    public Resume findByIdOrdened(long id) throws NotImplementedYetException, NoResultException {
        throw new NotImplementedYetException();
    }

    @Override
    public Resume findByUuid(String uuid) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

}
