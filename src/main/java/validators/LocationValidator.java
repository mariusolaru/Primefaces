package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.LocationValidator")
public class LocationValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        try {
            float coordinate = Integer.parseInt(value.toString());
            if (coordinate < 0) {
                System.out.println("negative coordinate");
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error",
                        value + " is not a valid coordinate;"));
            }
        } catch (NumberFormatException nfe) {
            System.out.println("invalid coordinate");
            throw new ValidatorException(new FacesMessage("Coordinate must be integer"));
        }
    }
}
