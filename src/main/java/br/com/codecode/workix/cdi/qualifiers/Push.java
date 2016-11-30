/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.qualifiers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.notify.Notification;

/**
 * CDI Qualifier for {@link Notification}
 * 
 * @see Notification
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Qualifier
@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Push {
}