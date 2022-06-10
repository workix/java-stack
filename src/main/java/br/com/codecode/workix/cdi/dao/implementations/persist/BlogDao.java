package br.com.codecode.workix.cdi.dao.implementations.persist;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Blog;

import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;

@Persist
public class BlogDao extends BaseDao implements Crud<Blog> {
    @Override
    public void save(Blog entity) {
        em.persist(entity);
    }

    @Override
    public Blog update(Blog entity) {
        return em.merge(entity);
    }

    @Override
    public Blog findById(long id) {
        return em.find(Blog.class, id);
    }

    @Override
    public void deleteById(long id) {
        Blog entity = em.find(Blog.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public List<Blog> listAll(int start, int end) {
        TypedQuery<Blog> findAllQuery = em.createQuery("SELECT DISTINCT b FROM Blog b LEFT JOIN FETCH b.author ORDER BY b.id", Blog.class);

        findAllQuery.setFirstResult(start);

        findAllQuery.setMaxResults(end);

        return findAllQuery.getResultList();
    }

    @Override
    public Blog findByUuid(String uuid) throws NotImplementedYetException {
        return null;
    }

    @Override
    public BigInteger countRegisters(String entityName) {
        return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + entityName).getSingleResult();
    }
}
