package br.com.codecode.workix.cdi.dao.implementations.standalone;

import java.time.LocalDateTime;
import java.util.List;

import br.com.codecode.workix.cdi.dao.implementations.persist.BaseDao;
import br.com.codecode.workix.jpa.models.SelectiveProcess;

/**
 * StandAlone DAO for find Expired Selective Processes 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see BaseDao
 */
public class CleanupDao extends BaseDao {

   
    private static final long serialVersionUID = 8313089022686190122L;
    
    public List<SelectiveProcess> findExpiredProcesses(LocalDateTime expiresIn) {

	String jpql = "select p from SelectiveProcess p where p.expiresIn <= :expiresIn";

	return em.createQuery(jpql, SelectiveProcess.class).setParameter("expiresIn", expiresIn).getResultList();
	 
    }

}
