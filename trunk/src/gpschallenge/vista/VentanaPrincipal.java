package gpschallenge.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gpschallenge.excepciones.EsquinasInvalidasException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS-Challenge");
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.lightGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton botonJugar = new JButton("Jugar");
		botonJugar.setBorder(BorderFactory.createEmptyBorder());
		botonJugar.setContentAreaFilled(false);
		//Posicion donde se colocar este boton
		botonJugar.setBounds(141, 38, 153, 55);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Inicia un juego nuevo
				Ventana unaVentana = null;
				try {
					unaVentana = new Ventana();
				} catch (EsquinasInvalidasException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				unaVentana.setVisible(true);
				dispose();

			}
		});
		contentPane.setLayout(null);
		contentPane.add(botonJugar);

		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setBorder(BorderFactory.createEmptyBorder());
		botonContinuar.setContentAreaFilled(false);
		//Posicion donde se colocar este boton
		botonContinuar.setBounds(141, 104, 153, 55);
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Carga un juego de partida guardada
			}
		});
		contentPane.add(botonContinuar);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setBorder(BorderFactory.createEmptyBorder());
		botonSalir.setContentAreaFilled(false);
		//Posicion donde se colocar este boton
		botonSalir.setBounds(141, 170, 153, 55);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sale del programa
				System.exit(0);
			}
		});
		contentPane.add(botonSalir);

		addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					Ventana unaVentana = null;
					try {
						unaVentana = new Ventana();
					} catch (EsquinasInvalidasException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					unaVentana.setVisible(true);
					dispose();
				}

			}
		});
	}

}