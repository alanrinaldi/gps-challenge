package gpschallengeTest.motor;

import static org.junit.Assert.*;

import org.junit.Test;

import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

public class JuegoTest {

	@Test
	public void deberiaCrearJuegoNuevoConRecordsMapaYJugador() {

		Jugador jugador = new Jugador("Lucas");
		Juego juego = new Juego(jugador);
		// assertNotNull(juego.getMapa());
		assertNull(juego.getPosiciones());
		assertEquals(jugador, juego.getJugador());

	}

}
