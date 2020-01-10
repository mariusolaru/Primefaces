package repository.connection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.*;

@Stateless
public class EntityManagerProducer {

    @PersistenceContext(unitName = "jdbcpostgres")
    private EntityManager entityManager;

    @Produces
    public EntityManager entityManager() {
        return entityManager;
    }
}

