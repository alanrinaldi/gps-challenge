package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class CambioDeVehiculo extends Sorpresa implements Afectable {	
	public CambioDeVehiculo() {
	}
	public void afectarAuto(Vehiculo unVehiculo) {
	/* Realiza el cambio de estado al vehiculo. Pasa a ser una CuatroXCuatro*/
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
	/* Realiza el cambio de estado al vehiculo. Pasa a ser una moto*/
		unVehiculo.setEstado(Moto.getInstancia());
	}

	public void afectarMoto(Vehiculo unVehiculo) {
	/* Realiza el cambio de estado al vehiculo. Pasa a ser un auto*/
	unVehiculo.setEstado(Auto.getInstancia());
		
	}
}
