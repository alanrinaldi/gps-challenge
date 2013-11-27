package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.mapa.CalleT;
import gpschallenge.mapa.EsquinaT;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehiculo vehiculo;
	private EsquinaT[][] esquinas;
	private int altoEsquinas;
	private int anchoEsquinas;

	public Panel(int dimensionFila, int dimensionColumna){
		altoEsquinas = dimensionFila - 1;
		anchoEsquinas = dimensionColumna - 1;
		esquinas = new EsquinaT[dimensionFila][dimensionColumna];
		setLayout(new GridLayout(0, 1));

		this.crearEsquinas();
		this.dibujarMapa(dimensionFila, dimensionColumna);
		/* Pruebo con estado CuatroXCuatro*/
		vehiculo = new Vehiculo();
		vehiculo.setEstado(Auto.getInstancia());
		/* Esquina inicial de vehiculo */
		vehiculo.setEsquinaActual(esquinas[0][0]);
		add(vehiculo);
		
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		super.setBackground(Color.white);
		vehiculo.setBounds(vehiculo.getPosicionActual().getX(), vehiculo.getPosicionActual().getY(), 32, 38);
		/*  Imprimo para ver si actuan los obstaculos */
		System.out.println(vehiculo.getCantMovimientos());
		
	}

	/* Codigo repetido, despues refactorizo */
	public void moverArriba() {
		CalleT unaCalle = vehiculo.getEsquinaActual().getCalleArriba();
		Iterator<Afectable> it = unaCalle.getAfectables().iterator();
		while(it.hasNext()){
			vehiculo.afectar(it.next());
		}
		vehiculo.sumarMovimientos(1);
		vehiculo.getPosicionActual().restarPosicion(0, 80);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();
	}
	public void moverAbajo() {
		CalleT unaCalle = vehiculo.getEsquinaActual().getCalleAbajo();
		Iterator<Afectable> it = unaCalle.getAfectables().iterator();
		while(it.hasNext()){
			vehiculo.afectar(it.next());
		}
		vehiculo.sumarMovimientos(1);
		vehiculo.getPosicionActual().sumarPosicion(0, 80);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();
	}

	public void moverDerecha() {
		CalleT unaCalle = vehiculo.getEsquinaActual().getCalleDerecha();
		Iterator<Afectable> it = unaCalle.getAfectables().iterator();
		while(it.hasNext()){
			vehiculo.afectar(it.next());
		}
		vehiculo.sumarMovimientos(1);
		vehiculo.getPosicionActual().sumarPosicion(80, 0);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();


	}

	public void moverIzquierda() {
		CalleT unaCalle = vehiculo.getEsquinaActual().getCalleIzquierda();
		Iterator<Afectable> it = unaCalle.getAfectables().iterator();
		while(it.hasNext()){
			vehiculo.afectar(it.next());
		}
		vehiculo.sumarMovimientos(1);
		vehiculo.getPosicionActual().restarPosicion(80, 0);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();

	}

	public void dibujarMapa(int tamanoFila, int tamanoColumna) {
		int tamanioManzana = 40;
		int anchoVehiculo = 40;
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
		
		/* Dibujo un  pozo en una calle de la esquina (0,0) */
		
		CalleT calle1 = esquinas[0][0].getCalleDerecha();
		Pozo unPozo1 = new Pozo();
		unPozo1.setRolloverEnabled(false);
		/* Esta pos pordemos hacer que lo maneje Pozo con una metodo */
		unPozo1.setBounds(120,80,20,40);
		calle1.addAfectable(unPozo1);
		add(unPozo1);
		
		
		CalleT calle2 = esquinas[0][0].getCalleDerecha();
		Pozo unPozo2 = new Pozo();
		unPozo2.setRolloverEnabled(false);
		/* Esta pos pordemos hacer que lo maneje Pozo con una metodo */
		unPozo2.setBounds(140,80,20,40);
		calle2.addAfectable(unPozo2);
		add(unPozo2);
		
		
		JButton botonSorpresa = new JButton("");
		botonSorpresa.setBackground(Color.orange);
		botonSorpresa.setRolloverEnabled(false);
		botonSorpresa.setBounds(60,160,20,40);
		add(botonSorpresa);
		
		JButton botonObstaculo2 = new JButton("");
		botonObstaculo2.setBackground(Color.green);
		botonObstaculo2.setRolloverEnabled(false);
		botonObstaculo2.setBounds(40,240,20,40);
		add(botonObstaculo2);
		
		JButton botonSorpresa2 = new JButton("");
		botonSorpresa2.setBackground(Color.orange);
		botonSorpresa2.setRolloverEnabled(false);
		botonSorpresa2.setBounds(60,240,20,40);
		add(botonSorpresa2);
		
		
	}
	/* 
	 * Crea las esquinas con sus respectivas posiciones.
	 *  La primer posicion de la esquina es x = 160, y = 160.
	 */
	private void crearEsquinas(){
		for (int i = 0; i < anchoEsquinas; i++) {
			for (int j = 0; j < altoEsquinas; j++) {
				EsquinaT esquina = new EsquinaT(new Posicion(80*(i+1),80*(j+1)));
				esquina.setCalleIzquierda(new CalleT());
				esquina.setCalleArriba(new CalleT());
				esquina.setCalleDerecha(new CalleT());
				esquina.setCalleAbajo(new CalleT());
				esquinas[i][j] = esquina;
			}
		}
		enlazarCallesVertical();
		enlazarCallesHorizontal();
	}
	private void enlazarCallesHorizontal(){
		EsquinaT anteriorH;
		EsquinaT siguienteH;
		for (int i = 0; i < altoEsquinas - 1; i++) {
			for (int j = 0; j < anchoEsquinas; j++) {
				anteriorH = esquinas[i][j];
				siguienteH = esquinas[i+1][j];
				anteriorH.setCalleDerecha(siguienteH.getCalleIzquierda());
				siguienteH.setCalleIzquierda(anteriorH.getCalleDerecha());
			}
		}
	}
	private void enlazarCallesVertical(){
		EsquinaT anteriorC;
		EsquinaT siguienteC;
		for (int i = 0; i < anchoEsquinas; i++) {
			for (int j = 0; j < altoEsquinas - 1; j++) {
				anteriorC = esquinas[i][j];
				siguienteC = esquinas[i][j+1];
				anteriorC.setCalleAbajo(siguienteC.getCalleArriba());
				siguienteC.setCalleArriba(anteriorC.getCalleAbajo());
			}
		}
	}
	public int getPosX(){
		
		return vehiculo.getPosicionActual().getX();
	}

	public int getPosY(){
		
		return vehiculo.getPosicionActual().getY();
	}
	private EsquinaT getEsquina(Posicion posicion){
		EsquinaT esquina = null;
		int i = 0;
		int j = 0;
		boolean encontrado = false;
		while (i < altoEsquinas && !encontrado) {
			j = 0;
			while (j < anchoEsquinas && !encontrado) {
				esquina = esquinas[i][j];
				Posicion pos = esquina.getPosicion();
				if (pos.esIgual(posicion)){
					encontrado = true;
				}
				j++;
			}
		i++;
		}
		return esquina;
	}
}
