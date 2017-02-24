
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adreca implements Serializable {

    @Column(name="street",length = 50, nullable = false)
    private String carrer;
    @Column(length = 50,nullable = false)
    private String poblacio;
    private int numero;

    public Adreca(String carrer, String poblacio, int numero) {
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

