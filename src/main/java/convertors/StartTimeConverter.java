package convertors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalTime;

@FacesConverter("converters.StartTimeConverter")
public class StartTimeConverter implements Converter<LocalTime> {

    @Override
    public LocalTime getAsObject(FacesContext facesContext,
                                 UIComponent uIComponent,
                                 String string) {
        return LocalTime.parse(string);
    }

    @Override
    public String getAsString(FacesContext facesContext,
                              UIComponent uIComponent,
                              LocalTime localTime) {
        return localTime.toString();
    }
}