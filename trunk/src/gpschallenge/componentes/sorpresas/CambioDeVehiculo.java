package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.AfectableTipo;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;

public class CambioDeVehiculo implements Afectable {
	public CambioDeVehiculo() {
	}

	/* Realiza el cambio de estado al vehiculo. Pasa a ser una CuatroXCuatro */
	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
	}

	/* Realiza el cambio de estado al vehiculo. Pasa a ser una moto */
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.setEstado(Moto.getInstancia());
	}

	/* Realiza el cambio de estado al vehiculo. Pasa a ser un auto */
	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.setEstado(Auto.getInstancia());

	}

	@Override
	public AfectableTipo getTipo() {
		// TODO Auto-generated method stub
		return AfectableTipo.CAMBIODEVEHICULO;
	}
}
