package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@Entity
@Table(name = "customers")
@ManagedBean(name = "customer")
@RequestScoped
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer extends Person{

    @Column(length = 256, name = "required_vehicle_model",  columnDefinition = "varchar(255) default ''")
    private String requiredVehicleModel;

    public Customer(){

    }

    public Customer(String name, String requiredVehicleModel){
        this.setName(name);
        this.requiredVehicleModel = requiredVehicleModel;
    }

    public String getRequiredVehicleModel() {
        return requiredVehicleModel;
    }

    public void setRequiredVehicleModel(String requiredVehicleModel) {
        this.requiredVehicleModel = requiredVehicleModel;
    }
}
