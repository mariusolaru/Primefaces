package view;

import dto.EditTripDTO;
import dto.TripDTO;
import entity.Customer;
import entity.Driver;
import entity.Trip;
import entity.Vehicle;
import org.apache.commons.lang.StringUtils;
import repository.CustomerRepository;
import repository.DriverRepository;
import repository.TripRepository;
import repository.VehicleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "tripsView")
@ViewScoped
public class TripsView extends DataView<Trip> implements Serializable {

    private TripDTO tripDTO = new TripDTO();
    private EditTripDTO editTripDTO = new EditTripDTO();

    @EJB
    private TripRepository tripRepository;

    @EJB
    private VehicleRepository vehicleRepository;

    @EJB
    private CustomerRepository customerRepository;

    @EJB
    private DriverRepository driverRepository;

    public TripsView() {
        super(Trip.class);
    }

    @PostConstruct
    public void init() {
        entities = tripRepository.findAll();
    }

    public TripDTO getTripDTO() {
        return tripDTO;
    }

    public void setTripDTO(TripDTO tripDTO) {
        this.tripDTO = tripDTO;
    }

    public EditTripDTO getEditTripDTO() {
        return editTripDTO;
    }

    public void setEditTripDTO(EditTripDTO editTripDTO) {
        this.editTripDTO = editTripDTO;
    }

    public void addTrip(){

        Trip trip = new Trip();

        //Mapping from DTO to DB entity
        trip.setStartingTime(tripDTO.getStartingTime());
        trip.setDurationMinutes(tripDTO.getDurationMinutes());
        trip.setStartingLocationXCoordinate(tripDTO.getStartingLocationXCoordinate());
        trip.setStartingLocationYCoordinate(tripDTO.getStartingLocationYCoordinate());
        trip.setEndLocationXCoordinate(tripDTO.getEndLocationXCoordinate());
        trip.setEndLocationYCoordinate(tripDTO.getEndLocationYCoordinate());

        Vehicle vehicle = vehicleRepository.findById(tripDTO.getVehicleId());
        Customer customer = customerRepository.findById(tripDTO.getCustomerId());

        trip.setVehicle(vehicle);
        trip.setCustomer(customer);

        tripRepository.persist(trip);
        this.entities = tripRepository.findAll();

        this.tripDTO = new TripDTO();
    }

    public void delete(Long id){
        Trip trip = tripRepository.findById(id);
        tripRepository.remove(trip);
    }

    public void editTrip(Long id){
        Trip trip = tripRepository.findById(id);

        if(StringUtils.isNotEmpty(editTripDTO.getStartingTime())){
            trip.setStartingTime(editTripDTO.getStartingTime());
        }

        if(StringUtils.isNotEmpty(editTripDTO.getDurationMinutes())){
            trip.setDurationMinutes(Integer.valueOf(editTripDTO.getDurationMinutes()));
        }
        tripRepository.update(trip);
    }
}
