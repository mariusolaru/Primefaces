package view;

import dto.AssignmentDTO;
import ejb.AssignmentBean;
import ejb.ScheduleStatusBean;
import ejb.TripCheckingBean;
import entity.Driver;
import entity.Trip;
import repository.DriverRepository;
import repository.TripRepository;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class AssignmentView {

    private AssignmentDTO assignmentDTO = new AssignmentDTO();

    @EJB
    private DriverRepository driverRepository;

    @EJB
    private TripRepository tripRepository;

    @EJB
    private AssignmentBean assignmentBean;

    @EJB
    private ScheduleStatusBean scheduleStatusBean;

    @EJB
    private TripCheckingBean tripCheckingBean;

    public AssignmentDTO getAssignmentDTO() {
        return assignmentDTO;
    }

    public void setAssignmentDTO(AssignmentDTO assignmentDTO) {
        this.assignmentDTO = assignmentDTO;
    }

    public void assignDriverToTrip(){
        if (!tripCheckingBean.checkIfAssignmentIsPossible(assignmentDTO.getDriverId(), assignmentDTO.getTripId())) {
            FacesMessage message = new FacesMessage("Assignment is not possible", "Timing conflict");
            FacesContext.getCurrentInstance().addMessage(":form", message);
        } else {
            Driver driver = driverRepository.findById(assignmentDTO.getDriverId());
            Trip trip = tripRepository.findById(assignmentDTO.getTripId());

            scheduleStatusBean.addAssignment(driver, trip);
            assignmentBean.assignDriverToTrip(driver, trip);
        }

    }

}
