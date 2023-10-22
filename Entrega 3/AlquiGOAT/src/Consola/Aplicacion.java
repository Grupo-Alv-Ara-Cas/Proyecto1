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
import Modelo.Factura;
import Modelo.AdministradorGeneral;

public class Aplicacion {

    private int opcionSeleccionada;

    private static Factura factura;
    private static AlquilerCarros alquiler;
    private static Sede sedeDisponibles;

    public static void cargarDatos() {

        File todosTrabajadores = new File("./data/todosTrabajadores.csv");
        File todosClientes = new File("./data/todosClientes.csv");
        File todosCarros = new File("./data/todosCarros.csv");
        File todasSedes = new File("./data/todasSedes.csv");
        File todosCategorias = new File("./data/todosCategorias.csv");
        File todosReservas = new File("./data/todosReservas.csv");
        File todosSeguros = new File("./data/todosSeguros.csv");

        alquiler.cargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todosCategorias, todosReservas, todosSeguros);

    }

    public static void iniciarSesion() {
    	try {
    	Boolean apagar = true;
    	while(apagar) {
    	String crearCuenta = input("Desea crear una cuenta nueva? (Y/N)");
    	if (crearCuenta.toLowerCase().equals("n")) {
    		String login = input("Ingrese su Usuario");
            String password = input("Ingrese su Contraseña");
            String cuenta = alquiler.revisarCuenta(login, password);
            String opcion = "";
            while (!opcion.equals("0")) {
	            if (cuenta.equals("1")) {
	                mostrarOpcionesAdminGeneral();
	                opcion = input("Eliga una opcion 0-10");
	                if (opcion.toLowerCase().equals("1")) {
	                	AdminSede(login);
	                }
	                else if (opcion.toLowerCase().equals("2")) {
	                	comprarCarr(login);
	               }
	                else if (opcion.toLowerCase().equals("3")) {
	                	crearCliente();
	               } 
	                else if (opcion.toLowerCase().equals("4")) {
	                	comprarCarr(login);
	               }
	                else if (opcion.toLowerCase().equals("5")) {
	            		String carro = input("Ingrese la placa del vehículo al que dara de baja");
	            		alquiler.bajaCarro(carro);
	                }
	                else if (opcion.toLowerCase().equals("6")) {
	            		String nombre = input("Ingrese el nombre del seguro (regular, completo, sencillo)");
	            		String descripcion = input("Ingrese la descripcion del vehículo");
	            		String precio = input("Ingrese el precio del seguro");
	            		
	            		alquiler.agregarSeguro(nombre, descripcion, precio);
	            	} 
	                
	                else if (opcion.toLowerCase().equals("7")) {
	                	String loginUsuario = input("Ingrese el login del usuario");
	                	crearAlquileresReservas(1, loginUsuario);
	                }
	                else if (opcion.toLowerCase().equals("8")) {
	                	anadirCondutor();
	                }
	                
	                else if (opcion.toLowerCase().equals("9")) {
	                	entregarCarrro(login);
	                }
	                
	            } else if (cuenta.equals("2")) {
	                mostrarOpcionesAdminSede();
	                opcion = input("Eliga una opcion 1-10");
	                if (opcion.toLowerCase().equals("1")) {
	                	String sede = input("Ingrese la sede a la que pertenece este empleado"); 
	                	String nombreUsurio = input("Ingrese el nombre y el apellido del empleado");
	                
	                }
	            } else if (cuenta.equals("3")) {
	                mostrarOpcionesTrabajador();
	            } else if (cuenta.equals("4")) {
	                mostrarOpcionesCliente();
	            }
            }
    	}
    	else {
    		crearCliente();
    	}
    	String apagars = input("¿Desea apagar la aplicacion? (Y/N)");
    	apagar = apagars.toLowerCase().equals("y");
    	}
    	alquiler.gurdarCarros();
    	alquiler.gurdarResevras();
    	}
    	
    	catch (Exception e) {
    		System.err.println("Ha ocurrido un error: " + e.getMessage());
    		alquiler.gurdarCarros();
    	}
    	
    }


	public static void mostrarOpcionesAdminGeneral() {

		System.out.println("0. Hacer logaut");
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

    	System.out.println("0. Hacer logaut");
    	System.out.println("1. Registrar la infomarción de empleado");
        System.out.println("2. Registrar información de cliente");
        System.out.println("3. Agregar un trabajador a la sede");
        System.out.println("4. Agregar carro a la sede");
        System.out.println("5. Remover carro de la sede");
        System.out.println("6. Alquilar un vehículo");
        System.out.println("7. Registrar conductores extras para el vehículo");
        System.out.println("8. Hacer la entrega de un vehículo");
        System.out.println("9. Hacer recibimiento de un vehículo");
        System.out.println("10. Actualizar el estado de un vehículo");
        System.out.println("11. Imprimir factura");
    }

    public static void mostrarOpcionesTrabajador() {

    	System.out.println("0. Hacer logaut");
    	System.out.println("1. Registrar información de cliente");
        System.out.println("2. Registrar un conductor extra para el vehículo");
    	System.out.println("3. Alquilar un vehículo");
    	System.out.println("4. Hacer la entrega de un vehículo");
        System.out.println("5. Hacer recibimiento de un vehículo");
        System.out.println("6. Actualizar el estado de un vehículo");
        

    }

    public static void mostrarOpcionesCliente() {
    	System.out.println("0. Hacer logaut");
    	System.out.println("1. Hacer reserva de un vehículo");
    }

    public static void crearAlquiler() {
        System.out.println("A continuación le mostraremos las sedes disponibles");
        sedeDisponibles.getSede();
    }

    public static void guardarFactura() {
        if (factura.imprimirFactura()) {
            System.out.println("Factura guardada con éxito");
        } else {
            System.out.println("Error al guardar la factura");
        }
    }

    public static void main(String[] args) {

        Aplicacion consola = new Aplicacion();
        alquiler = new AlquilerCarros();
        consola.cargarDatos();
        consola.iniciarSesion();
    }

    
    private static void crearCliente () {
    	
    	System.out.println("A continuación podra crear su cuenta de Usuario");
		String nombreUsuario = input("Escriba acá su nombre y apellido");
		String login = input("Cree un nombre de usuario");
		Boolean seguir = alquiler.rebisarUsuario(login);
		
		while (seguir) {
			login = input("El usuario introducido ya existe.\n Cree un nuevo nombre de usuario");
			seguir = alquiler.rebisarUsuario(login);
		} 
		String password = input("Cree una contraseña");
		String fechaNacimiento = input("Escriba su fecha de nacimiento en el formato dd-mm-yyyy");
		String nacionalidad = input("Escriba su nacionalidad");
		String documentopng = input("Ingrese acá una imágen de su documento de identidad");
		File imagenDocumento = new File(documentopng);
		String numeroCelular = input("Escriba su número de celular con la debida extensión, dependiendo de su país");
		String correo = input("Escriba su correo electrónico de contacto");
		String paisResidencia = input("Escriba su país de residencia");
		String ciudadResidencia = input("Escriba su cuidad de residencia");
		String direccionResidencia = input("Escriba su direccion de residencia");
		String codigoPostal = input("Escriba su código postal");
		String numeroID = input("Escriba su número de documento");
		String paisExpedicion = input("Escriba el país de expedición de su documento");
		String fechaCaducidadL = input("Escriba la fecha de caducidad de su licencia (dd-mm-yyyy)");
		String licenciapng = input("Ingrese acá una imágen de su licencia de conducción");
		File imagenLicencia = new File(licenciapng);
		String numeroTarjeta = input("Ingrese el número de su tarjeta con la que hará el pago");
		String codigoTarjeta = input("Ingrese el código de su targeta");
		String fechaCaducidadT = input("Ingrese la fecha de caducidad de su tarjeta (mm-yy)");
		String tipo = input("Ingrese el tipo de tarjeta (Visa, MasterCard...)");
		alquiler.crearCliente(nombreUsuario, login, password, fechaNacimiento,
				nacionalidad, imagenDocumento, numeroCelular, correo, paisResidencia,
				ciudadResidencia, direccionResidencia, codigoPostal, numeroID,
				paisExpedicion, fechaCaducidadL, imagenLicencia, numeroTarjeta,
				codigoTarjeta, fechaCaducidadT, tipo);
    	
    }
    
    private static void AdminSede(String login) {
    	try {
            String sedeT = input("Ingrese la sede a la que desea asignarle el administrador");
            String nombreUsuario = input("Ingrese el nombre del trabajador");
            String logins = input("Ingrese el nombre de Usuario (login) del trabajador");
            String passwords = input("Ingrese la cocntraseña para este login");
            String numeroID = input("Ingrese el numero de documento del ttrabajador");
            String paisExpedicion = input("Ingrese el pais donde se expede el documentto ingresdo previamente");
            String fechaCaducidadL = input("Ingrese la fecha de caducidad de la licencia del trabajador");
            String licenciapng = input("Ingrese acá una imágen de la licencia del trabajador");
            File imagenLicencia = new File(licenciapng);
            alquiler.crearAdminSede(sedeT, nombreUsuario, logins, passwords, numeroID, paisExpedicion, fechaCaducidadL, imagenLicencia, login);
             } catch (Exception e) {
            	 System.err.println("Ha ocurrido un error al ingresar datos del administrador: " + e.getMessage());
             }
    }
    
    private static void comprarCarr(String login) {
    	String placa = input("Ingrese la placa del vehículo comprado");
    	String marca = input("Ingrese la marca del vehículo comprado");
    	String modelo = input("Ingrese el modelo del vehículo comprado");
    	String color = input("Ingrese el color del vehículo comprado");
    	String tipoTransmisión = input("Ingrese el tipo de transmision del vehículo comprado");
    	String ubicacion = input("Ingrese en que sede esta ubicado el vehículo");
    	String disponibilidad = input("Ingrese si el vehículo esta disponible o no");
    	Boolean disponible = Boolean.parseBoolean(disponibilidad);
    	String sedeCarro = input("Ingrese nuevamente en que sede se encuentra el vehículo");
    	String categoria = input("Ingrese la categoria a la que pertenece el vehículo");
    	alquiler.comprarCarro(placa, marca, modelo, color, tipoTransmisión,
                ubicacion, disponible, sedeCarro, categoria, login); 
    }
    
    private static void crearAlquileresReservas(int num, String loginUsuario) {
    	HashMap<String, Sede> mapaSedes = alquiler.getSedes();
    	Set<String> setSedes = mapaSedes.keySet();
    	Object[] arraySede = setSedes.toArray();
    	
     	HashMap<String, Categorias> mapaCategorias = alquiler.getCategorias();
    	Set<String> setCategorias = mapaCategorias.keySet();
    	Object[] arrayCategoria = setCategorias.toArray();
    	
    	HashMap<String, Seguros> mapaSeguro = alquiler.getSeguros();
    	Set<String> setSeguros = mapaSeguro.keySet();
    	Object[] arraySeguro = setSeguros.toArray();
    	
    	String fechaInicio = input("Ingrese la fecha de inico");
    	String fechFin = input("Ingrese la fecha de fina");
    	mostrarCosas(setSedes);
    	String lugarInicioNum1 = input("Ingrese el numero de la sede que desea para resivir el carro");
    	String lugarEntregaNum1 = input("Ingrese el numero de la sede que desea para entregar el carro");
    	int lugarInicioNum =  Integer. parseInt(lugarInicioNum1)-1;
    	int lugarEntregaNum =Integer. parseInt(lugarEntregaNum1)-1;
    	String lugarInicio = (String) arraySede[lugarInicioNum];
    	String lugarEntrega = (String) arraySede[lugarEntregaNum];
    	
    	mostrarCosas(setCategorias);
    	String categoriaNum1 = input("Ingrese el numero de la categoria que desea");
    	int categoriaNum =  Integer. parseInt(categoriaNum1)-1;
    	String categoria = (String) arrayCategoria[categoriaNum];
    	Boolean revisarDiponibilidad = alquiler.revisarDisponibilidad(lugarInicio, categoria);
    	while (revisarDiponibilidad) {
    		categoria = input("Ingrese una nueva categoria");
    		revisarDiponibilidad = alquiler.revisarDisponibilidad(lugarInicio, categoria);
    	}
    	System.out.print("0: ninguno");
    	mostrarCosas(setSeguros);
    	String tipoSeguroNum1 = input("Ingrese los seguro que desae separados por coma").replaceAll(" ", "");
    	
    	String[] listaSeguros = tipoSeguroNum1.split(",");
    	
    	ArrayList<String> tipoSeguro = new ArrayList<String>();
    	for (String seguro: listaSeguros) {
    		if (!seguro.equals("0") ) {
	    	int tipoSeguroNum =  Integer. parseInt(seguro)-1;
	    	tipoSeguro.add((String) arraySeguro[tipoSeguroNum]);
	    	}
    	}
    	
    	if (num== 1) {
    		alquiler.crearAlquiler(fechFin, fechaInicio, lugarEntrega, lugarInicio, categoria, loginUsuario,tipoSeguro );
    	}
    	
    	}
		
	
    private static void anadirCondutor() {
    	String loginp = input("¿cual es el login de la persona?");
		String conductores = input("¿Cuantos condutores?");
		int cantidad = Integer. parseInt(conductores);
		int contador = 1;
		while (contador <= cantidad) {
			String nombre = input("Ingrese el color del vehículo comprado");
			String paseConduccionImagen = input("Ingrese el color del vehículo comprado");
			String fechaCaducidad = input("Ingrese el color del vehículo comprado");
			String nummeroID = input("Ingrese el color del vehículo comprado");
			String paisExpedicion = input("Ingrese el color del vehículo comprado");
			File documento = new File(paseConduccionImagen);
			alquiler.addCondutorextra(nombre, fechaCaducidad, nummeroID, paisExpedicion, documento, loginp);
		}
    }
    
    private static void mostrarCosas(Set<String> setSedes) {
    	int numero = 1;
    	for (String nombre: setSedes) {
    		System.out.print(numero +": "+nombre );
    	}
    	
    }

	private static void entregarCarrro(String login) {
		
		String logins = input("Ingrese el login del usuario");
    	String tipo = input("Ingrese si es 1: Reserva o 2: Alquiler");
    	String placa = input("Ingrese la placa del Carro");
    	if (tipo.endsWith("2")){
    		alquiler.finalisarAlquiler(login, logins, placa);
    	}
    	else {
    		alquiler.finalizarReserva(login, logins, placa);
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
