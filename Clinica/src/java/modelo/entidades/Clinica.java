/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinica.findAll", query = "SELECT c FROM Clinica c"),
    @NamedQuery(name = "Clinica.findByIdClinica", query = "SELECT c FROM Clinica c WHERE c.idClinica = :idClinica"),
    @NamedQuery(name = "Clinica.findByNombre", query = "SELECT c FROM Clinica c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clinica.findByLocalizacion", query = "SELECT c FROM Clinica c WHERE c.localizacion = :localizacion")})
public class Clinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clinica")
    private Integer idClinica;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "localizacion")
    private String localizacion;
    @OneToMany(mappedBy = "idClinica")
    private List<Paciente> pacienteList;

    public Clinica() {
    }

    public Clinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClinica != null ? idClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinica)) {
            return false;
        }
        Clinica other = (Clinica) object;
        if ((this.idClinica == null && other.idClinica != null) || (this.idClinica != null && !this.idClinica.equals(other.idClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Clinica[ idClinica=" + idClinica + " ]";
    }
    
}
