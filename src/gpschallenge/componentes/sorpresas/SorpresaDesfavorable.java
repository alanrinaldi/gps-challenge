package gpschallenge.componentes.sorpresas;

import java.awt.Color;

import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.vehiculos.Vehiculo;

public class SorpresaDesfavorable extends ObjetoAfectador{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6884116856710424960L;
	/* Representa el valor porcentual de movimientos desfavorables */
	private static int PORCENTAJE_MOVIMIENTOS = 25;
	
	public SorpresaDesfavorable() {

		this.setBackground(Color.YELLOW);
		this.setEnabled(false);
	}

	public void afectarAuto(Vehiculo unVehiculo) {
	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.sumarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.sumarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
	}

	public void afectarMoto(Vehiculo unVehiculo) {
	/* Suma el PORCENTAJE_MOVIMIENTOS, a la cantidad de movimientos del vehiculo */
		unVehiculo.sumarPorcentajeMovimientos(PORCENTAJE_MOVIMIENTOS);
		
	}
}
