package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.AfectableTipo;
import gpschallenge.componentes.vehiculos.Vehiculo;

public class SorpresaFavorable implements Afectable {
	/* Representa el valor porcentual de movimientos favorables */
	private static int PORCENTAJE_MOVIMIENTOS = 20;

	public SorpresaFavorable() {
	}

	/*
	 * Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del
	 * vehiculo
	 */
	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.restarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	/*
	 * Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del
	 * vehiculo
	 */
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.restarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	/*
	 * Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del
	 * vehiculo
	 */
	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.restarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);

	}

	@Override
	public AfectableTipo getTipo() {
		// TODO Auto-generated method stub
		return AfectableTipo.SORPRESAFAVORABLE;
	}
}
