package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trip.class)
public abstract class Trip_ extends entity.AbstractEntity_ {

	public static volatile SingularAttribute<Trip, Integer> durationMinutes;
	public static volatile SingularAttribute<Trip, Integer> endLocationXCoordinate;
	public static volatile SingularAttribute<Trip, Driver> driver;
	public static volatile SingularAttribute<Trip, String> startingTime;
	public static volatile SingularAttribute<Trip, Integer> startingLocationXCoordinate;
	public static volatile SingularAttribute<Trip, Integer> endLocationYCoordinate;
	public static volatile SingularAttribute<Trip, Integer> startingLocationYCoordinate;
	public static volatile SingularAttribute<Trip, Customer> customer;
	public static volatile SingularAttribute<Trip, Vehicle> vehicle;

	public static final String DURATION_MINUTES = "durationMinutes";
	public static final String END_LOCATION_XCOORDINATE = "endLocationXCoordinate";
	public static final String DRIVER = "driver";
	public static final String STARTING_TIME = "startingTime";
	public static final String STARTING_LOCATION_XCOORDINATE = "startingLocationXCoordinate";
	public static final String END_LOCATION_YCOORDINATE = "endLocationYCoordinate";
	public static final String STARTING_LOCATION_YCOORDINATE = "startingLocationYCoordinate";
	public static final String CUSTOMER = "customer";
	public static final String VEHICLE = "vehicle";

}

