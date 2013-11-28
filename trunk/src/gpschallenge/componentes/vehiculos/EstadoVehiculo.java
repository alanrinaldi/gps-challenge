package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;

public interface EstadoVehiculo {
		public void afectar(Afectable unAfectable, Vehiculo unVehiculo);
		public String soyUn();
		public String getImagen();
}
