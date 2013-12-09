package gpschallenge.vista;

import gpschallenge.componentes.utililidades.ListaJugadores;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PanelOpciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListaJugadores Lista;
	
	public PanelOpciones(final Juego juego,final Vehiculo vehiculo,final Jugador jugador) {
		
		setLayout(null);
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonGuardar.setBounds(50, 5, 100, 20);
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guarda el juego
				XStream xstream = new XStream();
				XStream xstream2 = new XStream(new DomDriver());
				PrintWriter pw = null;
				PrintWriter pw4 = null;
				
				try {
					pw = new PrintWriter("Datos/juegosguardados/juego"+jugador.getNombre()+".xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				xstream.toXML(juego,pw);
				pw.close();

				
				Lista = (ListaJugadores) xstream2
						.fromXML(new File(
								"Datos/juegosguardados/ListaJugadores.xml"));
				
				Lista.AgregarJugador(jugador.getNombre());
				
					try {
						pw4 = new PrintWriter("Datos/juegosguardados/ListaJugadores.xml");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				xstream.toXML(Lista,pw4);
				pw4.close();
				
				
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
