package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdministradorSede extends Trabajador {
	


    public AdministradorSede(Sede sede, String nombreUsuario, String login, String password, Licencia datos) {
    	super(sede, nombreUsuario, login, password, datos);
        tipoUsuario = "2";
    }
    

	public List<Trabajador> getEmpleados() {
		return null;
		
	}
	
	public List<Vehiculo> getCarros() {
		return null;
		
	}

	public void registrarInfoEmpleados(Sede sede, String nombreUsuario, String login, String password, String numeroID, 
			String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
		
    }
	
	public Trabajador crearTrabajador(Sede sedeT, String nombreUsuario, String login, String password,
            String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
        Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
        Trabajador trabajdor = new Trabajador(sedeT, nombreUsuario, login, password, datosLicencia);
        return trabajdor;
    }

}