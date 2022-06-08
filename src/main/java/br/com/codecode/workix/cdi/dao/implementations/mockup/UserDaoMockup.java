package br.com.codecode.workix.cdi.dao.implementations.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Mockup;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.User;

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
public class UserDaoMockup extends BaseDaoMockup implements Crud<User> {

   
    private static final long serialVersionUID = 8746840143580709391L;

    @Inject
    private Event<User> alertNewUser;

    @Override
    public void save(User entity) {

	alertNewUser.fire(entity);

	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getEmail() + SAVEMESSAGE));
    }

    @Override
    public User update(User entity) {

	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getEmail() + UPDATEMESSAGE));

	return entity;
    }

    @Override
    public void deleteById(long id) throws NotImplementedYetException {
	throw new NotImplementedYetException();

    }

    @Override
    public User findById(long id) {
	return em.find(User.class, id);
    }

    @Override
    public List<User> listAll(int start, int end) {

	TypedQuery<User> findAllQuery = em.createQuery("SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);

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
    public User findByUuid(String uuid) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

}
