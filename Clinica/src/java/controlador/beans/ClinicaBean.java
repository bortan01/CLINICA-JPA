package controlador.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import modelo.entidades.Clinica;
import session.beans.ClinicaFacade;

@ManagedBean
@RequestScoped
public class ClinicaBean implements Serializable{
@Inject
ClinicaFacade clinicaFac;
Clinica clinicaSeleccionada ;    
List<Clinica> listaClinica;
List<Clinica> ClinicaFiltrada;

    public ClinicaBean() {
    }
    
    public List<Clinica>BuscarClinicas(){
    listaClinica = clinicaFac.findAll();
    return listaClinica;
    }
    
}
