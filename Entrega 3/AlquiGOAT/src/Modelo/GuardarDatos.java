package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class GuardarDatos {

	private File todosTrabajadores;
	private File todosClientes;
	private File todosCarros;
	private File todasSedes;
	private File todasReservas;
	private File todasSeguros;
	public GuardarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes, File todasReservas, File todosSeguros) {
		this.todosTrabajadores = todosTrabajadores;
		this.todosClientes = todosClientes;
		this.todosCarros = todosCarros;
		this.todasSedes = todasSedes;
		this.todasReservas = todasReservas;
		this.todasSeguros = todosSeguros;
	}
	
	public void addCliente(String nombreUsuario, String login, String password, String fechaNacimiento,
			String nacionalidad, File imagenDocumento, String numeroCelular, String correo, String paisResidencia,
			String ciudadResidencia, String direccionResidencia, String codigoPostal, String numeroID,
			String paisExpedicion, String fechaCaducidadL, File imagenLicencia, String numeroTarjeta,
			String codigoTarjeta, String fechaCaducidadT, String tipo)  {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(todosClientes, true))) {
			String imagenDocumentos = imagenDocumento.getPath(); 
			
			String imagenLicencial= imagenLicencia.getPath(); 
			
			String datos =  "4"+","+ nombreUsuario+","+  login  +","+ password +","+ fechaNacimiento+","+
					nacionalidad+","+  imagenDocumentos +","+ numeroCelular+","+  correo +","+ paisResidencia+","+
					 ciudadResidencia+","+  direccionResidencia +","+ codigoPostal +","+ numeroID+","+
					 paisExpedicion +","+fechaCaducidadL +","+imagenLicencial+","+  numeroTarjeta+","+
					 codigoTarjeta +","+ fechaCaducidadT +","+tipo;
			writer.newLine();
			writer.write(datos);
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	
	public void addTrabajador(String sedeT, String nombreUsuario, String login, String password,
			String numeroID, String paisExpedicion, String fechaCaducidadL, File imagenLicencia , String cargo) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(todosTrabajadores, true))){
			
			
			
			String imagenLicencial= imagenLicencia.getPath();
			
			String datos =  cargo+ ","+ sedeT +","+ nombreUsuario+","+  login  +","+ password +","+ numeroID+","
			+paisExpedicion +","+fechaCaducidadL +","+imagenLicencial;
			writer.newLine();
			writer.write(datos);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void addVheiculo(String placa, String categoria, String sedeCarro, String marca, String modelo, String color,
			String tipoTransmisión, String ubicacion,
			String disponible) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(todosCarros, true))){
		
			
			
			String datos =  placa+ ","+ categoria +","+ sedeCarro+","+  sedeCarro  +","+ marca +","+ ","+ modelo+","
			+color +","+tipoTransmisión +","+ubicacion+","+disponible;
			
			writer.newLine();
			writer.write(datos);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void addSede(String nombreSede, String ubicacionSede, String horariosSede) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(todasSedes, true))){
			
	
			
			String datos =  nombreSede+ ","+ ubicacionSede +","+ horariosSede;
			
			writer.newLine();
			writer.write(datos);

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		public void addReserva(String nombreSede, String ubicacionSede, String horariosSede) {
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(todasSeguros, true))){
				
		
				
				String datos =  nombreSede+ ","+ ubicacionSede +","+ horariosSede;
				
				writer.newLine();
				writer.write(datos);

			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
		
		public void addSeguros (String nombre, String precio, String descripcion) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(todasReservas, true))){
					String datos =  nombre+ ","+ precio +","+ descripcion;
					
					writer.newLine();
					writer.write(datos);

			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	public void quitarCarro (String placa) {
		
		
		try (BufferedReader Cl = new BufferedReader(new FileReader(todosCarros));
	             BufferedWriter CR = new BufferedWriter(new FileWriter(todosCarros))) {
	            String linea;
	            while ((linea = Cl.readLine()) != null) {
	                String[] datosCarro  = linea.split(","); 
	                if (!placa.equals(datosCarro[0])) {
	                    CR.write(linea + "\n");
	                }
	            }


	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
		

	
