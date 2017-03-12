package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jorge
 */
@Entity
@Table (name = "M6UF2_Direccio")
public class Direccio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "direccioId")
    private long id;
    
    @Column(length = 50, nullable = false)
    private String carrer;
    
    @Column(length = 25, nullable = false)
    private String ciutat;
    
    @Column(length = 5, nullable = false)
    private String cp;
    
    @Column(length = 25, nullable = false)
    private String pais;
    
    @OneToOne(mappedBy = "direccio")
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Direccio other = (Direccio) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return "Direccio{" + "carrer=" + carrer + ", ciutat=" + ciutat + ", cp=" + cp + ", pais=" + pais + ", persona=" + persona.getId() + '}';
    }
    
}