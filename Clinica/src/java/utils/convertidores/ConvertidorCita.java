package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Cita;
import utils.lista.ListaCita;


@FacesConverter ("convertidorCita")
public class ConvertidorCita implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
           ListaCita  service = (ListaCita) context.getExternalContext().getSessionMap().get("listaCita");
           for(int i=0; i<service.getListaCita().size(); i++){
                if(service.getListaCita().get(i).getIdCita().equals(value))
                    pos=i;
            }
            return service.getListaCita().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Cita) value).getIdCita());            
        }
        else {
            return null;
        }
    }
    
}
