package gpschallengeTest.motor;

import static org.junit.Assert.*;
import gpschallenge.motor.Jugador;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void deberiaCrearJugadorConNombre() {

		Jugador jugador = new Jugador("Pedro");
		assertEquals("Pedro", jugador.getNombre());

	}

	@Test
	public void deberiaInicializarMarcadorEnCero() {

		Jugador jugador = new Jugador("Juan");
		assertEquals(0, jugador.getPuntaje());

	}

}
