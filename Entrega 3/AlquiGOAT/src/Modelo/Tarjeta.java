package Modelo;

public class Tarjeta {

	private String numeroTarjeta;
	private String codigoTarjeta;
	private String fechaCaducidadT;
	private String tipo;

	public Tarjeta(String numeroTarjeta, String codigoTarjeta, String fechaCaducidadT, String tipo) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.codigoTarjeta = codigoTarjeta;
		this.fechaCaducidadT = fechaCaducidadT;
		this.tipo = tipo;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public String getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public String getFechaCaducidadT() {
		return fechaCaducidadT;
	}

	public String getTipo() {
		return tipo;
	}

}
