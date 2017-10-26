package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Clinica;
import utils.lista.ListaClinica;

@ManagedBean(name = "autoCompleteBeanClinica")
@SessionScoped
public class AutoCompleteBeanClinica implements Serializable {

    @ManagedProperty("#{listaClinica}")
    ListaClinica clinicaData;
    Clinica clinica;

    public List<Clinica> completeClinicaDespacho(String query) {
        List<Clinica> allClinica = getClinicaData().getListaClinica();
        List<Clinica> filterClinica = new ArrayList<Clinica>();
        for (Clinica clinicaSelected : allClinica) {
            if (clinicaSelected.getNombre().toLowerCase().startsWith(query) || clinicaSelected.getLocalizacion().toLowerCase().startsWith(query)) {
                filterClinica.add(clinicaSelected);
            }
        }
        return filterClinica;
    }

    public ListaClinica getClinicaData() {
        return clinicaData;
    }

    public void setClinicaData(ListaClinica clinicaData) {
        this.clinicaData = clinicaData;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
    
    
    

}
