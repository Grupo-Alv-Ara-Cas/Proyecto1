package Modelo;

import java.io.File;

public class Cliente {
	
	private String fechaNacimiento;
	private String nacionalidad;
	File imagenDocumento = new File ("./data/imagen.png");
	
	public Cliente(String fechaNacimiento, String nacionalidad, File imagenDocumento) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.imagenDocumento = imagenDocumento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public File getImagenDocumento() {
		return imagenDocumento;
	}

}
