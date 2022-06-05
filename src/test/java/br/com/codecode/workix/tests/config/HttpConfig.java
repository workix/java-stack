package br.com.codecode.workix.tests.config;

/**
 * Startup Config for Unit Tests
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class HttpConfig {

    public static final String JAVAEE_PROJ_TEST = "http://localhost:8080/workix/services/v1" ,
	    JAVAEE_PROJ_PROD = "http://www.workix.com.br/services/v1";

    private HttpConfig(){}

}
