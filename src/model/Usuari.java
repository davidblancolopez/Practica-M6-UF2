
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "M6UF2_USUARIS")
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String consulta = "usuariNom";
    
    @Id
    @Column(name = "usuariNom", length = 30, nullable = false)
    private String nom;
    
    @Column(name = "contrasenyaUsuari", length = 30, nullable = false)
    private String contrasenya;
    
    
    //GETTER & SETTER

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Usuari(String nom, String contrasenya) {
        this.nom = nom;
        this.contrasenya = contrasenya;
    }
    
    public Usuari(){
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nom);
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
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuari{" + "nom=" + nom + ", contrasenya=" + contrasenya + '}';
    }
   
   
 

}
