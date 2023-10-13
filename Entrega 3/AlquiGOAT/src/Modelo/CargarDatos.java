package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modificaciones.Ingrediente;

public class CargarDatos {
	private File todosTrabajadores; 
	private File todosClientes;
	private File todosCarros; 
	private File todasSedes; 
	private File todosCEO;

	public CargarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes, File todosCEO) {
		this.todosTrabajadores = todosTrabajadores;
		this.todosClientes = todosClientes;
		this.todosCarros = todosCarros;
		this.todasSedes = todasSedes;
		this.todosCEO = todosCEO;
	}

	
	
	
	private HashMap<String, Usuario>  cargarTrabajadores(HashMap<String, Sede> mapaSede) {
			try (BufferedReader lector = new BufferedReader(new FileReader (todosTrabajadores))) {
				String linea = lector.readLine();
				HashMap<String, Usuario> trabajadores = new HashMap<String, Usuario>();
				while (linea != null) {
					String[] datosTrabajador = linea.split(",");
					Sede sedeT= mapaSede.get(datosTrabajador[1]);
					File imagenLicencia = new File(datosTrabajador[8]);
					
					if (datosTrabajador[0].equals("1")) {
						AdministradorGeneral admin = crearAdministradorGeneral( sedeT, datosTrabajador[2], datosTrabajador[3], datosTrabajador[4], datosTrabajador[5], datosTrabajador[6], datosTrabajador[7], imagenLicencia);
						trabajadores.put(datosTrabajador[3], admin);
					}
					
					else if (datosTrabajador[0].equals("2")){
						AdministradorSede adminSedeEste = crearAdminSede(sedeT, datosTrabajador[2], datosTrabajador[3], datosTrabajador[4], datosTrabajador[5], datosTrabajador[6], datosTrabajador[7], imagenLicencia);
						sedeT.setAdministradorSede(adminSedeEste);
						trabajadores.put(datosTrabajador[3], adminSedeEste);
					}
					else if (datosTrabajador[0].equals("2")){
						Trabajador trabajadorEste = crearNuevoTabajador(sedeT, datosTrabajador[2], datosTrabajador[3], datosTrabajador[4], datosTrabajador[5], datosTrabajador[6], datosTrabajador[7], imagenLicencia);
						sedeT.agregarTrabajador(trabajadorEste);
						trabajadores.put(datosTrabajador[3], trabajadorEste);
					}
					
					linea = lector.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		
	}
	
	private Cliente crearNuevoCliente(String nombreUsuario, String login, String password, String fechaNacimiento, String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia, String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta, String codigoTarjeta, String fechaCaducidadT, String tipo) {
		Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
		Tarjeta datosTarjeta = new Tarjeta(numeroTarjeta, codigoTarjeta, fechaCaducidadT, tipo);
		DatosContacto dataContact = new DatosContacto(numeroCelular, correo, paisResidencia, ciudadResidencia, direccionResidencia,codigoPostal);
		Cliente cliente = new Cliente(nombreUsuario, login, password, fechaNacimiento, nacionalidad, imagenDocumento, dataContact, datosLicencia, datosTarjeta);
        return cliente;
    }

	private Trabajador crearNuevoTabajador(Sede sedeT, String nombreUsuario, String login, String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
        Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
    	Trabajador trabajador = new Trabajador(sedeT, nombreUsuario, login, password, datosLicencia);
        return trabajador;
    }

	private AdministradorSede crearAdminSede(Sede sedeT, String nombreUsuario, String login, String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
    	Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
        AdministradorSede adminSede = new AdministradorSede(sedeT, nombreUsuario, login, password, datosLicencia);
        return adminSede;
    }

	private AdministradorGeneral crearAdministradorGeneral(Sede sedeT, String nombreUsuario, String login, String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
    	Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
        AdministradorGeneral adminGeneral = new AdministradorGeneral(sedeT, nombreUsuario, login, password, datosLicencia);
        return adminGeneral;
    }

}
