package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.TipoVehiculo;

public interface EstadoVehiculo {
	public void afectar(Afectable unAfectable, Vehiculo unVehiculo);

	public String soyUn();

	public TipoVehiculo getTipoVehiculo();
}
