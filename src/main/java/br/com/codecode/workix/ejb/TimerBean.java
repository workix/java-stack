package br.com.codecode.workix.ejb;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.dao.implementations.standalone.CleanupDao;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jpa.models.SelectiveProcess;

/**
 * This Class is a Enterprise Java Bean witch execute tasks in Some Periods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Singleton
@Startup
public class TimerBean {

    private Timer timer;
    
    @Inject
    private CleanupDao dao;
    
    @Inject @Generic
    private Crud<SelectiveProcess> spDao;

    @PostConstruct
    public void init() {

	System.out.println("[TimerBean] Starting EJB timer");

	System.out.println("[TimerBean] Create Schedule on Startup");	
	
    }

    @PreDestroy
    public void destroy() {

	System.out.println("[TimerBean] Finalizing schedule...");

	if (timer != null) timer.cancel();

    }

    @Schedule(hour = "*", minute = "0/30", second = "0", persistent = false)
    public void execute() {
	
	System.out.println("[TimerBean] Execute Schedule ... " 
		+Instant.now());
	
	try{
	   
	    List<SelectiveProcess> expireds = dao.findExpiredProcesses(LocalDateTime.now());
	    
	    for (SelectiveProcess sp : expireds) {
		
		sp.setActivated(false);
		
		spDao.save(sp);
		
	    }
	    
	}catch (Exception e) {
	    
	    System.err.println(e);
	    
	    e.printStackTrace();
	}
	
    }

}
