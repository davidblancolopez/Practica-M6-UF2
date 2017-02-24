
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
        
    @Column(name = "numeroPolissa", length = 10, nullable = false)
    private String numeroPolissa;
    
    @Column(name = "prenedor", nullable = false)
    private Client nom;
    
    @Column(name = "vehicle", nullable = false)
    private Vehicle vehicle;
    
    @Column(name = "dataInici", nullable = false)
    private Calendar dataInici;
    
    @Column(name = "dataFi", nullable = false)
    private Calendar dataFi;
    
    //MIRAR BIEN
    @Column(name = "tipusPolissa", nullable = false)
    private String tipusPolissa;
    
    @Column(name = "prima", nullable = false)
    private double prima;
    
    
    public String getNumeroPolissa() {
        return numeroPolissa;
    }

    public void setNumeroPolissa(String numeroPolissa) {
        this.numeroPolissa = numeroPolissa;
    }

    public Client getNom() {
        return nom;
    }

    public void setNom(Client nom) {
        this.nom = nom;
    }

    public Calendar getDataInici() {
        return dataInici;
    }

    public void setDataInici(Calendar dataInici) {
        this.dataInici = dataInici;
    }

    public Calendar getDataFi() {
        return dataFi;
    }

    public void setDataFi(Calendar dataFi) {
        this.dataFi = dataFi;
    }

    public String getTipusPolissa() {
        return tipusPolissa;
    }

    public void setTipusPolissa(String tipusPolissa) {
        this.tipusPolissa = tipusPolissa;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }
    
    //Falta llistaCobertures
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Polissa(Long id, String numeroPolissa, Client nom, Vehicle vehicle, Calendar dataInici, Calendar dataFi, String tipusPolissa, double prima) {
        this.id = id;
        this.numeroPolissa = numeroPolissa;
        this.nom = nom;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipusPolissa = tipusPolissa;
        this.prima = prima;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polissa)) {
            return false;
        }
        Polissa other = (Polissa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Polissa[ id=" + id + " ]";
    }
    
}
