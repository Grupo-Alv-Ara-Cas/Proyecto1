package Modelo;

public class Alquiler {
	private String  lugarInicio; 
	private String fechaInicio;
	private String rangoHoraInicio;
	private String lugarFin;
	private String fechaFin;
	private String rangoHoraFin;
	private String lugarEntrega;
	private long precio;
	private Categorias tipoDeCarro;
	public Alquiler(String lugarInicio, String fechaInicio, String rangoHoraInicio, String lugarFin, String fechaFin,
			String rangoHoraFin, String lugarEntrega, long precio, Categorias tipoDeCarro) {
		this.lugarInicio = lugarInicio;
		this.fechaInicio = fechaInicio;
		this.rangoHoraInicio = rangoHoraInicio;
		this.lugarFin = lugarFin;
		this.fechaFin = fechaFin;
		this.rangoHoraFin = rangoHoraFin;
		this.lugarEntrega = lugarEntrega;
		this.tipoDeCarro = tipoDeCarro;
		precio = tipoDeCarro.getPrecioBase();
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getLugarFin() {
		return lugarFin;
	}
	public void setLugarFin(String lugarFin) {
		this.lugarFin = lugarFin;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getLugarEntrega() {
		return lugarEntrega;
	}
	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}
	public String getLugarInicio() {
		return lugarInicio;
	}
	public String getRangoHoraInicio() {
		return rangoHoraInicio;
	}
	public String getRangoHoraFin() {
		return rangoHoraFin;
	}
	public long getPrecio() {
		
		return precio;
	}
	public Categorias getTipoDeCarro() {
		return tipoDeCarro;
	}
	
	
	
}
