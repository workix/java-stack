package br.com.codecode.workix.model.scaffold;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Experience {
	
	private String employer;
	
	private String jobTitle;
	
	private Date startDate,endDate;
	
	public Experience() {

	}	

	public Experience(String employer, String jobTitle, Date startDate, Date endDate) {
		super();
		this.employer = employer;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
