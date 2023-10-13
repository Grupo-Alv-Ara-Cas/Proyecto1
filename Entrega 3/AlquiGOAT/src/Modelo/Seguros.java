package Modelo;

public class Seguros {
	
	private String nombre;
    private String descripcion;
    private long precio;
    private int cantidadDias;

    public Seguros(String nombre, String descripcion, long precio, int cantidadDias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadDias = cantidadDias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public long getPrecio() {
        return precio;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

}
