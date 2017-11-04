package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Doctor;
import utils.lista.ListaDoctor;

@ManagedBean(name = "autoCompleteBeanDoctor")
@SessionScoped

public class AutoCompleteBeanDoctor implements Serializable {

    @ManagedProperty("#{listaDoctor}")
    ListaDoctor doctordatax;
    Doctor doctor;

    public List<Doctor> completeDoctorDespacho(String query) {
        List<Doctor> allDoctor = getdoctordatax().getListaDoctor();
        List<Doctor> filterDoctor = new ArrayList<Doctor>();
        for (Doctor doctorSelected : allDoctor) {
            if (doctorSelected.getNombre().toLowerCase().startsWith(query) || doctorSelected.getApellido().toLowerCase().startsWith(query)  || doctorSelected.getDireccion().toLowerCase().startsWith(query)) {
                filterDoctor.add(doctorSelected);
            }
        }
        return filterDoctor;
    }

    public ListaDoctor getdoctordatax() {
        return doctordatax;
    }

    public void setdoctordatax(ListaDoctor doctordatax) {
        this.doctordatax = doctordatax;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
    
}
