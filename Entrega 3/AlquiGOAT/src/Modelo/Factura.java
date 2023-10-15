package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Usuario usuario;
    private Sede sede;
    private Trabajador trabajador;
    private String lugarInicio;
    private String fechaInicio;
    private String rangoHoraInicio;
    private String lugarFin;
    private String fechaFin;
    private String rangoHoraFin;
    private Alquiler alquiler;
    private Categorias tipoDeCarro;
    private Vehiculo carro;
    private String lugarEntrega;
    private long precio;

    public Factura(Usuario usuario, Sede sede, Trabajador trabajador) {
        this.usuario = usuario;
        this.sede = sede;
        this.trabajador = trabajador;
    }

    public void setAlquiler(String lugarInicio, String fechaInicio, String rangoHoraInicio, String lugarFin,
            String fechaFin, String rangoHoraFin, Categorias tipoDeCarro, String lugarEntrega) {
        this.lugarInicio = lugarInicio;
        this.fechaInicio = fechaInicio;
        this.rangoHoraInicio = rangoHoraInicio;
        this.lugarFin = lugarFin;
        this.fechaFin = fechaFin;
        this.rangoHoraFin = rangoHoraFin;
        this.tipoDeCarro = tipoDeCarro;
        this.lugarEntrega = lugarEntrega;
    }

    public void setPrecio() {

    }

    public long getPrecio() {
        return precio;
    }

    public void opcionSeguro(Seguros seguroNuevo) {

    }

    public void conductorAdicional(String numeroID, String paisExpedicion, String fechaCaduca, File imagenLicencia) {

    }

    public void cambiarDisponibilidad() {

    }

    public File imprimirFactura() {
        // Lógica para imprimir la factura y guardarla en un archivo
        // Aquí deberías implementar la lógica para imprimir la factura y guardarla en
        // un archivo
        return null; // Retorna null para este ejemplo, debes implementar la lógica real
    }

}
