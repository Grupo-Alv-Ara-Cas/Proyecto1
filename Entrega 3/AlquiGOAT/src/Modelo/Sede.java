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
	private HashMap<String, Integer> disponibilidadSedeCategoria;

	public Sede(String nombreSede, String ubicacionSede, String horariosSede) {
		super();
		this.nombreSede = nombreSede;
		this.ubicacionSede = ubicacionSede;
		this.horariosSede = horariosSede;
		trabajadores = new ArrayList<Trabajador>();
		carrosSede = new HashMap<String, Vehiculo>();
		disponibilidadSedeCategoria = new HashMap<String, Integer>();
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
		String categoria = carro.getCategoria().getNombre();
		if (disponibilidadSedeCategoria.containsKey(categoria)) {
			if (carro.getDisponible()) {
				disponibilidadSedeCategoria.put(categoria, disponibilidadSedeCategoria.get(categoria) + 1);
			}
		} else {
			if (carro.getDisponible()) {
				disponibilidadSedeCategoria.put(categoria, 1);
			} else {
				disponibilidadSedeCategoria.put(categoria, 0);
			}
		}
		carrosSede.put(carro.getPlaca(), carro);
	}

	public void cambiarDisponibilidadCarro(Integer numero, String categoria) {
		disponibilidadSedeCategoria.put(categoria, disponibilidadSedeCategoria.get(categoria) + numero);
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
