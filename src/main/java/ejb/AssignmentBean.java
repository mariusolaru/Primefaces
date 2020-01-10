package ejb;

import entity.Driver;
import entity.Trip;
import repository.TripRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class AssignmentBean {

    @EJB
    private TripRepository tripRepository;

    public void assignDriverToTrip(Driver driver, Trip trip){
        trip.setDriver(driver);
        tripRepository.update(trip);
    }
}
