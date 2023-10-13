package Modelo;

import java.util.ArrayList;
import java.util.List;

public class AdministradorSede {
	
	protected Sede sede;
	protected String nombreUsuario;
	protected String login;
	protected String password;
	protected Licencia datos;
	protected List<Trabajador> empleados;
	protected List<Vehiculo> carros;

    public AdministradorSede(Sede sede, String nombreUsuario, String login, String password, Licencia datos) {
        this.sede = sede;
        this.nombreUsuario = nombreUsuario;
        this.login = login;
        this.password = password;
        this.datos = datos;
        this.empleados = new ArrayList<>();
        this.carros = new ArrayList<>();
    }
    
   
    public Sede getSede() {
		return sede;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Licencia getDatos() {
		return datos;
	}

	public List<Trabajador> getEmpleados() {
		return empleados;
	}
	
	public List<Vehiculo> getCarros() {
		return carros;
	}

	public void registrarInfoEmpleados() {
    }

    public void registrarInfoClientes() {
    }

    public void agregarTrabajadorSede(Trabajador empleado) {
        empleados.add(empleado);
    }

    public void agregarCarrosSede(Vehiculo carro) {
        carros.add(carro);
    }

    public void quitarCarrosSede(Vehiculo carro) {
        carros.remove(carro);
    }

}
