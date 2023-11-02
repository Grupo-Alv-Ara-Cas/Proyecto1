package Consola;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

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
        

        JButton yesButton = new JButton("Iniciar Sesión");
        
        JButton noButton = new JButton("Registrarse");
        

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        

        loginPanel.add(questionLabel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        loginPanel.add(buttonPanel, BorderLayout.CENTER);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        add(titleLabel, BorderLayout.NORTH);

        add(loginPanel, BorderLayout.CENTER);

        setTitle("AlquiGOAT - Entrega 4");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Interfaz();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
