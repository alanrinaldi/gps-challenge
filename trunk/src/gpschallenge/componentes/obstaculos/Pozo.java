package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.vehiculos.Vehiculo;

import java.awt.Color;




/**
 * @author delpinor
 *
 */
public class Pozo extends ObjetoAfectador{

	private static final long serialVersionUID = -8611256347492902590L;
	private static int VALOR_PENALIZACION = 3;
	public Pozo(){
		this.setBackground(Color.BLACK);
		this.setEnabled(false);
	}
	public void afectarMoto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
	}

	public void afectarAuto(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
	}

	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
		unVehiculo.sumarMovimientos(0);
	}
	
}
