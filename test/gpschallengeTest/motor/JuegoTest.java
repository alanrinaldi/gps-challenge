package gpschallengeTest.motor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.motor.Juego;
import gpschallenge.motor.Jugador;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	private Juego juego;
	private Jugador jugador;
	private Vehiculo vehiculo;
	@Before
	public void setUp(){
		vehiculo = new Vehiculo();
		vehiculo.setEstado(Auto.getInstancia());
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
	@Test
	public void juegoEnDificultadFacil(){
		juego = new Juego(jugador, vehiculo, Dificultad.FACIL);
		assertEquals(juego.getMapa().getAltoEsquinas(),  8);
		assertEquals(juego.getMapa().getAnchoEsquinas(), 8);
	}
	@Test
	public void juegoEnDificultadModerado(){
		juego = new Juego(jugador, vehiculo, Dificultad.MODERADO);
		assertEquals(juego.getMapa().getAltoEsquinas(),  9);
		assertEquals(juego.getMapa().getAnchoEsquinas(), 9);
	}
	@Test
	public void juegoEnDificultadDificil(){
		juego = new Juego(jugador, vehiculo, Dificultad.DIFICIL);
		assertEquals(juego.getMapa().getAltoEsquinas(),  11);
		assertEquals(juego.getMapa().getAnchoEsquinas(), 11);
	}
	@Test
	public void juegoFinalizaCuandoExcedeElLimitedemovimientosFacil(){
		juego = new Juego(jugador, vehiculo, Dificultad.FACIL);
		// Limite : 20
		vehiculo.sumarMovimientos(2);
		assertFalse(juego.finalizado());
		vehiculo.sumarMovimientos(18);
		assertTrue(juego.finalizado());
		
	}
	@Test
	public void juegoHayGanadorCuandoMetaCoincideConVehiculo(){
		juego = new Juego(jugador, vehiculo, Dificultad.FACIL);
		juego.getMapa().setPosicionPrimerEsquina(1, 1, 1);
		vehiculo.setPosicion(new Posicion(12, 12));
		assertFalse(juego.getMapa().getMeta().getPosicion().esIgual(vehiculo.getPosicionActual()));
		vehiculo.setPosicion(juego.getMapa().getMeta().getPosicion());
		assertTrue(juego.hayGanador());
		
	}
	@Test
	public void juegoFinalizaCuandoExcedeElLimitedemovimientosModerado(){
		juego = new Juego(jugador, vehiculo, Dificultad.MODERADO);
		// Limite : 25
		vehiculo.sumarMovimientos(2);
		assertFalse(juego.finalizado());
		vehiculo.sumarMovimientos(23);
		assertTrue(juego.finalizado());
		
	}
	@Test
	public void juegoFinalizaCuandoExcedeElLimitedemovimientosDificil(){
		juego = new Juego(jugador, vehiculo, Dificultad.DIFICIL);
		// Limite : 35
		vehiculo.sumarMovimientos(2);
		assertFalse(juego.finalizado());
		vehiculo.sumarMovimientos(33);
		assertTrue(juego.finalizado());
		
	}

}
