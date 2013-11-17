package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Calc;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class SorpresaFavorable extends Sorpresa implements Afectable {
	/* Representa el valor porcentual de movimientos favorables */
	private static int PORCENTAJE_MOVIMIENTOS = 20;
	
	public SorpresaFavorable() {
	}

	public void afectarAuto(Vehiculo unVehiculo) {
	/* Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.restarMovimientos(Calc.calcularPorcentaje(PORCENTAJE_MOVIMIENTOS, unVehiculo.getCantMovimientos()));
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
	/* Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.restarMovimientos(Calc.calcularPorcentaje(PORCENTAJE_MOVIMIENTOS, unVehiculo.getCantMovimientos()));
	}

	public void afectarMoto(Vehiculo unVehiculo) {
	/* Resta el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.restarMovimientos(Calc.calcularPorcentaje(PORCENTAJE_MOVIMIENTOS, unVehiculo.getCantMovimientos()));
		
	}
}
