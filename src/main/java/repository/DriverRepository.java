package repository;

import entity.Driver;

import javax.ejb.Stateless;

@Stateless
public class DriverRepository extends DataRepository<Driver, Long> {

    public DriverRepository(){
        super(Driver.class);
    }

}
