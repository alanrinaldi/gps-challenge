package gpschallenge.motor;

import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.vehiculos.Vehiculo;

import java.io.File;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Juego {
	private int MAX_FACIL = 30;
	private int MAX_MODERADO = 40;
	private int MAX_DIFICIL = 50;
	private Mapa mapa;
	private ArrayList<String> records;
	private Jugador jugador;
	private boolean finalizado;
	private int movimientosMax;


	public Juego(Jugador unJugador) {
		records = cargarRecords();
		jugador = unJugador;
		finalizado = false;

	}
	public void iniciarEnModo(Dificultad dif){
			XStream xstream = new XStream(new DomDriver());
			mapa = (Mapa)xstream.fromXML(new File("Datos/Mapas/"+dif+".xml"));
		this.mapa.setMeta(new Meta());
		switch (dif) {
		case FACIL:
			this.movimientosMax = MAX_FACIL;
			break;
		case MODERADO:
			this.movimientosMax = MAX_MODERADO;
		case DIFICIL:
			this.movimientosMax = MAX_DIFICIL;
		}
		
	}
	
	private ArrayList<String> cargarRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mapa getMapa() {

		return mapa;

	}
	public int getMovimientosMaximos(){
		return this.movimientosMax;
	}

	public Object getPosiciones() {

		return records;

	}

	public Jugador getJugador() {

		return jugador;

	}
	/*
	 * Devuelve verdadero si el jugador llego  a la meta. Falso de lo contrario.
	 */
	public Boolean hayGanador(){
		if(mapa.getMeta().getPosicion().esIgual(Vehiculo.getInstancia().getPosicionActual())){
			this.finalizado = true;
			return true;
		}
		return false;
		
	}

	/*
	 * Devuelve verdadero si la cantidad de movimientos es igual o mayor a la cantidad maxima de movmientos
	 * permitidos para el nivel elegido. Falso de lo contrario.
	 */
	public boolean juegoFinalizado() {

		if (Vehiculo.getInstancia().getCantMovimientos() >= this.movimientosMax){
			this.finalizado = true;
		}
		return finalizado;

	}

}
