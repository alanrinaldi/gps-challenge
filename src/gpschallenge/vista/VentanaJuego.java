package gpschallenge.vista;

import gpschallenge.componentes.utililidades.ListaJugadores;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class VentanaJuego extends JFrame implements KeyListener {

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

	public VentanaJuego(Juego juego) throws EsquinasInvalidasException {

		this.juego = juego;
		this.vehiculo = juego.getVehiculo();
		this.jugador = juego.getJugador();

		panelMapa = new PanelMapa(juego.getMapa());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 850);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		setFocusable(true);

		// Agrego a la vista principal
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);

		panelInformacion = new PanelInformacion();
		panelInformacion.setBounds(830, 0, 250, 600);
		contentPane.add(panelInformacion);
		panelInformacion.setLayout(null);
		panelInformacion.actualizarInfo(juego.getInformacion());

		panelOpciones = new PanelOpciones(juego, vehiculo, jugador);
		panelOpciones.setBounds(830, 600, 250, 200);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
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
		Posicion pos = vehiculo.getPosicionActual();
		panelInformacion.actualizarInfo(juego.getInformacion());
		vehiculo.setEsquina(juego.getMapa().getEsquina(pos));
		if (juego.hayGanador()) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			VentanaJuegoTerminado ganador = new VentanaJuegoTerminado("Ganaste!!", juego.getInformacion().getPuntaje());
			this.guardarPuntajes(juego.getJugador());
			ganador.setVisible(true);
			dispose();
		} else {
			if (juego.juegoFinalizado()) {
				VentanaJuegoTerminado ganador = new VentanaJuegoTerminado("Perdiste!!",  juego.getInformacion().getPuntaje());
				ganador.setVisible(true);
				dispose();
			} 
		}
	}

	private void guardarPuntajes(Jugador jugador) {
		XStream xstream = new XStream(new DomDriver());
		PrintWriter pwJugadores = null;
		ListaJugadores lista = (ListaJugadores) xstream.fromXML(new File("Datos/juegosguardados/ListaJugadores.xml"));
		lista.AgregarJugador(jugador);
		try {
				pwJugadores = new PrintWriter("Datos/juegosguardados/ListaJugadores.xml");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		xstream.toXML(lista,pwJugadores);
		pwJugadores.close();
		
	}

	public void keyTyped(KeyEvent e) {

	}

}
