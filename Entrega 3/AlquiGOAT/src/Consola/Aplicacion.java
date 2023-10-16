package Consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import Modelo.AlquilerCarros;
import Modelo.Categorias;
import Modelo.Sede;
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

        alquiler.cargarDatos(todosTrabajadores, todosClientes, todosCarros, todasSedes, todosCategorias);

    }

    public static void iniciarSesion() {
    	String crearCuenta = input("Desea crear una cuenta nueva? (Y/N)");
    	if (crearCuenta.toLowerCase().equals("n")) {
    		String login = input("Ingrese su Usuario");
            String password = input("Ingrese su Contraseña");
            String cuenta = alquiler.revisarCuenta(login, password);
            if (cuenta.equals("1")) {
                mostrarOpcionesAdminGeneral();
                String opcion = input("Eliga una opcion 1-9");
                if (opcion.toLowerCase().equals("1")) {
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
                }
                	else if (opcion.toLowerCase().equals("2")) {
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
                	else if (opcion.toLowerCase().equals("3")) {
                		String carro = input("Ingrese el vehículo al que le dara de baja");
                		alquiler.bajaCarro(carro, login);
                }
                	else if (opcion.toLowerCase().equals("4")) {
                		String nombre = input("Ingrese el nombre del seguro (regular, completo, sencillo)");
                		String descripcion = input("Ingrese la descripcion del vehículo");
                		String preci4o = input("Ingrese el precio del seguro");
                		long precio = Long.parseLong(preci4o);
                		alquiler.agregarSeguro(nombre, descripcion, precio);
                	}
                	
                
            } else if (cuenta.equals("2")) {
                mostrarOpcionesAdminSede();
                String opcion = input("Eliga una opcion 1-9");
                if (opcion.toLowerCase().equals("1")) {
                	String 
                	alquiler.registrarInfoEmpleados()
                }
            } else if (cuenta.equals("3")) {
                mostrarOpcionesTrabajador();
            } else if (cuenta.equals("4")) {
                mostrarOpcionesCliente();
            }
    	}
    	else {
    		System.out.println("A continuación podra crear su cuenta de Usuario");
    		String nombreUsuario = input("Escriba acá su nombre y apellido");
    		String login = input("Cree un nombre de usuario");
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
        
    }

    public static void mostrarOpcionesAdminGeneral() {

        System.out.println("1. Crear administrador de una sede");
        System.out.println("2. Comprar nuevo vehículo");
        System.out.println("3. Dar de baja a un vehículo");
        System.out.println("4. Crear seguro al vehículo");
        System.out.println("5. Alquilar un vehículo");
        System.out.println("6. Hacer la entrega de un vehículo");
        System.out.println("7. Hacer recibimiento de un vehículo");
        System.out.println("8. Registrar un conductor extra para el vehículo");
        System.out.println("9. Actualizar el estado de un vehículo");

    }

    public static void mostrarOpcionesAdminSede() {

        System.out.println("1. Registrar la infomarción de empleado");
        System.out.println("2. Registrar información de cliente");
        System.out.println("3. Agregar un trabajador a la sede");
        System.out.println("4. Agregar carro a la sede");
        System.out.println("5. Remover carro de la sede");
        System.out.println("6. Alquilar un vehículo");
        System.out.println("7. Hacer la entrega de un vehículo");
        System.out.println("8. Hacer recibimiento de un vehículo");
        System.out.println("9. Registrar un conductor extra para el vehículo");
        System.out.println("10. Actualizar el estado de un vehículo");

    }

    public static void mostrarOpcionesTrabajador() {

        System.out.println("1. Hacer la entrega de un vehículo");
        System.out.println("2. Hacer recibimiento de un vehículo");
        System.out.println("3. Registrar un conductor extra para el vehículo");
        System.out.println("4. Actualizar el estado de un vehículo");
        System.out.println("5. Alquilar un vehículo");

    }

    public static void mostrarOpcionesCliente() {

        System.out.println("1. Alquilar un vehículo");
        //if (alquiler)
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
