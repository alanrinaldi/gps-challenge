package gpschallenge.vista;

import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaConfiguraciones extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private PanelJugador paneljugador;

	private Jugador jugador;
	private Dificultad dificultad;
	private EstadoVehiculo estado;

	public VentanaConfiguraciones() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.lightGray);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		setFocusable(true);

		paneljugador = new PanelJugador();
		paneljugador.setBackground(Color.LIGHT_GRAY);
		paneljugador.setBounds(150, 10, 200, 230);
		contentPane.add(paneljugador);
		paneljugador.setLayout(null);

		JButton botonJugar = new JButton("INICIAR JUEGO");
		botonJugar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonJugar.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonJugar.setBounds(150, 250, 150, 55);
		botonJugar.addActionListener(new ActionListener() {
			private Vehiculo vehiculo;

			public void actionPerformed(ActionEvent arg0) {
				// Inicia un juego nuevo
				VentanaJuego unaVentana = null;
				// Se crea el juego y se pasa a la vista VentanaJuego
				jugador = new Jugador(paneljugador.getNombreJugador());
				dificultad = paneljugador.getDificultad();
				estado = paneljugador.getEstado();
				vehiculo = new Vehiculo();
				vehiculo.setEstado(estado);

				Juego juego = new Juego(jugador, vehiculo,dificultad);
				unaVentana = new VentanaJuego(juego);
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
