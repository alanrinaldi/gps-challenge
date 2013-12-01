package gpschallenge.motor;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.sorpresas.VistaAfectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.vehiculos.VistaVehiculo;
import gpschallenge.mapa.Esquina;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaMapa extends JPanel {
	private static final long serialVersionUID = 1L;
	private Mapa mapa = null;
	private VistaVehiculo vistaVehiculo = null;
	// Tama�o de los Objetos: Manzana, vehiculos, Obstaculos y Sorpresas.
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

		this.altoObjeto = (ANCHO_PANEL) / ((mapa.getAltoEsquinas() * 2) + 1);
		this.anchoObjeto = (ALTO_PANEL) / ((mapa.getAnchoEsquinas() * 2) + 1);
		this.separacionEntreEsquinas = altoObjeto * 2;
		this.distancia_esquina_afectable = separacionEntreEsquinas/2;
		this.mapa.setPosicionPrimerEsquina(anchoObjeto+anchoObjeto/mapa.getAnchoEsquinas(), altoObjeto, separacionEntreEsquinas);
		this.mapa.getVehiculo().setValorPorMovimiento(separacionEntreEsquinas);
		// tama�o del panel
		// Tama�o de los objetos de acuerdo a la cantidad
		
		System.out.println("alto" + this.altoObjeto);
		System.out.println(this.anchoObjeto);

		
		this.setLayout(new GridLayout(1, 1));
		this.dibujarManzanas();
		// Dibujo Vehiculo
		this.setBounds(5, 5, ANCHO_PANEL, ALTO_PANEL);
		this.setBackground(Color.BLACK);
		this.vistaVehiculo = new VistaVehiculo(this.mapa.getVehiculo());
		this.add(vistaVehiculo);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.white);
		this.dibujarVehiculo();
		this.dibujarAfectables();
	}

	private void dibujarVehiculo() {
		vistaVehiculo.setBounds(this.mapa.getVehiculo().getPosicionActual().getX(),
								this.mapa.getVehiculo().getPosicionActual().getY(),
													anchoObjeto, altoObjeto);
		this.setBackground(Color.WHITE);

	}

	private void dibujarAfectables(){
		ArrayList<Afectable> afectables;
		for (int i = 1; i < mapa.getAnchoEsquinas(); i++) {
			for (int j = 1; j < mapa.getAltoEsquinas(); j++) {
				Esquina esquina = mapa.getEsquina(i, j);
				afectables = esquina.getCalleEnSentido(Sentido.DERECHA).getAfectables();
				this.dibujar(afectables, esquina, Sentido.DERECHA);
				afectables = esquina.getCalleEnSentido(Sentido.IZQUIERDA).getAfectables();
				this.dibujar(afectables, esquina, Sentido.IZQUIERDA);
				afectables = esquina.getCalleEnSentido(Sentido.ARRIBA).getAfectables();
				this.dibujar(afectables, esquina, Sentido.ARRIBA);
				afectables = esquina.getCalleEnSentido(Sentido.ABAJO).getAfectables();
				this.dibujar(afectables, esquina, Sentido.ABAJO);

			}
		}
	}
	private void dibujar(ArrayList<Afectable> lista, Esquina esquina, Sentido sentido){
		Iterator<Afectable> it = lista.iterator();
		Afectable afectable;
		Posicion pos;
		while (it.hasNext()) {
			afectable = it.next();
			VistaAfectable unaVista= new VistaAfectable(afectable);
			pos = esquina.getPosicion();
			switch (sentido) {
			case DERECHA:
				unaVista.setBounds(pos.getX() + distancia_esquina_afectable, pos.getY(), anchoObjeto, altoObjeto);
				break;
			case IZQUIERDA:
				unaVista.setBounds(pos.getX() - distancia_esquina_afectable, pos.getY(), anchoObjeto, altoObjeto);
				break;
			case ABAJO:
				unaVista.setBounds(pos.getX(), pos.getY() + distancia_esquina_afectable, anchoObjeto, altoObjeto);
				break;
			case ARRIBA:
				unaVista.setBounds(pos.getX(), pos.getY() - distancia_esquina_afectable, anchoObjeto, altoObjeto);
				break;

			default:
				break;
			}
			this.add(unaVista);
		}
		
	}
	public void dibujarManzanas() {
		for (int i = 0; i < mapa.getAnchoEsquinas()+1; i++) {
			for (int j = 0; j < mapa.getAltoEsquinas()+1; j++) {
				JButton botonManzana = new JButton("");
				botonManzana.setBackground(Color.blue);
				botonManzana.setRolloverEnabled(false);
				botonManzana.setEnabled(false);
				botonManzana.setBounds(i*altoObjeto*2,j*altoObjeto*2, altoObjeto, altoObjeto);
				add(botonManzana);

			}
		}

	}

	public int getPosY() {
		// TODO Auto-generated method stub
		return mapa.getVehiculo().getPosicionActual().getY();
	}

	public int getPosX() {
		// TODO Auto-generated method stub
		return mapa.getVehiculo().getPosicionActual().getX();
	}
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
