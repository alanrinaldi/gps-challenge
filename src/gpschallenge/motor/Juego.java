package gpschallenge.motor;

import gpschallenge.componentes.utililidades.XML;
import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.vista.InfoJuego;

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
		this.dificultad = unaDificultad;
		this.jugador = unJugador;
		this.finalizado = false;
		this.vehiculo = unVehiculo;
		this.informacionJuego = new InfoJuego();
		this.iniciarEnModo(dificultad);
		this.mapa.setVehiculo(this.vehiculo);
		this.mapa.setMeta(new Meta());
	}
	public void iniciarEnModo(Dificultad dif){
		mapa = (Mapa)XML.obtenerObjeto("Datos/Mapas/"+dif+".xml");
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
	public boolean finalizado() {
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
