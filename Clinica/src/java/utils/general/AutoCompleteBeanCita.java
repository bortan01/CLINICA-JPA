package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Cita;
import utils.lista.ListaCita;

@ManagedBean(name = "autoCompleteBeanAlumno")
@SessionScoped
public class AutoCompleteBeanCita implements Serializable {

    @ManagedProperty("#{listasAlumnos}")
    ListaCita CitaData;
    Cita cita;

    public List<Cita> completeAlumnoDespacho(String query) {
        List<Cita> allCita = getCitaData().getListaCita();
        List<Cita> filterCita = new ArrayList<Cita>();
        for (Cita CitaSelected : allCita) {
            if (CitaSelected.getIdDoctor().getNombre().toLowerCase().startsWith(query)) {
                filterCita.add(CitaSelected);
            }
        }
        return filterCita;
    }

    public ListaCita getCitaData() {
        return CitaData;
    }

    public void setCitaData(ListaCita CitaData) {
        this.CitaData = CitaData;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    
    
}
