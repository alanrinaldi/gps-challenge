package gpschallengeTest.sorpresas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.vehiculos.*;

public class SorpresaDesfavorableTest {
	private Vehiculo unVehiculo;
	private SorpresaDesfavorable unaSorpresa;
	private ArrayList<Afectable> afectables;
	private Auto auto;
	private CuatroXCuatro cuatroporcuatro;
	private Moto moto;

	@Before
	public void setUp() {
		unaSorpresa = new SorpresaDesfavorable();
		afectables = new ArrayList<Afectable>();
		unVehiculo= Vehiculo.getInstancia();
		auto = Auto.getInstancia();
		cuatroporcuatro = CuatroXCuatro.getInstancia();
		moto = Moto.getInstancia();
		afectables.add(unaSorpresa);
	}

	@Test
	public void debeSumarMovimientosAMoto() {
		unVehiculo.setEstado(moto);
		unVehiculo.reiniciarValoresACero();
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 12);
	}

	@Test
	public void debeSumarMovimientosAAuto() {
		unVehiculo.setEstado(auto);
		unVehiculo.reiniciarValoresACero();
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 12);
	}

	@Test
	public void debeSumarMovimientosACuatroXCuatro() {
		unVehiculo.setEstado(cuatroporcuatro);
		unVehiculo.reiniciarValoresACero();
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 12);
	}
}