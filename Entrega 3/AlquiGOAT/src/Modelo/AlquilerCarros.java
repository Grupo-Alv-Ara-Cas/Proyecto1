package Modelo;

import java.io.File;
import java.util.HashMap;

public class AlquilerCarros {

    // private HashMap<String, String> trabajadores;
    // private HashMap<String, String> clientes;
    // private HashMap<String, String> carros;
    // private HashMap<Integer, String> sedes;
    private HashMap<String, String> usuarios;
    private CargarDatos cargarDatos;

    public void AlquilerCarros() {

    }

    public void cargarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes,
            File todasCategorias) {

        cargarDatos = new CargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todasCategorias);
        // usuarios = cargarDatos.cargarTrabajadores(null);

    }

}
