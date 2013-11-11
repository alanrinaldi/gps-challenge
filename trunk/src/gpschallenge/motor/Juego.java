package gpschallenge.motor;

import java.util.*;

public class Juego {

	private Mapa mapa;
	private ArrayList<String> records;
	
	public Juego(){
		
		mapa = new Mapa();
		mapa.inicializarJuego();
		records = cargarRecords();
		
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
	
}
