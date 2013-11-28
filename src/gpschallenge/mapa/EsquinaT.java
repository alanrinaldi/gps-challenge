package gpschallenge.mapa;

import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;

public class EsquinaT {
	
	private Posicion posicion;
	private CalleT calleDerecha;
	private CalleT calleIzquierda;
	private CalleT calleArriba;
	private CalleT calleAbajo;
	public EsquinaT(Posicion unaPosicion){
		calleDerecha = null;
		calleIzquierda = null;
		calleArriba = null;
		calleAbajo = null;
		this.posicion = unaPosicion;
	}
	public CalleT getCalleEnSentido(Sentido sentido){
		switch (sentido){
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
	public CalleT getCalleDerecha(){
		return this.calleDerecha;
	}
	public CalleT getCalleIzquierda(){
		return this.calleIzquierda;
	}
	public CalleT getCalleAbajo(){
		return this.calleAbajo;
	}
	public CalleT getCalleArriba(){
		return this.calleArriba;
	}
	public void setCalleDerecha(CalleT calle){
		this.calleDerecha = calle;
	}
	public void setCalleIzquierda(CalleT calle){
		this.calleIzquierda = calle;
	}
	public void setCalleArriba(CalleT calle){
		this.calleArriba = calle;
	}
	public void setCalleAbajo(CalleT calle){
		this.calleAbajo = calle;
	}
	public Posicion getPosicion(){
		
		return posicion;
		
	}
}
	