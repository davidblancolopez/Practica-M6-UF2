
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Adreca;
import model.Usuari;


public class Usuari_Controlador {
    
    public void Insertar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(u);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(u);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(u) ? u : em.merge(u));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Usuari Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Usuari p = (Usuari) em.find(Usuari.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
    public Usuari BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery(Usuari.consulta,Usuari.class);
        query.setParameter("nombre", nom);
        Usuari p = (Usuari) query.getSingleResult();

        System.out.println("close");
        em.close();

        return p;
    }

    public List<Usuari> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM M6UF2_USUARIS");
        List<Usuari> lista = (List<Usuari>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
        
        return lista;
    }

    public void imprimirLista(List<Usuari> lista) {
        System.out.println("Numero d'usuaris = " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirPersona(Usuari p) {
        System.out.println(p);
    }
    
}
