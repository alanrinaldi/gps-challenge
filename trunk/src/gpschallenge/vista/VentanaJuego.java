package gpschallenge.vista;

import gpschallenge.componentes.utililidades.ListaJugadores;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.utililidades.XML;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaJuego extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelMapa panelMapa;
	private PanelInformacion panelInformacion;
	private PanelOpciones panelOpciones;
	private CapaTransparente capaTrasparente;
	// Control
	private Vehiculo vehiculo;
	private Jugador jugador;
	private Juego juego;
	

	public VentanaJuego(Juego juego) {	
		this.juego = juego;
		this.vehiculo = juego.getVehiculo();
		this.jugador = juego.getJugador();

		
		panelMapa = new PanelMapa(juego.getMapa());
		
		this.capaTrasparente = new CapaTransparente(juego.getMapa().getMeta().getPosicion());
		this.capaTrasparente.actualizarPosicion(vehiculo.getPosicionActual());
		
        panelMapa.setLayout(new BorderLayout());
        panelMapa.add(capaTrasparente, 0);
	

		// Agrego a la vista principal
	//panelMapa.setLayout(null);
		add(panelMapa);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1050, 850);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
		
		panelInformacion = new PanelInformacion();
		panelInformacion.setBounds(830, 0, 250, 600);
		add(panelInformacion);
		panelInformacion.setLayout(null);
		panelInformacion.actualizarInfo(juego.getInformacion());

		panelOpciones = new PanelOpciones(juego);
		panelOpciones.setBounds(830, 600, 250, 100);
		add(panelOpciones);
		panelOpciones.setLayout(null);
		
		

		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorder(BorderFactory.createLineBorder(Color.black));
		btnVolver.setBounds(50,45, 100, 20);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guarda el juego
				Main inicio = new Main();
				inicio.setVisible(true);
				dispose();
		}});
		panelOpciones.add(btnVolver);

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
		this.capaTrasparente.actualizarPosicion(vehiculo.getPosicionActual());
		this.capaTrasparente.repaint();
		vehiculo.setEsquina(juego.getMapa().getEsquina(pos));
		if (juego.hayGanador()) {
			VentanaJuegoTerminado ganador = new VentanaJuegoTerminado("Ganaste!!", juego.getInformacion().getPuntaje());
			this.guardarPuntajes(this.jugador);
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
		ListaJugadores lista = (ListaJugadores) XML.obtenerObjeto("Datos/juegosguardados/ListaJugadores.xml");
		lista.AgregarJugador(jugador);
		XML.guardarObjeto(lista, "Datos/juegosguardados/ListaJugadores.xml");
		
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
