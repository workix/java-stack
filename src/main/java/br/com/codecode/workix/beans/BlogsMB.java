package br.com.codecode.workix.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Blog;

/**
 * This ManagedBean controls Blogs Fragment on HomePage and 404 page
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class BlogsMB extends BaseMB {
    
    @Inject
    @Generic
    private Crud<Blog> dao;
    
    private DataModel<Blog> list;

    @PostConstruct
    @Override
    protected void init() {
	try {
	    
	    list = new ListDataModel<Blog>(dao.listAll(0, Integer.MAX_VALUE));
	    
	} catch (NotImplementedYetException e) {	    
	    e.printStackTrace();
	}	

    }

    
    /**
     * @return the list
     */
    public DataModel<Blog> getList() {
        return list;
    }
    
    

}