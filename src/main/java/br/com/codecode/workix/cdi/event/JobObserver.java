package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSProducer;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.JobTopic;
import br.com.codecode.workix.jpa.models.Job;

/**
 * CDI Observer Class for {@link Job}
 * 
 * @see Observes
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class JobObserver {

    @Inject
    @Factory
    private JMSProducer jmsProducer;

    @Inject
    @Factory
    @JobTopic
    private Destination destination;

    /**
     * Execute an Action on Event as FiredUp
     * 
     * @param job
     *            Observer for Job Events
     */
    public void alert(@Observes Job job) {

	System.out.println("[CDI - Alert for New Job]");

	System.out.println(job.getUuid());

	System.out.println(Instant.now());

	System.out.println("[-----------------------]");

	if (job.getJobCategory() != null) {
	    switch (job.getJobCategory()) {

		case MANAGEMENT: {
		    System.out.println("SEND Notification for Management Job");
		}
		    break;

		case OPERATOR: {
		    System.out.println("SEND Notification for Operator Job");
		}
		    break;

		default: {
		    System.out.println("SEND Notification for Default Job");
		}
		    break;

	    }
	}

	jmsProducer.send(destination, job.getUuid());

    }

}
