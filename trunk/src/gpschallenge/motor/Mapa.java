package gpschallenge.motor;

import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.mapa.Esquina;

import java.util.HashMap;

public class Mapa {
	
	private HashMap<Posicion,Esquina> mapaEsquinas;
	private Esquina esquinaInicial;
	
	private static Mapa unicoMapa = null;
	private Mapa(){
		
		mapaEsquinas = new HashMap<Posicion,Esquina>();
		
	}
	public static Mapa getInstancia(){
		if(unicoMapa == null){
			unicoMapa = new Mapa();
		}
		return unicoMapa;
	}

	
	public void agregarEsquina(Esquina esquina){
		
		mapaEsquinas.put(esquina.getPosicion(), esquina);
		
	}
	
	public Esquina getEsquinaEnPosicion(Posicion posicion){
		
		return mapaEsquinas.get(posicion);
		
	}
	
	public void setEsquinaInicial(Esquina esquina){
		
		esquinaInicial = esquina;
	}
	
	public Esquina getEsquinaInicial(){
		
		return esquinaInicial;
		
	}
	
	public void inicializarJuego() {
		
	}

}
