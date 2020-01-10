package repository;

import entity.Vehicle;

import javax.ejb.Stateless;

@Stateless
public class VehicleRepository extends DataRepository<Vehicle, Long> {

    public VehicleRepository(){
        super(Vehicle.class);
    }

}
