package view;

import dto.DriverDTO;
import dto.VehicleDTO;
import entity.Depot;
import entity.Driver;
import entity.Trip;
import entity.Vehicle;
import repository.DepotRepository;
import repository.TripRepository;
import repository.VehicleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vehiclesView")
@RequestScoped
public class VehiclesView extends DataView<Vehicle> implements Serializable {

    private VehicleDTO vehicleDTO = new VehicleDTO();

    private Long passedIdForView;

    private List<Trip> trips = new ArrayList<>();

    @EJB
    private VehicleRepository vehicleRepository;

    @EJB
    private TripRepository tripRepository;

    @EJB
    private DepotRepository depotRepository;

    public VehiclesView() {
        super(Vehicle.class);
    }

    @PostConstruct
    public void init() {
        entities = vehicleRepository.findAll();
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }

    public Long getPassedIdForView() {
        return passedIdForView;
    }

    public void setPassedIdForView(Long passedIdForView) {
        this.passedIdForView = passedIdForView;
    }

    public void delete(Long id){
        Vehicle vehicle = vehicleRepository.findById(id);
        vehicleRepository.remove(vehicle);
    }

    public List<Trip> getTripsByVehicle(Long id){
        return tripRepository.getTripsByVehicle(id);
    }

    public void addVehicle(){
        Vehicle vehicle = new Vehicle();

        //Mapping from DTO to DB entity
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setRequiredDriverLicenseType(vehicleDTO.getRequiredDriverLicenseType());
        Depot depot = depotRepository.findById(vehicleDTO.getDepotId());
        vehicle.setDepot(depot);

        vehicleRepository.persist(vehicle);
        this.entities = vehicleRepository.findAll();

        this.vehicleDTO = new VehicleDTO();
    }

    public void redirectToViewTripsPage(Long vehicleId) throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.redirect("trips_for_vehicle.xhtml?faces-redirect=true&vehicleId=" + vehicleId);
    }
}
