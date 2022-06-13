package br.com.codecode.workix.cdi.producers;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Fake;
import br.com.codecode.workix.cdi.qualifiers.Gmail;
import br.com.codecode.workix.mail.MailSender;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.mail.Session;

/**
 * Mail Session Producer
 * 
 * @see Produces
 * @see Session
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationScoped
public class MailSessionProducer {

     @Resource(mappedName = "java:jboss/mail/gmail")
     private Session sessionGmail;

     @Resource(mappedName = "java:jboss/mail/fake")
     private Session sessionFake;

    /**
     * Produces Session for {@link MailSender} use in CDI Injection Points
     * 
     * @return Session Instance for {@link MailSender}
     */
    @Produces
    @Dependent
    @Factory
    @Gmail
    public Session getSessionGmail() {
	return sessionGmail;
    }

    /**
     * Produces Session for {@link MailSender} use in CDI Injection Points
     * 
     * @return Session Instance for {@link MailSender}
     */
    @Produces
    @Dependent
    @Factory
    @Fake
    public Session getSessionFake() {
	return sessionFake;
    }

}
