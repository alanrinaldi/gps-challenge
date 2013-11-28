package gpschallenge.componentes.obstaculos;



import java.awt.Color;

import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.vehiculos.Vehiculo;

/**
 * @author delpinor
 *
 */
public class Piquete extends ObjetoAfectador{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2175742219721280881L;
	private static int VALOR_PENALIZACION = 2;
	public Piquete(){
		this.setBackground(Color.BLUE);
		this.setEnabled(false);
	}
	
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.setPosicion(unVehiculo.getPosicionAnterior());
		
	}

	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		
	}

	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.setPosicion(unVehiculo.getPosicionAnterior());
		
	}
	
}
