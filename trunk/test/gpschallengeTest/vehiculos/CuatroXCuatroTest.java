package gpschallengeTest.vehiculos;

import static org.junit.Assert.*;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;

import org.junit.Before;
import org.junit.Test;

/**
 * @author delpinor
 * 
 */
public class CuatroXCuatroTest {
	private CuatroXCuatro unaCuatroXCuatro = null;

	@Before
	public void setUp() {
		unaCuatroXCuatro = CuatroXCuatro.getInstancia();
	}

	@Test
	public void instanciaNoNula() {
		assertNotNull(unaCuatroXCuatro);
	}

	@Test
	public void debeSerUnicaInstancia() {
		CuatroXCuatro otraCuatroXCuatro = CuatroXCuatro.getInstancia();
		assertEquals(otraCuatroXCuatro.hashCode(), unaCuatroXCuatro.hashCode());
	}
}
