package br.com.codecode.workix.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Comment;

/**
 * This ManagedBean controls Blogs Fragment on HomePage and 404 page
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class BlogsMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Blog> dao;

    @Inject
    @Generic
    private Crud<Comment> daoComment;

    private DataModel<Blog> list;

    private DataModel<Comment> comments;

       
    @PostConstruct
    @Override
    public void init() {

        list = new ListDataModel<Blog>(dao.listAll(0, Integer.MAX_VALUE));

        comments = new ListDataModel<Comment>(daoComment.listAll(0, Integer.MAX_VALUE));


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


}
