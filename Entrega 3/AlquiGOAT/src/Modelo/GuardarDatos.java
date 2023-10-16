package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GuardarDatos {

	private File todosTrabajadores;
	private File todosClientes;
	private File todosCarros;
	private File todasSedes;
	public GuardarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes) {
		this.todosTrabajadores = todosTrabajadores;
		this.todosClientes = todosClientes;
		this.todosCarros = todosCarros;
		this.todasSedes = todasSedes;
	}
	
	public void addCliente(String nombreUsuario, String login, String password, String fechaNacimiento,
			String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia,
			String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID,
			String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta,
			String codigoTarjeta, String fechaCaducidadT, String tipo) {
		
		try {
			PrintStream consola = System.out;
			
			System.setOut(new PrintStream((todosClientes)));
			
			String imagenDocumentos = imagenDocumento.getPath(); 
			
			String imagenLicencial= imagenLicencia.getPath(); 
			
			String datos =  "1"+","+ nombreUsuario+","+  login  +","+ password +","+ fechaNacimiento+","+
					nacionalidad+","+  imagenDocumentos +","+ numeroCelular+","+  correo +","+ paisResidencia+","+
					 ciudadResidencia+","+  direccionResidencia +","+ codigoPostal +","+ numeroID+","+
					 paisExpedicion +","+fechaCaducidadL +","+imagenLicencial+","+  numeroTarjeta+","+
					 codigoTarjeta +","+ fechaCaducidadT +","+tipo;
			
			System.out.println(datos);
			System.setOut(consola);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public void addTrabajador(String sedeT, String nombreUsuario, String login, String password,
			String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia , String cargo) {
		
		try {
			PrintStream consola = System.out;
			
			System.setOut(new PrintStream((todosTrabajadores)));
			
			
			String imagenLicencial= imagenLicencia.getPath();
			
			String datos =  cargo+ ","+ sedeT +","+ nombreUsuario+","+  login  +","+ password +","+ ","+ numeroID+","
			+paisExpedicion +","+fechaCaducidadL +","+imagenLicencial;
			
			System.out.println(datos);
			System.setOut(consola);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addVheiculo(String placa, String categoria, String sedeCarro, String marca, String modelo, String color,
			String tipoTransmisión, String ubicacion,
			String disponible) {
		
		try {
			PrintStream consola = System.out;
			
			System.setOut(new PrintStream((todosCarros)));
			
			String datos =  placa+ ","+ categoria +","+ sedeCarro+","+  sedeCarro  +","+ marca +","+ ","+ modelo+","
			+color +","+tipoTransmisión +","+ubicacion+","+disponible;
			
			System.out.println(datos);
			System.setOut(consola);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addSede(String nombreSede, String ubicacionSede, String horariosSede) {
		
		try {
			PrintStream consola = System.out;
			
			System.setOut(new PrintStream((todasSedes)));
			
			String datos =  nombreSede+ ","+ ubicacionSede +","+ horariosSede;
			
			System.out.println(datos);
			System.setOut(consola);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
