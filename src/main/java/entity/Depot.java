package entity;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "depots")
@ManagedBean(name = "depotComplete")
@RequestScoped
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Depot extends AbstractEntity {

    @Column(length = 256)
    private String name;

    private int capacity;

    @Column(name = "x_coordinate", columnDefinition = "integer default 0")
    private int xCoordinate;

    @Column(name = "y_coordinate", columnDefinition = "integer default 0")
    private int yCoordinate;

    public Depot() {

    }
    public Depot(long id, String name, int capacity, int xCoordinate, int yCoordinate) {
        this.setId(id);
        this.name = name;
        this.capacity = capacity;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Depot(long id, String name, int capacity) {
        this.setId(id);
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
