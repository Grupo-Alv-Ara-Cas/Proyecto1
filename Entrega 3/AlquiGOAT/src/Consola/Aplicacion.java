package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Aplicacion {

    private int opcionSeleccionada;

    public static void cargarDatos() {

        File todosTrabajadores = new File("./data/trabajadores.csv");
        File todosClientes = new File("./data/clientes.csv");
        File todosCarros = new File("./data/carros.csv");
        File todasSedes = new File("./data/sedes.csv");

    }

    public static void iniciarSesion() {

    }

    public static void mostrarMenu() {

        System.out.println("\n1. Cargar datos restaurante");
        System.out.println("2. Mostrar menú");
        System.out.println("3. Iniciar nuevo pedido");
        System.out.println("4. Agregar elemento a un pedido");
        System.out.println("5. Cerrar pedido y guardar factura");
        System.out.println("6. Consultar la información de un pedido por id");

    }

    public static void ejecutarOpcion() {

    }

    public static void main(String[] args) {

        Aplicacion consola = new Aplicacion();
        consola.iniciarSesion();
        consola.ejecutarOpcion();

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
