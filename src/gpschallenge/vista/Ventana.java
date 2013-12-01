package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.motor.Mapa;
import gpschallenge.motor.VistaMapa;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VistaMapa vistaMapa;
	private Mapa mapa;
	private Vehiculo vehiculo;
	private PanelInformacion panelInformacion;
	private PanelOpciones panelOpciones;
	/**
	 * 
	 *  
	 */
	public Ventana() throws EsquinasInvalidasException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 850);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addKeyListener(this);
		setFocusable(true);

		mapa = new Mapa(12, 12);
		vehiculo = new Vehiculo(Moto.getInstancia());

		// Agrego Vehiculo
		mapa.setVehiculoEnEsquina(vehiculo, 5, 5);

		// Afectable
		mapa.addAfectable(new Pozo(), 4, 4, Sentido.DERECHA);
		mapa.addAfectable(new Pozo(), 2, 2, Sentido.DERECHA);
		mapa.addAfectable(new Pozo(), 1, 4, Sentido.DERECHA);
		mapa.addAfectable(new Pozo(), 2, 1, Sentido.DERECHA);
		mapa.addAfectable(new Pozo(), 5, 3, Sentido.DERECHA);
		mapa.addAfectable(new Pozo(), 5, 2, Sentido.DERECHA);
		
		// Creo vista Mapa y agrego la logica al modelo
		vistaMapa = new VistaMapa(mapa);

		// Agrego a la vista
		contentPane.add(vistaMapa);
		vistaMapa.setLayout(null);

		panelInformacion = new PanelInformacion();
		panelInformacion.setBounds(830, 0, 250, 600);
		contentPane.add(panelInformacion);
		panelInformacion.setLayout(null);

		panelOpciones = new PanelOpciones();
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
			if (vistaMapa.puedeMoverse(Sentido.ARRIBA)) {
				vehiculo.mover(Sentido.ARRIBA);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (vistaMapa.puedeMoverse(Sentido.ABAJO)) {
				vehiculo.mover(Sentido.ABAJO);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (vistaMapa.puedeMoverse(Sentido.DERECHA)) {
				vehiculo.mover(Sentido.DERECHA);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (vistaMapa.puedeMoverse(Sentido.IZQUIERDA)) {
				vehiculo.mover(Sentido.IZQUIERDA);
			}
			break;
		}
		vehiculo.setEsquina(mapa.getEsquina(vehiculo.getPosicionActual()));
		panelInformacion.actualizarMovimientos(vehiculo.getCantMovimientos());
		panelInformacion.actualizarEstado(vehiculo.getTipoVehiculo().toString());
		vistaMapa.repaint();
	}

	public void keyTyped(KeyEvent e) {

	}

}
