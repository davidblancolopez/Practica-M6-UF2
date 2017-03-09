
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "M6UF2_Polissas", indexes = {@Index(columnList = "prenedor", name = "indexPrenedor")})
//@NamedQueries({
//@NamedQuery(name="numPolissa", query="SELECT p FROM Polisses p WHERE p.numPolissa := numPolissa"),
//@NamedQuery(name="numPolissaClient", query="SELECT p FROM Polisses p WHERE p.clientId := idClient"),
//@NamedQuery(name="numPolissaVehicle", query="SELECT p FROM Polisses p WHERE p.vehicleId := idVehicle"),
//@NamedQuery(name="TotesPolissa", query="SELECT p FROM Polisses p WHERE p.numPolissa := numPolissa")
//})

public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //String on posem el nom de la consulta que es realitzara en aquesta entity.
//    public static final String consultaPolises = "numPolissa";
//    public static final String consultaPolisesClient = "numPolissaClient";
//    public static final String consultaPolisesVehicle = "numPolissaClient";
//    public static final String consultaTotesPolises= "TotesPolissa";
    
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
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idPolissa);
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
        if (!Objects.equals(this.idPolissa, other.idPolissa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "idPolissa=" + idPolissa + ", numeroPolissa=" + numeroPolissa + ", nom=" + nom + ", prenedor=" + prenedor + ", vehicle=" + vehicle + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + '}';
    }


    
    
}
