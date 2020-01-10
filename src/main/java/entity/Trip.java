package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@Entity
@Table(name = "trips")
@ManagedBean(name="tripComplete")
@RequestScoped
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Trip extends AbstractEntity{

    @Column(name = "starting_time")
    private String startingTime;

    // in minutes
    @Column(length = 256, name = "duration_minutes", columnDefinition = "integer default 0")
    private int durationMinutes;

    @Column(name = "starting_location_x_coordinate")
    private int startingLocationXCoordinate;

    @Column(name = "starting_location_y_coordinate")
    private int startingLocationYCoordinate;

    @Column(name = "end_location_x_coordinate")
    private int endLocationXCoordinate;

    @Column(name = "end_location_y_coordinate")
    private int endLocationYCoordinate;

    @OneToOne
    @JoinColumn(name= "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable=false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="driver_id", nullable=false)
    private Driver driver;

    public Trip(){

    }

    public Trip(String startingTime, int durationMinutes, int startingLocationXCoordinate, int startingLocationYCoordinate, int endLocationXCoordinate, int endLocationYCoordinate) {
        this.startingTime = startingTime;
        this.durationMinutes = durationMinutes;
        this.startingLocationXCoordinate = startingLocationXCoordinate;
        this.startingLocationYCoordinate = startingLocationYCoordinate;
        this.endLocationXCoordinate = endLocationXCoordinate;
        this.endLocationYCoordinate = endLocationYCoordinate;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getStartingLocationXCoordinate() {
        return startingLocationXCoordinate;
    }

    public void setStartingLocationXCoordinate(int startingLocationXCoordinate) {
        this.startingLocationXCoordinate = startingLocationXCoordinate;
    }

    public int getStartingLocationYCoordinate() {
        return startingLocationYCoordinate;
    }

    public void setStartingLocationYCoordinate(int startingLocationYCoordinate) {
        this.startingLocationYCoordinate = startingLocationYCoordinate;
    }

    public int getEndLocationXCoordinate() {
        return endLocationXCoordinate;
    }

    public void setEndLocationXCoordinate(int endLocationXCoordinate) {
        this.endLocationXCoordinate = endLocationXCoordinate;
    }

    public int getEndLocationYCoordinate() {
        return endLocationYCoordinate;
    }

    public void setEndLocationYCoordinate(int endLocationYCoordinate) {
        this.endLocationYCoordinate = endLocationYCoordinate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
