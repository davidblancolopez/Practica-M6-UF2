
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@NamedQueries({
@NamedQuery(name="numPolissa", query="SELECT p FROM Polisses p WHERE p.numPolissa := numPolissa")
})
@Table (name = "M6UF2_Asseguradores")
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //String on posem el nom de la consulta que es realitzara en aquesta entity.
    public static final String consulta = "numPolissa";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAsseguradora;
    
    @Column(name = "nomAsseguradora", length = 100, nullable = false, unique = true)
    private String nomAsseguradora;
    
    @Column(name = "nifAsseguradora", nullable = false)
    private String nifAsseguradora;

    public Asseguradora() {
    }
    
    public Asseguradora(String nomAsseguradora, String nifAsseguradora) {
        this.nomAsseguradora = nomAsseguradora;
        this.nifAsseguradora = nifAsseguradora;
    }
    
    

    public Long getIdAsseguradora() {
        return idAsseguradora;
    }

    public void setIdAsseguradora(Long idAsseguradora) {
        this.idAsseguradora = idAsseguradora;
    }

    public String getNomAsseguradora() {
        return nomAsseguradora;
    }

    public void setNomAsseguradora(String nomAsseguradora) {
        this.nomAsseguradora = nomAsseguradora;
    }

    public String getNifAsseguradora() {
        return nifAsseguradora;
    }

    public void setNifAsseguradora(String nifAsseguradora) {
        this.nifAsseguradora = nifAsseguradora;
    }

    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsseguradora != null ? idAsseguradora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asseguradora)) {
            return false;
        }
        Asseguradora other = (Asseguradora) object;
        if ((this.idAsseguradora == null && other.idAsseguradora != null) || (this.idAsseguradora != null && !this.idAsseguradora.equals(other.idAsseguradora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "id=" + idAsseguradora + ", nomAsseguradora=" + nomAsseguradora + ", nifAsseguradora=" + nifAsseguradora + '}';
    }


    
}
