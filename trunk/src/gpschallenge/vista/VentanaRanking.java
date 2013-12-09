package gpschallenge.vista;

import gpschallenge.componentes.utililidades.XML;
import gpschallenge.componentes.utililidades.ListaJugadores;
import gpschallenge.motor.Jugador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaRanking extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = -4210348182614871641L;
private ListaJugadores Lista;
private static int CANT_RESULTADOS = 10;

public VentanaRanking(){
	setLayout(null);
	JLabel lblTop = new JLabel("TOP 10 PUNTUACIONES");
	lblTop.setFont(new Font("Serif", Font.PLAIN, 16));
	lblTop.setBounds(130, 10, 200, 60);
	this.add(lblTop);
	
	
	Lista = (ListaJugadores) XML.obtenerObjeto("Datos/juegosguardados/ListaJugadores.xml");
	ArrayList<Jugador> jugadores = Lista.ObtenerListaJugadores();
	Collections.sort(jugadores);
	Iterator<Jugador> it = jugadores.iterator();
	int i = 1;
	// Lista los 10 mejores puntuaciones
	while(i <= CANT_RESULTADOS && it.hasNext()){
		Jugador jugador = it.next();
		JLabel lblNombre = new JLabel(i + " .- " + jugador.getNombre());
		lblNombre.setBounds(120, i*40, 100, 55);
		
		JLabel lblPuntos = new JLabel(jugador.getPuntaje().toString());
		lblPuntos.setBounds(280, i*40, 55, 55);
		
		i++;
		this.add(lblNombre);
		this.add(lblPuntos);
	}

	JButton btnVolver = new JButton("Volver");
	btnVolver.setBorder(BorderFactory.createLineBorder(Color.black));
	btnVolver.setContentAreaFilled(false);
	// Posicion donde se colocar este boton
	btnVolver.setBounds(130, 480, 150, 30);
	btnVolver.setFont(new Font("Serif", Font.PLAIN, 20));
	btnVolver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Main unaVentana = new Main();
			unaVentana.setVisible(true);
			dispose();
		}
	});
	this.add(btnVolver);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 450, 600);
	setFocusable(true);
}
		
}
