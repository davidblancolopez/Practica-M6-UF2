
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="clientNom", query="SELECT p FROM Persona p WHERE p.nomClient =: nom")
})


@Table(name = "M6UF2_CLIENTS")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient" , unique = true)
    private Long id;
    
    
    @Column(name = "nifClient", length = 9, nullable = false)
    private String nif;

    
    @Column(name = "nomClient", nullable = false)
    private String nom;

    @OneToOne(cascade = {CascadeType.ALL})
    @Column(name = "AdrecaClient", nullable = false)
    private Adreca adreca;

    @OneToMany(mappedBy = "vehicleId")
    private Vehicle vehicle;
    
    @OneToOne(mappedBy = "prenedor")
    private Polissa polissa;
    
    
    public Client(String nif, String nom) {
       
        this.nif = nif;
        this.nom = nom;
        
    }

    public Client() {
   
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //GETS I SETS
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Polissa getPolissa() {
        return polissa;
    }

    public void setPolissa(Polissa polissa) {
        this.polissa = polissa;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nif=" + nif + ", nom=" + nom + ", adreca=" + adreca + '}';
    }

    
    
}
