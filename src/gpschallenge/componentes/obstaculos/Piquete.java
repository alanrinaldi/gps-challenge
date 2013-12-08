package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.TipoAfectables;
import gpschallenge.componentes.vehiculos.Vehiculo;

/**
 * @author delpinor
 * 
 */
public class Piquete implements Afectable {

	private static int VALOR_PENALIZACION = 2;

	public Piquete() {
	}

	/*
	 * Afecta a los vehiculo de tipo CuatroXCuatro. Los devuelve a la posicion
	 * anterior
	 */
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		Posicion pos = unVehiculo.getPosicionAnterior();
		unVehiculo.setPosicion(new Posicion(pos.getX(), pos.getY()));

	}

	/* Afecta a los vehiculo de tipo Moto. Penaliza con movimientos */
	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);

	}

	/* Afecta a los vehiculo de tipo Auto. Los devuelve a la posicion anterior */
	public void afectarAuto(Vehiculo unVehiculo) {
		Posicion pos = unVehiculo.getPosicionAnterior();
		unVehiculo.setPosicion(new Posicion(pos.getX(), pos.getY()));

	}

	@Override
	public TipoAfectables getTipoAfectables() {
		
		return TipoAfectables.PIQUETE;
	}


}
