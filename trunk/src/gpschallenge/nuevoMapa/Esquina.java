package gpschallenge.nuevoMapa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import gpschallenge.nuevoMapa.Calle;
import gpschallenge.componentes.utililidades.Posicion;

public class Esquina {
	private Posicion unaPosicion;
	private HashMap<Posicion,Calle> callesAdyacentes;
	
	public Esquina(Posicion unaPos){
		callesAdyacentes = new HashMap<Posicion,Calle>();
		unaPosicion = unaPos;
		//Calle de la derecha
		Posicion unaPosicionAuxiliar = new Posicion(unaPosicion.getX()+1,unaPosicion.getY());
		callesAdyacentes.put(unaPosicionAuxiliar,new Calle(unaPosicionAuxiliar));
		//Calle de la izquierda
		unaPosicionAuxiliar = new Posicion(unaPosicion.getX()-1,unaPosicion.getY());
		callesAdyacentes.put(unaPosicionAuxiliar,new Calle(unaPosicionAuxiliar));
		//Calle de Abajo
		unaPosicionAuxiliar = new Posicion(unaPosicion.getX(),unaPosicion.getY()+1);
		callesAdyacentes.put(unaPosicionAuxiliar,new Calle(unaPosicionAuxiliar));
		//Calle de Arriba
		unaPosicionAuxiliar = new Posicion(unaPosicion.getX(),unaPosicion.getY()-1);
		callesAdyacentes.put(unaPosicionAuxiliar,new Calle(unaPosicionAuxiliar));
	}

	public int getCantidadDeCalles() {
			return callesAdyacentes.size();
	}

	private Calle getCalleEnPosicion(Posicion unaPos) {
		Map.Entry e;
		Iterator it = callesAdyacentes.entrySet().iterator();
		while (it.hasNext()){
		       e = (Map.Entry)it.next();
		       if (((Posicion) e.getKey()).esIgual(unaPos)){
		    	   return (Calle) e.getValue();
		       }
		}
		
       
		return null;
	}
	
	
	public Calle getCalleDerecha(){
		Posicion unaPos = new Posicion(unaPosicion.getX()+1,unaPosicion.getY());
		return getCalleEnPosicion(unaPos);
	}

	public Calle getCalleIzquierda(){
		Posicion unaPos = new Posicion(unaPosicion.getX()-1,unaPosicion.getY());
		return getCalleEnPosicion(unaPos);
	}
	
	public Calle getCalleArriba(){
		Posicion unaPos = new Posicion(unaPosicion.getX(),unaPosicion.getY()-1);
		return getCalleEnPosicion(unaPos);
	}
	
	public Calle getCalleAbajo(){
		Posicion unaPos = new Posicion(unaPosicion.getX(),unaPosicion.getY()+1);
		return getCalleEnPosicion(unaPos);
	}

	public void setCalle(Posicion unaPos, Calle nuevaCalle) {
		callesAdyacentes.put(unaPos,nuevaCalle);		
	}
}