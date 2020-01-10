package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Depot.class)
public abstract class Depot_ extends entity.AbstractEntity_ {

	public static volatile SingularAttribute<Depot, Integer> xCoordinate;
	public static volatile SingularAttribute<Depot, Integer> yCoordinate;
	public static volatile SingularAttribute<Depot, String> name;
	public static volatile SingularAttribute<Depot, Integer> capacity;

	public static final String X_COORDINATE = "xCoordinate";
	public static final String Y_COORDINATE = "yCoordinate";
	public static final String NAME = "name";
	public static final String CAPACITY = "capacity";

}

