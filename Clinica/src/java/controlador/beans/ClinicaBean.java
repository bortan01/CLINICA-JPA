package controlador.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Clinica;
import session.beans.ClinicaFacade;

@ManagedBean (name ="clinicaBean")
@ViewScoped
public class ClinicaBean implements Serializable{
@Inject
ClinicaFacade clinicaFac;
Clinica clinicaSeleccionada ;    
List<Clinica> listaClinica;
List<Clinica> ClinicaFiltrada;

 @PostConstruct
    public void init() {
        clinicaSeleccionada = new Clinica();
        BuscarClinicas();
    }

    public ClinicaBean() {
    }
    
    public List<Clinica>BuscarClinicas(){
    listaClinica = clinicaFac.findAll();
    return listaClinica;
    }
    
public String eliminarClinica() {
        clinicaFac.remove(clinicaSeleccionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "listar_clinica.xhtml?faces-redirect=true";
    }
    
    public String actualizarClinica() {
        clinicaFac.edit(clinicaSeleccionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_clinica.xhtml?faces-redirect=true";
    }
  public String insertarClinica() {
        clinicaFac.create(clinicaSeleccionada);
            return "listar_clinica.xhtml?faces-redirect=true";
    }

    public ClinicaFacade getClinicaFac() {
        return clinicaFac;
    }

    public void setClinicaFac(ClinicaFacade clinicaFac) {
        this.clinicaFac = clinicaFac;
    }

    public Clinica getClinicaSeleccionada() {
        return clinicaSeleccionada;
    }

    public void setClinicaSeleccionada(Clinica clinicaSeleccionada) {
        this.clinicaSeleccionada = clinicaSeleccionada;
    }

    public List<Clinica> getListaClinica() {
        return listaClinica;
    }

    public void setListaClinica(List<Clinica> listaClinica) {
        this.listaClinica = listaClinica;
    }

    public List<Clinica> getClinicaFiltrada() {
        return ClinicaFiltrada;
    }

    public void setClinicaFiltrada(List<Clinica> ClinicaFiltrada) {
        this.ClinicaFiltrada = ClinicaFiltrada;
    }


}
