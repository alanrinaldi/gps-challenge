package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.Vehiculo;


public interface Afectable{
	public void afectarAuto(Vehiculo unVehiculo);
	public void afectarCuatroXCuatro(Vehiculo unVehiculo);
	public void afectarMoto(Vehiculo unVehiculo);
}
