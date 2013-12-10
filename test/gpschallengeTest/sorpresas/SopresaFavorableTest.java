package gpschallengeTest.sorpresas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.vehiculos.*;

public class SopresaFavorableTest {
	private Vehiculo unVehiculo;
	private SorpresaFavorable unaSorpresa;
	private ArrayList<Afectable> afectables;
	private Auto auto;
	private CuatroXCuatro cuatroporcuatro;
	private Moto moto;

	@Before
	public void setUp() {
		unaSorpresa = new SorpresaFavorable();
		afectables = new ArrayList<Afectable>();
		unVehiculo= new Vehiculo();
		auto = Auto.getInstancia();
		cuatroporcuatro = CuatroXCuatro.getInstancia();
		moto = Moto.getInstancia();
		afectables.add(unaSorpresa);
	}
	
	@Test
	public void debeRestarMovimientosAMoto() {
		unVehiculo.setEstado(moto);
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 8);
	}

	@Test
	public void debeRestarMovimientosAAuto() {
		unVehiculo.setEstado(auto);
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 8);
	}

	@Test
	public void debeRestarMovimientosACuatroXCuatro() {
		unVehiculo.setEstado(cuatroporcuatro);
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 8);
	}
}
