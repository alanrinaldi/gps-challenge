package gpschallenge.vista;

import gpschallenge.excepciones.EsquinasInvalidasException;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaConfiguraciones extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private PanelJugador paneljugador;
	
	public VentanaConfiguraciones(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.lightGray);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		setFocusable(true);
		
		paneljugador = new PanelJugador();
		paneljugador.setBackground(Color.LIGHT_GRAY);
		paneljugador.setBounds(150, 10, 200, 170);
		contentPane.add(paneljugador);
		paneljugador.setLayout(null);
		
		JButton botonJugar = new JButton("INICIAR JUEGO");
		botonJugar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonJugar.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonJugar.setBounds(150, 200, 150, 55);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Inicia un juego nuevo
				VentanaNuevoJuego unaVentana = null;
				try {
					unaVentana = new VentanaNuevoJuego();
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
		
	}
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
