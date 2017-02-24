
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Client;


public class persistencia {
    
    private EntityManager em;

    public persistencia(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Metode per a realitzar la consulta de client per nom.
     * @param nom
     * @return 
     */
    public Client cercaPerNif(String nom) {
        Query q = em.createQuery("SELECT p FROM Client p WHERE p.nom=:nomP");
        q.setParameter("nomP", nom);
        return (Client) q.getSingleResult();
    }
    
    
    
}
