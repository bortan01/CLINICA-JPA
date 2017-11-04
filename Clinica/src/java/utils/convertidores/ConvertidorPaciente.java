package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Paciente;
import utils.lista.ListaPaciente;


@FacesConverter ("convertidorPaciente")
public class ConvertidorPaciente implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Paciente pos = null;
        if(value != null && value.trim().length() > 0) {
           ListaPaciente  service = (ListaPaciente) context.getExternalContext().getSessionMap().get("listaPaciente");
            for(int i=0; i<service.getListaPaciente().size(); i++){
                if(service.getListaPaciente().get(i).getIdPaciente() == Integer.parseInt(value))
                    pos= service.getListaPaciente().get(i);
            }
            return pos;
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Paciente) value).getIdPaciente());            
        }
        else {
            return null;
        }
    }
    
}
