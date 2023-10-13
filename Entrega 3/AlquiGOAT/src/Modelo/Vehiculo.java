package Modelo;

public class Vehiculo {
	private String  placa; 
	private String  marca;
	private String  modelo;
	private String  color;
	private String  tipoTransmisión;
	private String  ubicacion;
	private Boolean  disponible;
	private Sede  sedeCarro;
	private Categorias  categoria;
	
	public Vehiculo(String placa, String marca, String modelo, String color, String tipoTransmisión, String ubicacion,
			Boolean disponible, Sede sedeCarro, Categorias categoria) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmisión = tipoTransmisión;
		this.ubicacion = ubicacion;
		this.disponible = disponible;
		this.sedeCarro = sedeCarro;
		this.categoria = categoria;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getColor() {
		return color;
	}
	public String getTipoTransmisión() {
		return tipoTransmisión;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setSedeCarro(Sede sedeCarro) {
		this.sedeCarro = sedeCarro;
	}
	public Sede getSedeCarro() {
		return sedeCarro;
	}
	public void setDisponible(Boolean disponible) {
		if (disponible) {
			categoria.masCarrosDisponibles(1);
		}
		else {
			categoria.masCarrosDisponibles(0);
		}	
		this.disponible = disponible;
		
	}
	
		
}
