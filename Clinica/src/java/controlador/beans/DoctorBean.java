package controlador.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import modelo.entidades.Doctor;
import session.beans.DoctorFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@ManagedBean (name= "doctorBean")
@ViewScoped
public class DoctorBean implements Serializable{
DoctorFacade DoctorFac;
Doctor DoctorSeleccionado;    
List<Doctor> listaDoctor;
List<Doctor> DoctorFiltrado;

    @PostConstruct
    public void init() {
        DoctorSeleccionado = new Doctor();
        BuscarDoctor();
    }
    
    public DoctorBean() {
    }
    
     public List<Doctor>BuscarDoctor(){
    listaDoctor = DoctorFac.findAll();
    return listaDoctor;
    }
    
public String eliminarDcotor() {
        DoctorFac.remove(DoctorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "listar_doctor.xhtml?faces-redirect=true";
    }
    
    public String actualizarDoctor() {
        DoctorFac.edit(DoctorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_doctor.xhtml?faces-redirect=true";
    }
  public String insertarDoctor(){
        DoctorFac.create(DoctorSeleccionado);
            return "listar_doctor.xhtml?faces-redirect=true";
    }

    public DoctorFacade getDoctorFac() {
        return DoctorFac;
    }

    public void setDoctorFac(DoctorFacade DoctorFac) {
        this.DoctorFac = DoctorFac;
    }

    public Doctor getDoctorSeleccionado() {
        return DoctorSeleccionado;
    }

    public void setDoctorSeleccionado(Doctor DoctorSeleccionado) {
        this.DoctorSeleccionado = DoctorSeleccionado;
    }

    public List<Doctor> getListaDoctor() {
        return listaDoctor;
    }

    public void setListaDoctor(List<Doctor> listaDoctor) {
        this.listaDoctor = listaDoctor;
    }

    public List<Doctor> getDoctorFiltrado() {
        return DoctorFiltrado;
    }

    public void setDoctorFiltrado(List<Doctor> DoctorFiltrado) {
        this.DoctorFiltrado = DoctorFiltrado;
    }
    
    
}
