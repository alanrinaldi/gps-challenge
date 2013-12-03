package gpschallenge.motor;

import gpschallenge.componentes.utililidades.Dificultad;

import java.io.File;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Juego {

	private Mapa mapa;
	private ArrayList<String> records;
	private Jugador jugador;
	private boolean finalizado;


	public Juego(Jugador unJugador) {
		records = cargarRecords();
		jugador = unJugador;
		finalizado = false;
		

	}
	public void iniciarEnModo(Dificultad dif){
		
			XStream xstream = new XStream(new DomDriver());
			mapa = (Mapa)xstream.fromXML(new File("Mapas/"+dif+".xml"));
			
		this.mapa.setMeta(new Meta());
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

	public Jugador getJugador() {

		return jugador;

	}

	public void finalizarJuego() {

		finalizado = true;
	}

	public boolean juegoFinalizado() {

		if (finalizado)
			return true;
		return false;

	}

}
