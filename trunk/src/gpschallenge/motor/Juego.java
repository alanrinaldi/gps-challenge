package gpschallenge.motor;

import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.vista.InfoJuego;

import java.io.File;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Juego {
	private int MAX_FACIL = 20;
	private int MAX_MODERADO = 25;
	private int MAX_DIFICIL = 35;
	private static int SOBRANTE_FACIL = 1;
	private static int SOBRANTE_MODERADO = 2;
	private static int SOBRANTE_DIFICIL = 3;
	private boolean finalizado;
	private int movimientosMax;
	private int puntosPorMovSobrante;
	private InfoJuego informacionJuego;
	private Jugador jugador;
	private Vehiculo vehiculo;
	private Dificultad dificultad;
	private Mapa mapa;

	public Juego(Jugador unJugador,Vehiculo unVehiculo, Dificultad unaDificultad) {
		dificultad = unaDificultad;
		jugador = unJugador;
		finalizado = false;
		vehiculo = unVehiculo;
		informacionJuego = new InfoJuego();
		this.iniciarEnModo(dificultad);
		mapa.setVehiculo(this.vehiculo);
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
	}
	private int calcularPuntaje(){
		return ((movimientosMax - vehiculo.getCantMovimientos()) * puntosPorMovSobrante);
	}

	public Mapa getMapa() {

		return mapa;

	}
	public int getMovimientosMaximos(){
		return this.movimientosMax;
	}

	public Jugador getJugador() {

		return jugador;

	}
	/*
	 * Devuelve verdadero si el jugador llego  a la meta. Falso de lo contrario.
	 */
	public Boolean hayGanador(){
		this.jugador.setPuntaje(this.calcularPuntaje());
		if(mapa.getMeta().getPosicion().esIgual(vehiculo.getPosicionActual())){
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
		if (vehiculo.getCantMovimientos() >= this.movimientosMax){
			this.finalizado = true;
		}
		return finalizado;

	}
	public InfoJuego getInformacion() {
		informacionJuego.setDesafio(this.movimientosMax);
		informacionJuego.setJugador(this.jugador.getNombre());
		informacionJuego.setMovimientos(vehiculo.getCantMovimientos());
		informacionJuego.setPuntaje(jugador.getPuntaje());
		informacionJuego.setTipoVehiculo(vehiculo.getTipoVehiculo());
		return informacionJuego;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

}
