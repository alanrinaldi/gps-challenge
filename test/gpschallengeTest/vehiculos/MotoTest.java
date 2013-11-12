package gpschallengeTest.vehiculos;
import static org.junit.Assert.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;

import org.junit.Before;
import org.junit.Test;

public class MotoTest {
	private Vehiculo unVehiculo = null;
	private Posicion unaPosicion = null;
	@Before
	public void setUp(){
		unVehiculo = new Vehiculo();
		unVehiculo.setEstado(Moto.getInstancia());
	}
	@Test
	public void iniciaConPosicionNULL(){
		unaPosicion = unVehiculo.getPosicionActual();
		assertNotNull(unaPosicion);
	}
	@Test
	public void debeCambiarDePosicion(){
		unVehiculo.setPosicion(new Posicion(1,6));
		unaPosicion = unVehiculo.getPosicionActual();
		assertEquals(unaPosicion.getX(), 1);
		assertEquals(unaPosicion.getY(), 6);
	}
}
