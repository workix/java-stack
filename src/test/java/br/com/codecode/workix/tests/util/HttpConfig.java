package br.com.codecode.workix.tests.util;
/**
 * Startup Config for Unit Tests
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public abstract class HttpConfig {
			
	public static final String JAVAEE_PROJ_TEST = "http://localhost:8080/workix/services";
	
	public static final String JAVAEE_PROJ_PROD = "http://www.workix.com.br/services";
	
	private HttpConfig(){}

}
