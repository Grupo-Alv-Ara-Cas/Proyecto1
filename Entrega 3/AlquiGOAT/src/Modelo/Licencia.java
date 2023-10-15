package Modelo;

import java.io.File;

public class Licencia {

	private String numeroID;
	private String paisExpedicion;
	private String fechaCaducidadL;
	private File imagenLicencia;

	public Licencia(String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
		super();
		this.numeroID = numeroID;
		this.paisExpedicion = paisExpedicion;
		this.fechaCaducidadL = fechaCaducidadL;
		this.imagenLicencia = imagenLicencia;
	}

	public String getNumeroID() {
		return numeroID;
	}

	public String getPaisExpedicion() {
		return paisExpedicion;
	}

	public String getFechaCaducidadL() {
		return fechaCaducidadL;
	}

	public File getImagenLicencia() {
		return imagenLicencia;
	}

}
