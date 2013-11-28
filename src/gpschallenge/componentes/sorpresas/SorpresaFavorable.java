package gpschallenge.componentes.sorpresas;

import java.awt.Color;

import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class SorpresaFavorable extends ObjetoAfectador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8578563005996279811L;
	/* Representa el valor porcentual de movimientos favorables */
	private static int PORCENTAJE_MOVIMIENTOS = 20;
	
	public SorpresaFavorable() {

		this.setBackground(Color.GREEN);
		this.setEnabled(false);
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
