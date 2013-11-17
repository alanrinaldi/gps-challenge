package gpschallengeTest.sorpresas;
import static org.junit.Assert.*;

import org.junit.Test;

import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;
public class SorpresaDesfavorableTest {
	private Vehiculo unVehiculo = new Vehiculo();
	private SorpresaDesfavorable unaSorpresa = new SorpresaDesfavorable();
	@Test
	public void debeSumarMovimientosAMoto(){
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(unaSorpresa);
		assertEquals(unVehiculo.getCantMovimientos(),12);
	}
	@Test
	public void debeSumarMovimientosAAuto(){
		unVehiculo.setEstado(Auto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(unaSorpresa);
		assertEquals(unVehiculo.getCantMovimientos(),12);
	}
	@Test
	public void debeSumarMovimientosACuatroXCuatro(){
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(unaSorpresa);
		assertEquals(unVehiculo.getCantMovimientos(),12);
	}
}