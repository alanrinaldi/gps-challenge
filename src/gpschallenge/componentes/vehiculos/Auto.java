package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.TipoVehiculo;

public class Auto implements EstadoVehiculo {
	private static Auto unicaInstancia = null;

	private Auto() {
	}

	public static Auto getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new Auto();
		}
		return unicaInstancia;
	}

	public void afectar(Afectable unAfectable, Vehiculo unVehiculo) {
		unAfectable.afectarAuto(unVehiculo);
	}

	public String soyUn() {
		return "Auto";
	}

	/* Devuelve el tipo de auto (enumerado) */
	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.AUTO;
	}
}
