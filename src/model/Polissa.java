
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPolissa", unique = true)
    private Long idPolissa;

    
        
    @Column(name = "numeroPolissa", length = 10)
    private String numeroPolissa;
    
    @Column(name = "prenedor", nullable = false)
    private Client nom;
    
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", nullable = false)
    private Client prenedor;
    
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleId", nullable =  false)
    private Vehicle vehicle;
    
    @Column (name = "dataInici", nullable = false)
    private Date dataInici;
    
    @Column (name = "dataFi", nullable = false)
    private Date dataFi;
    
    @Column (name = "tipusPolissa", nullable = false)
    private boolean tipus;
    
    @Column (name = "primaPolissa", nullable = false)
    private double prima;

   
    
    //GETTER i SETTER
    public Long getIdPolissa() {
        return idPolissa;
    }

    public void setIdPolissa(Long idPolissa) {
        this.idPolissa = idPolissa;
    }

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

    public Client getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public boolean isTipus() {
        return tipus;
    }

    public void setTipus(boolean tipus) {
        this.tipus = tipus;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public Polissa(String numeroPolissa, Date dataInici, Date dataFi, boolean tipus, double prima) {
        this.numeroPolissa = numeroPolissa;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
    }

    public Polissa() {
    }


    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPolissa != null ? idPolissa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polissa)) {
            return false;
        }
        Polissa other = (Polissa) object;
        if ((this.idPolissa == null && other.idPolissa != null) || (this.idPolissa != null && !this.idPolissa.equals(other.idPolissa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Polissa[ id=" + idPolissa + " ]";
    }
    
}
