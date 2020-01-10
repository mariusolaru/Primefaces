package view;

import dto.SearchTripDTO;
import dto.TripDTO;
import entity.Customer;
import entity.Trip;
import entity.Vehicle;
import repository.CustomerRepository;
import repository.TripRepository;
import repository.VehicleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "tripsSearchPageView")
@RequestScoped
public class TripsSearchPageView extends DataView<Trip> implements Serializable {

    private SearchTripDTO searchTripDTO = new SearchTripDTO();
    private static List<Trip> filteredTrips = new ArrayList<>();

    @EJB
    private TripRepository tripRepository;

    @EJB
    private VehicleRepository vehicleRepository;

    @EJB
    private CustomerRepository customerRepository;

    public TripsSearchPageView() {
        super(Trip.class);
    }

    public SearchTripDTO getSearchTripDTO() {
        return searchTripDTO;
    }

    public void setSearchTripDTO(SearchTripDTO searchTripDTO) {
        this.searchTripDTO = searchTripDTO;
    }

    public List<Trip> getFilteredTrips() {
        return filteredTrips;
    }

    public void setFilteredTrips(List<Trip> filteredTrips) {
        this.filteredTrips = filteredTrips;
    }

    @PostConstruct
    public void init() {
        entities = tripRepository.findAll();
    }

    public void searchTrips() throws IOException {
        this.filteredTrips = tripRepository.getFilteredTrips(searchTripDTO);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.redirect("trips_search_results.xhtml?faces-redirect=true");
    }

}
