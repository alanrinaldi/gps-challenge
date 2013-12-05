package gpschallenge.componentes.utililidades;
import java.util.ArrayList;


public class ListaJugadores {
	
	private ArrayList<String> listajugadores;
	
	public ListaJugadores(){
		
		listajugadores = new ArrayList<String>();
		
	}

	public ArrayList<String> ObtenerListaJugadores(){
		return listajugadores;
	}
	
	public void AgregarJugador(String jugador){
		listajugadores.add(jugador);
	}
	
}
