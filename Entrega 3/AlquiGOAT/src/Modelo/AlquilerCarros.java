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
    private HashMap<String, Reservas> reservasEmpresa;
    private HashMap<String, Seguros> seguros;
    private CargarDatos cargarDatos;
    private GuardarDatos guardarDatos;

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
            File todasCategorias, File todosReservas, File todosSeguros) {

        cargarDatos = new CargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todasCategorias, todosReservas, todosSeguros);
        categorias = cargarDatos.cargarCategoria();
        sedes = cargarDatos.cargarSedes();
        carros = cargarDatos.cargarVehiculos(sedes, categorias);
        usuarios = cargarDatos.cargarUsuarios(sedes);
        seguros = cargarDatos.cargarSeguros();
        reservasEmpresa = cargarDatos.cargarResevas(usuarios, sedes, categorias);
        guardarDatos = new GuardarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todosReservas, todosSeguros);

    }

    public int crearCliente(String nombreUsuario, String login, String password, String fechaNacimiento,
            String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia,
            String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID,
            String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta,
            String codigoTarjeta, String fechaCaducidadT, String tipo) {
    	int x = 0;
    	if (!usuarios.containsKey(login)) {
	        Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
	        Tarjeta datosTarjeta = new Tarjeta(numeroTarjeta, codigoTarjeta, fechaCaducidadT, tipo);
	        DatosContacto dataContact = new DatosContacto(numeroCelular, correo, paisResidencia, ciudadResidencia,
	                direccionResidencia, codigoPostal);
	        Cliente cliente = new Cliente(nombreUsuario, login, password, fechaNacimiento, nacionalidad, imagenDocumento,
	                dataContact, datosLicencia, datosTarjeta);
	        usuarios.put(login, cliente);
	        guardarDatos.addCliente(nombreUsuario, login, password, fechaNacimiento,
	                nacionalidad, imagenDocumento, numeroCelular, correo, paisResidencia,
	                ciudadResidencia, direccionResidencia, codigoPostal, numeroID,
	                paisExpedicion, fechaCaducidadL, imagenLicencia, numeroTarjeta,
	                codigoTarjeta, fechaCaducidadT, tipo);
	        x =1;
    	}
    	return (x);
    }



	public void bajaCarro(Vehiculo carro) {

    }

    public void agregarSeguro(String nombre, String descripcion, long precio) {

    }

    public boolean revisarDisponibilidad(String sede, String categoria) {
        Sede sedeRevisar = sedes.get(sede);
        return (sedeRevisar.revisarDisponibilidad(categoria));
    }

    
    
    public void crearReserva(String usuario, String lugarInicio, String fechaInicio, String rangoHoraInicio,
            String lugarFin, String fechaFin, String rangoHoraFin, String tipoDeCarro) {
        Usuario usuarioActual = usuarios.get(usuario);
        Sede sedeRecojer = sedes.get(lugarInicio);
        Sede sedeEntregar = sedes.get(lugarFin);
        Categorias categoriaEste = categorias.get(tipoDeCarro);
    
        Reservas reservaEste = new Reservas(sedeRecojer, fechaInicio, rangoHoraInicio, fechaFin, rangoHoraFin, sedeEntregar, categoriaEste, usuarioActual);
        reservasEmpresa.put(usuario, reservaEste);
        
        
    }

    public void finalizarReserva() {

    }

    public void procesoReserva(String nombreUsuario) {

    }

    private Vehiculo obtenerCarroDisponible(Categorias categoria) {
        return null;
    }

}
