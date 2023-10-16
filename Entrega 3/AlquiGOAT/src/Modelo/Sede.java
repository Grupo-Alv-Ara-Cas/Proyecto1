package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Sede {

	private String nombreSede;
	private String ubicacionSede;
	private String horariosSede;
	private AdministradorSede admin;
	private ArrayList<Trabajador> trabajadores;
	private HashMap<String, Vehiculo> carrosSede;
	

	public Sede(String nombreSede, String ubicacionSede, String horariosSede) {
		super();
		this.nombreSede = nombreSede;
		this.ubicacionSede = ubicacionSede;
		this.horariosSede = horariosSede;
		trabajadores = new ArrayList<Trabajador>();
		carrosSede = new HashMap<String, Vehiculo>();
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public String getUbicacionSede() {
		return ubicacionSede;
	}

	public String getHorariosSede() {
		return horariosSede;
	}

	public void agregarTrabajador(Trabajador empleado) {
		trabajadores.add(empleado);
	}

	public void agregarCarros(Vehiculo carro) {
		carrosSede.put(carro.getPlaca(), carro);
	}

	public void quitarCarros(Vehiculo carro) {
		carrosSede.remove(carro.getPlaca());
	}

	public void setAdministradorSede(AdministradorSede admin) {
		this.admin = admin;
	}

	public AdministradorSede getAdmin() {
		return admin;
	}
	public String getSede() {
		String nombre = getNombreSede();
		String ubicacion = getUbicacionSede();
		String horario = getHorariosSede();
		String detalles = nombre + "," + ubicacion + "," + horario;
		return detalles;
				
	}

}
