package dto;

public class TripDTO {

    private Long id;

    private String startingTime;

    private int durationMinutes;

    private int startingLocationXCoordinate;

    private int startingLocationYCoordinate;

    private int endLocationXCoordinate;

    private int endLocationYCoordinate;

    private Long customerId;

    private Long vehicleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
