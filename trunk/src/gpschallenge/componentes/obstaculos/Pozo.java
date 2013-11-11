package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.*;




/**
 * @author delpinor
 *
 */
public class Pozo extends Obstaculo implements Afectable{
	private static int VALOR_PENALIZACION = 3;
	public Pozo(){
		
	}
	public void afectarMoto(Moto unaMoto) {
		unaMoto.sumarMovimientos(VALOR_PENALIZACION);
	}

	public void afectarAuto(Auto unAuto) {
		unAuto.sumarMovimientos(VALOR_PENALIZACION);
	}

	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro) {
		unaCuatroXCuatro.sumarMovimientos(0);
	}
	
}
