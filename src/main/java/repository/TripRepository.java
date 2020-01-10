package repository;

import dto.SearchTripDTO;
import dto.TripDTO;
import entity.*;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class TripRepository extends DataRepository<Trip, Long> {

    public TripRepository(){
        super(Trip.class);
    }

    public List<Trip> getTripsByVehicle(Long vehicleId){
        TypedQuery<Trip> query = entityManager.createQuery("SELECT t from Trip t where t.vehicle.id = ?1", Trip.class);
        query.setParameter(1, vehicleId);

        return query.getResultList();
    }

    public List<Trip> getTripsByDriver(Long driverId){
        TypedQuery<Trip> query = entityManager.createQuery("SELECT t from Trip t where t.driver.id = ?1", Trip.class);
        query.setParameter(1, driverId);

        return query.getResultList();
    }

    public List<Trip> getFilteredTrips(SearchTripDTO searchTripDTO){

        if(StringUtils.isEmpty(searchTripDTO.getCustomerName())
                && StringUtils.isEmpty(searchTripDTO.getDurationMinutes())
                && StringUtils.isEmpty(searchTripDTO.getStartingTime())
                && StringUtils.isEmpty(searchTripDTO.getCustomerName())){

            return findAll();
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trip> criteriaQuery = criteriaBuilder.createQuery(Trip.class);
        Root<Trip> trip = criteriaQuery.from(Trip.class);

        Predicate filter = criteriaBuilder.conjunction();

        if(StringUtils.isNotEmpty(searchTripDTO.getStartingTime())){
            Predicate startingTimeLike = criteriaBuilder.like(trip.get(Trip_.STARTING_TIME), searchTripDTO.getStartingTime());
            filter = criteriaBuilder.and(filter, startingTimeLike);
        }

        if(StringUtils.isNotEmpty(searchTripDTO.getDurationMinutes())){
            Predicate durationMinutesEquals = criteriaBuilder.equal(trip.get(Trip_.DURATION_MINUTES), Integer.valueOf(searchTripDTO.getDurationMinutes()));
            filter = criteriaBuilder.and(filter, durationMinutesEquals);
        }

        if(StringUtils.isNotEmpty(searchTripDTO.getCustomerName())){
            Join<Trip, Customer> item = trip.join(Trip_.CUSTOMER);
            Predicate customerNameLike = criteriaBuilder.like(item.get(Customer_.NAME), searchTripDTO.getCustomerName());
            filter = criteriaBuilder.and(filter, customerNameLike);
        }

        if(StringUtils.isNotEmpty(searchTripDTO.getVehicleModel())){
            Join<Trip, Vehicle> item = trip.join(Trip_.VEHICLE);
            Predicate vehicleModelLike = criteriaBuilder.like(item.get(Vehicle_.MODEL), searchTripDTO.getVehicleModel());
            filter = criteriaBuilder.and(filter, vehicleModelLike);
        }

        criteriaQuery.where(filter);
        criteriaQuery.select(trip);

        TypedQuery<Trip> q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
}
