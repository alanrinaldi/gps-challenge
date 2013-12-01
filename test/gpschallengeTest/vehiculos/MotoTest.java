package gpschallengeTest.vehiculos;

import static org.junit.Assert.*;
import gpschallenge.componentes.vehiculos.Moto;

import org.junit.*;

public class MotoTest {
	private Moto unaMoto = null;

	@Before
	public void setUp() {
		unaMoto = Moto.getInstancia();
	}

	@Test
	public void iniciaConPosicionNULL() {
		assertNotNull(unaMoto);
	}

	@Test
	public void unicaInstanciaDeMoto() {
		Moto otraMoto = Moto.getInstancia();
		assertTrue(unaMoto.hashCode() == otraMoto.hashCode());

	}
}
