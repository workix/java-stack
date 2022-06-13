package br.com.codecode.workix.cdi.producers;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.JobTopic;
import br.com.codecode.workix.cdi.qualifiers.SelectiveProcessTopic;
import br.com.codecode.workix.cdi.qualifiers.UserTopic;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.jms.Destination;

/**
 * JMS Destination Producer
 * 
 * @see Produces
 * @see Destination
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@ApplicationScoped
public class JmsDestinationProducer {

    @Resource(mappedName = "java:/jms/topics/jobsTopic", name = "jobsTopic")
    private Destination jobsTopic;

    @Resource(mappedName = "java:/jms/topics/usersTopic", name = "usersTopic")
    private Destination usersTopic;

    @Resource(mappedName = "java:/jms/topics/selectiveProcessesTopic", name = "selectiveProcessesTopic")
    private Destination selectiveProcessesTopic;

    /**
     * Produces JMS Destination for CDI Injection Points
     * 
     * @return JMS Destination Instance
     */
    @Produces
    @Dependent
    @Factory
    @JobTopic
    public Destination getJobDestination() {
	return jobsTopic;
    }

    /**
     * Produces JMS Destination for CDI Injection Points
     * 
     * @return JMS Destination Instance
     */
    @Produces
    @Dependent
    @Factory
    @UserTopic
    public Destination getUserDestination() {
	return usersTopic;
    }

    /**
     * Produces JMS Destination for CDI Injection Points
     * 
     * @return JMS Destination Instance
     */
    @Produces
    @Dependent
    @Factory
    @SelectiveProcessTopic
    public Destination getSelectiveProcessesDestination() {
	return selectiveProcessesTopic;
    }

}
