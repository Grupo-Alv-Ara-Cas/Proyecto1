package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Modelo.AlquilerCarros;
import Modelo.Categorias;
import Modelo.Sede;
import Modelo.Seguros;

public class Aplicacion {

	private static AlquilerCarros alquiler;

	public static void cargarDatos() {

		File todosTrabajadores = new File("./data/todosTrabajadores.csv");
		File todosClientes = new File("./data/todosClientes.csv");
		File todosCarros = new File("./data/todosCarros.csv");
		File todasSedes = new File("./data/todasSedes.csv");
		File todosCategorias = new File("./data/todosCategorias.csv");
		File todosReservas = new File("./data/todosReservas.csv");
		File todosSeguros = new File("./data/todosSeguros.csv");
		File historiales = new File("./historialCarros/historiales.csv");

		alquiler.cargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todosCategorias, todosReservas,
				todosSeguros, historiales);

	}

	public static void iniciarSesion() {

		Boolean apagar = true;
		while (apagar) {
			try {
				String crearCuenta = input("Desea crear una cuenta nueva? (Y/N)");
				if (crearCuenta.toLowerCase().equals("n")) {
					String login = input("Ingrese su Usuario");
					String password = input("Ingrese su Contraseña");
					String cuenta = alquiler.revisarCuenta(login, password);
					String opcion = "";
					while (!opcion.equals("0")) {
						if (cuenta.equals("1")) {
							mostrarOpcionesAdminGeneral();
							opcion = input("Eliga una opcion 0-11");
							if (opcion.toLowerCase().equals("1")) {
								adminSede(login);
							} else if (opcion.toLowerCase().equals("2")) {
								crearEmpleado(login);
							} else if (opcion.toLowerCase().equals("3")) {
								crearCliente();
							} else if (opcion.toLowerCase().equals("4")) {
								comprarCarr(login);
							} else if (opcion.toLowerCase().equals("5")) {
								String carro = input("Ingrese la placa del vehículo al que dara de baja");
								alquiler.bajaCarro(carro);
							} else if (opcion.toLowerCase().equals("6")) {
								String nombre = input("Ingrese el nombre del seguro (regular, completo, sencillo)");
								String descripcion = input("Ingrese la descripcion del vehículo");
								String precio = input("Ingrese el precio del seguro");

								alquiler.agregarSeguro(nombre, descripcion, precio);
							}

							else if (opcion.toLowerCase().equals("7")) {
								String loginUsuario = input("Ingrese el login del cliente");
								crearAlquileresReservas(1, loginUsuario);
							} else if (opcion.toLowerCase().equals("8")) {
								anadirCondutor();
							}
							else if (opcion.toLowerCase().equals("9")) {
								entregarCarrro(login);
							} else if (opcion.toLowerCase().equals("10")) {
								recibirCarro(login);
							} else if (opcion.toLowerCase().equals("11")) {
								cambiarEstadoCarro(login);
							}
						} else if (cuenta.equals("2")) {
							mostrarOpcionesAdminSede();
							opcion = input("Eliga una opcion 0-9");
							if (opcion.toLowerCase().equals("1")) {
								crearEmpleado(login);
							} else if (opcion.toLowerCase().equals("2")) {
								crearCliente();
							} else if (opcion.toLowerCase().equals("3")) {
								anadirTrabajdorSede(login);
							} 
							else if (opcion.toLowerCase().equals("4")) {
								anadirCarroSede(login);
							} 
							else if (opcion.toLowerCase().equals("5")) {
								String loginUsuario = input("Ingrese el login del cliente");
								crearAlquileresReservas(1, loginUsuario);
							} else if (opcion.toLowerCase().equals("6")) {
								anadirCondutor();
							}
							else if (opcion.toLowerCase().equals("7")) {
								entregarCarrro(login);
							} else if (opcion.toLowerCase().equals("8")) {
								recibirCarro(login);
							} else if (opcion.toLowerCase().equals("9")) {
								cambiarEstadoCarro(login);
							}
						} 
						else if (cuenta.equals("3")) {
							mostrarOpcionesTrabajador();
							mostrarOpcionesAdminSede();
							opcion = input("Eliga una opcion 0-9");
							if (opcion.toLowerCase().equals("1")) {
								crearCliente();
							} 
							else if (opcion.toLowerCase().equals("2")) {
								String loginUsuario = input("Ingrese el login del cliente");
								crearAlquileresReservas(1, loginUsuario);
							} else if (opcion.toLowerCase().equals("6")) {
								anadirCondutor();
							}
							else if (opcion.toLowerCase().equals("3")) {
								entregarCarrro(login);
							} else if (opcion.toLowerCase().equals("4")) {
								recibirCarro(login);
							} else if (opcion.toLowerCase().equals("5")) {
								cambiarEstadoCarro(login);
							}
						} else if (cuenta.equals("4")) {
							mostrarOpcionesCliente();
							if (opcion.toLowerCase().equals("1")) {
								crearAlquileresReservas(2, login);
							} 
						}
					}
				} else {
					crearCliente();
				}
				String apagars = input("¿Desea apagar la aplicacion? (Y/N)");
				apagar = !(apagars.toLowerCase()).equals("y");
			} catch (Exception e) {
				System.err.println("Ha ocurrido un error: " + e.getMessage());
			}
			alquiler.gurdarCarros();
			alquiler.gurdarResevras();
			alquiler.gurdarHistorial();
		}
		}

	

	private static void anadirCarroSede(String login) {
		String placa = input("Ingrese la placa del carro que va a cambiar de sede");
		alquiler.anadirCarroSede(placa, login);
	}

	private static void anadirTrabajdorSede(String login) {
		String trabajdor = input("Ingrese el codigo del trabajador que desea añadir a la sede");
		alquiler.addTrabajador(trabajdor, login);
	}

	private static void recibirCarro(String loginTra) {
		HashMap<String, Sede> mapaSedes = alquiler.getSedes();
		Set<String> setSedes = mapaSedes.keySet();
		Object[] arraySede = setSedes.toArray();

		System.out.println("Llene los siguentes campos");
		String loginCli = input("Login del cliente");
		String placa = input("Placa del carro");
		mostrarCosas(setSedes);
		String sede = input("Sede en la que se encuentra");
		int sedeNum = Integer.parseInt(sede) - 1;
		String sedeFinal = (String) arraySede[sedeNum];
		alquiler.recibirCarro(loginTra, loginCli, placa, sedeFinal);
		System.out.println("El vehículo se ha recibido con éxito!");
		System.out.println("RECUERDA LAVAR EL VEHÍCULO ANTES DE HABILITARLO DE NUEVO");
	}

	private static void cambiarEstadoCarro(String login) {
		System.out.println("Llene los siguentes campos");
		String placa = input("Placa del carro");
		System.out.println("1. Lavando");
		System.out.println("2. Arreglando");
		System.out.println("3. Sede");
		String estado = input("Estado del carro");
		int num = Integer.parseInt(estado);
		alquiler.cambiarEstadoCarro(placa, num);

	}

	public static void mostrarOpcionesAdminGeneral() {

		System.out.println("0. Hacer Log-Out");
		System.out.println("1. Crear administrador de una sede");
		System.out.println("2. Registrar la infomarción de empleado");
		System.out.println("3. Registrar información de cliente");
		System.out.println("4. Comprar nuevo vehículo");
		System.out.println("5. Dar de baja a un vehículo");
		System.out.println("6. Crear seguro al vehículo");
		System.out.println("7. Alquilar un vehículo");
		System.out.println("8. Registrar conductores extras para el vehículo");
		System.out.println("9. Hacer la entrega de un vehículo");
		System.out.println("10. Hacer recibimiento de un vehículo");
		System.out.println("11. Actualizar el estado de un vehículo");
	}

	public static void mostrarOpcionesAdminSede() {

		System.out.println("0. Hacer Log-Out");
		System.out.println("1. Registrar la infomarción de empleado");
		System.out.println("2. Registrar información de cliente");
		System.out.println("3. Agregar un trabajador a la sede");
		System.out.println("4. Agregar carro a la sede");
		System.out.println("5. Alquilar un vehículo");
		System.out.println("6. Registrar conductores extras para el vehículo");
		System.out.println("7. Hacer la entrega de un vehículo");
		System.out.println("8. Hacer recibimiento de un vehículo");
		System.out.println("9. Actualizar el estado de un vehículo");
	}

	public static void mostrarOpcionesTrabajador() {

		System.out.println("0. Hacer Log-Out");
		System.out.println("1. Registrar información de cliente");
		System.out.println("2. Alquilar un vehículo");
		System.out.println("3. Registrar un conductor extra para el vehículo");
		System.out.println("4. Hacer la entrega de un vehículo");
		System.out.println("5. Hacer recibimiento de un vehículo");
		System.out.println("6. Actualizar el estado de un vehículo");

	}

	public static void mostrarOpcionesCliente() {
		System.out.println("0. Hacer Log-Out");
		System.out.println("1. Hacer reserva de un vehículo");
	}

	public static void main(String[] args) {

		Aplicacion consola = new Aplicacion();
		alquiler = new AlquilerCarros();
		consola.cargarDatos();
		consola.iniciarSesion();
	}

	private static void crearCliente() {

		System.out.println("A continuación podra crear su cuenta de Usuario");
		String nombreUsuario = input("Escriba acá su nombre y apellido");
		String login = input("Cree un nombre de usuario");
		Boolean seguir = alquiler.revisarUsuario(login);

		while (seguir) {
			login = input("El usuario introducido ya existe.\n Cree un nuevo nombre de usuario");
			seguir = alquiler.revisarUsuario(login);
		}
		System.out.println("Complete los siguientes datos\n");
		String password = input("Cree una contraseña");
		String fechaNacimiento = input("Su fecha de nacimiento (dd-mm-yyyy)");
		String nacionalidad = input("Su nacionalidad");
		String documentopng = input("Imagen de su documento de identidad");
		File imagenDocumento = new File(documentopng);
		String numeroCelular = input("Número de celular con la extensión respectiva");
		String correo = input("Correo electrónico de contacto");
		String paisResidencia = input("País de residencia");
		String ciudadResidencia = input("Ciudad de residencia");
		String direccionResidencia = input("Direccion de residencia");
		String codigoPostal = input("Código postal");
		String numeroID = input("Número de documento");
		String paisExpedicion = input("País de expedición de su documento");
		String fechaCaducidadL = input("Fecha de caducidad de su licencia (dd-mm-yyyy)");
		String licenciapng = input("Imagen de su licencia de conducción");
		File imagenLicencia = new File(licenciapng);
		String numeroTarjeta = input("Número de su tarjeta con la que hará el pago");
		String codigoTarjeta = input("Código de la tarjeta");
		String fechaCaducidadT = input("Ingrese la fecha de caducidad de su tarjeta (mm-yy)");
		String tipo = input("Tipo de tarjeta (Visa, Mastercard, ...)");
		alquiler.crearCliente(nombreUsuario, login, password, fechaNacimiento,
				nacionalidad, imagenDocumento, numeroCelular, correo, paisResidencia,
				ciudadResidencia, direccionResidencia, codigoPostal, numeroID,
				paisExpedicion, fechaCaducidadL, imagenLicencia, numeroTarjeta,
				codigoTarjeta, fechaCaducidadT, tipo);
		System.out.println("El cliente fue creado correctamente.");

	}

	private static void adminSede(String login) {
		try {
			String sedeT = input("Sede a la que desea asignarle el administrador");
			String nombreUsuario = input("Nombre del trabajador");
			String logins = input("Nombre de Usuario (Log-In) del trabajador");
			String passwords = input("Contraseña para este Log-In");
			String numeroID = input("Número de documento del ttrabajador");
			String paisExpedicion = input("País de expedición del documento");
			String fechaCaducidadL = input("Ingrese la fecha de caducidad de la licencia del trabajador");
			String licenciapng = input("Ingrese acá una imagen de la licencia del trabajador");
			File imagenLicencia = new File(licenciapng);
			alquiler.crearAdminSede(sedeT, nombreUsuario, logins, passwords, numeroID, paisExpedicion, fechaCaducidadL,
					imagenLicencia, login);
			System.out.println("El administrador de la sede fue creado correctamente.");
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error al ingresar datos del administrador: " + e.getMessage());
		}
	}
	
	private static void crearEmpleado(String login) {
		try {
			String sedeT = input("Sede a la que desea asignarle el trabajador");
			String nombreUsuario = input("Nombre del trabajador");
			String logins = input("Nombre de Usuario (Log-In) del trabajador");
			String passwords = input("Contraseña para este Log-In");
			String numeroID = input("Número de documento del ttrabajador");
			String paisExpedicion = input("País de expedición del documento");
			String fechaCaducidadL = input("Ingrese la fecha de caducidad de la licencia del trabajador");
			String licenciapng = input("Ingrese acá una imagen de la licencia del trabajador");
			File imagenLicencia = new File(licenciapng);
			alquiler.crearTrabajdor(sedeT, nombreUsuario, logins, passwords, numeroID, paisExpedicion, fechaCaducidadL,
					imagenLicencia, login);
			System.out.println("El trabajdor fue creado correctamente.");
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error al ingresar datos del administrador: " + e.getMessage());
		}
	}

	private static void comprarCarr(String login) {
		String placa = input("Placa del vehículo comprado");
		String marca = input("Marca del vehículo comprado");
		String modelo = input("Modelo del vehículo comprado");
		String color = input("Color del vehículo comprado");
		String tipoTransmisión = input("Tipo de transmisión del vehículo comprado");
		String ubicacion = "Sede";
		Boolean disponible = true;
		String sedeCarro = input("Sede en la que se ubicará el vehículo");
		String categoria = input("Categoría a la que pertenece el vehículo");
		alquiler.comprarCarro(placa, marca, modelo, color, tipoTransmisión,
				ubicacion, disponible, sedeCarro, categoria, login);
	}

	private static void crearAlquileresReservas(int num, String loginUsuario) {
		
		Boolean revicion = alquiler.revisarUsuario(loginUsuario);
		while (!revicion) {
			loginUsuario = input("Ingrese un login que exista del cliente");
			revicion = alquiler.revisarUsuario(loginUsuario);
		}
		
		HashMap<String, Sede> mapaSedes = alquiler.getSedes();
		Set<String> setSedes = mapaSedes.keySet();
		Object[] arraySede = setSedes.toArray();

		HashMap<String, Categorias> mapaCategorias = alquiler.getCategorias();
		Set<String> setCategorias = mapaCategorias.keySet();
		Object[] arrayCategoria = setCategorias.toArray();

		HashMap<String, Seguros> mapaSeguro = alquiler.getSeguros();
		Set<String> setSeguros = mapaSeguro.keySet();
		Object[] arraySeguro = setSeguros.toArray();

		System.out.println("\nComplete los siguientes datos acorde al alquiler");
		String fechaInicio = input("Fecha de inicio (dd-mm-yyyy)");
		String fechFin = input("Fecha de finalización (dd-mm-yyyy)");
		mostrarCosas(setSedes);
		String lugarInicioNum1 = input("Número de la sede que desea para recibir el carro");
		String lugarEntregaNum1 = input("Número de la sede que desea para entregar el carro");
		int lugarInicioNum = Integer.parseInt(lugarInicioNum1) - 1;
		int lugarEntregaNum = Integer.parseInt(lugarEntregaNum1) - 1;
		String lugarInicio = (String) arraySede[lugarInicioNum];
		String lugarEntrega = (String) arraySede[lugarEntregaNum];

		mostrarCosas(setCategorias);
		String categoriaNum1 = input("Número de la categoría que desea");
		int categoriaNum = Integer.parseInt(categoriaNum1) - 1;
		String categoria = (String) arrayCategoria[categoriaNum];
		Boolean revisarDiponibilidad = alquiler.revisarDisponibilidad(lugarInicio, categoria);
		while (revisarDiponibilidad) {
			categoriaNum1 = input("Ingrese una nueva categoria");
			categoriaNum = Integer.parseInt(categoriaNum1) - 1;
			categoria = (String) arrayCategoria[categoriaNum];
			revisarDiponibilidad = alquiler.revisarDisponibilidad(lugarInicio, categoria);
		}
		System.out.println("0: ninguno\n");
		mostrarCosas(setSeguros);
		String tipoSeguroNum1 = input("Ingrese los seguros que desea separados por coma").replaceAll(" ", "");

		String[] listaSeguros = tipoSeguroNum1.split(",");

		ArrayList<String> tipoSeguro = new ArrayList<String>();
		for (String seguro : listaSeguros) {
			if (!seguro.equals("0")) {
				int tipoSeguroNum = Integer.parseInt(seguro) - 1;
				tipoSeguro.add((String) arraySeguro[tipoSeguroNum]);
			}
		}

		if (num == 1) {
			alquiler.crearAlquiler(fechFin, fechaInicio, lugarEntrega, lugarInicio, categoria, loginUsuario,
					tipoSeguro);
			}
		else if (num == 2) {
				alquiler.cerarReserva(fechFin, fechaInicio, lugarEntrega, lugarInicio, categoria, loginUsuario,
						tipoSeguro);
				String coductorExtra = input("¿quiere registrar más conductores? (Y/N)");
				if (coductorExtra.toLowerCase().equals("y")) {
					anadirCondutor();
				}
				System.out.println("La reserva se cargo correctamente.");
		}

	}

	private static void anadirCondutor() {
		String loginp = input("¿Cuál es el Log-In de la persona?");
		String conductores = input("¿Cuántos condutores?");
		int cantidad = Integer.parseInt(conductores);
		int contador = 1;
		while (contador <= cantidad) {
			String nombre = input("Nombre completo del conductor adicional");
			String paseConduccionImagen = input("Ingrese el color del vehículo comprado");
			String fechaCaducidad = input("Ingrese el color del vehículo comprado");
			String nummeroID = input("Ingrese el color del vehículo comprado");
			String paisExpedicion = input("Ingrese el color del vehículo comprado");
			File documento = new File(paseConduccionImagen);
			alquiler.addCondutorextra(nombre, fechaCaducidad, nummeroID, paisExpedicion, documento, loginp);
			System.out.println("El conductor extra se cargo correctamente.");
		}
	}

	private static void mostrarCosas(Set<String> setSedes) {
		int numero = 1;
		for (String nombre : setSedes) {

			System.out.println(numero + ": " + nombre + "\n");
			numero++;
		}

	}
	private static void mostrarCosasLista(ArrayList<String> placasPocibles) {
		int numero = 1;
		for (String nombre : placasPocibles) {

			System.out.println(numero + ": " + nombre + "\n");
			numero++;
		}

	}

	private static void entregarCarrro(String loginTra) {

		String loginCli = input("Ingrese el Log-In del usuario");
		String tipo = input("Ingrese si es \n1: Reserva\n2: Alquiler");
		ArrayList<String> placasPocibles = alquiler.placasPosibles(loginCli);
		mostrarCosasLista(placasPocibles);
		String placaString = input("Ingrese la placa del Carro");
		int lugarEntregaNum = Integer.parseInt(placaString) - 1;
		String placa = (String)  placasPocibles.get(lugarEntregaNum) ;
		if (tipo.endsWith("2")) {
			alquiler.finalizarAlquiler(loginTra, loginCli, placa);
		} else {
			alquiler.finalizarReserva(loginTra, loginCli, placa);
		}

	}

	private static String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.err.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}
