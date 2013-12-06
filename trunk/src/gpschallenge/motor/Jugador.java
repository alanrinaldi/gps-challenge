package gpschallenge.motor;

/**
 * @author delpinor/apredazzi
 * 
 */
public class Jugador {

	private String nombre;
	private int puntaje;

	public Jugador(String nombreJugador) {

		nombre = nombreJugador;
		puntaje = 0;

	}

	public String getNombre() {

		return nombre;

	}

	public int getPuntaje() {

		return puntaje;

	}
	public void setPuntaje(int puntos){
		this.puntaje = puntos;
	}

}
