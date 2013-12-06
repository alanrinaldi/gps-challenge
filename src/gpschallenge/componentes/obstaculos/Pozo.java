package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.Vehiculo;

/**
 * @author delpinor
 * 
 */
public class Pozo implements Afectable {
	private static int VALOR_PENALIZACION = 3;

	public Pozo() {

	}

	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
	}

	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(0);
	}
}
