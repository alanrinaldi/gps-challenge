package gpschallengeTest.obstaculos;

import static org.junit.Assert.assertEquals;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;

import org.junit.Before;
import org.junit.Test;

/**
 * @author delpinor
 * 
 */
public class PozoTest {
	private Pozo unPozo = null;
	private Vehiculo unVehiculo = new Vehiculo();

	@Before
	public void setUp() {
		unPozo = new Pozo();
		unVehiculo.reiniciarValoresACero();
	}

	@Test
	public void debePenalizarConTresMovimientosAMotos() {
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.sumarMovimientos(12);
		unVehiculo.afectar(unPozo);
		assertEquals(unVehiculo.getCantMovimientos(), 15);
	}

	@Test
	public void debePenalizarConTresMovimientosAAutos() {
		unVehiculo.setEstado(Auto.getInstancia());
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(unPozo);
		assertEquals(unVehiculo.getCantMovimientos(), 9);
	}

	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro() {
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.sumarMovimientos(11);
		unVehiculo.afectar(unPozo);
		assertEquals(unVehiculo.getCantMovimientos(), 11);
	}
}
