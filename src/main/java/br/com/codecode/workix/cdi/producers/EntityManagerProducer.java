package br.com.codecode.workix.cdi.producers;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.MySQL;
import br.com.codecode.workix.cdi.qualifiers.PostgreSQL;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.stream.Collectors;

/**
 * Entity Manager Producer
 * 
 * @see Produces
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationScoped
public class EntityManagerProducer implements Serializable {

    private static final long serialVersionUID = -1826763804778726145L;

    @PersistenceUnit(unitName = "PostgresDS")
    private EntityManagerFactory emfPostGres;

    @PersistenceUnit(unitName = "MySqlDS")
    private EntityManagerFactory emfMysql;

    /**
     * Produce EntityManager for CDI Injection Points
     * 
     * @return EntityManager PostgreSQL Implementation
     */
    @Produces
    @RequestScoped
    @Factory
    @PostgreSQL
    public EntityManager getPostgreSQLEntityManager() {
	    return emfPostGres.createEntityManager();
    }
    /**
     * Produce EntityManager for CDI Injection Points
     * 
     * @return EntityManager PostgreSQL Implementation
     */
    @Produces
    @RequestScoped
    @Factory
    @MySQL
    public EntityManager getMySQLEntityManager() {
	    return emfMysql.createEntityManager();
    }

    /**
     * Produce EntityManager for CDI Injection Points based on WEB-INF/web.xml
     * ContextParam javax.faces.PROJECT_STAGE
     * 
     * @return EntityManager
     */
    @Produces
    @RequestScoped
    @Factory
    @Default
    public EntityManager getDefaultEntityManager() {

    String database = getContextParam();

	EntityManagerFactory emf = null;

        switch (database) {
            case "PostgreSQL":
                emf = emfPostGres;
                break;
            case "MySQL":
                emf = emfMysql;
                break;
            default:
                throw new RuntimeException("Context Param is NULL or Undefined");
        }

	return emf.createEntityManager();
    }

    /**
     * Closes Entity Manager when Necessary
     * 
     * @param em
     *            Provide a EntityManager AutoClose
     */
    public void close(@Disposes EntityManager em) {

	if (em.isOpen()) {
	    em.close();
	}

    }

    /**
     * Discover Project Stage Parameter to Choose Default EntityManager
     * 
     * @return String Representation for Entity Manager Selection
     * @throws RuntimeException
     *             if ContextParam is not Accessible
     */
    private String getContextParam() throws RuntimeException {

	String s = System.getProperty("default.database", "MySQL");

	if (s != null && !s.isEmpty()) {
	    return s;
	} else
	    throw new RuntimeException("Impossible to Discover Runtime Environment");
    }
}
