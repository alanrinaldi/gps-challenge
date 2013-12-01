package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.TipoVehiculo;

public class CuatroXCuatro implements EstadoVehiculo {
	private static CuatroXCuatro unicaInstancia = null;

	private CuatroXCuatro() {
	}

	public static CuatroXCuatro getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new CuatroXCuatro();
		}
		return unicaInstancia;
	}

	public void afectar(Afectable unAfectable, Vehiculo unVehiculo) {
		unAfectable.afectarCuatroXCuatro(unVehiculo);
	}

	@Override
	public String soyUn() {
		return "Cuatro X Cuatro";
	}

	/* Devuelve el tipo de auto (enumerado) */
	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.CUATROXCUATRO;
	}
}
