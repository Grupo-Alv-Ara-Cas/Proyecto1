package Modelo;

public class Tarjeta {
	
	private String numeroTarjeta;
	private String codigoTarjeta;
	private String fechaCaducidad;
	private String tipo;
	
	public Tarjeta(String numeroTarjeta, String codigoTarjeta, String fechaCaducidad, String tipo) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.codigoTarjeta = codigoTarjeta;
		this.fechaCaducidad = fechaCaducidad;
		this.tipo = tipo;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public String getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public String getTipo() {
		return tipo;
	}

}
