package br.com.codecode.workix.jpa.models.jdk8;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.059-0300")
@StaticMetamodel(Experience.class)
public class Experience_ {
	public static volatile SingularAttribute<Experience, String> description;
	public static volatile SingularAttribute<Experience, String> employerName;
	public static volatile SingularAttribute<Experience, LocalDate> endDate;
	public static volatile SingularAttribute<Experience, String> jobTitle;
	public static volatile SingularAttribute<Experience, LocalDate> startDate;
}