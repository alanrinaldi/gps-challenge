package gpschallenge.motor;

import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.vista.InfoJuego;

import java.io.File;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Juego {
	private int MAX_FACIL = 15;
	private int MAX_MODERADO = 20;
	private int MAX_DIFICIL = 30;
	private static int SOBRANTE_FACIL = 1;
	private static int SOBRANTE_MODERADO = 2;
	private static int SOBRANTE_DIFICIL = 3;
	private Mapa mapa;
	private ArrayList<String> records;
	private Jugador jugador;
	private boolean finalizado;
	private int movimientosMax;
	private int puntosPorMovSobrante;
	private InfoJuego informacionJuego;


	public Juego(Jugador unJugador) {
		records = cargarRecords();
		jugador = unJugador;
		finalizado = false;
		informacionJuego = new InfoJuego();
	}
	public void iniciarEnModo(Dificultad dif){
		XStream xstream = new XStream(new DomDriver());
		mapa = (Mapa)xstream.fromXML(new File("Datos/Mapas/"+dif+".xml"));
		this.mapa.setMeta(new Meta());
		switch (dif) {
		case FACIL:
			this.movimientosMax = MAX_FACIL;
			this.puntosPorMovSobrante = SOBRANTE_FACIL;
			break;
		case MODERADO:
			this.movimientosMax = MAX_MODERADO;
			this.puntosPorMovSobrante = SOBRANTE_MODERADO;
			break;
		case DIFICIL:
			this.movimientosMax = MAX_DIFICIL;
			this.puntosPorMovSobrante = SOBRANTE_DIFICIL;
			break;
		}
		jugador.setPuntaje(this.calcularPuntaje());
	}
	private int calcularPuntaje(){
		return ((movimientosMax - Vehiculo.getInstancia().getCantMovimientos()) * puntosPorMovSobrante);
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
		this.jugador.setPuntaje(this.calcularPuntaje());
		if(mapa.getMeta().getPosicion().esIgual(Vehiculo.getInstancia().getPosicionActual())){
			return true;
		}
		return false;
		
	}

	/*
	 * Devuelve verdadero si la cantidad de movimientos es igual o mayor a la cantidad maxima de movmientos
	 * permitidos para el nivel elegido. Falso de lo contrario.
	 */
	public boolean juegoFinalizado() {
		this.jugador.setPuntaje(this.calcularPuntaje());
		if (Vehiculo.getInstancia().getCantMovimientos() >= this.movimientosMax){
			this.finalizado = true;
		}
		return finalizado;

	}
	public InfoJuego getInformacion() {
		informacionJuego.setDesafio(this.movimientosMax);
		informacionJuego.setJugador(this.jugador.getNombre());
		informacionJuego.setMovimientos(Vehiculo.getInstancia().getCantMovimientos());
		informacionJuego.setPuntaje(jugador.getPuntaje());
		informacionJuego.setTipoVehiculo(Vehiculo.getInstancia().getTipoVehiculo());
		return informacionJuego;
	}

}
