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
    private List<Seguros> tipoSeguro;
    private List<ConductorAdicional> conductores;

    public Factura(Usuario usuario, Sede sede, Trabajador trabajador) {
        this.usuario = usuario;
        this.sede = sede;
        this.trabajador = trabajador;
        this.tipoSeguro = new ArrayList<>();
        this.conductores = new ArrayList<>();
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
        // Lógica para calcular el precio
        // Aquí deberías implementar la lógica para calcular el precio en base a los
        // datos de alquiler y seguros
    }

    public long getPrecio() {
        return precio;
    }

    public void añadirSeguro(Seguros seguroNuevo) {
        tipoSeguro.add(seguroNuevo);
    }

    public void añadirConductor(String numeroID, String paisExpedicion, String fechaCaduca, File imagenLicencia) {
        /*
         * ConductorAdicional conductor = new ConductorAdicional(numeroID,
         * paisExpedicion, fechaCaduca, imagenLicencia);
         * conductores.add(conductor);
         */
    }

    public void cambiarDisponibilidad() {
        // Lógica para cambiar la disponibilidad del vehículo
        // Aquí deberías implementar la lógica para cambiar la disponibilidad del
        // vehículo
    }

    public File imprimirFactura() {
        // Lógica para imprimir la factura y guardarla en un archivo
        // Aquí deberías implementar la lógica para imprimir la factura y guardarla en
        // un archivo
        return null; // Retorna null para este ejemplo, debes implementar la lógica real
    }

}
