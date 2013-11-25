package gpschallenge.vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gpschallenge.excepciones.EsquinasInvalidasException;

public class Ventana extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Panel panelMapa;
	final int ancho_movimiento = 75;
	final int alto_movimiento = 80;

	/**
	 * 
	 *  
	 */
	public Ventana() throws EsquinasInvalidasException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addKeyListener(this);
		setFocusable(true);
		
		int alto = 8;
		int ancho = 8;
		
		panelMapa = new Panel(alto, ancho);
		panelMapa.setBounds(5, 5, 660, 730);
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
				if (panelMapa.getPosY()<(7*alto_movimiento)){
					panelMapa.moverAbajo();
				}
					break;
			case KeyEvent.VK_RIGHT:
				if (panelMapa.getPosX()<(7*ancho_movimiento)){
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

