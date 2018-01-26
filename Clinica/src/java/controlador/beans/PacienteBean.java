package controlador.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import modelo.entidades.Paciente;
import session.beans.PacienteFacade;
import utils.general.AutoCompleteBeanClinica;


@ManagedBean (name ="pacienteBean")
@ViewScoped
public class PacienteBean implements Serializable{
@Inject
PacienteFacade PacienteFac;

@ManagedProperty("#{autoCompleteBeanClinica}")
    AutoCompleteBeanClinica auC;


Paciente PacienteSeleccionado ;    
List<Paciente> listaPaciente;
List<Paciente> PacienteFiltrado;
private SelectItem[] opcionesGenero = new SelectItem[]{new SelectItem("MACHO"),
        new SelectItem("HEMBRA")};
    private String opcionActualGenero;

 @PostConstruct
    public void init() {
        PacienteSeleccionado = new Paciente();
        BuscarPaciente();
    }

    public PacienteBean() {
    }
    
    public List<Paciente>BuscarPaciente(){
    listaPaciente = PacienteFac.findAll();
    return listaPaciente;
    }
    
public String eliminarPaciente() {
        PacienteFac.remove(PacienteSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "listar_paciente.xhtml?faces-redirect=true";
    }
    
    public String actualizarPaciente() {
        PacienteSeleccionado.setIdClinica(auC.getClinica());
        PacienteFac.edit(PacienteSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_paciente.xhtml?faces-redirect=true";
    }
  public String insertarPaciente() {
      PacienteSeleccionado.setIdClinica(auC.getClinica());
        PacienteFac.create(PacienteSeleccionado);
         return "listar_paciente.xhtml?faces-redirect=true";
    }

    public PacienteFacade getPacienteFac() {
        return PacienteFac;
    }

    public void setPacienteFac(PacienteFacade PacienteFac) {
        this.PacienteFac = PacienteFac;
    }

    public Paciente getPacienteSeleccionado() {
        return PacienteSeleccionado;
    }

    public void setPacienteSeleccionado(Paciente PacienteSeleccionado) {
        this.PacienteSeleccionado = PacienteSeleccionado;
    }

    public List<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public void setListaPaciente(List<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }

    public List<Paciente> getPacienteFiltrado() {
        return PacienteFiltrado;
    }

    public void setPacienteFiltrado(List<Paciente> PacienteFiltrado) {
        this.PacienteFiltrado = PacienteFiltrado;
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

    public AutoCompleteBeanClinica getAuC() {
        return auC;
    }

    public void setAuC(AutoCompleteBeanClinica auC) {
        this.auC = auC;
    }


}
