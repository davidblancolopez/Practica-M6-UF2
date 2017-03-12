
package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "M6UF2_Asseguradores")
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //String on posem el nom de la consulta que es realitzara en aquesta entity.
//    public static final String consulta = "numPolissa";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAsseguradora;
    
    @Column(name = "nomAsseguradora", length = 100, nullable = false, unique = true)
    private String nomAsseguradora;
    
    @Column(name = "nifAsseguradora")
    private String nifAsseguradora;
    
    @OneToMany (mappedBy = "asseguradora")
    private List <Polissa> polissa;

    
    
    
    public Asseguradora() {
    }

    public Asseguradora(long idAsseguradora, String nomAsseguradora, String nifAsseguradora) {
        this.idAsseguradora = idAsseguradora;
        this.nomAsseguradora = nomAsseguradora;
        this.nifAsseguradora = nifAsseguradora;
    }

    
    
    
    
    
    public List<Polissa> getPolissa() {
        return polissa;
    }

    public void setPolissa(List<Polissa> polissa) {
        this.polissa = polissa;
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
        int hash = 7;
        hash = 67 * hash + (int) (this.idAsseguradora ^ (this.idAsseguradora >>> 32));
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
        final Asseguradora other = (Asseguradora) obj;
        if (!Objects.equals(this.idAsseguradora, other.idAsseguradora)) {
            return false;
        }
        return true;
    }

    

    
    

    @Override
    public String toString() {
        return "Asseguradora{" + "id=" + idAsseguradora + ", nomAsseguradora=" + nomAsseguradora + ", nifAsseguradora=" + nifAsseguradora + '}';
    }


    
}
