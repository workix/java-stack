package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.SelectiveProcessTopic;
import br.com.codecode.workix.jpa.models.SelectiveProcess;

/**
 * CDI Observer Class for {@link SelectiveProcess}
 * 
 * @see Observes
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class SelectiveProcessObserver {

    @Inject
    @Factory
    private JMSProducer jmsProducer;

    @Inject
    @Factory
    @SelectiveProcessTopic
    private Destination destination;

    /**
     * Execute an Action on Event as FiredUp
     * 
     * @param process
     *            Observer for SelectiveProcess Events
     */
    public void alert(@Observes SelectiveProcess process) {

	System.out.println("[CDI - Alert for Selective Processes]");

	System.out.println(process.getId());

	System.out.println(Instant.now());

	System.out.println("[-----------------------]");

	if (process.isActivated()) {
	    System.out.println("Process is Active");
	} else {
	    System.out.println("Process is no More Elegible");
	    System.out.println("Process is Disabled from Database");
	}

	jmsProducer.send(destination, process.getId());

    }

}
