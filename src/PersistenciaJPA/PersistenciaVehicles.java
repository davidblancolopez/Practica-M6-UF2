package PersistenciaJPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Vehicle;

public class PersistenciaVehicles {

    private EntityManager em;

    public PersistenciaVehicles(EntityManager em) {
        this.em = em;
    }

    public List<Vehicle> cercaPerNom(String matricula) {
        Query q = em.createNamedQuery("Persona.cercaPerNom", Vehicle.class);
        q.setParameter("matricula", matricula);
        return q.getResultList();
    }
}
