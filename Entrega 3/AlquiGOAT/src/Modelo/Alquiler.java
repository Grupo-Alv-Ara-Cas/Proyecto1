package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class  Alquiler {
	protected Sede lugarInicio;
	protected String fechaInicio;
	protected String rangoHoraInicio;
	protected String fechaFin;
	protected String rangoHoraFin;
	protected Sede lugarEntrega;
	protected long precio;
	protected ArrayList<ConductorAdicional> masConductor;
	protected ArrayList<Seguros> tipoSeguro;
	protected Categorias tipoDeCarro;

	public Alquiler(Sede lugarInicio, String fechaInicio, String rangoHoraInicio, String fechaFin,
			String rangoHoraFin, Sede lugarEntrega, Categorias tipoDeCarro) {
		this.lugarInicio = lugarInicio;
		this.fechaInicio = fechaInicio;
		this.rangoHoraInicio = rangoHoraInicio;
		this.fechaFin = fechaFin;
		this.rangoHoraFin = rangoHoraFin;
		this.lugarEntrega = lugarEntrega;
		this.tipoDeCarro = tipoDeCarro;
		masConductor = new ArrayList<ConductorAdicional>();
		tipoSeguro = new ArrayList<Seguros>();
		definirPrecio();
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

	public Sede getLugarEntrega() {
		return lugarEntrega;
	}

	public Sede getLugarInicio() {
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
		
		if (!lugarInicio.equals(lugarEntrega)) {
			precioExtra += 100000;
		}

		precio = ((long) totalDias) * precioDia + precioExtra;

	}

	public Categorias getTipoDeCarro() {
		return tipoDeCarro;
	}

	public void cambiarDisponibilidad() {

	}

}
