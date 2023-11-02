package Modelo;

import java.util.HashMap;

public class Categorias {
	private String nombre;
	private long precioBase;
	private HashMap<String, Vehiculo> vehiculosCategoria;

	public Categorias(String nombre, long precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		vehiculosCategoria = new HashMap<String, Vehiculo>();
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

	public void anadirVehiculo(Vehiculo carro) {
		String nombreCarro = carro.getPlaca();
		vehiculosCategoria.put(nombreCarro, carro);
	}

}
