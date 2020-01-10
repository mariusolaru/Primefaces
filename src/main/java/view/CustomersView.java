package view;

import dto.CustomerDTO;
import dto.DepotDTO;
import entity.Customer;
import entity.Depot;
import entity.Vehicle;
import repository.CustomerRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "customersView")
@RequestScoped
public class CustomersView extends DataView<Customer> implements Serializable {

    private CustomerDTO customerDTO = new CustomerDTO();

    @EJB
    private CustomerRepository customerRepository;

    public CustomersView() {
        super(Customer.class);
    }

    @PostConstruct
    public void init() {
        entities = customerRepository.findAll();
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public void delete(Long id){
        Customer customer = customerRepository.findById(id);
        customerRepository.remove(customer);
    }

    public void addCustomer(){
        Customer customer = new Customer();

        //Mapping from DTO to DB entity
        customer.setName(customerDTO.getName());
        customer.setRequiredVehicleModel(customerDTO.getRequiredVehicleModel());

        customerRepository.persist(customer);
        this.entities = customerRepository.findAll();

        this.customerDTO = new CustomerDTO();
    }
}
