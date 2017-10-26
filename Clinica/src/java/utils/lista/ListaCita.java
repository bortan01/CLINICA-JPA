package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import session.beans.CitaFacade;
import modelo.entidades.Cita;

@ManagedBean (name = "listaCita")
@SessionScoped
public class ListaCita implements Serializable{

    @Inject
    CitaFacade CitaFacade;
    public List<Cita> ListaCita;

    @PostConstruct
    public void init() {
        ListaCita = llenarLista();
    }

    public List<Cita> llenarLista() {
        return CitaFacade.findAll();
    }
   public ListaCita() {
    }

    public CitaFacade getCitaFacade() {
        return CitaFacade;
    }

    public void setCitaFacade(CitaFacade CitaFacade) {
        this.CitaFacade = CitaFacade;
    }

    public List<Cita> getListaCita() {
        return ListaCita;
    }

    public void setListaCita(List<Cita> ListaCita) {
        this.ListaCita = ListaCita;
    }

    
    
}
