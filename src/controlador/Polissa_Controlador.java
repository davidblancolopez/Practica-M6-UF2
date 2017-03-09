
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Client;
import model.Polissa;


public class Polissa_Controlador {
    
      public void Insertar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Polissa Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Polissa p = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
    /**
     * Buscar per client.
     * @param idCLient
     * @return 
     */
    public Polissa BuscarPerClient(String idClient) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per client");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery(Polissa.consultaPolises,Polissa.class);
        query.setParameter("idClient", idClient);
        Polissa p = (Polissa) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }
    
    /**
     * Buscar per vehicle.
     * @param idVehicle
     * @return 
     */
    public Polissa BuscarPerVehicle(String idVehicle) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per vehicle");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery(Polissa.consultaPolisesVehicle,Polissa.class);
        query.setParameter("idVehicle", idVehicle);
        Polissa p = (Polissa) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }
    
    /**
     * Buscar totes les polises.
     * @return 
     */
    public Polissa BuscarTotes() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per client");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery(Polissa.consultaTotesPolises,Polissa.class);
//        query.setParameter("idClient", idClient);
        Polissa p = (Polissa) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }
    
    
    
    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Asseguradora");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    public void imprimirLista(List<Polissa> lista) {
        System.out.println("Numero de clients= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
}
