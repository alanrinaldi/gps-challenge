package gpschallenge.componentes.utililidades;
import gpschallenge.motor.Jugador;

import java.util.ArrayList;


public class ListaJugadores {
	
	private ArrayList<Jugador> listajugadores;
	
	public ListaJugadores(){
		
		listajugadores = new ArrayList<Jugador>();
		
	}

	public ArrayList<Jugador> ObtenerListaJugadores(){
		return listajugadores;
	}
	
	public void AgregarJugador(Jugador jugador){
			listajugadores.add(jugador);
	}
}
