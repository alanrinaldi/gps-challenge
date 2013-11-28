package gpschallenge.componentes.obstaculos;

import java.awt.Color;

import gpschallenge.componentes.utililidades.ObjetoAfectador;
import gpschallenge.componentes.vehiculos.Vehiculo;
/**
 * @author delpinor
 *
 */
public class ControlPolicial extends ObjetoAfectador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4931703737022248945L;
	private static int VALOR_PENALIZACION = 3;
	private static double PROBABILIDAD_MOTO = 0.8;
	private static double PROBABILIDAD_AUTO = 0.5;
	private static double PROBABILIDAD_CUATROPORCUATRO = 0.3;
	public ControlPolicial(){
		this.setBackground(Color.RED);
		this.setEnabled(false);
	}
	private boolean afectaVehiculo(double unValor){
		return (Math.random() < unValor ? true : false);
	}
	public void afectarCuatroXCuatro(Vehiculo unVehiculo) {
	/* Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION. /*
	 * La probabilidad de ser penalizado depende del valor PROBABILIDAD_CUATROPORCUATRO */
		
		if(afectaVehiculo(PROBABILIDAD_CUATROPORCUATRO)){
			unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		}
	}
	public void afectarMoto(Vehiculo unVehiculo) {
	/* Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION. /*
	 * La probabilidad de ser penalizado depende del valor PROBABILIDAD_MOTO */
		
		if(afectaVehiculo(PROBABILIDAD_MOTO)){
			unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		}
		
	}
	public void afectarAuto(Vehiculo unVehiculo) {
	/* Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION. /*
	 * La probabilidad de ser penalizado depende del valor PROBABILIDAD_AUTO */
		
		if(afectaVehiculo(PROBABILIDAD_AUTO)){
			unVehiculo.sumarMovimientos(VALOR_PENALIZACION);
		}
	}
	
}
