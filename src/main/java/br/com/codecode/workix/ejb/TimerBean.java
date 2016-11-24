package br.com.codecode.workix.ejb;

import java.time.Instant;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
/**
 * This Class is a Enterprise Java Bean witch execute tasks in Some Periods
 * @author felipe
 *
 */
@Singleton
@Startup
public class TimerBean {

	private Timer timer;

	@PostConstruct
	public void init() {

		System.out.println("[TimerBean] Iniciando o EJB com timer");

		System.out
		.println("[TimerBean] Criando agendamento na inicializaçao");
	}

	@PreDestroy
	public void destroy() {		

		if(timer != null)

		System.out.println("[TimerBean] Finalizando agendamento ...");

		timer.cancel();
	}

	@Schedule(hour="*",minute="0/30",second="0",persistent=false)
	public void executar() {
		System.out.println("[TimerBean] Executando agendamento ... " + Instant.now());
	}

}
