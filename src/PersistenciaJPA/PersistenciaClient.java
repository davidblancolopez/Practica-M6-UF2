package PersistenciaJPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Client;

public class PersistenciaClient {

    private EntityManager em;

    public PersistenciaClient(EntityManager em) {
        this.em = em;
    }

    public List<Client> cercaPerNom(String nom) {
        Query q = em.createNamedQuery("Client.cercaPerNom", Client.class);
        q.setParameter("nomP", nom);
        return q.getResultList();
    }

}
