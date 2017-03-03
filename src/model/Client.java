
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="nomClient", query="SELECT p FROM M6UF2_Clients p WHERE p.nomClient =: nom")
})


@Table(name = "M6UF2_CLIENTS")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //String on posem el nom de la consulta que es realitzara en aquesta entity.
    public static final String consulta = "nomClient";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient" , unique = true)
    private Long id;
    
    
    @Column(name = "nifClient", length = 9, nullable = false)
    private String nif;

    
    @Column(name = "nomClient", nullable = false)
    private String nom;

    @Embedded
    private Adreca adreca;

    public Client(int id, String nif, String nom, String carrer, int numero, String poblacio) {
        this.nif = nif;
        this.nom = nom;
        this.adreca = new Adreca(carrer, numero, poblacio);
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
