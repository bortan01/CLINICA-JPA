package controlador.beans;

//import java.io.IOException;
//import java.io.InputStream;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.faces.model.SelectItem;
//import javax.inject.Inject;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Cita;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import session.beans.CitaFacade;
import utils.general.AutoCompleteBeanDoctor;
import utils.general.AutoCompleteBeanPaciente;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



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

private SelectItem[] opcionEstado = new SelectItem[]{new SelectItem(1),
        new SelectItem(0)};
    private String opcionActualEstado;


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
    
    public String actualizarEstado() {
      
        citaSeleccionada.setEstado(0);
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

    public SelectItem[] getOpcionEstado() {
        return opcionEstado;
    }

    public void setOpcionEstado(SelectItem[] opcionEstado) {
        this.opcionEstado = opcionEstado;
    }

    public String getOpcionActualEstado() {
        return opcionActualEstado;
    }

    public void setOpcionActualEstado(String opcionActualEstado) {
        this.opcionActualEstado = opcionActualEstado;
    }

    public void mostrarPDF() throws JRException{
       FacesContext context = FacesContext.getCurrentInstance();
HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
Map<String,Object> parametros;
        parametros = new HashMap<>();
parametros.put("", "");
//pega o caminho do arquivo .jasper da aplicação


InputStream reportStream = context.getExternalContext().getResourceAsStream("/docs/reportes/mascotaCita.jasper");
    //File jasper =new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteAlumnos.jasper"));
    //JasperPrint jasperPrint =  JasperFillManager.fillReport(reportStream, null, new JRBeanCollectionDataSource(this.getLstAlumno()));
    byte[] bytes= JasperRunManager.runReportToPdf(reportStream, parametros,new JRBeanCollectionDataSource(this.listaCita));
    //HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream stream;
        try {
            stream = response.getOutputStream();
            stream.write(bytes, 0, bytes.length);
            //JasperExportManager.exportReportToPdfStream(jasperPrint2, stream);
    stream.flush();
    stream.close();
        } catch (IOException ex) {
            Logger.getLogger(CitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    FacesContext.getCurrentInstance().responseComplete();
    
    }

}
