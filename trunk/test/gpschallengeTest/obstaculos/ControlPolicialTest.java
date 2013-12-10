package gpschallengeTest.obstaculos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.vehiculos.*;

import org.junit.Before;
import org.junit.Test;

public class ControlPolicialTest {
	private ControlPolicial unControlPolicial = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	private Vehiculo unVehiculo;
	private ArrayList<Afectable> afectables;
	
	public double porcentajeDeAparicion(EstadoVehiculo unEstado) {
		unVehiculo.setEstado(unEstado);
		double cantidad = 0;
		/* Pruebo 1000 casos y calculo la probabilidad de ser penalizado */
		for (int i = 0; i < 1000; i++) {
			unVehiculo.sumarMovimientos(5);
			unVehiculo.afectar(afectables);
			if (unVehiculo.getCantMovimientos() == 8) {
				cantidad += 1;
			}
			unVehiculo = new Vehiculo();
			unVehiculo.setEstado(unEstado);
		}
		/* Redondeo a un valor double de tipo 0.0 */
		double valor = cantidad / 1000;
		valor = Math.rint(valor * 10) / 10;
		return valor;
	}

	@Before
	public void setUp() {
		unControlPolicial = new ControlPolicial();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
		afectables = new ArrayList<Afectable>();
		afectables.add(unControlPolicial);
		unVehiculo = new Vehiculo();
	}

	@Test
	public void probabilidadDeSerPenalizadoAuto() {
		assertTrue(this.porcentajeDeAparicion(unAuto) == 0.5);
	}

	@Test
	public void probabilidadDeSerPenalizadoMoto() {
		assertTrue(this.porcentajeDeAparicion(unaMoto) == 0.8);
	}

	@Test
	public void probabilidadDeSerPenalizadoCuatroXCuatro() {
		assertTrue(this.porcentajeDeAparicion(una4x4) == 0.3);
	}
}
