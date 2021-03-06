package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Email;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This ManagedBean controls company-details.xhtml
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class CompanyDetailsMB extends BaseMB {

    private String messageTitle, messageBody;

    @Inject
    @Generic
    private Crud<Company> dao;
    
    @Inject
    @Generic
    private Crud<Job> daoJob;

    @Inject
    @Push
    private Notification pushNotification;

    @Inject
    @Email
    private Notification mailNotification;

    @Inject
    private MessagesHelper messagesHelper;

    @Inject
    @Factory
    @Default
    private FacesContext facesContext;

    private long id;

    private String prefix, sufix;

    private Company company;
    
    private List<Job> jobs;

    /**
     * Must be Called by f:viewAction After f:viewParam {page}
     */
    @Override
    public void init() {

	prefix = facesContext.getExternalContext().getRequestContextPath();

	sufix = "?faces-redirect=true";

	try {

	    company = dao.findById(id);
	    
	    jobs = daoJob.listAll(0, Integer.MAX_VALUE);
	    
	    jobs = jobs.stream().filter(j -> j.getCompany() == company).collect(Collectors.toList());    

	    if (company == null) goToErrorPage();

	} catch (NotImplementedYetException | NoResultException e) {

	    e.printStackTrace();

	}

    }

    
    /**
     * @return the jobs
     */
    public List<Job> getJobs() {
        return jobs;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Company getCompany() {
	return company;
    }

    public void notifyByEmail() {
	messagesHelper.addFlash(new FacesMessage("Email Enviado com Sucesso !"));
	mailNotification.doSendMessage(company.getUser(), messageTitle, messageBody);

    }

    public void notifyByPush() {
	messagesHelper.addFlash(new FacesMessage("Push Message Enviado com Sucesso !"));
	pushNotification.doSendMessage(company.getUser(), messageTitle, messageBody);

    }

    public String getMessageBody() {
	return messageBody;
    }

    public void setMessageBody(String messageBody) {
	this.messageBody = messageBody;
    }

    public String getMessageTitle() {
	return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
	this.messageTitle = messageTitle;
    }

    private String goToErrorPage() {

	try {

	    facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

	} catch (IOException e) {

	    e.printStackTrace();
	}
	return prefix + "/404.xhtml" + sufix;
    }

}
