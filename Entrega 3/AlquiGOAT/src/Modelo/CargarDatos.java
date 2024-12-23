package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class CargarDatos {
	private File todosTrabajadores;
	private File todosClientes;
	private File todosCarros;
	private File todasSedes;
	private File todosCategorias;
	private File todosReservas;
	private File todosSeguros;
	private File historiales;

	public CargarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes,
			File todosCategorias, File todosReservas, File todosSeguros, File historiales) {
		super();
		this.todosTrabajadores = todosTrabajadores;
		this.todosClientes = todosClientes;
		this.todosCarros = todosCarros;
		this.todasSedes = todasSedes;
		this.todosCategorias = todosCategorias;
		this.todosReservas = todosReservas;
		this.todosSeguros = todosSeguros;
		this.historiales = historiales;
	}

	public HashMap<String, Sede> cargarSedes() {
		HashMap<String, Sede> sedes = new HashMap<String, Sede>();
		try (BufferedReader lector = new BufferedReader(new FileReader(todasSedes))) {
			String linea = lector.readLine();
			linea = lector.readLine();
			while (linea != null) {
				String[] datosSede = linea.split(",");
				Sede cli = new Sede(datosSede[0], datosSede[1], datosSede[2]);
				sedes.put(datosSede[0], cli);
				linea = lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sedes;

	}

	public HashMap<String, Categorias> cargarCategoria() {
		HashMap<String, Categorias> categoria = new HashMap<String, Categorias>();
		try (BufferedReader lector = new BufferedReader(new FileReader(todosCategorias))) {
			String linea = lector.readLine();
			linea = lector.readLine();
			while (linea != null) {
				String[] datosCategoria = linea.split(",");
				long precio = Long.parseLong(datosCategoria[1]);
				Categorias cat = new Categorias(datosCategoria[0], precio);
				categoria.put(datosCategoria[0], cat);
				linea = lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return categoria;

	}

	public HashMap<String, Vehiculo> cargarVehiculos(HashMap<String, Sede> mapaSede,
			HashMap<String, Categorias> mapaCategoria) {
		HashMap<String, Vehiculo> carros = new HashMap<String, Vehiculo>();
		try (BufferedReader lector = new BufferedReader(new FileReader(todosCarros))) {
			String linea = lector.readLine();
			linea = lector.readLine();
			while (linea != null) {
				if (linea.equals(";;;;;;")) {
					break;
				}
				String[] datosvheicu = linea.split(",");
				Categorias categoria = mapaCategoria.get(datosvheicu[1]);
				Sede sede = mapaSede.get(datosvheicu[2]);
				Boolean disponible = Boolean.parseBoolean(datosvheicu[8]);
				Vehiculo vheicu = new Vehiculo(datosvheicu[0], categoria, sede, datosvheicu[3], datosvheicu[4],
						datosvheicu[5], datosvheicu[6], datosvheicu[7], disponible);
				categoria.anadirVehiculo(vheicu);
				sede.agregarCarros(vheicu);
				carros.put(datosvheicu[0], vheicu);
				linea = lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return carros;

	}

	private Cliente crearNuevoCliente(String nombreUsuario, String login, String password, String fechaNacimiento,
			String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia,
			String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID,
			String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta,
			String codigoTarjeta, String fechaCaducidadT, String tipo) {
		Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
		Tarjeta datosTarjeta = new Tarjeta(numeroTarjeta, codigoTarjeta, fechaCaducidadT, tipo);
		DatosContacto dataContact = new DatosContacto(numeroCelular, correo, paisResidencia, ciudadResidencia,
				direccionResidencia, codigoPostal);
		Cliente cliente = new Cliente(nombreUsuario, login, password, fechaNacimiento, nacionalidad, imagenDocumento,
				dataContact, datosLicencia, datosTarjeta);
		return cliente;
	}

	private Trabajador crearNuevoTabajador(Sede sedeT, String nombreUsuario, String login, String password,
			String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
		Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
		Trabajador trabajador = new Trabajador(sedeT, nombreUsuario, login, password, datosLicencia);
		return trabajador;
	}

	private AdministradorSede crearAdminSede(Sede sedeT, String nombreUsuario, String login, String password,
			String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
		Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
		AdministradorSede adminSede = new AdministradorSede(sedeT, nombreUsuario, login, password, datosLicencia);
		return adminSede;
	}

	private AdministradorGeneral crearAdministradorGeneral(Sede sedeT, String nombreUsuario, String login,
			String password, String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia) {
		Licencia datosLicencia = new Licencia(numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia);
		AdministradorGeneral adminGeneral = new AdministradorGeneral(sedeT, nombreUsuario, login, password,
				datosLicencia);
		return adminGeneral;
	}

	public HashMap<String, Usuario> cargarUsuarios(HashMap<String, Sede> sedes) {
		{
			HashMap<String, Usuario> Usuarios = new HashMap<String, Usuario>();
			try (BufferedReader lector = new BufferedReader(new FileReader(todosTrabajadores))) {
				String linea = lector.readLine();
				linea = lector.readLine();
				while (linea != null) {
					String[] datosTrabajador = linea.split(",");
					Sede sedeT = sedes.get(datosTrabajador[1]);
					File imagenLicencia = new File(datosTrabajador[8]);

					if (datosTrabajador[0].equals("1")) {
						AdministradorGeneral admin = crearAdministradorGeneral(sedeT, datosTrabajador[2],
								datosTrabajador[3], datosTrabajador[4], datosTrabajador[5], datosTrabajador[6],
								datosTrabajador[7], imagenLicencia);
						Usuarios.put(datosTrabajador[3], admin);
					}

					else if (datosTrabajador[0].equals("2")) {
						AdministradorSede adminSedeEste = crearAdminSede(sedeT, datosTrabajador[2], datosTrabajador[3],
								datosTrabajador[4], datosTrabajador[5], datosTrabajador[6], datosTrabajador[7],
								imagenLicencia);
						sedeT.setAdministradorSede(adminSedeEste);
						Usuarios.put(datosTrabajador[3], adminSedeEste);
					} else if (datosTrabajador[0].equals("3")) {
						Trabajador trabajadorEste = crearNuevoTabajador(sedeT, datosTrabajador[2], datosTrabajador[3],
								datosTrabajador[4], datosTrabajador[5], datosTrabajador[6], datosTrabajador[7],
								imagenLicencia);
						sedeT.agregarTrabajador(trabajadorEste);
						Usuarios.put(datosTrabajador[3], trabajadorEste);
					}

					linea = lector.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try (BufferedReader lector = new BufferedReader(new FileReader(todosClientes))) {
				String linea = lector.readLine();
				linea = lector.readLine();
				while (linea != null) {
					String[] datosCliente = linea.split(",");
					File imagenLicencia = new File(datosCliente[15]);
					File imagenDocumento = new File(datosCliente[6]);
					if (datosCliente[0].equals("4")) {
						Cliente cli = crearNuevoCliente(datosCliente[1], datosCliente[2], datosCliente[3],
								datosCliente[4], datosCliente[5], imagenDocumento, datosCliente[6], datosCliente[7],
								datosCliente[8], datosCliente[9], datosCliente[10], datosCliente[11], datosCliente[12],
								datosCliente[13], datosCliente[14], imagenLicencia, datosCliente[16], datosCliente[17],
								datosCliente[18], datosCliente[19]);
						Usuarios.put(datosCliente[2], cli);
					}

					linea = lector.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			return Usuarios;

		}
	}
	
	public HashMap<String, Seguros> cargarSeguros() {
		HashMap<String, Seguros> seguros = new HashMap<String, Seguros>();
		try (BufferedReader lector = new BufferedReader(new FileReader(todosSeguros))) {
			String linea = lector.readLine();
			linea = lector.readLine();
			while (linea != null) {
				String[] datosSeguros = linea.split(",");
				long precio = Long.parseLong(datosSeguros[1]);
				Seguros seg = new Seguros(datosSeguros[0], datosSeguros[2], precio);
				seguros.put(datosSeguros[0], seg);
				linea = lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return seguros;
		
		

	}
	
	public HashMap<String, Reservas> cargarResevas(HashMap<String, Usuario> Usuarios, HashMap<String, Sede> sedes, HashMap<String, Categorias> categoria, HashMap<String, Seguros> seguros) {
		HashMap<String, Reservas> reservas = new HashMap<String, Reservas>();
		try (BufferedReader lector = new BufferedReader(new FileReader(todosReservas))) {
			String linea = lector.readLine();
			linea = lector.readLine();
			while (linea != null) {
				String[] datosReservas = linea.split(",");
				Usuario user = Usuarios.get(datosReservas[0]);
				Sede lugarInicio = sedes.get(datosReservas[1]);
				Sede lugarFin = sedes.get(datosReservas[3]);
				Categorias categori = categoria.get(datosReservas[5]);
				
				lugarInicio.cambiarDisponibilidadCarro(false, categori.getNombre());
				
				Reservas res = new Reservas(lugarInicio, datosReservas[2], lugarInicio.getHorariosSede(), datosReservas[4], lugarFin.getHorariosSede(), lugarFin, categori, user);
				reservas.put(datosReservas[0], res);
				
				String[] conductoresExtra = datosReservas[6].split("/");
				
				for (String conductro: conductoresExtra) {
					String[] conductorActual = conductro.split("%");
					File imagen = new File(conductorActual[4]);
					Licencia datosLicencia = new Licencia(conductorActual[1], conductorActual[2], conductorActual[3], imagen);
					ConductorAdicional condu = new ConductorAdicional(datosLicencia, conductorActual[0]);
					res.anadirCondutor(condu);
				}
				
				String[] tipoSeguros = datosReservas[7].split("/");
				
				
				for (String seguroT: tipoSeguros) {
					Seguros segurd = seguros.get(seguroT);
					res.anadirSeguro(segurd);
				}
				
				
				linea = lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	public HashMap<String, String> cargarHistorial() {
		HashMap<String, String> carroHist = new HashMap<String, String>();
		try (BufferedReader lector = new BufferedReader(new FileReader(historiales))) {
			String linea = lector.readLine();
			linea = lector.readLine();
			while (linea != null) {
				String[] historialCarros = linea.split(",");
				carroHist.put(historialCarros[0], historialCarros[1]);
				linea = lector.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return carroHist;

	}
}
