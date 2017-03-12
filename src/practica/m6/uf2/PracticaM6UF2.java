package practica.m6.uf2;

import controlador.*;
import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

public class PracticaM6UF2 {

    public static void main(String[] args) {

        try {

            //Inicialitzem un calendar per a les dates.
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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
            System.out.println("Cerca d' un usuari per ID: " + uc.Buscar("david"));

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
            System.out.println("Cerca de client per id: " + cc.Buscar(clientModificar.getId()));

            
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
            System.out.print("Insertem una asseguradora: ");
            ac.Insertar(asseguradora1);//Insertem a la BBDD la asseguradora que hem creat
            System.out.println(asseguradora1);
            Asseguradora aseModificar = ac.Buscar(789L);//Busquem la asseguradora pel seu ID i la fiquem a un nou objecte Asseguradora
            System.out.println("Modificar una asseguradora: ");
            System.out.println("Abans: " + aseModificar);
            aseModificar.setNom("Mahfre");
            ac.Modificar(aseModificar);//Realitzem alguna modificacio a la asseguradora
            System.out.println("Despres: " + aseModificar);
            System.out.println("Cerca d'una asseguradora per la seva id: " + ac.Buscar(aseModificar.getAsseguradoraId()));//Cerca de asseguradora per ID
            System.out.println("Eliminem una asseguradora: ");
            ac.Eliminar(aseModificar);//Eliminem una asseguradora de la BBDD
            System.out.println("Si busquem ara no la trobem: " + ac.Buscar(aseModificar.getAsseguradoraId()));

            /**
             * POLISSA
             */
            Vehicle vehi = pc.buscarVehicle(2301L);//Declarem un vehicle que cerquem
            Asseguradora ase = pc.buscarAsseguradora(789L);//Declarem una Asseguradora que cerquem
            Client cli = pc.buscarClient(2261L);//Declarem un client que cerquem
            Polissa poliCreacio = new Polissa(0, "fesd", vehi, cli, sdf.parse("09-03-2018"), sdf.parse("09-03-2018"), true, 0, ase);//Creem una polissa nova amb les seves dades(i els objectes que hem cercat anteriorment. El camp de tipus esta en boolean i significa: true TERCERS, false TOT RISC
            System.out.print("Insertem una polissa: ");
            pc.Insertar(poliCreacio);//Insertem la polissa creada a la BBDD
            System.out.println(poliCreacio);
            Polissa poliModifi = pc.Buscar(2321L);//Creem un objecte polissa per modificar una polissa que cerquem.
            System.out.println("Modifiquem una polissa: ");
            System.out.println("Abans: " + poliModifi);
            poliModifi.setNumero("4578");//Modifiquem algun atribut de la polissa
            pc.Modificar(poliModifi);//Apliquem la modificacio a la Polissa
            System.out.println("Despres: " + poliModifi);
            System.out.println("Cerca d'una polissa: " + pc.Buscar(poliModifi.getIdPolissa()));//Realitzem una cerca d'una polissa per ID
            System.out.println("Eliminem una polissa: ");
            pc.Eliminar(pc.Buscar(poliModifi.getIdPolissa()));//Eliminem una polissa per ID
            System.out.println("I com podem veure ja no existeix: " + pc.Buscar(poliModifi.getIdPolissa()));
            System.out.println("Mostrar totes les polisses: ");
            pc.imprimirLista(pc.ConsultaTots());//Imprimim totes les polisses.

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
