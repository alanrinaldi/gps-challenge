package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.Vehiculo;

/**
 * @author delpinor
 * 
 */
public class ControlPolicial implements Afectable {
	private static int VALOR_PENALIZACION = 3;
	private static double PROBABILIDAD_MOTO = 0.8;
	private static double PROBABILIDAD_AUTO = 0.5;
	private static double PROBABILIDAD_CUATROPORCUATRO = 0.3;

	public ControlPolicial() {
	}

	private boolean afectaVehiculo(double unValor) {
		return (Math.random() < unValor ? true : false);
	}

	/*
	 * Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION.
	 * /* La probabilidad de ser penalizado depende del valor
	 * PROBABILIDAD_CUATROPORCUATRO
	 */
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		if (afectaVehiculo(PROBABILIDAD_CUATROPORCUATRO)) {
			unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		}
	}

	/*
	 * Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION.
	 * /* La probabilidad de ser penalizado depende del valor PROBABILIDAD_MOTO
	 */
	public void afectarMoto(Vehiculo unVehiculo) {
		if (afectaVehiculo(PROBABILIDAD_MOTO)) {
			unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		}

	}

	/*
	 * Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION.
	 * /* La probabilidad de ser penalizado depende del valor PROBABILIDAD_AUTO
	 */
	public void afectarAuto(Vehiculo unVehiculo) {
		if (afectaVehiculo(PROBABILIDAD_AUTO)) {
			unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		}
	}

}
