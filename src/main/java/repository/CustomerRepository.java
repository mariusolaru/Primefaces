package repository;

import entity.Customer;
import javax.ejb.Stateless;

@Stateless
public class CustomerRepository extends DataRepository<Customer, Long> {

    public CustomerRepository(){
        super(Customer.class);
    }

}
