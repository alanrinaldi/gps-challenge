package gpschallenge.vista;

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

	public PanelOpciones() {
		setLayout(null);

		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonGuardar.setBounds(50, 5, 100, 20);
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guarda el juego
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
