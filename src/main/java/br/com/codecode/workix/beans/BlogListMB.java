package br.com.codecode.workix.beans;

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
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Comment;
import br.com.codecode.workix.jsf.util.helper.Paginator;

/**
 * This ManagedBean controls Blogs List
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class BlogListMB extends BaseMB {

    private DataModel<Comment> comments;

    @Inject @Factory @Default
    private FacesContext facesContext;

    @Inject
    @Generic
    private Crud<Blog> dao;

    @Inject
    @Generic
    private Crud<Comment> daoComment;

    private Paginator paginator;    

    private DataModel<Blog> list;

    private String prefix, sufix;

    /**
     * Max Results By Page
     */
    private final int limitRows = 10;

    @Min(1)
    private int page;

    private int start, end, totalRows, totalPages;

    private List<Integer> pager = new ArrayList<>();


    /**
     * @return the pager
     */
    public List<Integer> getPager() {
	return pager;
    }

    /**
     * @return the comments
     */
    public DataModel<Comment> getComments() {
	return comments;
    }    

    /**
     * @return the list
     */
    public DataModel<Blog> getList() {
	return list;
    }


    public int getPage() {
	return page;
    }

    public int getTotalPages() {
	return totalPages;
    }

    @Override
    public void init() {

        totalRows = dao.countRegisters("blogs").intValue();

        paginator = new Paginator(limitRows, page, totalRows);

        totalPages = paginator.getTotalPages();

        start = paginator.getStart();

        end = paginator.getEnd();

        list = new ListDataModel<Blog>(dao.listAll(start -1 , end));

        comments = new ListDataModel<Comment>(daoComment.listAll(0, Integer.MAX_VALUE));


        prefix = "/" + facesContext.getExternalContext().getContextName();

	sufix = "&faces-redirect=true";
	
	for (int x=0; x <= totalPages  ; x++) {
	    
	    if(x == 0) continue;
	    
	    pager.add(x);
	}

	{
	    System.out.println("Current Page : " + page);

	    System.out.println("Total Rows : " + totalRows);

	    System.out.println("Total Pages : " + totalPages);

	    System.out.println("Start " + start);

	    System.out.println("End " + end);
	}


    }

    public void setPage(int page) {
	this.page = page;
    }

    public String goToLastPage(){
	return prefix + "/blog.xhtml?page=" + String.valueOf(totalPages) + sufix;
    }

    public String goToFirstPage(){
	return prefix + "/blog.xhtml?page=" + String.valueOf(1) + sufix;
    }



}
