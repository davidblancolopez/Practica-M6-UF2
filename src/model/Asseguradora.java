
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nomAsseguradora", length = 100, nullable = false)
    private String nomAsseguradora;
    
    @Column(name = "nifAsseguradora", length = 100, nullable = false)
    private String nifAsseguradora;

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

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Asseguradora)) {
            return false;
        }
        Asseguradora other = (Asseguradora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "id=" + id + ", nomAsseguradora=" + nomAsseguradora + ", nifAsseguradora=" + nifAsseguradora + '}';
    }


    
}
