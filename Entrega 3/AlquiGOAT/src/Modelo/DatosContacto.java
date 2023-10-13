package Modelo;

public class DatosContacto {

	private String numeroCelular;
    private String correo;
    private String paisResidencia;
    private String ciudadResidencia;
    private String direccionResidencia;
    private String codigoPostal;
    
    public DatosContacto(String numeroCelular, String correo, String paisResidencia, String ciudadResidencia, String direccionResidencia, String codigoPostal) {
		this.numeroCelular = numeroCelular;
		this.correo = correo;
		this.paisResidencia = paisResidencia;
		this.ciudadResidencia = ciudadResidencia;
		this.direccionResidencia = direccionResidencia;
		this.codigoPostal = codigoPostal;
	}
    
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public String getCorreo() {
		return correo;
	}
	public String getDireccionResidencia() {
		return direccionResidencia;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public String getPaisResidencia() {
		return paisResidencia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}

}
