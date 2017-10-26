package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import session.beans.DoctorFacade;
import modelo.entidades.Doctor;

@ManagedBean (name = "listaDoctor")
@SessionScoped
public class ListaDoctor implements Serializable{

    @Inject
    DoctorFacade DoctorFacade;
    public List<Doctor> listaDoctor;

    @PostConstruct
    public void init() {
        listaDoctor = llenarLista();
    }

    public List<Doctor> llenarLista() {
        return DoctorFacade.findAll();
    }
   public ListaDoctor() {
    }

    public DoctorFacade getDoctorFacade() {
        return DoctorFacade;
    }

    public void setDoctorFacade(DoctorFacade DoctorFacade) {
        this.DoctorFacade = DoctorFacade;
    }

    public List<Doctor> getListaDoctor() {
        return listaDoctor;
    }

    public void setListaDoctor(List<Doctor> listaDoctor) {
        this.listaDoctor = listaDoctor;
    }

    
    
}
