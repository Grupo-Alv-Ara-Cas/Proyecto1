package Modelo;

import java.io.File;

public class Trabajador extends Usuario {

	public void setSedeT(Sede sedeT) {
		this.sedeT = sedeT;
	}

	private Sede sedeT;

	public Trabajador(Sede sedeT, String nombreUsuario, String login, String password, Licencia datosLicencia) {
		super(nombreUsuario, login, password, datosLicencia);
		this.sedeT = sedeT;
		tipoUsuario = "3";
	}

	public void entregarCarro(Vehiculo carro, Usuario recibe) {

	}
	
    

	public Sede getSedeT() {
		return sedeT;
	}

	public void recibirCarro(Vehiculo carro) {

	}

	public void registrarConductorExtra(Licencia nuevoConductor) {

	}

	public void actualizarEstadoCarro(Vehiculo carro, String estado) {

	}

}
