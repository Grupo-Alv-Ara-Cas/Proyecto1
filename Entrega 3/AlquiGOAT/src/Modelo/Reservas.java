package Modelo;

public class Reservas extends Alquiler {

	private long precioReserva;
	private long aPagar;
	private Usuario usuario;



		public Reservas(Sede lugarInicio, String fechaInicio, String rangoHoraInicio, String fechaFin,
			String rangoHoraFin, Sede lugarEntrega, Categorias tipoDeCarro, Usuario usuario) {
		super(lugarInicio, fechaInicio, rangoHoraInicio, fechaFin, rangoHoraFin, lugarEntrega,
				tipoDeCarro);
		this.usuario = usuario ; 
		
		precioReserva();
		aPagar = precio - precioReserva;
	}

	public Usuario getUsuario() {
			return usuario;
		}

	private void precioReserva() {
		precioReserva = (precio * 30 / 100);
	}

	public long getPrecioReserva() {
		return precioReserva;
	}

	public long getaPagar() {
		return aPagar;
	}

}
