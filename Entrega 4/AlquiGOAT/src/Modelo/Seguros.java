package Modelo;

public class Seguros {

    private String nombre;
    private String descripcion;
    private long precio;

    public Seguros(String nombre, String descripcion, long precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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


}
