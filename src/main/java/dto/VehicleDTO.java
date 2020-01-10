package dto;

public class VehicleDTO {

    private Long id;

    private Long depotId;

    private String model;

    private String requiredDriverLicenseType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
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
