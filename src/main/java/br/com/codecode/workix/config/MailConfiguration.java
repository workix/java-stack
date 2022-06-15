/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.config;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.MailSessionDefinition;

/**
 * Replace Configuration MAIL inside the Server not work on WildFly 9.0.2 JAVA
 * EE 7
 * 
 * @author Felipe
 * @since 1.0
 * @version 1.1
 */
/*@MailSessionDefinition(name = "java:jboss/mail/fake", host = "smtp.gmail.com", user = "fake@gmail.com",
    password = "fake@fake", transportProtocol = "smtp", from = "fake@gmail.com", properties = { "mail.smtp.port=465" })*/
@Startup
@Singleton
public class MailConfiguration{}
