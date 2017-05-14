package br.com.codecode.workix.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * The Interface NeedUpgrade.
 */
@Documented
@Retention(SOURCE)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE})
/**
 * Mark Object as needing upgrade
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * 
 */
public @interface NeedUpgrade{}
