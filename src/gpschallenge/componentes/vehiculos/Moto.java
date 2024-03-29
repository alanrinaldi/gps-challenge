package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.TipoVehiculo;

public class Moto implements EstadoVehiculo {
	private static Moto unicaInstancia = null;

	private Moto() {
	}

	public static Moto getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new Moto();
		}
		return unicaInstancia;
	}

	public void afectar(Afectable unAfectable, Vehiculo unVehiculo) {
		unAfectable.afectarMoto(unVehiculo);
	}

	/* Devuelve el tipo de auto (enumerado) */
	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.MOTO;
	}
}
