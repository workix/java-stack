package br.com.codecode.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.model.scaffold.Company;

/**
 * DAO for Company
 */

public class CompanyDao extends BasicDao {	

	private static final long serialVersionUID = -6997728484075279219L;

	public void create(Company entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Company entity = em.find(Company.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Company findById(Long id) {
		return em.find(Company.class, id);
	}

	public Company update(Company entity) {
		return em.merge(entity);
	}

	public List<Company> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Company> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Company c ORDER BY c.id",
				Company.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
