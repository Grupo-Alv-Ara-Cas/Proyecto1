package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList; 
import java.util.HashMap;

public class GuardarDatos {

	private File todosTrabajadores;
	private File todosClientes;
	private File todosCarros;
	private File todasSedes;
	private File todasReservas;
	private File todasSeguros;
	private File historiales;
	public GuardarDatos(File todosTrabajadores, File todosClientes, File todosCarros, File todasSedes, File todasReservas, File todosSeguros, File historiales) {
		this.todosTrabajadores = todosTrabajadores;
		this.todosClientes = todosClientes;
		this.todosCarros = todosCarros;
		this.todasSedes = todasSedes;
		this.todasReservas = todasReservas;
		this.todasSeguros = todosSeguros;
		this.historiales = historiales;
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
			e.printStackTrace();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
		
	public void guardarCarros (HashMap<String, Vehiculo> carros) {
		
		
		try (  BufferedWriter CR = new BufferedWriter(new FileWriter(todosCarros))) {
			String linea;
			linea = "placa,categoria,sede_carro,marca,modelo,color,tipo_transmision,ubicacion,disponible";
			CR.write(linea + "\n");
			for(String placa: carros.keySet()) {
				Vehiculo carro =  carros.get(placa);
				
				String categoria = carro.getCategoria().getNombre();
				String sede = carro.getSedeCarro().getNombreSede();
				
				linea = placa +","+categoria+","+ sede+","+carro.getMarca()+","+carro.getModelo()+","+carro.getColor()+","+carro.getTipoTransmisión()+","+carro.getUbicacion()+","+carro.getDisponible().toString();
				
				CR.write(linea + "\n");
			}
			
	                }
	         catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	public void guardarReserva (HashMap<String, Reservas> reservas) {
		
		
		try (  BufferedWriter CR = new BufferedWriter(new FileWriter(todasReservas))) {
			String linea;
			linea = "loginReserva,lugarInicio,fechaInicio,lugarFin,fechaFin,categoria,condutoresExtra,tipoDeseguro";
			CR.write(linea + "\n");
			for(String login: reservas.keySet()) {
				Reservas reserva =  reservas.get(login);
				String categoria = reserva.getTipoDeCarro().getNombre();
				String sedeInico = reserva.getLugarInicio().getNombreSede();
				String fechaInico = reserva.getFechaInicio();
				String lugarFin = reserva.getLugarEntrega().getNombreSede();
				String fechaFin = reserva.getFechaFin();
				ArrayList<ConductorAdicional> conductoresEsxtra = reserva.getMasConductor();
				String datosRecolectado = "";
				for (ConductorAdicional conductor: conductoresEsxtra) {
					String nombre = conductor.getNombre();
					String datosLicencia = conductor.getLicencia().recuperarDatos();
					String todosDatos = nombre+"%"+datosLicencia;
					if (datosRecolectado.equals("")) {
						datosRecolectado = todosDatos;
					}
					else {
						datosRecolectado += "/" + todosDatos;
					}
				}
				
				ArrayList<Seguros> segurosReserva = reserva.getTipoSeguro();
				String stringSeguros = "";
				for (Seguros seguroT: segurosReserva) {
					String nombreSeguro = seguroT.getNombre();
					if (stringSeguros.equals("")) {
						stringSeguros = nombreSeguro;
					}
					else {
						stringSeguros += "/" + nombreSeguro;
					}
				}
				
				linea = login +","+sedeInico+","+ fechaInico+","+lugarFin+","+fechaFin+","+categoria+","+datosRecolectado+","+stringSeguros;
				
				CR.write(linea + "\n");
			}
			
	                }
	         catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	public void guardarHistorial (HashMap<String, String> historiale) {
		try ( BufferedWriter CR = new BufferedWriter(new FileWriter(historiales))) {
			String linea;
			linea = "placa,seguimiento";
			CR.write(linea + "\n");
			for(String placa: historiale.keySet()) {
				String seguimiento =  historiale.get(placa);
				linea = placa +","+seguimiento;
				CR.write(linea + "\n");
			}
			
	                }
	         catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	}
