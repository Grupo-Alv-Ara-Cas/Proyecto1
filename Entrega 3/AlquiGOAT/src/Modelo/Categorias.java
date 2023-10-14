package Modelo;

import java.util.HashMap;

public class Categorias {
	private String nombre;
	private long precioBase;
	private int carrosDisponibles;
	private HashMap<String, Vehiculo>vehiculosCategoria;
	
	public Categorias(String nombre, long precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		vehiculosCategoria = new HashMap<String, Vehiculo>();
		carrosDisponibles = 0;
	}
	public int getCarrosDisponibles() {
		return carrosDisponibles;
	}
	
	public void masCarrosDisponibles(int caunto) {
		carrosDisponibles = carrosDisponibles + caunto ;
	}
	
	public String getNombre() {
		return nombre;
	}
	public long getPrecioBase() {
		return precioBase;
	}
	public HashMap<String, Vehiculo> getVehiculosCategoria() {
		return vehiculosCategoria;
	}
	
	public void añadirVehiculo(Vehiculo carro) {
		String nombreCarro = carro.getPlaca();
		vehiculosCategoria.put(nombreCarro, carro);
	}
	
	
	
}
