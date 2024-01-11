/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aca2parte2;

import java.util.*;
import modelo.Cliente;
import modelo.Conexion;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.RegistroHuespedes;
import modelo.Pago;
import modelo.Reserva;
import modelo.Validacion;
import vista.Vista;

/**
 *
 * @author leonel.borja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // se instancia la clase validar
        Validacion validacion = new Validacion();
        // se inicializan las variables a utilizar 
        int opcion, numeroRepeticiones;
        // se insytancia la cñase Conexion 
        Conexion cx = new Conexion();
        // se instancia la clase Hotel y se obtiene el objeto hotel 
        Hotel hotel = new Hotel();
        // se crea una lista (hoteles) donde se almacenaran el hotel creado
        List<Hotel> hoteles = new ArrayList<>();
        // se cargan los hoteles en la lista con el m,etodo cargar 
        hoteles = hotel.cargar();
        // se asigna el hotel cargado al objeto hotel iterando la lista 
        for (Hotel hotelCargado : hoteles) {
            hotel = hotelCargado;
        }
        // se instancia la clase Scanner
        Scanner entrada = new Scanner(System.in);
        //se crean las listas que se necesitanm de cada objeto
        List<Habitacion> habitaciones = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<RegistroHuespedes> huespedesRegistrados = new ArrayList<>();
        List<Pago> pagosRegistrados = new ArrayList<>();
        //se intancia la clase vista  la cual nos permitira mostrar por consola el menu
        Vista vista = new Vista();
        // se asigan valor a la variable para determinar el nuemro de veces que se va a repetir el proceso 
        // controlando que solo ingresen valores numericos 
        System.out.println("****************************");
                
        System.out.println("Bienvenidos al Registro de Hotel ");
        System.out.println("****************************" + "\n");
        System.out.println("Indique el numero de consultas que desea realizar");
        numeroRepeticiones = validacion.validar();

        // se iteran el numero de veces que se requiera que se repita el proceso cxon base a la variable 
        for (int i = 1; i <= numeroRepeticiones; i++) {
            // se crea un ciclo do- while el cual nos garantice que por lo menos el proceso de menu se ejecutara 1 vez
            do {
                // se muestra el menu 
                vista.menu();
                // asigana la variableobcion el cual recibe de un 
                //metodo de la clace validacion que controla quie solo se pueda ingresar un numero entero
                opcion = validacion.validarEntero();
                // se crea el metodo switch-case el cual recibe la variable opcion y valida el caso que crresponde(remplaza las validaciones if) 
                switch (opcion) {
                    // dependiendo el caso ejecuta los mensajes estaticos necesarios 
                    case 1:
                        // se cargan la lista de objetos que se tienen almnacenados en los archivos .csv 
                        hoteles = cx.cargarHotelesCSV();
                        // se imprimen mensajes decorativos (igual para cada opcion que se ingrese)
                        System.out.println("****************************");
                        System.out.println("los Hoteles creados son: ");
                        System.out.println("****************************");
                        //se itera la lista y se imprime 1 objeto a la vez
                        for (Hotel hotel1 : hoteles) {
                            System.out.println(hotel.toString());
                            System.out.println("****************************");
                        }
                        break;
                    case 2:

                        habitaciones = cx.cargarHabitacionesCSV();

                        System.out.println("****************************");
                        System.out.println("las habitaciones creadas son: ");
                        System.out.println("****************************");

                        for (Habitacion habitacion : habitaciones) {
                            System.out.println(habitacion.toString());
                            System.out.println("****************************");
                        }
                        break;

                    case 3:

                        clientes = cx.cargarClientesCSV();

                        System.out.println("****************************");
                        System.out.println("Los clientes creados son: ");
                        System.out.println("****************************");

                        for (Cliente cliente : clientes) {
                            System.out.println(cliente.toString());
                            System.out.println("****************************");
                        }
                        break;
                    case 4:

                        reservas = cx.cargarReservasCSV();

                        System.out.println("****************************");
                        System.out.println("Las reservas creadas son: ");
                        System.out.println("****************************");

                        for (Reserva reserva : reservas) {
                            System.out.println(reserva.toString());
                            System.out.println("****************************");
                        }
                        break;
                    case 5:

                        huespedesRegistrados = cx.cargarRegistroHuespedesCSV();

                        System.out.println("****************************");
                        System.out.println("Los Huspedes registrados son: ");
                        System.out.println("****************************");

                        for (RegistroHuespedes registroHuespedes : huespedesRegistrados) {
                            System.out.println(registroHuespedes.toString());
                            System.out.println("****************************");
                        }
                        break;
                    case 6:

                        pagosRegistrados = cx.cargarPagosCSV();

                        System.out.println("****************************");
                        System.out.println("Los Pagos registrados son: ");
                        System.out.println("****************************");

                        for (Pago pago : pagosRegistrados) {

                            System.out.println(pago.toString());
                            System.out.println("****************************");
                        }
                        break;
                    // se dejo un caso de control por si se presiona una opcion fuewra del menu y se mantiene en el ciclo hasta que no ingrese una opcion valida y se ejecuten plos pasos
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6);
        }
    }

}
