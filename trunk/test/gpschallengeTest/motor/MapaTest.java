package gpschallengeTest.motor;

import static org.junit.Assert.*;
import gpschallenge.motor.Mapa;

import org.junit.Before;
import org.junit.Test;
public class MapaTest {
	private Mapa unMapa = null;
	@Before
	public void setUp(){
		unMapa = Mapa.getInstancia();
	}
	@Test
	public void iniciaNoNUll(){
		assertNotNull(unMapa);
	}
	@Test
	public void esUnicaInstancia(){
		Mapa otroMapa = Mapa.getInstancia();
		assertEquals(unMapa.hashCode(), otroMapa.hashCode());
	}
}
