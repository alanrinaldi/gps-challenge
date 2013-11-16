package gpschallenge.componentes.obstaculos;



import gpschallenge.componentes.vehiculos.Vehiculo;

/**
 * @author delpinor
 *
 */
public class Piquete extends Obstaculo implements Afectable{
	
	private static int VALOR_PENALIZACION = 2;
	
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.setPosicion(unVehiculo.getPosicionAnterior());
		
	}

	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		
	}

	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.setPosicion(unVehiculo.getPosicionAnterior());
		
	}
	
}
