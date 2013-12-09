package gpschallenge.vista;

import gpschallenge.componentes.utililidades.ListaUsuarios;
import gpschallenge.componentes.utililidades.XML;
import gpschallenge.motor.Juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListaUsuarios lista;
	private Juego juego;
	
	public PanelOpciones(final Juego juego) {
		this.juego = juego;
		setLayout(null);
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonGuardar.setBounds(50, 5, 100, 20);
		botonGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Guarda el juego
				guardarJuego();
				guardarUsuario();				
		}});
		add(botonGuardar);

	}
	private void guardarUsuario() {
		// Obtengo lista
		lista = (ListaUsuarios) XML.obtenerObjeto("Datos/juegosguardados/ListaUsuarios.xml");
		// Actualizo
		lista.agregarUsuario(juego.getJugador().getNombre());
		//Guardo
		XML.guardarObjeto(lista, "Datos/juegosguardados/ListaUsuarios.xml");
		
	}

	private void guardarJuego() {
		XML.guardarObjeto(juego, "Datos/juegosguardados/juego"+juego.getJugador().getNombre()+".xml");
	}


}
