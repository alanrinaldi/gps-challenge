package gpschallengeTest.vehiculos;

import static org.junit.Assert.*;
import gpschallenge.componentes.vehiculos.Auto;

import org.junit.Before;
import org.junit.Test;

/**
 * @author delpinor
 *
 */
public class AutoTest {
	private Auto unAuto = null;
	@Before
	public void setUp(){
		unAuto = Auto.getInstancia();
	}
	@Test
	public void instanciaNoNula(){
		assertNotNull(unAuto);
	}
	@Test
	public void debeSerUnicaInstancia(){
		Auto otroAuto = Auto.getInstancia();
		assertEquals(otroAuto.hashCode(), unAuto.hashCode());
	}
}
