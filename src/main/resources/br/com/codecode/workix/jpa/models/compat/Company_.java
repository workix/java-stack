package br.com.codecode.workix.jpa.models.compat;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.368-0300")
@StaticMetamodel(Company.class)
public class Company_ extends Person_ {
	public static volatile SingularAttribute<Company, Long> cnpj;
	public static volatile SingularAttribute<Company, String> description;
	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, String> segment;
}
