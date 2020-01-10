package ejb;

import entity.Driver;
import entity.Trip;
import repository.DriverRepository;
import repository.TripRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.time.LocalTime;
import java.util.List;

@Stateless
@LocalBean
public class TripCheckingBean {

    @EJB
    private TripRepository tripRepository;

    public boolean checkIfAssignmentIsPossible(Long driverId, Long tripId){
        Trip trip = tripRepository.findById(tripId);

        List<Trip> driversAssignedTrips = tripRepository.getTripsByDriver(driverId);

        for(Trip it : driversAssignedTrips){
            if(LocalTime.parse(it.getStartingTime()).plusMinutes(trip.getDurationMinutes()).compareTo(LocalTime.parse(trip.getStartingTime())) > 0)
                return false;
        }
        return true;
    }
}
