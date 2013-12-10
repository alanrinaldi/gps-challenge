package gpschallenge.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaJuegoTerminado extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel content;

	public VentanaJuegoTerminado(String titulo, Integer puntaje){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(titulo);
		setLayout(new BorderLayout());
		
		setBounds(0, 0, 400, 300);
		content = new JPanel();
		content.setBackground(Color.lightGray);
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		
		JLabel lblGanaste = new JLabel(titulo);
		lblGanaste.setFont(new Font("Serif", Font.PLAIN, 25));
		lblGanaste.setBounds(140, 20, 160, 60);
		content.add(lblGanaste);
		
		if(puntaje>0){
			JLabel lblPuntaje = new JLabel("Puntaje: " + puntaje.toString());
			lblPuntaje.setFont(new Font("Serif", Font.PLAIN, 28));
			lblPuntaje.setBounds(120, 80, 160, 60);
			content.add(lblPuntaje);
		}
		
		JButton botonJugarDenuevo = new JButton("Nuevo juego!");
		botonJugarDenuevo.setBorder(BorderFactory.createLineBorder(Color.black));
		botonJugarDenuevo.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonJugarDenuevo.setBounds(115, 140, 150, 40);
		botonJugarDenuevo.setFont(new Font("Serif", Font.PLAIN, 20));
		botonJugarDenuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Inicia un juego nuevo
				Main unaVentana = new Main();
				unaVentana.setVisible(true);
				dispose();
			}
		});
		content.setLayout(null);
		content.add(botonJugarDenuevo);

		JButton salir = new JButton("Salir");
		salir.setBorder(BorderFactory.createLineBorder(Color.black));
		salir.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		salir.setBounds(115, 210, 150, 40);
		salir.setFont(new Font("Serif", Font.PLAIN, 20));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		content.setLayout(null);
		content.add(salir);
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
