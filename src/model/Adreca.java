
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
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adrecaId", nullable = false, unique = true)
    private Long id;

    @Column(name = "carrer", length = 50, nullable = false)
    private String carrer;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "poblacio", length = 50, nullable = false)
    private String poblacio;

    @OneToOne(mappedBy = "adreca")
    private Client client;

    

    public Adreca(String carrer, int numero, String poblacio) {
        this.carrer = carrer;
        this.poblacio = poblacio;
        this.numero = numero;
    }


    public Adreca() {
    }

    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

