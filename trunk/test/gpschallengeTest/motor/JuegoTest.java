package gpschallengeTest.motor;

import static org.junit.Assert.assertTrue;
import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	private Juego juego;
	private Jugador jugador;
	private Dificultad dificultad;
	private Vehiculo vehiculo;
	@Before
	public void setUp(){
		vehiculo = Vehiculo.getInstancia();;
		vehiculo.reiniciarValoresACero();
		jugador = new Jugador("Pepe");
	}
	@Test
	public void juegoIniciaCorrectamente(){
		juego = new Juego(jugador, vehiculo, Dificultad.DIFICIL);
		assertTrue(juego != null);
	}
	@Test
	public void juegoCreaMapaCorrectamente(){
		juego = new Juego(jugador, vehiculo, Dificultad.DIFICIL);
		assertTrue(juego.getMapa() != null);
	}
	@Test
	public void juegoIniciaConJugador(){
		juego = new Juego(jugador, vehiculo, Dificultad.DIFICIL);
		assertTrue(juego.getJugador() != null);
	}

}
