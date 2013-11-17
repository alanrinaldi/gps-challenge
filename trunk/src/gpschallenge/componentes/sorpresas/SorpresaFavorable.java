package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class SorpresaFavorable extends Sorpresa implements Afectable {
	/* Representa el valor porcentual de movimientos favorables */
	private static int PORCENTAJE_MOVIMIENTOS = 20;
	
	public SorpresaFavorable() {
	}

	public void afectarAuto(Vehiculo unVehiculo) {
	/* Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.restarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
	/* Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.restarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	public void afectarMoto(Vehiculo unVehiculo) {
	/* Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.restarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
		
	}
}
