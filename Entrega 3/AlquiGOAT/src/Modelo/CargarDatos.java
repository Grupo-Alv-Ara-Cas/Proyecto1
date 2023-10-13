package Modelo;

import java.io.File;

public class CargarDatos {
	
	public Cliente crearNuevoCliente(String nombreUsuario, String login, String password, String fechaNacimiento, String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia, String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta, String codigoTarjeta, String fechaCaducidadT, String tipo) {
		Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
		Tarjeta datosTarjeta = new Tarjeta(numeroTarjeta, codigoTarjeta, fechaCaducidadT, tipo);
		DatosContacto dataContact = new DatosContacto(numeroCelular, correo, paisResidencia, ciudadResidencia, direccionResidencia,codigoPostal);
		Cliente cliente = new Cliente(nombreUsuario, login, password, fechaNacimiento, nacionalidad, imagenDocumento, dataContact, datosLicencia, datosTarjeta);
        return cliente;
    }

    public Trabajador crearNuevoTabajador(Sede sedeT, String nombreUsuario, String login, String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
        Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
    	Trabajador trabajador = new Trabajador(sedeT, nombreUsuario, login, password, datosLicencia);
        return trabajador;
    }

    public AdministradorSede crearAdminSede(Sede sedeT, String nombreUsuario, String login, String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
    	Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
        AdministradorSede adminSede = new AdministradorSede(sedeT, nombreUsuario, login, password, datosLicencia);
        return adminSede;
    }

    public AdministradorGeneral crearAdministradorGeneral(Sede sedeT, String nombreUsuario, String login, String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
    	Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia); 
        AdministradorGeneral adminGeneral = new AdministradorGeneral(sedeT, nombreUsuario, login, password, datosLicencia);
        return adminGeneral;
    }

}
