package controlador.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import modelo.entidades.Doctor;
import session.beans.DoctorFacade;


@ManagedBean (name ="doctorBean")
@ViewScoped
public class DoctorBean implements Serializable{
@Inject
DoctorFacade doctorFac;
Doctor doctorSeleccionado ;    
List<Doctor> listaDoctor;
List<Doctor> DoctorFiltrado;
private SelectItem[] opcionesGenero = new SelectItem[]{new SelectItem("MASCULINO"),
        new SelectItem("FEMENINO")};
    private String opcionActualGenero;

 @PostConstruct
    public void init() {
        doctorSeleccionado = new Doctor();
        BuscarClinicas();
    }

    public DoctorBean() {
    }
    
    public List<Doctor>BuscarClinicas(){
    listaDoctor = doctorFac.findAll();
    return listaDoctor;
    }
    
public String eliminarClinica() {
        doctorFac.remove(doctorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "listar_doctor.xhtml?faces-redirect=true";
    }
    
    public String actualizarClinica() {
        doctorFac.edit(doctorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_doctor.xhtml?faces-redirect=true";
    }
  public String insertarClinica() {
        doctorFac.create(doctorSeleccionado);
            return "listar_doctor.xhtml?faces-redirect=true";
    }

    public DoctorFacade getDoctorFac() {
        return doctorFac;
    }

    public void setDoctorFac(DoctorFacade doctorFac) {
        this.doctorFac = doctorFac;
    }

    public Doctor getDoctorSeleccionado() {
        return doctorSeleccionado;
    }

    public void setDoctorSeleccionado(Doctor doctorSeleccionado) {
        this.doctorSeleccionado = doctorSeleccionado;
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

    public SelectItem[] getOpcionesGenero() {
        return opcionesGenero;
    }

    public void setOpcionesGenero(SelectItem[] opcionesGenero) {
        this.opcionesGenero = opcionesGenero;
    }

    public String getOpcionActualGenero() {
        return opcionActualGenero;
    }

    public void setOpcionActualGenero(String opcionActualGenero) {
        this.opcionActualGenero = opcionActualGenero;
    }


}
