package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;

import java.awt.Color;



public class CambioDeVehiculo extends ObjetoAfectador{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5658207660674294873L;

	public CambioDeVehiculo() {

		this.setBackground(Color.PINK);
		this.setEnabled(false);
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
