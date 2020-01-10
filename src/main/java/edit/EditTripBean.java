package edit;

import entity.Trip;
import repository.TripRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "editTrip")
@ViewScoped
public class EditTripBean {

    @EJB
    private TripRepository tripRepository;

    @ManagedProperty(value="#{trip}")
    private Trip trip;

    public EditTripBean() {
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void editTrip(){
        tripRepository.update(trip);
    }
}

