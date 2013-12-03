package gpschallenge.vista;

import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.thoughtworks.xstream.XStream;

public class PanelOpciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Juego juego;
	private Vehiculo vehiculo;
	private Jugador jugador;
	
	public PanelOpciones(Juego unjuego,Vehiculo unvehiculo, Jugador unjugador) {
		setLayout(null);

		juego = unjuego;
		vehiculo = unvehiculo;
		jugador = unjugador;
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonGuardar.setBounds(50, 5, 100, 20);
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guarda el juego
				XStream xstream = new XStream();
				PrintWriter pw = null;
				PrintWriter pw2 = null;
				try {
					pw = new PrintWriter("Datos/juegosguardados/juego"+jugador.getNombre()+".xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				xstream.toXML(juego,pw);
				pw.close();
				
				try {
					pw2 = new PrintWriter("Datos/juegosguardados/vehiculo"+jugador.getNombre()+".xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				xstream.toXML(vehiculo,pw2);
				pw2.close();
				
			}
		});
		add(botonGuardar);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setBorder(BorderFactory.createLineBorder(Color.black));
		botonSalir.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonSalir.setBounds(50, 35, 100, 20);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sale del programa
				System.exit(0);
			}
		});
		add(botonSalir);
	}

}
