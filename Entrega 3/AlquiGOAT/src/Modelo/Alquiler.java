package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Alquiler {
	protected String lugarInicio;
	protected String fechaInicio;
	protected String rangoHoraInicio;
	protected String fechaFin;
	protected String rangoHoraFin;
	protected String lugarEntrega;
	protected long precio;
	protected ArrayList<ConductorAdicional> masConductor;
	protected ArrayList<Seguros> tipoSeguro;
	protected Categorias tipoDeCarro;

	public Alquiler(String lugarInicio, String fechaInicio, String rangoHoraInicio, String lugarFin, String fechaFin,
			String rangoHoraFin, String lugarEntrega, long precio, Categorias tipoDeCarro) {
		this.lugarInicio = lugarInicio;
		this.fechaInicio = fechaInicio;
		this.rangoHoraInicio = rangoHoraInicio;
		this.fechaFin = fechaFin;
		this.rangoHoraFin = rangoHoraFin;
		this.lugarEntrega = lugarEntrega;
		this.precio = precio;
		this.tipoDeCarro = tipoDeCarro;
		definirPrecio();
		masConductor = new ArrayList<ConductorAdicional>();
		tipoSeguro = new ArrayList<Seguros>();
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void anadirCondutor(ConductorAdicional condutor) {
		masConductor.add(condutor);
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public String getLugarEntrega() {
		return lugarEntrega;
	}

	public String getLugarInicio() {
		return lugarInicio;
	}

	public long getPrecio() {
		return precio;
	}

	public String getRangoHoraInicio() {
		return rangoHoraInicio;
	}

	public String getRangoHoraFin() {
		return rangoHoraFin;
	}

	public String getAnadirCondutor() {
		String condutores = "";
		for (int i = 0; i < masConductor.size(); i++) {
			condutores += masConductor.get(i).getNombre() + "\n";
		}
		return condutores;
	}

	public String getOpcionSeguro() {
		String seguros = "";
		for (int i = 0; i < tipoSeguro.size(); i++) {
			seguros += tipoSeguro.get(i).getNombre() + "\n";
		}
		return seguros;
	}

	private void definirPrecio() {

		long precioDia = tipoDeCarro.getPrecioBase();

		long precioExtra = (long) (masConductor.size() * 320000);

		LocalDate Fin = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate Inicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Period period = Period.between(Inicio, Fin);
		int totalDias = period.getDays();

		precio = ((long) totalDias) * precioDia + precioExtra;

	}

	public Categorias getTipoDeCarro() {
		return tipoDeCarro;
	}

	public void cambiarDisponibilidad() {

	}

}
