package view;

import dto.DepotDTO;
import dto.DriverDTO;
import entity.Driver;
import entity.Vehicle;
import repository.DriverRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "driversView")
@RequestScoped
public class DriversView extends DataView<Driver> implements Serializable {

    private DriverDTO driverDTO = new DriverDTO();

    @EJB
    private DriverRepository driverRepository;

    public DriversView() {
        super(Driver.class);
    }

    @PostConstruct
    public void init() {
        entities = driverRepository.findAll();
    }

    public DriverDTO getDriverDTO() {
        return driverDTO;
    }

    public void setDriverDTO(DriverDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public void delete(Long id){
        Driver driver = driverRepository.findById(id);
        driverRepository.remove(driver);
    }

    public void addDriver(){
        Driver driver = new Driver();

        //Mapping from DTO to DB entity
        driver.setName(driverDTO.getName());
        driver.setDriverLicenseType(driverDTO.getDriverLicenseType());
        driverRepository.persist(driver);
        this.entities = driverRepository.findAll();

        this.driverDTO = new DriverDTO();
    }
}
