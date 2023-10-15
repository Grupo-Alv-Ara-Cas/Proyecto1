package Modelo;

import java.io.File;
import java.util.HashMap;

public class AdministradorGeneral extends AdministradorSede {

    public AdministradorGeneral(Sede sedeT, String nombreUsuario, String login, String password, Licencia datos) {
        super(sedeT, nombreUsuario, login, password, datos);
    }

    public AdministradorSede crearAdminSede(Sede sedeT, String nombreUsuario, String login, String password,
            String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
        Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
        AdministradorSede adminSede = new AdministradorSede(sedeT, nombreUsuario, login, password, datosLicencia);
        return adminSede;
    }

    public Vehiculo comprarCarro(String placa, String marca, String modelo, String color, String tipoTransmisión,
            String ubicacion, Boolean disponible, Sede sedeCarro, Categorias categoria) {
        Vehiculo vehiculo = new Vehiculo(placa, categoria, sedeCarro, marca, modelo, color, tipoTransmisión, ubicacion,
                disponible);
        return vehiculo;
    }

    public void bajaCarro(Vehiculo carro, HashMap<String, Categorias> categorias) {
    }

    public void agregarSeguro(HashMap<String, Seguros> seguros, String nombre, String descripcion, long precio,
            int cantidadDias) {
        Seguros seguro = new Seguros(nombre, descripcion, precio, cantidadDias);
        seguros.put(nombre, seguro);
    }

}
