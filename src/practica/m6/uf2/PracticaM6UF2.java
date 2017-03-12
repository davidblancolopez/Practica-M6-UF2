package practica.m6.uf2;

import controlador.*;
import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

public class PracticaM6UF2 {

    public static void main(String[] args) {

        try {

            //Inicialitzem un calendar per a les dates.
            SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");

            //Creació dels objectes.
            Adreca adreca1 = new Adreca("Calle falsa", 123, "Un sitio");
            Usuari usuari1 = new Usuari("david", "1234");
            Client client1 = new Client(0, "55555555-z", "david", adreca1);
            Asseguradora asseguradora1 = new Asseguradora(0, "Qualitas", "12345A");

            //Inicialitzem els controladors
            Usuari_Controlador uc = new Usuari_Controlador();
            Polissa_Controlador pc = new Polissa_Controlador();
            Vehicle_Controlador vc = new Vehicle_Controlador();
            Client_Controlador cc = new Client_Controlador();
            Asseguradora_Controlador ac = new Asseguradora_Controlador();

            /**
             * USUARI
             */
            System.out.print("Inserció usuari: ");

            //Inserció usuari.
            uc.Insertar(usuari1);
            System.out.println("Insertat: " + usuari1);

            //Modificació de l'usuari.
            Usuari usuariModificar = uc.Buscar("david");

            //Modifiquem un parametre de l'usuari (contrasennya)
            usuariModificar.setContrasenya("123");
            uc.Modificar(usuariModificar);

            //Cerca d'un usuari.
            System.out.println( uc.Buscar("david"));

            //Eliminem un usuari.
            Usuari usuEliminar = uc.Buscar("david");
            uc.Eliminar(usuEliminar);

            /**
             * CLIENT
             */
            System.out.print("Inserció client: ");

            //Inserció usuari.
            cc.Insertar(client1);
            System.out.println("Insertat: " + client1);
            
            //Modificació de client.
            Client clientModificar = cc.Buscar(2221L);

            //Modifiquem un parametre de client (nif)
            clientModificar.setNif("9999999B");
            cc.Modificar(clientModificar);
            
            //Cerca d'un client.
            System.out.println( cc.Buscar(clientModificar.getId()));

            
            //Eliminem un usuari.
            System.out.print("Eliminem un client: ");
            Client cliEliminar = cc.Buscar(clientModificar.getId());
            
            //Al estar connectades clients i polisses cal eliminar primer la polissa relacionada amb el client.
            List<Polissa> polissasAmbClient = pc.BuscarPolissesPerClientLlista(cliEliminar.getId());
            
            for (Polissa polissa : polissasAmbClient) {
                Vehicle vehiTeureClient = polissa.getVehicle(); 
                vehiTeureClient.setPropietari(null);
                vc.Modificar(vehiTeureClient);
            }

            //S'eliminen primer les polisses de client.
            pc.EliminarPolissasClient(pc.BuscarPolissesPerClientLlista(cliEliminar.getId())); 
            
            //Eliminem el client.
            cc.Eliminar(cliEliminar);
            
            //Cerca del client per nom.
            cc.imprimirPersona(cc.BuscarPerNom("david"));


            /**
             * VEHICLE
             */
            
            //Inserció vehicle.
            Client clientVehicle = vc.BuscarClient(2261L);
            Vehicle vehi1 = new Vehicle(0, "1111AAA", "Ferrari", 2015, clientVehicle, null);
            vc.Insertar(vehi1);
            
            //Modificació vehicle.
            Vehicle vehicleModificar = vc.Buscar(1721L);

            vehicleModificar.setMarca("Aston Martin");
            vc.Modificar(vehicleModificar);
            
            
            //Eliminació vehicle.
            Vehicle vehiclePerEliminar = vc.Buscar(2141L);
            Polissa poliEliminar = pc.BuscarPerVehicle(vehiclePerEliminar.getIdVehicle());
            
            //Eliminem la polissa del vehicle.
            pc.Eliminar(poliEliminar);
            
            //Eliminem el vehicle.
            vc.Eliminar(vehiclePerEliminar);
            
            //Cerca del vehicle.
            System.out.println(pc.BuscarPerVehicle(vc.Buscar(2141L).getIdVehicle()));//Realitzem una cerca de polissas que te el vehicle

            
            
            /**
             * ASSEGURADORA
             */
            
            //Inserció asseguradora.
            ac.Insertar(asseguradora1);
            
            //Modificació asseguradora.
            Asseguradora asseguradoraModificar = ac.Buscar(789L);//Busquem la asseguradora pel seu ID i la fiquem a un nou objecte Asseguradora
            asseguradoraModificar.setNomAsseguradora("Seguro");
            ac.Modificar(asseguradoraModificar);
            
            //Cerca asseguradora.(ID)
            System.out.println(ac.Buscar(asseguradoraModificar.getIdAsseguradora()));
            
            //Eliminació asseguradora.
            ac.Eliminar(asseguradoraModificar);//Eliminem una asseguradora de la BBDD
            

            /**
             * POLISSA
             */
            
            //Tenim que crear un vehicle, un client i una asseguradoraper la polissa.
            Vehicle vehiclePolissa = pc.buscarVehicle(2301L);
            Asseguradora asseguradoraPolissa = pc.buscarAsseguradora(789L);
            Client clientPolissa = pc.buscarClient(2261L);
            
            //Es crea la polissa.
            Polissa poliCreacio = new Polissa(0, "1234567890", vehiclePolissa, clientPolissa, data.parse("12-03-2018"), data.parse("12-03-2018"), true, 0, asseguradoraPolissa);
            
            //Inserció polissa
            pc.Insertar(poliCreacio);

            //Modificació polissa.
            Polissa poliModifi = pc.Buscar(2321L);
            poliModifi.setNumeroPolissa("45689");
            pc.Modificar(poliModifi);

            //Cerca polissa
            System.out.println(pc.Buscar(poliModifi.getIdPolissa()));
            
            
            //Eliminació polissa.
            pc.Eliminar(pc.Buscar(poliModifi.getIdPolissa()));
            
            //Totes les polisses.
            System.out.println("Mostrar totes les polisses: ");
            pc.imprimirLista(pc.ConsultaTots());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
