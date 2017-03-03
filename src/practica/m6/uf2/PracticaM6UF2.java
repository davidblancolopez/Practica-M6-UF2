
package practica.m6.uf2;

import controlador.Client_Controlador;
import model.Client;


public class PracticaM6UF2 {


    public static void main(String[] args) {
        
            try {

           
            Client client1 = new Client ("55555555J", "David", "Sant Pepe", 9, "Montcada i Reixac");
            
            Client_Controlador cc= new Client_Controlador();
            
            cc.Insertar(client1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
