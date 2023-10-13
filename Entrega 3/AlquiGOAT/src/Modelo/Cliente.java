package Modelo;

import java.io.File;

public class Cliente extends Usuario{
	
	private String fechaNacimiento;
	private String nacionalidad;
	private File imagenDocumento;
	private Tarjeta metodoPago;
	private DatosContacto datos;
	
	public Cliente(String nombreUsuario, String login, String password, String fechaNacimiento, String nacionalidad, File imagenDocumento, DatosContacto datosContacto, Licencia licencia, Tarjeta tarjeta) {
		super(nombreUsuario, login, password, licencia);
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.imagenDocumento = imagenDocumento;
		metodoPago = tarjeta;
		datos = datosContacto;
		tipoUsuario = "4";
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
	
	public Tarjeta getMetodoPago() {
		return metodoPago;
	}
	
	public DatosContacto getDatosContactoo() {
		return datos;
	}

}
