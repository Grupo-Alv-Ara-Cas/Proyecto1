package Modelo;

public class ConductorAdicional {
	private Licencia licencia;
	private String nombre;

	public ConductorAdicional(Licencia licencia, String nombre) {
		this.licencia = licencia;
		this.nombre = nombre;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public String getNombre() {
		return nombre;
	}

}
