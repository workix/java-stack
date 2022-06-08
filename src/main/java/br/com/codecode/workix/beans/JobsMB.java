package br.com.codecode.workix.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.enums.JobType;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jsf.util.helper.JobTypeLinkHelper;
import br.com.codecode.workix.jsf.util.helper.Paginator;

/**
 * This ManagedBean controls jobs.xhtml and jobs2.xhtml Execute with
 * {@link Model}
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Model
public class JobsMB extends BaseMB {

    @Inject @Factory @Default
    private FacesContext facesContext;

    private Paginator paginator;

    @Inject @Generic
    private Crud<Job> dao;

    @Inject
    private JobTypeLinkHelper jobTypeLinkHelper;

    private DataModel<Job> list;

    private String prefix, sufix;

    private LocalDate localdate = LocalDate.now();
    
    private List<Integer> pager = new ArrayList<>();

    
    /**
     * @return the pager
     */
    public List<Integer> getPager() {
        return pager;
    }


    public String discoverBadge(JobType jobType){
	return jobTypeLinkHelper.returnType(jobType);
    }


    /**
     * @return the localdate
     */
    public LocalDate getLocaldate() {
	return localdate;
    }

    /**
     * Max Results By Page
     */
    private final int limitRows = 10;

    private int start, end, totalRows, totalPages;

    @Min(1)
    private int page;

    /**
     * Must be Called by f:viewAction After f:viewParam {page}
     */
    @Override
    public void init() {

        totalRows = dao.countRegisters("jobs").intValue();

        paginator = new Paginator(limitRows, page, totalRows);

        totalPages = paginator.getTotalPages();

        start = paginator.getStart();

        end = paginator.getEnd();

        List<Job> jobs = dao.listAll(start - 1, end);

        list = new ListDataModel<Job>(jobs);

        prefix = "/" + facesContext.getExternalContext().getContextName();

	sufix = "&faces-redirect=true";

	{
	    System.out.println("Current Page : " + page);

	    System.out.println("Total Rows : " + totalRows);

	    System.out.println("Total Pages : " + totalPages);

	    System.out.println("Start " + start);

	    System.out.println("End " + end);
	}
	
	for(int x = 0 ; x <= totalPages; x++){
	    if (x == 0) continue;
	    	pager.add(x);
	}

    }

    public DataModel<Job> getList() {
	return list;
    }

    public String goToJobDetail(Job job) {

	System.out.println("Received Job " + job.toString());

	return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix;
    }

    public String goToLastPage() {
	return prefix + "/jobs2.xhtml?page=" + String.valueOf(totalPages) + sufix;
    }

    public String goToFirstPage() {
	return prefix + "/jobs2.xhtml?page=" + String.valueOf(1) + sufix;
    }
  

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public int getTotalPages() {
	return totalPages;
    }

}
