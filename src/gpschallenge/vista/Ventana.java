package gpschallenge.vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.excepciones.EsquinasInvalidasException;

public class Ventana extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Panel panelMapa;
	final int ancho_movimiento = 80;
	final int alto_movimiento = 80;

	/**
	 * 
	 *  
	 */
	public Ventana() throws EsquinasInvalidasException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addKeyListener(this);
		setFocusable(true);
		
		int alto = 8;
		int ancho = 8;
		
		panelMapa = new Panel(alto, ancho);
		// Agrego un pozo en la esquina 5, 5 lado derecho
		panelMapa.addAfectable(5, 5, Sentido.DERECHA, new Piquete());
		// Agrego un pozo en la esquina 4, 4 lado izquierdo
		panelMapa.addAfectable(4, 4, Sentido.IZQUIERDA, new Pozo());
		// Agrego una Sopresa en la esquina 2, 3 lado derecho
		panelMapa.addAfectable(4, 1, Sentido.ARRIBA, new ControlPolicial());
		panelMapa.addAfectable(2, 3, Sentido.ABAJO, new SorpresaDesfavorable());
		panelMapa.addAfectable(3, 3, Sentido.ARRIBA, new SorpresaFavorable());
		panelMapa.addAfectable(4, 3, Sentido.ARRIBA, new CambioDeVehiculo());
		
		panelMapa.setBounds(5, 5, 700, 730);
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);
		
	}
		
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:
				if (panelMapa.getPosY()>0){
					panelMapa.moverArriba();
				}
					break;
			case KeyEvent.VK_DOWN:
				if (panelMapa.getPosY()<(8*alto_movimiento)){
					panelMapa.moverAbajo();
				}
					break;
			case KeyEvent.VK_RIGHT:
				if (panelMapa.getPosX()<(8*ancho_movimiento)){
					panelMapa.moverDerecha();
				}
					break;
			case KeyEvent.VK_LEFT:
				if (panelMapa.getPosX()>0){
					panelMapa.moverIzquierda();
				}
					break;
		}	
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

