package gpschallengeTest.motor;

import static org.junit.Assert.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.mapa.Esquina;
import gpschallenge.motor.Mapa;
import gpschallenge.motor.Meta;

import org.junit.Before;
import org.junit.Test;

public class MapaTest {
	private Vehiculo vehiculo;
	private Mapa unMapa = null;
	private Meta meta;

	@Before
	public void setUp() {
		unMapa = new Mapa(10,10);
		vehiculo = new Vehiculo();
		meta = new Meta();
	}

	@Test
	public void iniciaNoNull() {
		assertNotNull(unMapa);
	}

	@Test
	public void agregaEsquinas() {
		vehiculo.setEstado(Auto.getInstancia());
		unMapa.setMeta(meta);
		unMapa.setVehiculo(vehiculo);
		unMapa.setPosicionPrimerEsquina(1, 1, 1);
		
		Esquina esquina = unMapa.getEsquina(1, 1);
		Esquina esquina2 = unMapa.getEsquina(5, 3);
		Esquina esquina3 = unMapa.getEsquina(7, 9);
		Esquina esquina4 = unMapa.getEsquina(10, 10);
		
		assertTrue(esquina.getPosicion().esIgual(new Posicion(1,1)));
		assertTrue(esquina2.getPosicion().esIgual(new Posicion(5,3)));
		assertTrue(esquina3.getPosicion().esIgual(new Posicion(7,9)));
		assertTrue(esquina4.getPosicion().esIgual(new Posicion(10,10)));

	}

}
