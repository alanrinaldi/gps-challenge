package gpschallenge.motor;


import gpschallenge.componentes.obstaculos.Obstaculo;
import gpschallenge.componentes.sorpresas.Sorpresa;
import gpschallenge.componentes.utililidades.Posicion;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa {
	
	
	HashMap<Posicion,Obstaculo> mapaObstaculos;
	HashMap<Posicion,Sorpresa> mapaSorpresas;
	ArrayList<Posicion> posicionesMapa;
	private static Mapa unicoMapa = null;
	private Mapa(){}
	public static Mapa getInstancia(){
		if(unicoMapa == null){
			unicoMapa = new Mapa();
		}
		return unicoMapa;
	}
	public void inicializarJuego() {
		
	}

}
