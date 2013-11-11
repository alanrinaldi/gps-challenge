package gpschallengeTest.obstaculos;
import static org.junit.Assert.assertEquals;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;

import org.junit.Before;
import org.junit.Test;

/**
 * @author delpinor
 *
 */
public class PozoTest {
	private Pozo unPozo = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	@Before
	public void setUp(){
		unPozo = new Pozo();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
	}
	@Test
	public void debePenalizarConTresMovimientosAMotos(){
		unaMoto.sumarMovimientos(12);
		unaMoto.afectar(unPozo);
		assertEquals(unaMoto.getCantMovimientos(), 15);
	}
	@Test
	public void debePenalizarConTresMovimientosAAutos(){
		unAuto.sumarMovimientos(6);
		unAuto.afectar(unPozo);
		assertEquals(unAuto.getCantMovimientos(), 9);
	}
	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro(){
		una4x4.sumarMovimientos(6);
		una4x4.afectar(unPozo);
		assertEquals(una4x4.getCantMovimientos(), 6);
	}
}
