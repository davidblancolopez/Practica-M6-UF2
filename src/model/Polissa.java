
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity

@NamedQueries({
@NamedQuery(name="cercaPolissasClient", query="SELECT p FROM Polissa p WHERE p.client.id=:id"),
@NamedQuery(name="asignarVehicle", query="SELECT v FROM Vehicle v WHERE v.idVehicle=:vehicleId"), 
@NamedQuery(name="asignarAsseguradora", query="SELECT a FROM Asseguradora a WHERE a.idAsseguradora=:aseguradoraId"), 
@NamedQuery(name="asignarClient", query="SELECT c FROM Client c WHERE c.id=:id"), 
@NamedQuery(name="cercaPolissaPerVehicle", query="SELECT p FROM Polissa p WHERE p.vehicle.idVehicle=:idVehicle")})

@Table (name = "M6UF2_Polissas", indexes = {@Index(columnList = "clientId", name = "indexPrenedor")})


public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPolissa", unique = true)
    private long idPolissa;

    @Column(name = "numeroPolissa", length = 10)
    private String numeroPolissa;
    
    @OneToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;
    
    @ManyToOne 
    @JoinColumn(name = "clientId")
    private Client client;
    
    @Column (name = "dataInici", nullable = false)
    private Date dataInici;
    
    @Column (name = "dataFi", nullable = false)
    private Date dataFi;
    
    @Column (name = "tipus")
    private boolean tipus;
    
    @Column (name = "prima")
    private double prima;
    
    @ManyToOne
    @JoinColumn(name = "asseguradoraId")
    private Asseguradora asseguradora;
    

    
    //GETTER i SETTER

    public long getIdPolissa() {
        return idPolissa;
    }

    public void setIdPolissa(long idPolissa) {
        this.idPolissa = idPolissa;
    }

    public String getNumeroPolissa() {
        return numeroPolissa;
    }

    public void setNumeroPolissa(String numeroPolissa) {
        this.numeroPolissa = numeroPolissa;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client cliente) {
        this.client = cliente;
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

    public Asseguradora getAsseguradora() {
        return asseguradora;
    }

    public void setAsseguradora(Asseguradora asseguradora) {
        this.asseguradora = asseguradora;
    }
    
    
    
    public Polissa() {
    }

    public Polissa(long idPolissa, String numero, Vehicle vehicle, Client cliente, Date dataInici, Date dataFi, boolean tipus, double prima, Asseguradora asseguradora) {
        this.idPolissa = idPolissa;
        this.numeroPolissa = numero;
        this.vehicle = vehicle;
        this.client = cliente;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
        this.asseguradora = asseguradora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.idPolissa ^ (this.idPolissa >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polissa other = (Polissa) obj;
        if (this.idPolissa != other.idPolissa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "idPolissa=" + idPolissa + ", numeroPolissa=" + numeroPolissa + ", vehicle=" + vehicle + ", cliente=" + client + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + ", asseguradora=" + asseguradora + '}';
    }


    
}
