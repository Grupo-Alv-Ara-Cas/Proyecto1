package Modelo;

public class Trabajador extends Usuario{

	public Trabajador(Sede sedeT, String nombreUsuario, String login, String password, Licencia datosLicencia) {
		super(nombreUsuario, login, password, datosLicencia);
	}
	
	public void entregarCarro(Vehiculo carro, Usuario recibe) {
		
	}
	
	public void recibirCarro(Vehiculo carro) {
		
	}
	
	public void registrarConductorExtra(Licencia nuevoConductor) {
		
	}
	
	public void actualizarEstadoCarro(Vehiculo carro, String estado) {
		
	}
	

}
