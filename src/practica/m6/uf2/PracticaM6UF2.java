
package practica.m6.uf2;

import controlador.Client_Controlador;
import model.Client;


public class PracticaM6UF2 {


    public static void main(String[] args) {
        
            try {

            // Crea una nova persona
            /*Persona persona1 = new Persona();
            persona1.setNombre("Jorge");
            persona1.setApellidos("Rubio");
            persona1.setEmail("jorge@rubio.net");
            persona1.setTelefono("987654321");
            Persona persona2 = new Persona();
            persona2.setNombre("Emilio");
            persona2.setApellidos("Garcia");
            persona2.setEmail("emilio@garcia.net");
            persona2.setTelefono("876543219");
            Direccio direccio1 = new Direccio();
            direccio1.setCarrer("Carrer1");
            direccio1.setCiutat("Montcada");
            direccio1.setCp("21345");
            direccio1.setPais("Espanya");
            Direccio direccio2 = new Direccio();
            direccio2.setCarrer("Carrer2");
            direccio2.setCiutat("Reixac");
            direccio2.setCp("21346");
            direccio2.setPais("Espanya");
            persona1.setDireccio(direccio1);
            persona2.setDireccio(direccio2);
            */
            //Client client1 = new Client("tekniko","12345678-Z","Calle Calle",20, "Country City Super Mega WallMart");
            
            //Client client2 = new Client("teknikokoko","12345672-Z","Calle Callo",23, "CosaCOsaCOsaAOSDPSCCOSA");
            Client client1 = new Client ();
            
            Client_Controlador cc= new Client_Controlador();
            
            cc.Insertar(client1);
            //cc.Insertar(client2);

            
            
            //Persona_Controller pc = new Persona_Controller();

            //1er INSERTEM LES PERSONES A LA BBDD I DESPRES COMENTEM LES 3 LINIES SEGUENTES
            //pc.Insertar(persona1);
            //pc.Insertar(persona2);
            //pc.Consulta();
            
//2n DESCOMENTEM LES 3 LINIES SEGUENTS, EXECUTEM LA @NamedQuery
           // String nom = "Emilio";
           // Persona p = pc.BuscarPerNom(nom); //PRIMER IDPERSONA
            //pc.imprimirPersona(p);

            //3r DESCOMENTEM LES 8 LINIES SEGUENTS, OBTENIM ELS IDPERSONA CREATS A LA BBDD I ELS MODIFIQUEM
//            Persona p = pc.Buscar(722L); //PRIMER IDPERSONA
//            pc.imprimirPersona(p);
//
//            p.setNombre("Pepe");
//            pc.Modificar(p);
//
//            p = pc.Buscar(741L); //SEGON IDPERSONA
//            pc.imprimirPersona(p);
//
//            pc.Eliminar(p);
//
//            pc.Consulta();
            //System.out.println("FI");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
