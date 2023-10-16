package Modelo;

import java.io.File;
import java.util.HashMap;

public class AlquilerCarros {

    // private HashMap<String, String> trabajadores;
    // private HashMap<String, String> clientes;
    private HashMap<String, Vehiculo> carros;
    private HashMap<String, Sede> sedes;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Categorias> categorias;
    private CargarDatos cargarDatos;


    public String revisarCuenta(String usuario, String password) {
    if (usuarios.containsKey(usuario)) {
    	Usuario user = usuarios.get(usuario);
    	String contrasena = user.getPassword();
    	if (contrasena.equals(password)) {
    	String tipoUsuario = user.getTipoUsuario();
    	return (tipoUsuario);
    	}
    	
    }
    return (null);
    }

    public void cargarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes,
            File todasCategorias) {

        cargarDatos = new CargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todasCategorias);
        categorias = cargarDatos.cargarCategoria();
        sedes = cargarDatos.cargarSedes();
        carros = cargarDatos.cargarVehiculos(sedes, categorias);
        usuarios = cargarDatos.cargarUsuarios(sedes);

    }

}
