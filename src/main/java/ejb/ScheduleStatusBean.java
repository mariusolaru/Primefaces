package ejb;

import entity.Driver;
import entity.Trip;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ScheduleStatusBean {

    private static Map<Driver, Trip> assignments;

    static {
        assignments = new HashMap<>();
    }

    public synchronized void addAssignment(Driver driver, Trip trip) {
        assignments.put(driver, trip);
    }

}
