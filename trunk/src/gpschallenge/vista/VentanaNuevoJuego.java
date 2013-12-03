package gpschallenge.vista;

import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaNuevoJuego extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelMapa panelMapa;
	private PanelInformacion panelInformacion;
	private PanelOpciones panelOpciones;
	// Control
	private Vehiculo vehiculo;
	private Jugador jugador;
	private Juego juego;

	/**
	 * 
	 *  
	 */
	public VentanaNuevoJuego() throws EsquinasInvalidasException {

		// Jugador, Vehiculo, Juego
		jugador = new Jugador("Pepe");
		vehiculo = Vehiculo.getInstancia();
		vehiculo.setEstado(Auto.getInstancia());
		juego = new Juego(jugador);
		juego.iniciarEnModo(Dificultad.FACIL);
		panelMapa = new PanelMapa(juego.getMapa());
		juego.getMapa().setVehiculoEnEsquina(1, 1);

		// Inicia Juego

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 850);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		setFocusable(true);

		// Creo vista Mapa y agrego a la vista

		// Agrego a la vista principal
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);

		panelInformacion = new PanelInformacion();
		panelInformacion.setBounds(830, 0, 250, 600);
		contentPane.add(panelInformacion);
		panelInformacion.setLayout(null);

		panelOpciones = new PanelOpciones(juego,vehiculo,jugador);
		panelOpciones.setBounds(830, 600, 250, 200);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		if (!juego.juegoFinalizado()) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (panelMapa.puedeMoverse(Sentido.ARRIBA)) {
					vehiculo.mover(Sentido.ARRIBA);
				}
				break;
			case KeyEvent.VK_DOWN:
				if (panelMapa.puedeMoverse(Sentido.ABAJO)) {
					vehiculo.mover(Sentido.ABAJO);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (panelMapa.puedeMoverse(Sentido.DERECHA)) {
					vehiculo.mover(Sentido.DERECHA);
				}
				break;
			case KeyEvent.VK_LEFT:
				if (panelMapa.puedeMoverse(Sentido.IZQUIERDA)) {
					vehiculo.mover(Sentido.IZQUIERDA);
				}
				break;
			}
		}
		Posicion pos = vehiculo.getPosicionActual();
		if (pos.esIgual(this.juego.getMapa().getMeta().getPosicion())) {
			juego.finalizarJuego();
			// Que pasa cunado termina??
		} else {
			vehiculo.setEsquina(juego.getMapa().getEsquina(pos));
			panelInformacion.actualizarMovimientos(vehiculo
					.getCantMovimientos());
			panelInformacion.actualizarEstado(vehiculo.getTipoVehiculo()
					.toString());
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}
