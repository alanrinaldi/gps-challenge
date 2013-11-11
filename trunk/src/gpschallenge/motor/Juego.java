package gpschallenge.motor;

import java.util.*;

public class Juego {

	private Mapa mapa;
	private ArrayList<String> records;
	private Jugador jugador;
	
	public Juego(Jugador unJugador){
		
		mapa = new Mapa(2,2);
		mapa.inicializarJuego();
		records = cargarRecords();
		jugador = unJugador;
		
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
	
	public Jugador getJugador(){
		
		return jugador;
		
	}
	
}
