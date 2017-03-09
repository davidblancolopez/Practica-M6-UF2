
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "Adreca")
public class Adreca implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Column(name = "carrer", length = 50, nullable = false)
    private String carrer;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "poblacio", length = 50, nullable = false)
    private String poblacio;



    public Adreca(String carrer, int numero, String poblacio) {
        this.carrer = carrer;
        this.poblacio = poblacio;
        this.numero = numero;
    }


    public Adreca() {
    }

    
    
    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Adreca{" + "carrer=" + carrer + ", poblacio=" + poblacio + ", numero=" + numero + '}';
    }
    
}

