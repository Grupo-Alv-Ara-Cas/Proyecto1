package Modelo;

public class Usuario {
	
	private String nombreUsuario;
	private String login;
	private String password;
	
	public Usuario(String nombreUsuario, String login, String password) {
		this.nombreUsuario = nombreUsuario;
		this.login = login;
		this.password = password;
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

}
