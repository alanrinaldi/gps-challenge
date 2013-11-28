package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.excepciones.EsquinasInvalidasException;
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
	// Distancia que se mueve el vehiculo en cada interaccion.
	private static int CADA_MOVIMIENTO = 80;
	// Distancia de una esquina al primer afectable.
	private static int ESQUINA_AFECTABLE = 40;
	private EsquinaT[][] esquinas;
	private int altoEsquinas;
	private int anchoEsquinas;

	public Panel(int dimensionFila, int dimensionColumna) {
		altoEsquinas = dimensionFila - 1;
		anchoEsquinas = dimensionColumna - 1;
		esquinas = new EsquinaT[dimensionFila][dimensionColumna];
		setLayout(new GridLayout(0, 1));

		this.crearEsquinas();
		this.dibujarMapa(dimensionFila, dimensionColumna);
		/* Pruebo con estado CuatroXCuatro */
		vehiculo = new Vehiculo();
		vehiculo.setEstado(Auto.getInstancia());
		/* Esquina inicial de vehiculo */
		vehiculo.setEsquinaActual(esquinas[0][0]);
		add(vehiculo);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		super.setBackground(Color.white);
		vehiculo.setBounds(vehiculo.getPosicionActual().getX(), vehiculo
				.getPosicionActual().getY(), 32, 38);
		/* Imprimo para ver si actuan los obstaculos */
		System.out.println(vehiculo.getCantMovimientos());
		System.out.println(vehiculo.getEstado().getClass().getName());

	}

	/* Mueve el vehiculo a la esquina superior */
	public void moverArriba() {
		this.aplicarAfectables(vehiculo.getEsquinaActual().getCalleArriba());
		vehiculo.getPosicionActual().restarPosicion(0, CADA_MOVIMIENTO);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();
	}

	/* Mueve el vehiculo a la esquina inferior */
	public void moverAbajo() {
		this.aplicarAfectables(vehiculo.getEsquinaActual().getCalleAbajo());
		vehiculo.getPosicionActual().sumarPosicion(0, CADA_MOVIMIENTO);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();
	}

	/* Mueve el vehiculo a la esquina derecha */
	public void moverDerecha() {
		this.aplicarAfectables(vehiculo.getEsquinaActual().getCalleDerecha());
		vehiculo.getPosicionActual().sumarPosicion(CADA_MOVIMIENTO, 0);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();
	}

	/* Mueve el vehiculo a la esquina Izquierda */
	public void moverIzquierda() {
		this.aplicarAfectables(vehiculo.getEsquinaActual().getCalleIzquierda());
		vehiculo.getPosicionActual().restarPosicion(CADA_MOVIMIENTO, 0);
		vehiculo.setEsquinaActual(this.getEsquina(vehiculo.getPosicionActual()));
		repaint();

	}

	/* Aplica los obstaculos y sopresas de la calle actual al vehiculo */
	private void aplicarAfectables(CalleT unaCalle) {
		Iterator<Afectable> it = unaCalle.getAfectables().iterator();
		// Recorre los efectos de la calle.
		while (it.hasNext()) {
			vehiculo.afectar(it.next());
		}
		vehiculo.sumarMovimientos(1);
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
				botonManzana.setBounds((tamanioManzana * fila)
						+ (anchoVehiculo * (fila + 1)),
						(tamanioManzana * columna)
								+ (altoVehiculo * (columna + 1)),
						tamanioManzana, tamanioManzana);
				add(botonManzana);

			}
		}

	}

	/*
	 * Agrega un afectable en una calle en el sentido indicado(ARRIBA, ABAJO,
	 * IZQUIERDA, DERECHA). X e Y representa la posicion en la matriz de
	 * esquinas.
	 */
	public void addAfectable(int posEsquinaX, int posEsquinaY, Sentido sentido,	ObjetoAfectador afectable) throws EsquinasInvalidasException {
		EsquinaT esquina = esquinas[posEsquinaX][posEsquinaY];
		CalleT calle = esquina.getCalleEnSentido(sentido);
		/* Esta pos pordemos hacer que lo maneje Pozo con una metodo */
		switch (sentido) {
		case IZQUIERDA:
			afectable.setBounds(esquina.getPosicion().getX() - ESQUINA_AFECTABLE, esquina
					.getPosicion().getY(), 20, 40);
			break;
		case ARRIBA:
			afectable.setBounds(esquina.getPosicion().getX(), esquina
					.getPosicion().getY() - ESQUINA_AFECTABLE, 40, 20);
			break;
		case DERECHA:
			afectable.setBounds(esquina.getPosicion().getX() + ESQUINA_AFECTABLE, esquina
					.getPosicion().getY(), 20, 40);
			break;
		case ABAJO:
			afectable.setBounds(esquina.getPosicion().getX(), esquina
					.getPosicion().getY() + ESQUINA_AFECTABLE, 40, 20);
			break;

		default:
			break;
		}
		afectable.setRolloverEnabled(false);
		calle.addAfectable(afectable);
		add(afectable);
		repaint();
	}

	/*
	 * Crea las esquinas con sus respectivas posiciones. La primer posicion de
	 * la esquina es x = 160, y = 160.
	 */
	private void crearEsquinas() {
		for (int i = 0; i < anchoEsquinas; i++) {
			for (int j = 0; j < altoEsquinas; j++) {
				EsquinaT esquina = new EsquinaT(new Posicion(80 * (i + 1),
						80 * (j + 1)));
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

	/* Devuelve la esquina en la posicion indicada del argumento */
	private EsquinaT getEsquina(Posicion posicion) {
		EsquinaT esquina = null;
		int i = 0;
		int j = 0;
		boolean encontrado = false;
		while (i < altoEsquinas && !encontrado) {
			j = 0;
			while (j < anchoEsquinas && !encontrado) {
				esquina = esquinas[i][j];
				Posicion pos = esquina.getPosicion();
				if (pos.esIgual(posicion)) {
					encontrado = true;
				}
				j++;
			}
			i++;
		}
		return esquina;
	}

	/* Enlaza las calles horizontales de esquinas contiguas. */
	private void enlazarCallesHorizontal() {
		EsquinaT anteriorH;
		EsquinaT siguienteH;
		for (int i = 0; i < altoEsquinas - 1; i++) {
			for (int j = 0; j < anchoEsquinas; j++) {
				anteriorH = esquinas[i][j];
				siguienteH = esquinas[i + 1][j];
				anteriorH.setCalleDerecha(siguienteH.getCalleIzquierda());
				siguienteH.setCalleIzquierda(anteriorH.getCalleDerecha());
			}
		}
	}

	/* Enlaza las calles horizontales de esquinas contiguas. */
	private void enlazarCallesVertical() {
		EsquinaT anteriorC;
		EsquinaT siguienteC;
		for (int i = 0; i < anchoEsquinas; i++) {
			for (int j = 0; j < altoEsquinas - 1; j++) {
				anteriorC = esquinas[i][j];
				siguienteC = esquinas[i][j + 1];
				anteriorC.setCalleAbajo(siguienteC.getCalleArriba());
				siguienteC.setCalleArriba(anteriorC.getCalleAbajo());
			}
		}
	}

	public int getPosX() {

		return vehiculo.getPosicionActual().getX();
	}

	public int getPosY() {

		return vehiculo.getPosicionActual().getY();
	}
}
