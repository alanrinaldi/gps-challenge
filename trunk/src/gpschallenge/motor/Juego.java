package gpschallenge.motor;

import java.util.*;

public class Juego {

	private Mapa mapa;
	private ArrayList<String> records;
	private Jugador jugador;
	private boolean finalizado;
	
	public Juego(Jugador unJugador){
		
		mapa.inicializarJuego();
		records = cargarRecords();
		jugador = unJugador;
		finalizado = false;
		
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
	
	public void finalizarJuego(){
		
		finalizado = true;
	}
	
	public boolean juegoFinalizado(){
		
		if (finalizado == true) return true;
		return false;
		
	}
	
}
