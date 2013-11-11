package gpschallengeTest.obstaculos;

import static org.junit.Assert.*;
import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;

import org.junit.Before;
import org.junit.Test;

/**
 * @author delpinor
 *
 */

public class ControlPolicialTest {
	private ControlPolicial unControlPolicial = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	@Before
	public void setUp(){
		unControlPolicial = new ControlPolicial();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
		unaMoto.reiniciarValoresACero();
		una4x4.reiniciarValoresACero();
		unAuto.reiniciarValoresACero();
	}
	@Test
	public void debePenalizarAMoto(){
		unaMoto.sumarMovimientos(5);
		unControlPolicial.afectarMoto(unaMoto);
		assertEquals(unaMoto.getCantMovimientos(), 8);
	}
	@Test
	public void debePenalizarAuto(){
		unAuto.sumarMovimientos(8);
		unAuto.afectar(unControlPolicial);
		assertEquals(unAuto.getCantMovimientos(), 11);
	}
	@Test
	public void debePenalizarCuatroXCuatro(){
		una4x4.sumarMovimientos(10);
		una4x4.afectar(unControlPolicial);
		assertEquals(una4x4.getCantMovimientos(), 13);
	}
}
