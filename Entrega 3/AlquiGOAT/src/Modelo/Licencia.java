package Modelo;

public class Licencia {
	
	private String numeroID;
	private String paísExpedición;
	private String fechaCaducidad;
	private String imagenLicencia;
	
	public Licencia(String numeroID, String paísExpedición, String fechaCaducidad, String imagenLicencia) {
		super();
		this.numeroID = numeroID;
		this.paísExpedición = paísExpedición;
		this.fechaCaducidad = fechaCaducidad;
		this.imagenLicencia = imagenLicencia;
	}

	public String getNumeroID() {
		return numeroID;
	}

	public String getPaísExpedición() {
		return paísExpedición;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public String getImagenLicencia() {
		return imagenLicencia;
	}

}
