package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Clinica;
import utils.lista.ListaClinica;


@FacesConverter ("convertidorLibro")
public class ConvertidorClinica implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
           ListaClinica  service = (ListaClinica) context.getExternalContext().getSessionMap().get("listaClinica");
            for(int i=0; i<service.getListaClinica().size(); i++){
                if(service.getListaClinica().get(i).getIdClinica().equals(value))
                    pos=i;
            }
            return service.getListaClinica().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Clinica) value).getIdClinica());            
        }
        else {
            return null;
        }
    }
    
}
