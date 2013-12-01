package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
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

		mapa = new Mapa(8, 8);
		System.out.println(mapa.getAltoEsquinas());
		vehiculo = new Vehiculo(Moto.getInstancia());

		// Agrego Vehiculo
		mapa.setVehiculoEnEsquina(vehiculo, 4, 4);

		// Afectable
		mapa.addAfectable(new Pozo(), 1, 1, Sentido.DERECHA);
		mapa.addAfectable(new ControlPolicial(), 2, 2, Sentido.IZQUIERDA);
		mapa.addAfectable(new Piquete(), 3, 3, Sentido.DERECHA);
		mapa.addAfectable(new CambioDeVehiculo(), 3, 3, Sentido.DERECHA);
		mapa.addAfectable(new SorpresaFavorable(), 2, 2, Sentido.IZQUIERDA);
		mapa.addAfectable(new SorpresaDesfavorable(), 4, 2, Sentido.ARRIBA);
		mapa.addAfectable(new CambioDeVehiculo(), 3, 1, Sentido.DERECHA);
		mapa.addAfectable(new CambioDeVehiculo(), 3, 1, Sentido.DERECHA);

		// Creo vista Mapa y agrego a la vista
		vistaMapa = new VistaMapa(mapa);

		// Agrego a la vista principal
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
	}

	public void keyTyped(KeyEvent e) {

	}

}
