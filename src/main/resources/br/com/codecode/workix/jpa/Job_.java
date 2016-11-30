package br.com.codecode.workix.jpa;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-28T19:39:43.191-0200")
@StaticMetamodel(Job.class)
public class Job_ {
	public static volatile SingularAttribute<Job, Long> id;
	public static volatile SingularAttribute<Job, String> title;
	public static volatile SingularAttribute<Job, BigDecimal> minPayment;
	public static volatile SingularAttribute<Job, BigDecimal> maxPayment;
	public static volatile SingularAttribute<Job, String> description;
	public static volatile SingularAttribute<Job, String> requirement;
	public static volatile SingularAttribute<Job, String> benefits;
	public static volatile SingularAttribute<Job, Calendar> start;
	public static volatile SingularAttribute<Job, Calendar> expire;
	public static volatile SingularAttribute<Job, JobType> type;
	public static volatile SingularAttribute<Job, JobCategory> category;
	public static volatile SingularAttribute<Job, Boolean> active;
	public static volatile SingularAttribute<Job, Company> company;
}