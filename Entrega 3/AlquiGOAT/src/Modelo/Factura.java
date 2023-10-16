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
    private Sede lugarInicio;
    private String fechaInicio;
    private String rangoHoraInicio;
    private String fechaFin;
    private String rangoHoraFin;
    private Sede lugarEntrega;
    private long precio;

    public Factura(Usuario usuario, Trabajador trabajador, Categorias tipoDeCarro) {
        this.usuario = usuario;
        this.trabajador = trabajador;
    }
    
    public void setAlquish(Alquiler alquiler) {
    	this.lugarInicio = alquiler.getLugarInicio();
        this.fechaInicio = alquiler.getFechaInicio();
        this.rangoHoraInicio = alquiler.getRangoHoraInicio();
        this.fechaFin = alquiler.getFechaFin();
        this.rangoHoraFin = alquiler.getRangoHoraFin();
        this.tipoDeCarro = alquiler.getTipoDeCarro();
        this.lugarEntrega = alquiler.getLugarEntrega();
    }

    public long getPrecio() {
        return alquiler.getPrecio();
    }

    public void setCarro(Vehiculo carro) {
		this.carro = carro;
	}

	public String conductorAdicional() {
        return alquiler.getAnadirCondutor();
    }

    public String opcionSeguro() {
        return alquiler.getOpcionSeguro();
    }
    
    String sedeNombre = sede.getNombreSede();
    String trabajadorSede = trabajador.getNombreUsuario();
	String placa = carro.getPlaca();
	String marca = carro.getMarca();
	String modelo = carro.getModelo();
    String color = carro.getColor();
	String tipoTransmision = carro.getTipoTransmisión();
    String segurito = String.valueOf(opcionSeguro()) + "\n";
    String conducs = String.valueOf(conductorAdicional()) + "\n";
    long subtotal = getPrecio();
    long total = (long) (getPrecio() * 0.19);
    String subtotalStr = String.valueOf(subtotal);
    String totalStr = String.valueOf(total);
    
    private String generarContenidoFactura() {
        return """
                ***** Factura de Alquiler *****
                Trabajador: %s
                Sede: %s
                Cliente: %s
                Carro Alquilado: %s
                Categoría del Carro: %s
                Placa: %s
                Color: %s
                Tipo de Transmisión: %s
                Fecha de Inicio del Alquiler: %s
                Lugar de Inicio del Alquiler: %s
                Fecha de Finalización del Alquiler: %s
                Lugar de Finalización del Alquiler: %s
                Seguro Seleccionado: %s
                Conductores Asociados: %s
                SUBTOTAL: %s
                TOTAL: %s
                """.formatted(trabajadorSede, sedeNombre, usuario, modelo, tipoDeCarro, placa, color, tipoTransmision, fechaInicio,
                		lugarInicio.getNombreSede(), fechaFin, lugarEntrega.getNombreSede(), segurito, conducs, subtotalStr, totalStr);
    }

    public boolean imprimirFactura() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./data/factura/factura" + usuario.getNombreUsuario() + ".txt"))) {
            writer.write(generarContenidoFactura());
            return true;

        } catch (IOException e) {
            return false;
        }
    }
    
    private String generarContenidoIndicaciones() {
        return """
                ***** Indicaciones de Uso *****
                Querido %s, AlquiGOAT le recuerda las siguientes indicaciones para hacer uso de nuestros vehículos:
                El carro Alquilado es un %s de la categoría %s.
                La fecha de Inicio del Alquiler: %s
                El ugar de Inicio del Alquiler: %s
                La fecha de Finalización del Alquiler: %s
                El lugar de Finalización del Alquiler: %s
                Seguro Seleccionado: %s
                Conductores Asociados: %s
                """.formatted(usuario, modelo, tipoDeCarro, fechaInicio,
                		lugarInicio, fechaFin, lugarEntrega, segurito, conducs, subtotalStr, totalStr);
    }

    public boolean imprimirIndicaciones() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./data/factura/factura" + usuario.getNombreUsuario() + ".txt"))) {
            writer.write(generarContenidoFactura());
            return true;

        } catch (IOException e) {
            return false;
        }
    }

}
