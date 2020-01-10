package repository;

import entity.Depot;

import javax.ejb.Stateless;

@Stateless
public class DepotRepository extends DataRepository<Depot, Long> {

    public DepotRepository(){
        super(Depot.class);
    }

}
