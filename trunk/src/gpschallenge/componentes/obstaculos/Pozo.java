package gpschallenge.componentes.obstaculos;

import java.awt.Color;

import javax.swing.JButton;

import gpschallenge.componentes.vehiculos.*;




/**
 * @author delpinor
 *
 */
public class Pozo extends JButton implements Afectable{

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
