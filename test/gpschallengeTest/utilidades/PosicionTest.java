package gpschallengeTest.utilidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gpschallenge.componentes.utililidades.Posicion;

import org.junit.Before;
import org.junit.Test;


public class PosicionTest {
	private Posicion unaPosicion = null;
	@Before
	public void setUp(){
		unaPosicion = new Posicion(1, 2);
	}
	@Test
	public void posicionIniciaCorrectamente(){
		assertEquals(unaPosicion.getX(), 1);
		assertEquals(unaPosicion.getY(), 2);
	}
	@Test
	public void debeSetearCordenadas(){
		unaPosicion.setX(2);
		unaPosicion.setY(3);
		assertEquals(unaPosicion.getX(), 2);
		assertEquals(unaPosicion.getY(), 3);
	}
	@Test
	public void dosPosicionesIgualesDevuelveVerdadero(){
		Posicion otraPosicion = new Posicion(1, 2);
		assertTrue(unaPosicion.esIgual(otraPosicion));
	}
}
