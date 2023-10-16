package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AlquilerCarros {

    // private HashMap<String, String> trabajadores;
    // private HashMap<String, String> clientes;
    private HashMap<String, Vehiculo> carros;
    private HashMap<String, Sede> sedes;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Categorias> categorias;
    private CargarDatos cargarDatos;
    
    private ArrayList<Reservas> lisaReservas;


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
        sedes = cargarDatos.cargarSedes() ;
        carros = cargarDatos.cargarVehiculos(sedes, categorias);
        usuarios = cargarDatos.cargarUsuarios(sedes);
        
    }
    
public void bajaCarro(Vehiculo carro) {
        
    }

    public void agregarSeguro(String nombre, String descripcion, long precio) {
        
    }

    public boolean revisarDisponibilidad(String sede, String categoria) {
        Sede sedeRevisar = sedes.get(sede);
        return (sedeRevisar.revisarDisponibilidad(categoria));
    }

    public void crearReserva(String usuario, String lugarInicio, String fechaInicio, String rangoHoraInicio,String lugarFin, String fechaFin, String rangoHoraFin, String tipoDeCarro, String lugarEntrega, String categoria) {
        Usuario usuarioActual = usuarios.get(usuario);
        Sede sedeRecojer = sedes.get(lugarInicio);
        Sede sedeEntregar = sedes.get(lugarFin);
        Categorias categoriaEste = categorias.get(categoria);
        
    }

    public void finalizarReserva() {
        
    }

    public void procesoReserva(String nombreUsuario) {
        
    }

    private Vehiculo obtenerCarroDisponible(Categorias categoria) {
        return null;
    }
    

}
