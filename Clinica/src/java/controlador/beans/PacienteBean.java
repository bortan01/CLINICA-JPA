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
import modelo.entidades.Paciente;
import session.beans.PacienteFacade;


@ManagedBean (name ="pacienteBean")
@ViewScoped
public class PacienteBean implements Serializable{
@Inject
PacienteFacade PacienteFac;
Paciente PacienteSeleccionado ;    
List<Paciente> listaPaciente;
List<Paciente> PacienteFiltrado;
private SelectItem[] opcionesGenero = new SelectItem[]{new SelectItem("MASCULINO"),
        new SelectItem("FEMENINO")};
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
        PacienteFac.edit(PacienteSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_paciente.xhtml?faces-redirect=true";
    }
  public String insertarPaciente() {
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


}
