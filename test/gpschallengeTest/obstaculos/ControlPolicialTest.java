package gpschallengeTest.obstaculos;

import static org.junit.Assert.*;

import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
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
	public double porcentajeDeAparicion(EstadoVehiculo unVehiculo){
		double cantidad = 0;
		/* Pruebo 1000 casos y calculo la probabilidad de ser penalizado */
		for(int i = 0; i < 1000; i++){
			unVehiculo.sumarMovimientos(5);
			unVehiculo.afectar(unControlPolicial);
			if(unVehiculo.getCantMovimientos() == 8){
				cantidad += 1;
			}
			unVehiculo.reiniciarValoresACero();
		}
		double valor = cantidad/1000;
		valor = Math.rint(valor*10)/10;
		return valor;
	}
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
	public void probabilidadDeSerPenalizadoAuto(){
		assertTrue(this.porcentajeDeAparicion(unAuto) == 0.5);
	}
	@Test
	public void probabilidadDeSerPenalizadoMoto(){
		assertTrue(this.porcentajeDeAparicion(unaMoto) == 0.8);
	}
	@Test
	public void probabilidadDeSerPenalizadoCuatroXCuatro(){
		assertTrue(this.porcentajeDeAparicion(una4x4) == 0.3);
	}
}
