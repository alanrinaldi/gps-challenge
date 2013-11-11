package gpschallengeTest.motor;


import static org.junit.Assert.*;

import org.junit.Test;

import gpschallenge.motor.Juego;


public class JuegoTest {
	
	@Test
	public void deberiaCrearJuegoNuevoConRecordsYMapa(){
		
		Juego juego = new Juego();
		assertNotNull(juego.getMapa());
		assertNull(juego.getPosiciones());
		
	}

}