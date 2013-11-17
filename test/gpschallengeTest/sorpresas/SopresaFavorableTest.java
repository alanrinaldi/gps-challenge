package gpschallengeTest.sorpresas;
import static org.junit.Assert.*;

import org.junit.Test;

import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;
/**
 * @author delpinor
 *
 */
public class SopresaFavorableTest {
	private Vehiculo unVehiculo = new Vehiculo();
	private SorpresaFavorable unaSorpresa = new SorpresaFavorable();
	@Test
	public void debeRestarMovimientosAMoto(){
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(unaSorpresa);
		assertEquals(unVehiculo.getCantMovimientos(),8);
	}
	@Test
	public void debeRestarMovimientosAAuto(){
		unVehiculo.setEstado(Auto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(unaSorpresa);
		assertEquals(unVehiculo.getCantMovimientos(),8);
	}
	@Test
	public void debeRestarMovimientosACuatroXCuatro(){
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(unaSorpresa);
		assertEquals(unVehiculo.getCantMovimientos(),8);
	}
}
