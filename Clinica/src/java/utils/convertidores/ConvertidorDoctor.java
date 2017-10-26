package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Doctor;
import utils.lista.ListaDoctor;


@FacesConverter ("convertidorDoctor")
public class ConvertidorDoctor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
           ListaDoctor  service = (ListaDoctor) context.getExternalContext().getSessionMap().get("listaDoctor");
            for(int i=0; i<service.getListaDoctor().size(); i++){
                if(service.getListaDoctor().get(i).getIdDoctor().equals(value))
                    pos=i;
            }
            return service.getListaDoctor().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Doctor) value).getIdDoctor());            
        }
        else {
            return null;
        }
    }
    
}
