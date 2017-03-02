
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAsseguradora;
    
    @Column(name = "nomAsseguradora", length = 100, nullable = false, unique = true)
    private String nomAsseguradora;
    
    @Column(name = "nifAsseguradora", nullable = false)
    private String nifAsseguradora;

    public Asseguradora() {
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

    

    public Asseguradora(Long id, String nomAsseguradora, String nifAsseguradora) {
        this.idAsseguradora = id;
        this.nomAsseguradora = nomAsseguradora;
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
