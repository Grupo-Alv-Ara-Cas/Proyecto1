package Consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Modelo.AlquilerCarros;

public class Interfaz extends JFrame {
	
	private AlquilerCarros aplicacion;
	private PanelUsuario panelUsuario;

    public Interfaz() {
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocation(350, 100);

        JLabel titleLabel = new JLabel("AlquiGOAT");
        Font titleFont = new Font("SansSerif", Font.BOLD, 32);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel("¿Cómo desea acceder?");
        questionLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton regisButton = new JButton("Registrarse");
        

        /*logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	logButton.addActionListener(this);
            	logButton.setActionCommand("Login");
            	String login = JOptionPane.showInputDialog("Ingrese su usuario: ");
            	String password = JOptionPane.showInputDialog("Ingrese su contraseña: ");
            	aplicacion.revisarCuenta(login, password);
            }
        });

        regisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	regisButton.addActionListener(this);
            	regisButton.setActionCommand("Registrarse");
            	String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre: ");
            	String login = JOptionPane.showInputDialog("Ingrese su usuario: ");
            	String password = JOptionPane.showInputDialog("Ingrese su contraseña: ");
            	String fechaNacimiento = JOptionPane.showInputDialog("Ingrese su fecha de nacimiento: ");
            	String nacionalidad = JOptionPane.showInputDialog("Ingrese su nacionalidad: ");
            	File imagenDocumento = new File("Ingrese la URL de su imagen de documento: ");
            	String numeroCelular = JOptionPane.showInputDialog("Ingrese su número de celular: ");
            	String correo = JOptionPane.showInputDialog("Ingrese su correo electrónico: ");
            	String paisResidencia = JOptionPane.showInputDialog("Ingrese su país de residencia: ");
            	String ciudadResidencia = JOptionPane.showInputDialog("Ingrese su ciudad de residencia: ");
            	String direccionResidencia = JOptionPane.showInputDialog("Ingrese su dirección de residencia: ");
            	String codigoPostal = JOptionPane.showInputDialog("Ingrese su código postal: ");
            	String numeroID = JOptionPane.showInputDialog("Ingrese su número de identificación: ");
            	String paisExpedicion = JOptionPane.showInputDialog("Ingrese el país de expedición de su licencia: ");
            	String fechaCaducidadL = JOptionPane.showInputDialog("Ingrese la fecha de caducidad de su licencia: ");
            	File imagenLicencia = new File("Ingrese la URL de su imagen de licencia: ");
            	String numeroTarjeta = JOptionPane.showInputDialog("Ingrese su número de tarjeta: ");
            	String codigoTarjeta = JOptionPane.showInputDialog("Ingrese el código de seguridad de su tarjeta: ");
            	String fechaCaducidadT = JOptionPane.showInputDialog("Ingrese la fecha de caducidad de su tarjeta: ");
            	String tipo = JOptionPane.showInputDialog("Ingrese el tipo de cliente: ");
            	aplicacion.crearCliente(nombreUsuario, login, password, fechaNacimiento,
        				nacionalidad, imagenDocumento, numeroCelular, correo, paisResidencia,
        				ciudadResidencia, direccionResidencia, codigoPostal, numeroID,
        				paisExpedicion, fechaCaducidadL, imagenLicencia, numeroTarjeta,
        				codigoTarjeta, fechaCaducidadT, tipo);
            }
        });
        

        loginPanel.add(questionLabel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(logButton);
        buttonPanel.add(regisButton);
        loginPanel.add(buttonPanel, BorderLayout.CENTER);*/

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        add(titleLabel, BorderLayout.NORTH);

        add(loginPanel, BorderLayout.CENTER);

        setTitle("AlquiGOAT - Entrega 4");
        setVisible(true);
    }
    
    public void iniciarSesion() throws IOException {
    	JButton logButton = new JButton("Iniciar Sesión");
    	panelUsuario = new PanelUsuario();
   	
   }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Interfaz();
                
                /*public PanelUsuario {
            		return ;
            	}*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
