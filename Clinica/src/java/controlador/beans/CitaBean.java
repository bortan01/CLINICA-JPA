package controlador.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Cita;
import session.beans.CitaFacade;
import utils.general.AutoCompleteBeanDoctor;
import utils.general.AutoCompleteBeanPaciente;
        

@ManagedBean (name ="citaBean")
@ViewScoped
public class CitaBean implements Serializable{
@Inject
CitaFacade citaFac;

  @ManagedProperty("#{autoCompleteBeanDoctor}")
    AutoCompleteBeanDoctor auD;

    @ManagedProperty("#{autoCompleteBeanPaciente}")
    AutoCompleteBeanPaciente auP;


Cita citaSeleccionada ;    
List<Cita> listaCita;
List<Cita> ClinicaFiltrada;

 @PostConstruct
    public void init() {
        citaSeleccionada = new Cita();
        BuscarCitas();
    }

    public CitaBean() {
    }
    
    public List<Cita>BuscarCitas(){
    listaCita = citaFac.findAll();
    return listaCita;
    }
    
public String eliminarCita() {
        citaFac.remove(citaSeleccionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "listar_cita.xhtml?faces-redirect=true";
    }
    
    public String actualizarCita() {
      
        citaSeleccionada.setIdDoctor(auD.getDoctor());
        citaSeleccionada.setIdPaciente(auP.getPaciente());
        citaFac.edit(citaSeleccionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_cita.xhtml?faces-redirect=true";
    }
  public String insertarCita() {
      citaSeleccionada.setIdDoctor(auD.getDoctor());
        citaSeleccionada.setIdPaciente(auP.getPaciente());
        citaFac.create(citaSeleccionada);
            return "listar_cita.xhtml?faces-redirect=true";
    }

    public CitaFacade getCitaFac() {
        return citaFac;
    }

    public void setCitaFac(CitaFacade citaFac) {
        this.citaFac = citaFac;
    }

    public Cita getCitaSeleccionada() {
        return citaSeleccionada;
    }

    public void setCitaSeleccionada(Cita citaSeleccionada) {
        this.citaSeleccionada = citaSeleccionada;
    }

    public List<Cita> getListaCita() {
        return listaCita;
    }

    public void setListaCita(List<Cita> listaCita) {
        this.listaCita = listaCita;
    }

    public List<Cita> getClinicaFiltrada() {
        return ClinicaFiltrada;
    }

    public void setClinicaFiltrada(List<Cita> ClinicaFiltrada) {
        this.ClinicaFiltrada = ClinicaFiltrada;
    }

    public AutoCompleteBeanDoctor getAuD() {
        return auD;
    }

    public void setAuD(AutoCompleteBeanDoctor auD) {
        this.auD = auD;
    }

    public AutoCompleteBeanPaciente getAuP() {
        return auP;
    }

    public void setAuP(AutoCompleteBeanPaciente auP) {
        this.auP = auP;
    }

    

}
