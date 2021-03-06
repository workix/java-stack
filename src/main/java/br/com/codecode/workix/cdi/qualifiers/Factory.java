package br.com.codecode.workix.cdi.qualifiers;

import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CDI Qualifier for Factory Producers
 * 
 * @see Produces
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Qualifier
@Target({ METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Factory {

}
