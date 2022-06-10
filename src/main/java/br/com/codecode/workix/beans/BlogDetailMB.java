package br.com.codecode.workix.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.enums.BlogCategory;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Comment;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

/**
 * Blog Detail ManagedBean
 * @author felipe
 * @see BaseMB
 */
@Named
@ViewScoped
public class BlogDetailMB extends BaseMB implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -1445938230157483518L;

    private List<BlogCategory> blogCategories;    

    private List<Comment> comments;    

    private Blog currentBlog; 

    @Inject
    @Generic
    private Crud<Blog> daoBlog;


    @Inject
    @Generic
    private Crud<Comment> daoComment;

    private String email, name, text;

    @Inject
    @Factory
    @Default
    private FacesContext facesContext;

    private long id;

    @Inject
    private MessagesHelper messagesHelper;

    private String prefix, sufix;

    /**
     * @return the blogCategories
     */
    public List<BlogCategory> getBlogCategories() {
	return blogCategories;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
	return comments;
    }

    public Blog getCurrentBlog() {
	return currentBlog;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }


    public long getId() {
	return id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }


    public String getText() {
	return text;
    }

    private String goToErrorPage() {

	try {

	    facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

	} catch (IOException e) {

	    e.printStackTrace();
	}
	return prefix + "/404.xhtml" + sufix;
    }

    /**
     * Must be Called by f:viewAction After f:viewParam {page}
     */    
    @Override
    public void init() {

	blogCategories = Arrays.asList(BlogCategory.values());	

	prefix = facesContext.getExternalContext().getRequestContextPath();

	sufix = "?faces-redirect=true";

	System.out.println("BLOG ID RECEIVED -> " + id);

	if (id < 1){
	    goToErrorPage();
	}else{
	    try {

		currentBlog = daoBlog.findById(id);

		comments = daoComment.listAll(0, Integer.MAX_VALUE);


	    } catch (NotImplementedYetException e) {

		e.printStackTrace();

		goToErrorPage();

	    } catch (NoResultException e) {

		e.printStackTrace();

		goToErrorPage();
	    }

	    if (currentBlog == null) {
		goToErrorPage();
	    }

	}


    }

    @Transactional
    public String saveComment(){

        daoComment.save(Comment.builder().withEmail(email).withName(name).withText(text).build());

        messagesHelper.addFlash(new FacesMessage("Comentário Enviado !"));

        comments = daoComment.listAll(0, Integer.MAX_VALUE);

        return prefix + "/post.xhtml?id=" + currentBlog.getId() + sufix;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }   

    public void setId(long id) {
	this.id = id;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }


    public void setText(String text) {
	this.text = text;
    }



}
