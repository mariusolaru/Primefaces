package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
@ManagedBean(name= "vehicle")
@RequestScoped
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Vehicle extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "depot_id", referencedColumnName = "id")
    private Depot depot;

    @OneToMany(mappedBy = "vehicle")
    private List<Trip> trips;

    @Column(length = 100)
    private String model; // Audi, VW etc.

    @Column(length = 20, name = "required_driver_license")
    private String requiredDriverLicenseType;

    public Vehicle(){
    }

    public Vehicle(Depot depot, String model, String requiredDriverLicenseType){
        this.depot = depot;
        this.requiredDriverLicenseType = requiredDriverLicenseType;
        trips = new ArrayList<>();
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRequiredDriverLicenseType() {
        return requiredDriverLicenseType;
    }

    public void setRequiredDriverLicenseType(String requiredDriverLicenseType) {
        this.requiredDriverLicenseType = requiredDriverLicenseType;
    }
}
