/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.infra;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.jpa.Candidate;
import br.com.codecode.workix.model.jpa.Job;
import br.com.codecode.workix.util.ReadFile;

/**
 * This Class Construct Email Body from a Template
 * TODO FIXME
 * @author felipe
 *
 */
public class MailBodyBuilder {
	
	@Inject @Factory
	private FacesContext facesContext;

	private String server, templatePath;
	
	public MailBodyBuilder() throws NotImplementedYetException{
		throw new NotImplementedYetException();
	}
	
	@PostConstruct
	private void init(){
		server = facesContext.getExternalContext().getApplicationContextPath();
	}


	public String makeBodyForNew(Job job) {

		StringBuilder mailBody = new StringBuilder();

		try {

			mailBody.append(ReadFile.readFileFromURL(
					new URL(server + templatePath)));

			String result = mailBody.toString();

			mailBody = new StringBuilder();

			/*mailBody.append(result.replace("varUsuario", 
					job.getCand().getName()).replace("varCarrinho", 
							checkout.getShoppingCart()).replace("varCodigo", checkout.getUuid()));*/

			return mailBody.toString();


		} catch (MalformedURLException e) {

			System.err.println("URL do Template Incorreta " + e);

			mailBody.append("Reserva Solicitada com Sucesso, Código de checkout ")
			.append(job.getId());

			return mailBody.toString();

		}		

	}

	public String makeBodyForNew(Candidate candidate) {

		StringBuilder mailBody = new StringBuilder();	

		try {

			mailBody.append(ReadFile.readFileFromURL(
					new URL(server + templatePath)));

			String result = mailBody.toString();

			mailBody = new StringBuilder();

			result = result.replace("varNome", candidate.getName());

			result = result.replace("varUsuario", candidate.getUser().getEmail());

			mailBody.append(result);	

			return mailBody.toString();


		} catch (MalformedURLException e) {

			System.err.println("URL do Template Incorreta " + e);

			mailBody.append("Olá ").append(candidate.getUser().getEmail()).append("<br />")
			.append(", Seja Bem Vindo e Aproveite Nossos Serviços");

			return mailBody.toString();

		}


	}
}