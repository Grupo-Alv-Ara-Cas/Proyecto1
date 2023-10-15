package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import Modelo.AlquilerCarros;

public class Aplicacion {

    private int opcionSeleccionada;

    private static AlquilerCarros alquiler;

    public static void cargarDatos() {

        File todosTrabajadores = new File("./data/todosTrabajadores.csv");
        File todosClientes = new File("./data/todosClientes.csv");
        File todosCarros = new File("./data/todosCarros.csv");
        File todasSedes = new File("./data/todasSedes.csv");
        File todosCategorias = new File("./data/todosCategorias.csv");

        alquiler.cargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todosCategorias);

    }
    
    public static void iniciarSesion() {

	}
    public static void mostrarOpcionesAdminGeneral() {

        System.out.println("1. Crear administrador de una sede");
        System.out.println("2. Comprar nuevo vehículo");
        System.out.println("3. Dar de baja a un vehículo");
        System.out.println("4. Crear seguro al vehículo");
        System.out.println("5. Alquilar un vehículo");
        System.out.println("6. Hacer la entrega de un vehículo");
        System.out.println("7. Hacer recibimiento de un vehículo");
        System.out.println("8. Registrar un conductor extra para el vehículo");
        System.out.println("9. Actualizar el estado de un vehículo");
        
    }	

    public static void mostrarOpcionesAdminSede() {

        System.out.println("1. Registrar la infomarción de empleado");
        System.out.println("2. Registrar información de cliente");
        System.out.println("3. Agregar un trabajador a la sede");
        System.out.println("4. Agregar carro a la sede");
        System.out.println("5. Remover carro de la sede");
        System.out.println("6. Alquilar un vehículo");
        System.out.println("7. Hacer la entrega de un vehículo");
        System.out.println("8. Hacer recibimiento de un vehículo");
        System.out.println("9. Registrar un conductor extra para el vehículo");
        System.out.println("10. Actualizar el estado de un vehículo");
        
    }
    		
    public static void mostrarOpcionesTrabajador() {

        System.out.println("1. Hacer la entrega de un vehículo");
        System.out.println("2. Hacer recibimiento de un vehículo");
        System.out.println("3. Registrar un conductor extra para el vehículo");
        System.out.println("4. Actualizar el estado de un vehículo");
        System.out.println("5. Alquilar un vehículo");
        
    }	
   
    public static void mostrarOpcionesCliente() {

        System.out.println("1. ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("5. Cerrar pedido y guardar factura");
        System.out.println("6. Consultar la información de un pedido por id");

    }

    public static void main(String[] args) {

        Aplicacion consola = new Aplicacion();
        alquiler = new AlquilerCarros();
        consola.cargarDatos();
        consola.iniciarSesion();
        consola.mostrarOpcionesAdminGeneral();
        consola.mostrarOpcionesAdminSede();
        consola.mostrarOpcionesTrabajador();
        consola.mostrarOpcionesCliente();
    }

    private String input(String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error leyendo de la consola");
            e.printStackTrace();
        }
        return null;
    }

}
