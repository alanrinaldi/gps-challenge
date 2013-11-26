package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.vehiculos.Vehiculo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehiculo vehiculo;

	public Panel(int dimensionFila, int dimensionColumna){
		setLayout(new GridLayout(0, 1));
		vehiculo = new Vehiculo();
		add(vehiculo);
		
		this.dibujarMapa(dimensionFila, dimensionColumna);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		super.setBackground(Color.white);
		vehiculo.setBounds(vehiculo.getPosicionActual().getX(), vehiculo.getPosicionActual().getY(), 32, 38);
		
	}

	public void moverArriba() {
		vehiculo.getPosicionActual().restarPosicion(0, 1);
		repaint();
	}
	public void moverAbajo() {
		vehiculo.getPosicionActual().sumarPosicion(0, 80);
		repaint();
	}

	public void moverDerecha() {
		vehiculo.getPosicionActual().sumarPosicion(75, 0);
		repaint();
	}

	public void moverIzquierda() {
		vehiculo.getPosicionActual().restarPosicion(75, 0);
		repaint();
	}

	public void dibujarMapa(int tamanoFila, int tamanoColumna) {
		int tamanioManzana = 40;
		int anchoVehiculo = 35;
		int altoVehiculo = 40;

		for (int fila = 0; fila < tamanoFila; fila++) {
			for (int columna = 0; columna < tamanoColumna; columna++) {
				JButton botonManzana = new JButton("");
				botonManzana.setBackground(Color.blue);
				botonManzana.setRolloverEnabled(false);
				botonManzana.setEnabled(false);
				botonManzana.setBounds((tamanioManzana*fila) + (anchoVehiculo*(fila+1)),
						(tamanioManzana*columna) + (altoVehiculo*(columna+1)), tamanioManzana,
						tamanioManzana);
				add(botonManzana);
			}
		}
		
		JButton botonObstaculo = new Pozo();
		botonObstaculo.setRolloverEnabled(false);
		botonObstaculo.setBounds(35,80,20,40);
		add(botonObstaculo);
		
		JButton botonSorpresa = new JButton("");
		botonSorpresa.setBackground(Color.orange);
		botonSorpresa.setRolloverEnabled(false);
		botonSorpresa.setBounds(55,160,20,40);
		add(botonSorpresa);
		
		JButton botonObstaculo2 = new JButton("");
		botonObstaculo2.setBackground(Color.green);
		botonObstaculo2.setRolloverEnabled(false);
		botonObstaculo2.setBounds(35,240,20,40);
		add(botonObstaculo2);
		
		JButton botonSorpresa2 = new JButton("");
		botonSorpresa2.setBackground(Color.orange);
		botonSorpresa2.setRolloverEnabled(false);
		botonSorpresa2.setBounds(55,240,20,40);
		add(botonSorpresa2);
		
		
	}
	
	
	
	public int getPosX(){
		
		return vehiculo.getPosicionActual().getY();
	}

	public int getPosY(){
		
		return vehiculo.getPosicionActual().getX();
	}
}
