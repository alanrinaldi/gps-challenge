package gpschallenge.motor;

import gpschallenge.componentes.obstaculos.Obstaculo;
import gpschallenge.componentes.sorpresas.Sorpresa;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa {
	
	HashMap<Posicion,Sorpresa> mapaSorpresas;
	HashMap<Posicion,Obstaculo> mapaObstaculos;
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
		
		HashMap<Posicion,Sorpresa> mapaSorpresas = new HashMap<Posicion,Sorpresa>();
		HashMap<Posicion,Obstaculo> mapaObstaculos = new HashMap<Posicion,Obstaculo>();
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
	
	public void aplicarIncidenciasEnPosicion(Posicion unaPosicion, Vehiculo unVehiculo){
		
		mapaSorpresas.get(unaPosicion).aplicarIncidencia(unVehiculo);
		//mapaObstaculos.get(unaPosicion).
		
	}

	/*public Mapa getMapa(){
		
		return mapa;
		
	}*/
	
	public void inicializarJuego() {
		// TODO Auto-generated method stub
		
	}

	//TODO
}
