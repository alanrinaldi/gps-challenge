package gpschallengeTest.motor;

import static org.junit.Assert.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.mapa.EsquinaVieja;
import gpschallenge.motor.Mapa;

import org.junit.Before;
import org.junit.Test;

public class MapaTest {
	private Mapa unMapa = null;

	@Before
	public void setUp() {
		unMapa = Mapa.getInstancia();
	}

	@Test
	public void iniciaNoNull() {
		assertNotNull(unMapa);
	}

	@Test
	public void esUnicaInstancia() {
		Mapa otroMapa = Mapa.getInstancia();
		assertEquals(unMapa.hashCode(), otroMapa.hashCode());
	}

	@Test
	public void agregaUnaEsquinaEnPosicion() {

		Posicion posicion = new Posicion(1, 1);
		EsquinaVieja unaEsquina = new EsquinaVieja(posicion);
		unMapa.agregarEsquina(unaEsquina);

		assertEquals(unMapa.getEsquinaEnPosicion(posicion).getPosicion(),
				posicion);

	}

}
