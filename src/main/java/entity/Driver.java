package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "drivers")
@ManagedBean(name = "driver")
@RequestScoped
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Driver extends Person {

    @Column(length = 20, name = "driver_license_type")
    private String driverLicenseType;

    @OneToMany(mappedBy = "driver")
    private List<Trip> trips;

    public Driver(){

    }

    public String getDriverLicenseType() {
        return driverLicenseType;
    }

    public void setDriverLicenseType(String driverLicenseType) {
        this.driverLicenseType = driverLicenseType;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
