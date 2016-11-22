package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.model.scaffold.Company;

/**
 * Mockup Class for Demonstration Only
 * @author felipe
 * @category Mockup
 */
@Mockup
public class CompanyDaoMockup extends BaseDaoMockup implements Crud<Company> {

	private static final long serialVersionUID = 8018323736641984258L;

	@Override
	public void save(Company entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getName() + " Salvo com Sucesso!"));	

	}

	@Override
	public Company update(Company entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getName() + " Atualizado com Sucesso!"));
		return entity;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> listAll(int start, int end) {
		TypedQuery<Company> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Company c ORDER BY c.id",
				Company.class);

		findAllQuery.setFirstResult(start);

		findAllQuery.setMaxResults(end);

		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + Company.class.getSimpleName()).getSingleResult();
	}

	@Override
	public Company findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
