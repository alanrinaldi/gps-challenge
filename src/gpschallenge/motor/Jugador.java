package gpschallenge.motor;


/**
 * @author delpinor/apredazzi
 * @param <T>
 * 
 */
public class Jugador implements Comparable<Jugador> {

	private String nombre;
	private Integer puntaje;

	public Jugador(String nombreJugador) {

		nombre = nombreJugador;
		puntaje = 0;

	}

	public String getNombre() {

		return nombre;

	}

	public Integer getPuntaje() {

		return puntaje;

	}
	public void setPuntaje(int puntos){
		this.puntaje = puntos;
	}
	public boolean esIgual(Jugador jugador){
		if(this.nombre == jugador.getNombre())
			return true;
		return false;
	}

	public int compareTo(Jugador jug) {
		return (this.getPuntaje() > jug.getPuntaje() ? -1 : (jug.getPuntaje() == this.getPuntaje() ? 0 : 1));
	}
}
