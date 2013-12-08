package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.TipoAfectables;
import gpschallenge.componentes.vehiculos.Vehiculo;

public class SorpresaDesfavorable implements Afectable {
	/* Representa el valor porcentual de movimientos desfavorables */
	private static int PORCENTAJE_MOVIMIENTOS = 25;

	public SorpresaDesfavorable() {
	}

	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.sumarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.sumarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.sumarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);

	}

	@Override
	public TipoAfectables getTipoAfectables() {
		
		return TipoAfectables.SORPRESADESFAVORABLE;
	}

}
