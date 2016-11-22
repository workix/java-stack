package br.com.codecode.workix.cdi.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.dao.implementation.generic.Dao;
import br.com.codecode.workix.cdi.producer.GenericDaoProducer;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CDI - Qualifier for Dao Instance
 * @see Dao
 * @see GenericDaoProducer
 * @author felipe
 *
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Generic{}
