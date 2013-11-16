package gpschallenge.motor;


import gpschallenge.componentes.obstaculos.Obstaculo;
import gpschallenge.componentes.sorpresas.Sorpresa;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Vehiculo;

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
	public Mapa(int ancho, int alto){
		
		mapaSorpresas = new HashMap<Posicion,Sorpresa>();
		mapaObstaculos = new HashMap<Posicion,Obstaculo>();
		ArrayList<Posicion> posicionesMapa = new ArrayList<Posicion>();
		for (int i=0; i<ancho-2; i++){
			for (int j=0; j<alto-2; j++){
				posicionesMapa.add(new Posicion((2*i)+1,(2*j)+1));
			}
		}
	}
	
	public void agregarObstaculo(Posicion unaPosicion, Obstaculo unObstaculo){
		
		mapaObstaculos.put(unaPosicion, unObstaculo);
		
	}
	
	public void agregarSorpresa(Posicion unaPosicion, Sorpresa unaSorpresa){
		
		mapaSorpresas.put(unaPosicion, unaSorpresa);
		
	}
	
	public boolean hayObjetosEnPosicion(Posicion posicion){
		
		if (!(mapaObstaculos.containsKey(posicion))&&!(mapaSorpresas.containsKey(posicion))) return false;
		return true;
		
	}
	
	public void aplicarSorpresasEnPosicion(Posicion unaPosicion, Vehiculo unVehiculo){
		
		mapaSorpresas.get(unaPosicion).aplicarIncidencia(unVehiculo);
		
	}
	
	public void aplicarObstaculosEnPosicion(Posicion unaPosicion, Vehiculo unVehiculo){
		
		mapaObstaculos.get(unaPosicion).getPenalizacion();
		
	}

	/*public Mapa getMapa(){
		
		return mapa;
		
	}*/
	
	public void inicializarJuego() {
		// TODO Auto-generated method stub
		
	}

	//TODO
}
