package gpschallengeTest.obstaculos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import gpschallenge.componentes.obstaculos.*;
import gpschallenge.componentes.vehiculos.*;

import org.junit.Before;
import org.junit.Test;

public class PozoTest {
	private Pozo unPozo;
	private Vehiculo unVehiculo;
	private ArrayList<Afectable> afectables;
	private Auto auto;
	
	@Before
	public void setUp() {
		unPozo = new Pozo();
		afectables = new ArrayList<Afectable>();
		unVehiculo= new Vehiculo();
		auto = Auto.getInstancia();
		afectables.add(unPozo);
	}

	@Test
	public void debePenalizarConTresMovimientosAMotos() {
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.sumarMovimientos(12);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 15);
	}

	@Test
	public void debePenalizarConTresMovimientosAAutos() {
		unVehiculo.setEstado(auto);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 9);
	}

	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro() {
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.sumarMovimientos(11);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 11);
	}
}
