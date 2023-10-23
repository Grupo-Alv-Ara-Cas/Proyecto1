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
    private String lugarInicioS;
    private String lugarEntregaS;
    private String nombreCliente;
    private String trabajadorSede;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipoTransmision;
    private String segurito;
    private String conducs;
    private long subtotal;
    private long total;
    private String subtotalStr;
    private String totalStr;
    
    
    public Factura(Usuario cliente, Trabajador trabajador, Alquiler alqui, Vehiculo carro ) {
        this.usuario = cliente;
        this.trabajador = trabajador;
        nombreCliente = cliente.getNombreUsuario();
        trabajadorSede = trabajador.getNombreUsuario();
        this.alquiler = alqui;
        this.carro = carro;
        Alquish();
        
    }

	public void Alquish() {
    	tipoDeCarro = alquiler.getTipoDeCarro();
    	lugarInicio = alquiler.getLugarInicio();
        fechaInicio = alquiler.getFechaInicio();
        rangoHoraInicio = alquiler.getRangoHoraInicio();
        fechaFin = alquiler.getFechaFin();
        rangoHoraFin = alquiler.getRangoHoraFin();
        tipoDeCarro = alquiler.getTipoDeCarro();
        lugarEntrega = alquiler.getLugarEntrega();
        lugarInicioS = lugarInicio.getNombreSede();
        lugarEntregaS = lugarEntrega.getNombreSede();
        trabajadorSede = trabajador.getNombreUsuario();
        nombreCliente = usuario.getNombreUsuario();
        placa = carro.getPlaca();
        marca = carro.getMarca();
        modelo = carro.getModelo();
        color = carro.getColor();
        tipoTransmision = carro.getTipoTransmisión();
        segurito = String.valueOf(opcionSeguro()) + "\n";
        conducs = String.valueOf(conductorAdicional()) + "\n";
        subtotal = (long) getPrecio();
        total = (long) (getPrecio() * 19 / 100);
        subtotalStr = String.valueOf(subtotal);
        totalStr = String.valueOf(total);
        lugarEntregaS = lugarEntrega.getNombreSede();
        lugarInicioS = lugarInicio.getNombreSede();
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
                """.formatted(trabajadorSede, lugarInicioS, nombreCliente, modelo, tipoDeCarro.getNombre(), marca, placa, color, tipoTransmision, fechaInicio,
                		lugarInicioS, fechaFin, lugarEntregaS, segurito, conducs, subtotalStr, totalStr);
    }

    public boolean imprimirFactura() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./facturas/comprobante_" + usuario.getNombreUsuario() + ".txt"))) {
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
                """.formatted(nombreCliente, modelo, tipoDeCarro.getNombre(), marca, fechaInicio,
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
