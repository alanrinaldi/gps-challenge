package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.mapa.Esquina;
import gpschallenge.motor.Mapa;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class VistaMapa extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int CANT_AFECTABLES_POR_CALLE = 2;
	private Mapa mapa = null;
	private VistaVehiculo vistaVehiculo = null;
	// Tamaño de los Objetos: Manzana, vehiculos, Obstaculos y Sorpresas.
	private static int ALTO_PANEL = 800;
	private static int ANCHO_PANEL = 800;
	private int altoObjeto = 0;
	private int anchoObjeto = 0;
	private int separacionEntreEsquinas;
	private int distancia_esquina_afectable;

	/*
	 * CONTRUCTOR
	 */
	public VistaMapa(Mapa mapa) {
		this.mapa = mapa;
		
		//Tamaño de manzadas, distancia entre mandazanas, afectables, etc
		this.altoObjeto = (ANCHO_PANEL) / ((mapa.getAltoEsquinas() * 2) + 1);
		this.anchoObjeto = (ALTO_PANEL) / ((mapa.getAnchoEsquinas() * 2) + 1);
		this.separacionEntreEsquinas = altoObjeto * 2;
		this.distancia_esquina_afectable = separacionEntreEsquinas/2;
		// Se setea a mapa la primer posicion de la esquina. Tambien se setea la separacion entre esquinas en el mapa
		this.mapa.setPosicionPrimerEsquina(anchoObjeto+anchoObjeto/mapa.getAnchoEsquinas(), altoObjeto, separacionEntreEsquinas);
		// Valor de cada movimiento del vehiculo
		this.mapa.getVehiculo().setValorPorMovimiento(separacionEntreEsquinas);
		//Configuracion visual del Panel		
		this.setLayout(new GridLayout(1, 1));
		this.setBounds(5, 5, ANCHO_PANEL, ALTO_PANEL);
		this.setBackground(Color.BLACK);
		this.vistaVehiculo = new VistaVehiculo();
		this.add(vistaVehiculo);
		this.dibujarManzanas();
		this.dibujarAfectablesVertical();
		this.dibujarAfectablesHorizontal();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.white);
		this.dibujarVehiculo();
	}

	// Dibuja el Vehiculo en el mapa
	private void dibujarVehiculo() {
		Posicion pos = mapa.getVehiculo().getPosicionActual();
		vistaVehiculo.setBounds(pos.getX(), pos.getY(), anchoObjeto, altoObjeto);
		this.setBackground(Color.WHITE);

	}
	/*
	 * 
	 * Dibuja los afectables de una calle de acuerdo a la orientacion de la calle.
	 */
	private void dibujarAfectables(ArrayList<Afectable> lista, Esquina esquina, Sentido sentido){
		Afectable afectable;
		Posicion pos;
		int cuandoHayDosAfectables = 0;
		// Recorro los afectable actual
		Iterator<Afectable> it = lista.iterator();
		while (it.hasNext()) {
			afectable = it.next();
			// Creo la vista para el afectable actual
			VistaAfectable unaVista= new VistaAfectable(afectable);
			pos = esquina.getPosicion();
			switch (sentido) {
			/*
			 * La Distancia desde una esquina hasta el primer Afectable en cualquier sentido es:
			 * Distancia = distancia_esquina_afectable +- SiHayDosAfectablesValor
			 */
			case DERECHA:
				unaVista.setBounds(pos.getX() + distancia_esquina_afectable + cuandoHayDosAfectables, pos.getY(), anchoObjeto/2, altoObjeto);
				break;
			case IZQUIERDA:
				unaVista.setBounds(pos.getX() - distancia_esquina_afectable/2 - cuandoHayDosAfectables, pos.getY(), anchoObjeto/2, altoObjeto);
				break;
			case ABAJO:
				unaVista.setBounds(pos.getX() + anchoObjeto/4, pos.getY() + distancia_esquina_afectable + cuandoHayDosAfectables, anchoObjeto, altoObjeto/2);
				break;
			case ARRIBA:
				unaVista.setBounds(pos.getX() + anchoObjeto/4, pos.getY() - distancia_esquina_afectable - cuandoHayDosAfectables, anchoObjeto, altoObjeto/2);
				break;
		}
			// Si hay mas de un afectable por calle(2) la posicion siguiente se mueve el valor indicado en -cuandoHayDosAfectables-
			if(lista.size() == CANT_AFECTABLES_POR_CALLE){
				cuandoHayDosAfectables = anchoObjeto/2;
			}
			// Agrego a la vista del Mapa(VistaMapa)
			this.add(unaVista);
		}
		
	}
	
	/*
	 * Dibuja los afectables de las las esquinas en sentido ARRIBA Y ABAJO
	 */
	public void dibujarAfectablesVertical(){
		ArrayList<Afectable> afectables = null;
		Esquina esquina = null;
		for (int i = 1; i <= mapa.getAnchoEsquinas(); i++) {
			// Dibujo todos los afectables con sentido ARRIBA.
			for (int j = 1; j <= mapa.getAltoEsquinas(); j++) {
				esquina = mapa.getEsquina(i, j);
				afectables = esquina.getCalleEnSentido(Sentido.ARRIBA).getAfectables();
				this.dibujarAfectables(afectables, esquina, Sentido.ARRIBA);
			}
			// Dibuja el ultimo afectable con sentido ABAJO
			afectables = esquina.getCalleEnSentido(Sentido.ABAJO).getAfectables();
			this.dibujarAfectables(afectables, esquina, Sentido.ABAJO);
		}
	}

	/*
	 * Dibuja los afectables de las las esquinas en sentido IZQUIERDA Y DERECHA
	 */
	public void dibujarAfectablesHorizontal(){
		ArrayList<Afectable> afectables = null;
		Esquina esquina = null;
		for (int i = 1; i <= mapa.getAltoEsquinas(); i++) {
			for (int j = 1; j <= mapa.getAnchoEsquinas(); j++) {
				esquina = mapa.getEsquina(i, j);
				afectables = esquina.getCalleEnSentido(Sentido.IZQUIERDA).getAfectables();
				this.dibujarAfectables(afectables, esquina, Sentido.IZQUIERDA);
			}
			afectables = esquina.getCalleEnSentido(Sentido.DERECHA).getAfectables();
			this.dibujarAfectables(afectables, esquina, Sentido.DERECHA);
		}
	}
	
	// Dibuja las manzanas del Mapa.
	public void dibujarManzanas() {
		for (int i = 0; i < mapa.getAnchoEsquinas()+1; i++) {
			for (int j = 0; j < mapa.getAltoEsquinas()+1; j++) {
				Canvas botonManzana = new Canvas();
				botonManzana.setBackground(Color.blue);
				botonManzana.setEnabled(false);
				botonManzana.setBounds(i*altoObjeto*2,j*altoObjeto*2, altoObjeto, altoObjeto);
				add(botonManzana);

			}
		}

	}
	// Devuelve verdadero si el vehiculo puede moverse en el sentido indicado por el argumento. 
	// Falso si excede los límites del mapa.
	public Boolean puedeMoverse(Sentido sentido){
		Posicion posVehiculo = mapa.getVehiculo().getPosicionActual();
		switch (sentido) {
		case ARRIBA:
			if((posVehiculo.getY() - separacionEntreEsquinas) > 0)
				return true;
			break;
		case ABAJO:
			if((posVehiculo.getY() + separacionEntreEsquinas + altoObjeto) < ALTO_PANEL)
				return true;
			break;
		case IZQUIERDA:
			if((posVehiculo.getX() - separacionEntreEsquinas) > 0)
				return true;
			break;
		case DERECHA:
			if((posVehiculo.getX() + separacionEntreEsquinas + anchoObjeto) < ANCHO_PANEL)
				return true;
			break;
		}
		return false;
	}

}
