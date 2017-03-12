package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Client;
import model.*;

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
     * Metode que serveix per a eliminar una polissa d'un client.
     * @param lista
     */
    public void EliminarPolissasClient(List lista) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        for (Object object : lista) {
            em.remove(em.contains(object) ? object : em.merge(object));
        }

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metode que realitza una cerca amb la id d'un vehicle que li arriba per parametre.
     * @param idVehicle
     * @return
     */
    public Polissa BuscarPerVehicle(Long idVehicle) {
        EntityManager em = new EM_Controller().getEntityManager();
        Query query = em.createNamedQuery("cercaPolissaPerVehicle", Polissa.class);
        query.setParameter("idVehicle", idVehicle);
        Polissa v = (Polissa) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }

    /**
     * Metode que realitza la cerca d'un vehicle amb la seva id.
     * @param vehicleId
     * @return
     */
    public Vehicle buscarVehicle(long vehicleId) {
        EntityManager em = new EM_Controller().getEntityManager();
        Vehicle p = (Vehicle) em.find(Vehicle.class, vehicleId);
        System.out.println(p);
        System.out.println("close");
        em.close();
        return p;
    }

    /**
     * Metode que realitza la cerca d'una asseguradora en concret amb la seva id.
     * @param aseguradoraId
     * @return
     */
    public Asseguradora buscarAsseguradora(long aseguradoraId) {
        EntityManager em = new EM_Controller().getEntityManager();
        Asseguradora a = (Asseguradora) em.find(Asseguradora.class, aseguradoraId);
        System.out.println(a);
        System.out.println("close");
        em.close();
        return a;
    }

    /**
     * Metode que realitza la cerca d' un client amb la seva id.
     * @param id
     * @return
     */
    public Client buscarClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        Client c = (Client) em.find(Client.class, id);
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }
    
    
    /**
     * Metode que realitza una cerca de les polisses d'un client utilitzant la id
     * de client.
     * @param id
     * @return
     */
    public List BuscarPolissesPerClientLlista(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        Query query = em.createNamedQuery("cercaPolissasClient", Polissa.class);
        query.setParameter("id", id);
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
    }

    /**
     * Metode que realitza la cerca de totes les polisses, retorna la llista.
     * @return
     */
    public List<Polissa> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Consulta");
        Query q = em.createQuery("FROM Polissa");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }

    /**
     * Metode que imprimeix la llista de polisses que li arriba per
     * parametre.
     *
     * @param lista
     */
    public void imprimirLista(List<Polissa> lista) {
        System.out.println("Numero de polisses= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

}
