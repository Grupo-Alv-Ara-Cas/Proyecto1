package Modelo;

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

	public void registrarInfoEmpleados() {
    }

    public void registrarInfoClientes() {
    }

    public void agregarTrabajadorSede(Trabajador empleado) {
    
    }

    public void agregarCarrosSede(Vehiculo carro) {
    
    }

    public void quitarCarrosSede(Vehiculo carro) {
    
    }

}
