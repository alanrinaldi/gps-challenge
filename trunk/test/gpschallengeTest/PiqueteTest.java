package gpschallengeTest;

import static org.junit.Assert.assertEquals;
import gpschallenge.Auto;
import gpschallenge.CuatroXCuatro;
import gpschallenge.Moto;
import gpschallenge.Piquete;

import org.junit.Before;
import org.junit.Test;

public class PiqueteTest {

	private Piquete unPiquete = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	@Before
	public void setUp(){
		unPiquete = new Piquete();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
	}
	@Test
	public void debePenalizarConDosMovimientosAMotos(){
		unaMoto.sumarMovimientos(12);
		unaMoto.afectar(unPiquete);
		assertEquals(unaMoto.getCantMovimientos(), 14);
	}
	@Test
	public void NoDebePenalizarAVehiculoAutos(){
		unAuto.sumarMovimientos(6);
		unAuto.afectar(unPiquete);
		assertEquals(unAuto.getCantMovimientos(), 6);
	}
	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro(){
		una4x4.sumarMovimientos(6);
		una4x4.afectar(unPiquete);
		assertEquals(una4x4.getCantMovimientos(), 6);
	}
		
}
