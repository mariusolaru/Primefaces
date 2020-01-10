package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vehicle.class)
public abstract class Vehicle_ extends entity.AbstractEntity_ {

	public static volatile SingularAttribute<Vehicle, String> requiredDriverLicenseType;
	public static volatile SingularAttribute<Vehicle, Depot> depot;
	public static volatile ListAttribute<Vehicle, Trip> trips;
	public static volatile SingularAttribute<Vehicle, String> model;

	public static final String REQUIRED_DRIVER_LICENSE_TYPE = "requiredDriverLicenseType";
	public static final String DEPOT = "depot";
	public static final String TRIPS = "trips";
	public static final String MODEL = "model";

}

