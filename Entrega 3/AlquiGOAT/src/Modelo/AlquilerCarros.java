package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AlquilerCarros {

    private HashMap<String, Vehiculo> carros;
    private HashMap<String, Sede> sedes;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Categorias> categorias;
    private HashMap<String, Reservas> reservasEmpresa;
    private HashMap<String, Seguros> seguros;
    private HashMap<String, Alquiler> alquilerEmpresa;
    private HashMap<String, String> historiales;
    private CargarDatos cargarDatos;
    private GuardarDatos guardarDatos;


    public String revisarCuenta(String usuario, String password) {
        if (usuarios.containsKey(usuario)) {
            Usuario user = usuarios.get(usuario);
            String contrasena = user.getPassword();
            if (contrasena.equals(password)) {
                String tipoUsuario = user.getTipoUsuario();
                return (tipoUsuario);
            }

        }
        return (null);
    }

    public void cargarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes,
            File todasCategorias, File todosReservas, File todosSeguros, File historiales) {

        cargarDatos = new CargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todasCategorias,
                todosReservas, todosSeguros, historiales);
        categorias = cargarDatos.cargarCategoria();
        sedes = cargarDatos.cargarSedes();
        carros = cargarDatos.cargarVehiculos(sedes, categorias);
        usuarios = cargarDatos.cargarUsuarios(sedes);
        seguros = cargarDatos.cargarSeguros();
        reservasEmpresa = cargarDatos.cargarResevas(usuarios, sedes, categorias, seguros);
        guardarDatos = new GuardarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todosReservas,
                todosSeguros, historiales);

    }
    
    public boolean revisarUsuario(String login){
    	return (usuarios.containsKey(login));
    }

    public void crearCliente(String nombreUsuario, String login, String password, String fechaNacimiento,
            String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia,
            String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID,
            String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta,
            String codigoTarjeta, String fechaCaducidadT, String tipo) {
         
            Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
            Tarjeta datosTarjeta = new Tarjeta(numeroTarjeta, codigoTarjeta, fechaCaducidadT, tipo);
            DatosContacto dataContact = new DatosContacto(numeroCelular, correo, paisResidencia, ciudadResidencia,
                    direccionResidencia, codigoPostal);
            Cliente cliente = new Cliente(nombreUsuario, login, password, fechaNacimiento, nacionalidad,
                    imagenDocumento,
                    dataContact, datosLicencia, datosTarjeta);
            usuarios.put(login, cliente);
            guardarDatos.addCliente(nombreUsuario, login, password, fechaNacimiento,
                    nacionalidad, imagenDocumento, numeroCelular, correo, paisResidencia,
                    ciudadResidencia, direccionResidencia, codigoPostal, numeroID,
                    paisExpedicion, fechaCaducidadL, imagenLicencia, numeroTarjeta,
                    codigoTarjeta, fechaCaducidadT, tipo);
           
        
    }

    public boolean revisarDisponibilidad(String sede, String categoria) {
        Sede sedeRevisar = sedes.get(sede);
        return (sedeRevisar.revisarDisponibilidad(categoria));
    }

    public void crearReserva(String usuario, String lugarInicio, String fechaInicio, String rangoHoraInicio,
            String lugarFin, String fechaFin, String rangoHoraFin, String tipoDeCarro) {
        Usuario usuarioActual = usuarios.get(usuario);
        Sede sedeRecojer = sedes.get(lugarInicio);
        Sede sedeEntregar = sedes.get(lugarFin);
        Categorias categoriaEste = categorias.get(tipoDeCarro);

        Reservas reservaEste = new Reservas(sedeRecojer, fechaInicio, rangoHoraInicio, fechaFin, rangoHoraFin,
                sedeEntregar, categoriaEste, usuarioActual);
        reservasEmpresa.put(usuario, reservaEste);

    }

    public void finalizarReserva(String loginTra, String loginCli, String placa) {
		Reservas reservaActual = reservasEmpresa.get(loginCli);
		Vehiculo carro = carros.get(placa);
		
		Usuario cliente = usuarios.get(loginCli);
		
		Trabajador trabajador = (Trabajador) usuarios.get(loginTra);
		
		Factura factura = new Factura(cliente, trabajador);
		factura.setAlquish(reservaActual);
		factura.setCarro(carro);
		carro.setDisponible(false);
		
		factura.imprimirFactura();
		factura.imprimirIndicaciones();
		
		String historias = historiales.get(placa);
		historias = carro.setUbicacion(loginCli, historias);
		historiales.put(placa, historias);
		reservasEmpresa.remove(loginCli);
    }


    public void comprarCarro(String placa, String marca, String modelo, String color, String tipoTransmisión,
            String ubicacion, Boolean disponible, String sedeCarro, String categoria, String login) {
        AdministradorGeneral admin = (AdministradorGeneral) usuarios.get(login);
        Categorias categoriaActual = categorias.get(categoria);
        Sede sedeActual = sedes.get(sedeCarro);
        Vehiculo vehAdd = admin.comprarCarro(placa, marca, modelo, color, tipoTransmisión, ubicacion, disponible,
                sedeActual, categoriaActual);
        carros.put(placa, vehAdd);
    }

    public void bajaCarro(String placa) {
        carros.remove(placa);

    }

    public void crearAdminSede(String sedeT, String nombreUsuario, String logins, String passwords, String numeroID,
            String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String login) {
        Sede sedett = sedes.get(sedeT);
        AdministradorGeneral admin = (AdministradorGeneral) usuarios.get(login);
        AdministradorSede adminSede = admin.crearAdminSede(sedett, nombreUsuario, logins, passwords, numeroID, paisExpedicion, fechaCaducidadL,
                imagenLicencia);
        usuarios.put(logins, adminSede);
        guardarDatos.addTrabajador(sedeT, nombreUsuario, logins, passwords, numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia, "2");
    }

    public void agregarSeguro(String nombre, String descripcion, String  precio) {
    long precios = Long.parseLong(precio);
    Seguros sguro1 = new Seguros(precio, descripcion, precios);
    seguros.put(nombre, sguro1);
    
    guardarDatos.addSeguros(nombre, precio, descripcion);
    
    }

	public void addCondutorextra(String nombre, String fecha, String numeorID, String paisExpedicion, File documento, String loginu) {
		Licencia linceniaActrual = new Licencia(numeorID,  paisExpedicion, fecha, documento);
		ConductorAdicional nuevoC = new ConductorAdicional(linceniaActrual, nombre);
		Alquiler alqui = alquilerEmpresa.get(loginu);
		alqui.anadirCondutor(nuevoC);
	}

	public void crearAlquiler(String fechFin, String fechInicio, String lugarEntrega, String lugarInicio,
			String categoria, String loginUsuario, ArrayList<String> segurosd) {
		
		Sede sedeInicio = sedes.get(lugarInicio);
		Sede sedeEntrega = sedes.get(lugarEntrega);
		Categorias ctegoriaEste = categorias.get(categoria);
		
		Alquiler nalquiler = new Alquiler(sedeInicio,fechInicio, sedeInicio.getHorariosSede(), fechFin, sedeEntrega.getHorariosSede(), sedeEntrega, ctegoriaEste );
		alquilerEmpresa.put(loginUsuario, nalquiler);
		for (String seguro: segurosd) {
			Seguros seg = seguros.get(seguro);
			nalquiler.anadirSeguro(seg);
		}
		sedeInicio.cambiarDisponibilidadCarro(false, ctegoriaEste.getNombre());
	}

	public void finalizarAlquiler(String loginTra, String loginCli, String placa) {
		Alquiler alquilerActual = alquilerEmpresa.get(loginCli);
		Vehiculo carro = carros.get(placa);
		
		Usuario cliente = usuarios.get(loginCli);
		
		Trabajador trabajador = (Trabajador) usuarios.get(loginTra);
		
		Factura factura = new Factura(cliente, trabajador);
		factura.setAlquish(alquilerActual);
		factura.setCarro(carro);
		carro.setDisponible(false);
		
		factura.imprimirFactura();
		factura.imprimirIndicaciones();
		
	}
	
	public void recibirCarro(String loginTra, String loginCli, String placa, String sede) {
		Vehiculo carro = carros.get(placa);
		Sede sedeEntrega= sedes.get(sede);
	
		Sede sedeAnterior = carro.getSedeCarro();
		sedeAnterior.quitarCarros(carro);
		
		String historias = historiales.get(placa);
		historias = carro.setUbicacion("lavando", historias);
		historiales.put(placa, historias);
		
		if (!(sedeAnterior.getSede()).equals(sede)) {
			sedeAnterior.quitarCarros(carro);
			carro.setSedeCarro(sedeEntrega);
			sedeEntrega.agregarCarros(carro);
		}
		
	}
	
	public void gurdarCarros() {
		guardarDatos.guardarCarros(carros);
	}
	
	public HashMap<String, Sede> getSedes() {
		return sedes;
	}

	public HashMap<String, Categorias> getCategorias() {
		return categorias;
	}

	public HashMap<String, Seguros> getSeguros() {
		return seguros;
	}

	public void gurdarResevras() {
		guardarDatos.guardarReserva(reservasEmpresa);
	}

	public void cambiarEstadoCarro(String placa, int estado) {
		Vehiculo carro = carros.get(placa);
		Sede sede = carro.getSedeCarro();
		String categoria = carro.getCategoria().getNombre();
		if (estado == 1) {
			if (carro.getDisponible()) {
				carro.setDisponible(false);
				sede.cambiarDisponibilidadCarro(false, categoria);
				String historias = historiales.get(placa);
				historias = carro.setUbicacion("lavando", historias);
				historiales.put(placa, historias);
			}
			else {
				String historias = historiales.get(placa);
				historias = carro.setUbicacion("lavando", historias);
				historiales.put(placa, historias);
			}
			
		}
		else if (estado == 2) {
			
			if (carro.getDisponible()) {
				carro.setDisponible(false);
				sede.cambiarDisponibilidadCarro(false, categoria);
				String historias = historiales.get(placa);
				historias = carro.setUbicacion("arreglando", historias);
				historiales.put(placa, historias);
			}
			else {
				String historias = historiales.get(placa);
				historias = carro.setUbicacion("arreglando", historias);
				historiales.put(placa, historias);
			}
			
		}
		else if (estado == 3) {
			if (carro.getDisponible()) {
				String historias = historiales.get(placa);
				historias = carro.setUbicacion("sede", historias);
				historiales.put(placa, historias);
			}
			else {
				carro.setDisponible(true);
				sede.cambiarDisponibilidadCarro(true, categoria);
				String historias = historiales.get(placa);
				historias = carro.setUbicacion("sede", historias);
				historiales.put(placa, historias);
			}
			
		}
		
	}

	
	
	
}
