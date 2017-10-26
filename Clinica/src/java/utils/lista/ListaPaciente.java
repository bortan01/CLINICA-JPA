package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import session.beans.PacienteFacade;
import modelo.entidades.Paciente;

@ManagedBean (name = "listaPaciente")
@SessionScoped
public class ListaPaciente implements Serializable{

    @Inject
    PacienteFacade PacienteFacade;
    public List<Paciente> listaPaciente;

    @PostConstruct
    public void init() {
        listaPaciente = llenarLista();
    }

    public List<Paciente> llenarLista() {
        return PacienteFacade.findAll();
    }
   public ListaPaciente() {
    }

    public PacienteFacade getPacienteFacade() {
        return PacienteFacade;
    }

    public void setPacienteFacade(PacienteFacade PacienteFacade) {
        this.PacienteFacade = PacienteFacade;
    }

    public List<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public void setListaPaciente(List<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }


      
    
}
