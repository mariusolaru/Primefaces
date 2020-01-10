package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Driver.class)
public abstract class Driver_ extends entity.Person_ {

	public static volatile ListAttribute<Driver, Trip> trips;
	public static volatile SingularAttribute<Driver, String> driverLicenseType;

	public static final String TRIPS = "trips";
	public static final String DRIVER_LICENSE_TYPE = "driverLicenseType";

}

