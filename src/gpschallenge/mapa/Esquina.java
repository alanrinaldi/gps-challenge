package gpschallenge.mapa;

import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;

public class Esquina {

	private Posicion posicion;
	private Calle calleDerecha;
	private Calle calleIzquierda;
	private Calle calleArriba;
	private Calle calleAbajo;

	public Esquina(Posicion unaPosicion) {
		calleDerecha = null;
		calleIzquierda = null;
		calleArriba = null;
		calleAbajo = null;
		this.posicion = unaPosicion;
	}

	public Calle getCalleEnSentido(Sentido sentido) {
		switch (sentido) {
		case IZQUIERDA:
			return calleIzquierda;
		case ARRIBA:
			return calleArriba;
		case DERECHA:
			return calleDerecha;
		case ABAJO:
			return calleAbajo;
		}
		return null;
	}

	public void setCalleEnSentido(Calle calle, Sentido sentido) {
		switch (sentido) {
		case IZQUIERDA:
			this.calleIzquierda = calle;
			break;
		case ARRIBA:
			this.calleArriba = calle;
			break;
		case DERECHA:
			this.calleDerecha = calle;
			break;
		case ABAJO:
			this.calleAbajo = calle;
			break;
		}
	}

	public Posicion getPosicion() {

		return posicion;

	}
}
