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

    public static void mostrarMenu() {

        System.out.println("\nIniciar Sesión");
        System.out.println("2. Cliente");
        System.out.println("3. Empleado");
        System.out.println("4. Agregar elemento a un pedido");
        System.out.println("5. Cerrar pedido y guardar factura");
        System.out.println("6. Consultar la información de un pedido por id");

    }

    public static void ejecutarOpcion() {

    }

    public static void main(String[] args) {

        Aplicacion consola = new Aplicacion();
        alquiler = new AlquilerCarros();
        consola.cargarDatos();
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
