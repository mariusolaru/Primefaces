package view;

import dto.DepotDTO;
import dto.TripDTO;
import entity.Customer;
import entity.Depot;
import entity.Trip;
import entity.Vehicle;
import repository.DepotRepository;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "depotsView")
@RequestScoped
public class DepotsView extends DataView<Depot> implements Serializable {

    private DepotDTO depotDTO = new DepotDTO();

    @EJB
    private DepotRepository depotRepository;

    public DepotsView() {
        super(Depot.class);
    }

    @PostConstruct
    public void init() {
        entities = depotRepository.findAll();
    }

    public DepotDTO getDepotDTO() {
        return depotDTO;
    }

    public void setDepotDTO(DepotDTO depotDTO) {
        this.depotDTO = depotDTO;
    }

    public void delete(Long id){
        Depot depot = depotRepository.findById(id);
        depotRepository.remove(depot);
    }

    public void addDepot(){
        Depot depot = new Depot();

        //Mapping from DTO to DB entity
        depot.setName(depotDTO.getName());
        depot.setCapacity(depotDTO.getCapacity());
        depot.setxCoordinate(depotDTO.getxCoordinate());
        depot.setyCoordinate(depotDTO.getyCoordinate());

        depotRepository.persist(depot);
        this.entities = depotRepository.findAll();

        this.depotDTO = new DepotDTO();
    }

}
