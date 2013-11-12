package gpschallengeTest.obstaculos;

import static org.junit.Assert.assertEquals;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;

import org.junit.Before;
import org.junit.Test;

public class PiqueteTest {

	private Piquete unPiquete = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	private Vehiculo unVehiculo = new Vehiculo();
	@Before
	public void setUp(){
		unPiquete = new Piquete();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
		unVehiculo.reiniciarValoresACero();

	}
	@Test
	public void debePenalizarConDosMovimientosAMotos(){
		unVehiculo.setEstado(unaMoto);
		unVehiculo.sumarMovimientos(12);
		unVehiculo.afectar(unPiquete);
		assertEquals(unVehiculo.getCantMovimientos(), 14);
	}
	@Test
	public void NoDebePenalizarAVehiculoAutos(){
		unVehiculo.setEstado(unAuto);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(unPiquete);
		assertEquals(unVehiculo.getCantMovimientos(), 6);
	}
	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro(){
		unVehiculo.setEstado(una4x4);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(unPiquete);
		assertEquals(unVehiculo.getCantMovimientos(), 6);
	}
		
}
