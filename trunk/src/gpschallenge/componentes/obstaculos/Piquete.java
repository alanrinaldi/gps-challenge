package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;

/**
 * @author delpinor
 *
 */
public class Piquete extends Obstaculo implements Afectable{
	private static int VALOR_PENALIZACION = 2;
	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro) {
		unaCuatroXCuatro.setPosicion(unaCuatroXCuatro.getPosicionAnterior());
		
	}

	public void afectarMoto(Moto unaMoto) {
		unaMoto.sumarMovimientos(VALOR_PENALIZACION);
		
	}

	public void afectarAuto(Auto unAuto) {
		unAuto.setPosicion(unAuto.getPosicionAnterior());
		
	}
	
}
