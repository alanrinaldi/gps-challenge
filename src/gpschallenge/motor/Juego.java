package gpschallenge.motor;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.utililidades.Sentido;

import java.util.ArrayList;
import java.util.Random;

public class Juego {

	private Mapa mapa;
	private ArrayList<String> records;
	private Jugador jugador;
	private boolean finalizado;
	private static int ALTO_FACIL = 7;
	private static int ALTO_MODERADO = 8;
	private static int ALTO_DIFICIL = 10; 

	public Juego(Jugador unJugador) {
		records = cargarRecords();
		jugador = unJugador;
		finalizado = false;
		

	}
	public void iniciarEnModo(Dificultad dif){
		try {
			this.crearMapaModo(dif);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		this.mapa.setMeta(new Meta());
	}
	private void crearMapaModo(Dificultad dif) throws InstantiationException, IllegalAccessException {
		switch (dif) {
		case FACIL:
			this.mapa = new Mapa(ALTO_FACIL, ALTO_FACIL);
			this.crearAfectables(20, new Pozo());
			this.crearAfectables(20, new ControlPolicial());
			this.crearAfectables(20, new Piquete());
			this.crearAfectables(10, new SorpresaDesfavorable());
			this.crearAfectables(30, new SorpresaFavorable());
			this.crearAfectables(20, new CambioDeVehiculo());
			break;
		case MODERADO:
			this.mapa = new Mapa(ALTO_MODERADO, ALTO_MODERADO);
			this.crearAfectables(25, new Pozo());
			this.crearAfectables(25, new ControlPolicial());
			this.crearAfectables(25, new Piquete());
			this.crearAfectables(20, new SorpresaDesfavorable());
			this.crearAfectables(20, new SorpresaFavorable());
			this.crearAfectables(35, new CambioDeVehiculo());
			break;
		case DIFICIL:
			this.mapa = new Mapa(ALTO_DIFICIL, ALTO_DIFICIL);
			this.crearAfectables(40, new Pozo());
			this.crearAfectables(40, new ControlPolicial());
			this.crearAfectables(40, new Piquete());
			this.crearAfectables(50, new SorpresaDesfavorable());
			this.crearAfectables(10, new SorpresaFavorable());
			this.crearAfectables(40, new CambioDeVehiculo());
			break;
		}
	}
	private int unaCoordenada(){
		Random random = new Random();
		int i = random.nextInt(mapa.getAltoEsquinas()) + 1;
		int j = random.nextInt(1);
		if(j == 1 && i == mapa.getAltoEsquinas()){
			i = i + 3;
		}
		return i;
	}
	private Sentido unSentido(){
		Random random = new Random();
		int i = random.nextInt(3) + 1;
		switch (i) {
		case 1:
			return Sentido.IZQUIERDA;
		case 2:
			return Sentido.ARRIBA;
		case 3:
			return Sentido.ABAJO;
		case 4:
			return Sentido.DERECHA;
		}
		return Sentido.DERECHA;
	}
	private void crearAfectables(int cantidad, Afectable unAfectable) throws InstantiationException, IllegalAccessException {
		for (int i = 0; i < cantidad; i++) {
			mapa.addAfectable(unAfectable, this.unaCoordenada(), this.unaCoordenada(), this.unSentido());
		}

		
	}
	private ArrayList<String> cargarRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mapa getMapa() {

		return mapa;

	}

	public Object getPosiciones() {

		return records;

	}

	public Jugador getJugador() {

		return jugador;

	}

	public void finalizarJuego() {

		finalizado = true;
	}

	public boolean juegoFinalizado() {

		if (finalizado)
			return true;
		return false;

	}

}
