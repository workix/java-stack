package br.com.codecode.workix.cdi.dao.implementations.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Mockup;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Company;

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
public class CompanyDaoMockup extends BaseDaoMockup implements Crud<Company> {

   
    private static final long serialVersionUID = 8018323736641984258L;

    @Override
    public void save(Company entity) {
	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getName() + SAVEMESSAGE));

    }

    @Override
    public Company update(Company entity) {
	messagesHelper.addFlash(new FacesMessage(TITLE, entity.getName() + UPDATEMESSAGE));
	return entity;
    }

    @Override
    public void deleteById(long id) throws NotImplementedYetException {
	throw new NotImplementedYetException();

    }

    @Override
    public Company findById(long id) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

    @Override
    public List<Company> listAll(int start, int end) {
	TypedQuery<Company> findAllQuery = em.createQuery("SELECT DISTINCT c FROM Company c ORDER BY c.id",
		Company.class);

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
    public Company findByUuid(String uuid) throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

}
