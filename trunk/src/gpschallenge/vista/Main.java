package gpschallenge.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

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
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS-Challenge");
		setBounds(0, 0, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.lightGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton botonJugar = new JButton("Jugar");
		botonJugar.setBorder(BorderFactory.createEmptyBorder());
		botonJugar.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonJugar.setBounds(141, 38, 153, 55);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Inicia un juego nuevo
				VentanaConfiguraciones unaVentana = new VentanaConfiguraciones();
				
				unaVentana.setVisible(true);
				dispose();

			}
		});
		contentPane.setLayout(null);
		contentPane.add(botonJugar);

		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setBorder(BorderFactory.createEmptyBorder());
		botonContinuar.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonContinuar.setBounds(141, 104, 153, 55);
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Carga un juego de partida guardada
				VentanaSeleccionJugador unaVentana = null;
				
				unaVentana = new VentanaSeleccionJugador();
			
			unaVentana.setVisible(true);
			dispose();
			}
		});
		contentPane.add(botonContinuar);
		
		
		
		
		JButton botonEstadisticas = new JButton("Estadisticas");
		botonEstadisticas.setBorder(BorderFactory.createEmptyBorder());
		botonEstadisticas.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonEstadisticas.setBounds(141, 170, 153, 55);
		botonEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Carga un juego de partida guardada
				VentanaRanking unaVentana = null;
				
				unaVentana = new VentanaRanking();
			
			unaVentana.setVisible(true);
			dispose();
			}
		});
		contentPane.add(botonEstadisticas);
		

		JButton botonSalir = new JButton("Salir");
		botonSalir.setBorder(BorderFactory.createEmptyBorder());
		botonSalir.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonSalir.setBounds(141, 230, 153, 55);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sale del programa
				System.exit(0);
			}
		});
		contentPane.add(botonSalir);

		
	}

}