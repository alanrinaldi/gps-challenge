package gpschallengeTest.motor;

import static org.junit.Assert.*;
import gpschallenge.motor.Jugador;

import org.junit.Test;

public class JugadorTest {
	
	Jugador jugador = new Jugador("Cristian");
	Jugador jugador2 = new Jugador("Cristian");
	
	@Test
	public void inicializaJugadorConNombre(){
		
		assertEquals(jugador.getNombre(),"Cristian");
	}
	
	@Test
	public void inicializaJugadorConPuntajeCero(){
		
		assertEquals(jugador.getPuntaje(),new Integer(0));
	}
	
	@Test
	public void setearPuntajeYVerificar(){
		
		jugador.setPuntaje(5);
		assertEquals(jugador.getPuntaje(), new Integer(5));
		
	}
	
	@Test
	public void compararDosJugadores(){
		
		assertTrue(jugador.esIgual(jugador2));
		
	}

}
