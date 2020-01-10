package dto;

public class CustomerDTO {

    private Long id;

    private String name;

    private String requiredVehicleModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequiredVehicleModel() {
        return requiredVehicleModel;
    }

    public void setRequiredVehicleModel(String requiredVehicleModel) {
        this.requiredVehicleModel = requiredVehicleModel;
    }
}
