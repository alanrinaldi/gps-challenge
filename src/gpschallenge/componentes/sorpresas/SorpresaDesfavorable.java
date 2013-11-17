package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Calc;
import gpschallenge.componentes.vehiculos.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa implements Afectable {
	/* Representa el valor porcentual de movimientos desfavorables */
	private static int PORCENTAJE_MOVIMIENTOS = 25;
	
	public SorpresaDesfavorable() {
	}

	public void afectarAuto(Vehiculo unVehiculo) {
	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.sumarMovimientos(Calc.calcularPorcentaje(PORCENTAJE_MOVIMIENTOS, unVehiculo.getCantMovimientos()));
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.sumarMovimientos(Calc.calcularPorcentaje(PORCENTAJE_MOVIMIENTOS, unVehiculo.getCantMovimientos()));
	}

	public void afectarMoto(Vehiculo unVehiculo) {
	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.sumarMovimientos(Calc.calcularPorcentaje(PORCENTAJE_MOVIMIENTOS, unVehiculo.getCantMovimientos()));
		
	}
}
