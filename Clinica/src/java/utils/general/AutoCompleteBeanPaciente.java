package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Paciente;
import utils.lista.ListaPaciente;

@ManagedBean(name = "autoCompleteBeanPaciente")
@SessionScoped
public class AutoCompleteBeanPaciente implements Serializable {

    @ManagedProperty("#{listaPaciente}")
    ListaPaciente pacienteDataxxx;
    Paciente paciente;

    public List<Paciente> completePacienteDespacho(String query) {
        List<Paciente> allPaciente = getpacienteDataxxx().getListaPaciente();
        List<Paciente> filterPaciente = new ArrayList<Paciente>();
        for (Paciente pacienteSelected : allPaciente) {
            if (pacienteSelected.getNombre().toLowerCase().startsWith(query) || pacienteSelected.getApellido().toLowerCase().startsWith(query)  || pacienteSelected.getDireccion().toLowerCase().startsWith(query)) {
                filterPaciente.add(pacienteSelected);
            }
        }
        return filterPaciente;
    }

    public ListaPaciente getpacienteDataxxx() {
        return pacienteDataxxx;
    }

    public void setpacienteDataxxx(ListaPaciente pacienteDataxxx) {
        this.pacienteDataxxx = pacienteDataxxx;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
