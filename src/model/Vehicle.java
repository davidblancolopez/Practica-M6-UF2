
package model;

import java.io.Serializable;
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

@NamedQueries({
@NamedQuery(name="buscarMatriculaVehicle", query="SELECT v FROM M6UF2_VEHICLES v WHERE v.matriculaClient =: matricula")
})

@Table(name = "M6UF2_VEHICLES", indexes = {@Index(columnList = "matriculaVehicle", name = "indexMatricula")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //String on posem el nom de la consulta que es realitzara en aquesta entity.
    public static final String consulta = "buscarMatriculaVehicle";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idVehicle", unique = true)
    private Long idVehicle;
    
    
    @Column(name = "matriculaVehicle", length = 7, nullable = false)
    private String matricula;

    @Column(name = "marca_modelVehicle", length = 50)
    private String marca;
    
    @Column(name = "anyFabricacioVehicle")
    private int anyFabricacio;

    @JoinColumn(name = "idClient")
    @OneToOne(fetch = FetchType.LAZY)
    private Client propietari;
       

    
    //GETS I SETS

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }


    public Vehicle(String matricula, String marca, int anyFabricacio) {
        this.matricula = matricula;
        this.marca = marca;
        this.anyFabricacio = anyFabricacio;
    }

    public Vehicle() {
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idVehicle);
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
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.idVehicle, other.idVehicle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "idVehicle=" + idVehicle + ", matricula=" + matricula + ", marca=" + marca + ", anyFabricacio=" + anyFabricacio + ", propietari=" + propietari + '}';
    }

    

    
    
    

    
}
