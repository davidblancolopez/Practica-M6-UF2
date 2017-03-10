
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@NamedQueries({
//@NamedQuery(name="nomClient", query="SELECT p FROM M6UF2_Clients p WHERE p.nomClient =: nom")
//})
@Table(name = "M6UF2_CLIENTS")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //String on posem el nom de la consulta que es realitzara en aquesta entity.
//    public static final String consulta = "nomClient";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient" , unique = true)
    private long id;
    
    
    @Column(name = "nifClient", length = 9, nullable = false, unique = true)
    private String nif;

    @Column(name = "nomClient", length = 50)
    private String nom;

    @OneToMany (mappedBy = "propietari")
    private List<Vehicle> llistaVechiles;
    
    @OneToMany (mappedBy = "client")
    private List<Polissa> llistaPolises;
    
    @Embedded
    private Adreca adreca;

    
    
    
    public Client(Long id, String nif, String nom, Adreca adreca) {
        this.id = id;
        this.nif = nif;
        this.nom = nom;
        this.adreca = adreca;
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

    public List<Vehicle> getLlistaVechiles() {
        return llistaVechiles;
    }

    public void setLlistaVechiles(List<Vehicle> llistaVechiles) {
        this.llistaVechiles = llistaVechiles;
    }

    public List<Polissa> getLlistaPolises() {
        return llistaPolises;
    }

    public void setLlistaPolises(List<Polissa> llistaPolises) {
        this.llistaPolises = llistaPolises;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nif=" + nif + ", nom=" + nom + ", adreca=" + adreca + '}';
    }



    
    
}
