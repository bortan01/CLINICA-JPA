package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import session.beans.ClinicaFacade;
import modelo.entidades.Clinica;

@ManagedBean (name = "listaClinica")
@SessionScoped
public class ListaClinica implements Serializable{

    @Inject
    ClinicaFacade clinicaFacade;
    public List<Clinica> listaClinica;

    @PostConstruct
    public void init() {
        listaClinica = llenarLista();
    }

    public List<Clinica> llenarLista() {
        return clinicaFacade.findAll();
    }
    
    
    public ListaClinica() {
    }

    public ClinicaFacade getClinicaFacade() {
        return clinicaFacade;
    }

    public void setClinicaFacade(ClinicaFacade clinicaFacade) {
        this.clinicaFacade = clinicaFacade;
    }

    public List<Clinica> getListaClinica() {
        return listaClinica;
    }

    public void setListaClinica(List<Clinica> listaClinica) {
        this.listaClinica = listaClinica;
    }
    
}
