package gpschallengeTest.sorpresas;

import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CambioDeVehiculoTest {
	private Vehiculo unVehiculo = new Vehiculo();
	private CambioDeVehiculo unaSopresa = new CambioDeVehiculo();
	@Test
	public void afectaAAutoDebeConvertirEnCuatroPoCuatro(){
		unVehiculo.setEstado(Auto.getInstancia());
		unVehiculo.afectar(unaSopresa);
		assertEquals(unVehiculo.getEstado().hashCode(), CuatroXCuatro.getInstancia().hashCode());	
		
	}
	@Test
	public void afectaAMotoDebeConvertirEnAuto(){
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.afectar(unaSopresa);
		assertEquals(unVehiculo.getEstado().hashCode(), Auto.getInstancia().hashCode());
	}
	@Test
	public void afectaACuatroPorCuatroDebeConvertirEnMoto(){
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.afectar(unaSopresa);
		assertEquals(unVehiculo.getEstado().hashCode(), Moto.getInstancia().hashCode());
	}
}
