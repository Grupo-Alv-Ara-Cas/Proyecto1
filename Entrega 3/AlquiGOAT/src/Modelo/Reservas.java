package Modelo;

public class Reservas extends Alquiler{
	
	private long precioReserva;
	private long aPagar;

	public Reservas(String lugarInicio, String fechaInicio, String rangoHoraInicio, String lugarFin, String fechaFin,
			String rangoHoraFin, String lugarEntrega, long precio, Categorias tipoDeCarro) {
		super(lugarInicio, fechaInicio, rangoHoraInicio, lugarFin, fechaFin, rangoHoraFin, lugarEntrega, precio, tipoDeCarro);
		
		precioReserva();
		aPagar = precio - precioReserva;
		
	}

	private void precioReserva() {
		precioReserva = (precio * 30/100); 
	}

	public long getPrecioReserva() {
		return precioReserva;
	}

	public long getaPagar() {
		return aPagar;
	}
	
	
	

}
