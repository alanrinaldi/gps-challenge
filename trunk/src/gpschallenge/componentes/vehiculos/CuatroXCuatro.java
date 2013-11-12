package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;

public class CuatroXCuatro implements EstadoVehiculo {
	private static CuatroXCuatro unicaInstancia = null;
	private CuatroXCuatro(){}
	public static CuatroXCuatro getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new CuatroXCuatro();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable, Vehiculo unVehiculo) {
		unAfectable.afectarCuatroXCuatro(unVehiculo);
	}
}

