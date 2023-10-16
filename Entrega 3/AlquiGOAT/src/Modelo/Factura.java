package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Usuario usuario;
    private Sede sede;
    private Trabajador trabajador;
    private Alquiler alquiler;
    private Categorias tipoDeCarro;
    private Vehiculo carro;
    private String lugarInicio;
    private String fechaInicio;
    private String rangoHoraInicio;
    private String lugarFin;
    private String fechaFin;
    private String rangoHoraFin;
    private String lugarEntrega;
    private long precio;

    public Factura(Usuario usuario, Sede sede, Trabajador trabajador, String lugarInicio, String fechaInicio,
            String rangoHoraInicio, String lugarFin,
            String fechaFin, String rangoHoraFin, Categorias tipoDeCarro, String lugarEntrega) {
        this.usuario = usuario;
        this.sede = sede;
        this.trabajador = trabajador;
        this.lugarInicio = lugarInicio;
        this.fechaInicio = fechaInicio;
        this.rangoHoraInicio = rangoHoraInicio;
        this.lugarFin = lugarFin;
        this.fechaFin = fechaFin;
        this.rangoHoraFin = rangoHoraFin;
        this.tipoDeCarro = tipoDeCarro;
        this.lugarEntrega = lugarEntrega;
        alquiler = new Alquiler(lugarInicio, fechaInicio, rangoHoraInicio, lugarFin, fechaFin, rangoHoraFin,
                lugarEntrega, precio, tipoDeCarro);
    }

    public long getPrecio() {
        return alquiler.getPrecio();
    }

    public String conductorAdicional() {
        return alquiler.getAnadirCondutor();
    }

    public String opcionSeguro() {
        return alquiler.getOpcionSeguro();
    }

    String contenido = String.valueOf(getPrecio()) + "\n" + conductorAdicional() + "\n" + opcionSeguro() + "\n";

    public boolean imprimirFactura() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./data/factura/factura" + usuario + ".txt"))) {
            writer.write(contenido);
            return true;

        } catch (IOException e) {
            return false;
        }
    }

}
