package br.com.codecode.workix.jpa;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T21:08:12.363-0200")
@StaticMetamodel(MyEntity.class)
public class MyEntity_ {
	public static volatile SingularAttribute<MyEntity, Long> id;
	public static volatile SingularAttribute<MyEntity, Integer> version;
	public static volatile SingularAttribute<MyEntity, LocalDateTime> createdAt;
	public static volatile SingularAttribute<MyEntity, LocalDateTime> updatedAt;
	public static volatile SingularAttribute<MyEntity, String> uuid;
}
