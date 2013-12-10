package gpschallengeTest.sorpresas;

import java.util.ArrayList;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.vehiculos.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CambioDeVehiculoTest {
	private Vehiculo unVehiculo;
	private CambioDeVehiculo unaSorpresa;
	private ArrayList<Afectable> afectables;
	private Auto auto;
	private CuatroXCuatro cuatroporcuatro;
	private Moto moto;
	
	@Before
	public void setUp() {
		unaSorpresa = new CambioDeVehiculo();
		afectables = new ArrayList<Afectable>();
		unVehiculo= new Vehiculo();
		auto = Auto.getInstancia();
		cuatroporcuatro = CuatroXCuatro.getInstancia();
		moto = Moto.getInstancia();
		afectables.add(unaSorpresa);
	}
	
	
	@Test
	public void afectaAAutoDebeConvertirEnCuatroPorCuatro() {
		unVehiculo.setEstado(auto);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getEstado().hashCode(), CuatroXCuatro
				.getInstancia().hashCode());

	}

	@Test
	public void afectaAMotoDebeConvertirEnAuto() {
		unVehiculo.setEstado(moto);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getEstado().hashCode(), Auto.getInstancia()
				.hashCode());
	}

	@Test
	public void afectaACuatroPorCuatroDebeConvertirEnMoto() {
		unVehiculo.setEstado(cuatroporcuatro);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getEstado().hashCode(), Moto.getInstancia()
				.hashCode());
	}
}
