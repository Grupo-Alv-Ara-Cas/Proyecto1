package Modelo;

public class Reservas extends Alquiler {

	private long precioReserva;
	private long aPagar;



		public Reservas(Sede lugarInicio, String fechaInicio, String rangoHoraInicio, String lugarFin, String fechaFin,
			String rangoHoraFin, Sede lugarEntrega, Categorias tipoDeCarro) {
		super(lugarInicio, fechaInicio, rangoHoraInicio, lugarFin, fechaFin, rangoHoraFin, lugarEntrega,
				tipoDeCarro);
		precioReserva();
		aPagar = precio - precioReserva;
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
