package gpschallenge.vista;

import javax.swing.*;

import java.awt.*;

public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel vehiculo;
	private int posX = 0;
	private int posY = 0;

	public Panel(int dimensionFila, int dimensionColumna){
		setLayout(new GridLayout(0, 1));

		vehiculo = new JLabel("");
		vehiculo.setIcon(new ImageIcon(getClass().getResource("/gpschallenge/imagenes/auto.png")));
		vehiculo.setBackground(Color.white);
		add(vehiculo);
		
		this.dibujarMapa(dimensionFila, dimensionColumna);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		super.setBackground(Color.white);
		vehiculo.setBounds(posX, posY, 32, 38);
		
	}

	public void moverArriba() {
		posY -= 80;
		repaint();
	}

	public void moverAbajo() {
		posY += 80;
		repaint();
	}

	public void moverDerecha() {
		posX += 75;
		repaint();
	}

	public void moverIzquierda() {
		posX -= 75;
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
				botonManzana.setBounds((tamanioManzana*fila) + (anchoVehiculo*(fila+1)),
						(tamanioManzana*columna) + (altoVehiculo*(columna+1)), tamanioManzana,
						tamanioManzana);
				add(botonManzana);
			}
		}
		
		JButton botonObstaculo = new JButton("");
		botonObstaculo.setBackground(Color.green);
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
		
		return posX;
	}

	public int getPosY(){
		
		return posY;
	}
}
