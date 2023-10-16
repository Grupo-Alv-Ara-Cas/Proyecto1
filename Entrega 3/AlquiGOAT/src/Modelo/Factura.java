package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Factura {
    private Usuario usuario;
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
    private String lugarInicioS = lugarInicio.getNombreSede();
    private String lugarEntregaS = lugarEntrega.getNombreSede();
    private String trabajadorSede = trabajador.getNombreUsuario();
    private String placa = carro.getPlaca();
    private String marca = carro.getMarca();
    private String modelo = carro.getModelo();
    private String color = carro.getColor();
    private String tipoTransmision = carro.getTipoTransmisión();
    private String segurito = String.valueOf(opcionSeguro()) + "\n";
    private String conducs = String.valueOf(conductorAdicional()) + "\n";
    private long subtotal = getPrecio();
    private long total = (long) (getPrecio() * 0.19);
    private String subtotalStr = String.valueOf(subtotal);
    private String totalStr = String.valueOf(total);

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
        this.lugarInicioS = lugarInicio.getNombreSede();
        this.lugarEntregaS = lugarEntrega.getNombreSede();
        this.trabajadorSede = trabajador.getNombreUsuario();
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.color = carro.getColor();
        this.tipoTransmision = carro.getTipoTransmisión();
        this.segurito = String.valueOf(opcionSeguro()) + "\n";
        this.conducs = String.valueOf(conductorAdicional()) + "\n";
        long subtotal = getPrecio();
        long total = (long) (getPrecio() * 0.19);
        this.subtotalStr = String.valueOf(subtotal);
        this.totalStr = String.valueOf(total);
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
    

    
    private String generarContenidoFactura() {
        return """
                ***** Factura de Alquiler *****
                Trabajador: %s
                Sede: %s
                Cliente: %s
                Carro Alquilado: %s
                Categoría del Carro: %s
                Marca: 
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
                """.formatted(trabajadorSede, lugarInicioS, usuario, modelo, tipoDeCarro.getNombre(), marca, placa, color, tipoTransmision, fechaInicio,
                		lugarInicioS, fechaFin, lugarEntregaS, segurito, conducs, subtotalStr, totalStr);
    }

    public boolean imprimirFactura() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./factura/comprobante_" + usuario.getNombreUsuario() + ".txt"))) {
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
                Sede donde se recibió el vehículo: %s
                Seguro Seleccionado: %s
                Conductores Asociados: %s
                La fecha de Finalización del Alquiler: %s
                Sede donde se dejará el vehículo: %s
                Este alquiler suma a un costo de: %s (sin impuestos)
                Para un total de: %s (19% IVA)
                """.formatted(usuario, modelo, tipoDeCarro.getNombre(), marca, fechaInicio,
                		lugarInicioS, segurito, conducs, fechaFin, lugarEntregaS, subtotalStr, totalStr);
    }

    public boolean imprimirIndicaciones() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./facturas/indicaciones_" + usuario.getNombreUsuario() + ".txt"))) {
            writer.write(generarContenidoIndicaciones());
            return true;

        } catch (IOException e) {
            return false;
        }
    }

}
