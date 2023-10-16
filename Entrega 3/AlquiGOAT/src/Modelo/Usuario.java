package Modelo;

public class Usuario {

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	protected String nombreUsuario;
	protected String login;
	protected String password;
	protected Licencia licencia;
	protected String tipoUsuario;

	public Usuario(String nombreUsuario, String login, String password, Licencia licencia) {
		this.nombreUsuario = nombreUsuario;
		this.login = login;
		this.password = password;
		this.licencia = licencia;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Licencia getLicencia() {
		return licencia;
	}

}
