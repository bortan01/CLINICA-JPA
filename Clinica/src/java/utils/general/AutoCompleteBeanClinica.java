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
    ListaClinica clinica_data;
    Clinica clinica;

    public List<Clinica> completeDoctorDespacho(String query) {
        List<Clinica> allDoctor = getClinica_data().getListaClinica();
        List<Clinica> filterDoctor = new ArrayList<Clinica>();
        for (Clinica doctorSelected : allDoctor) {
            if (doctorSelected.getNombre().toLowerCase().startsWith(query)) {
                filterDoctor.add(doctorSelected);
            }
        }
        return filterDoctor;
    }

    public ListaClinica getClinica_data() {
        return clinica_data;
    }

    public void setClinica_data(ListaClinica clinica_data) {
        this.clinica_data = clinica_data;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

}
