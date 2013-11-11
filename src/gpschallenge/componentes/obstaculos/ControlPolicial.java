package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;
/**
 * @author delpinor
 *
 */
public class ControlPolicial extends Obstaculo implements Afectable {
	private static int VALOR_PENALIZACION = 3;
	private static double PROBABILIDAD_MOTO = 0.8;
	private static double PROBABILIDAD_AUTO = 0.5;
	private static double PROBABILIDAD_CUATROPORCUATRO = 0.3;
	private boolean afectaVehiculo(double unValor){
		return (Math.random() < unValor ? true : false);
	}
	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro) {
	/* Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION. Es probable que quede demorado. /*
	 * La probabilidad que quede demorado depende del valor PROBABILIDAD_CUATROPORCUATRO */
		unaCuatroXCuatro.sumarMovimientos(VALOR_PENALIZACION);
		if(afectaVehiculo(PROBABILIDAD_CUATROPORCUATRO)){
			unaCuatroXCuatro.demorar();
		}
	}
	public void afectarMoto(Moto unaMoto) {
	/* Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION. Es probable que quede demorado. /*
	 * La probabilidad que quede demorado depende del valor PROBABILIDAD_MOTO */
		unaMoto.sumarMovimientos(VALOR_PENALIZACION);
		if(afectaVehiculo(PROBABILIDAD_MOTO)){
			unaMoto.demorar();
		}
		
	}
	public void afectarAuto(Auto unAuto) {
	/* Penaliza con movimientos al vehiculo con la cantidad VALOR_PENALIZACION. Es probable que quede demorado. /*
	 * La probabilidad que quede demorado depende del valor PROBABILIDAD_AUTO */
		unAuto.sumarMovimientos(VALOR_PENALIZACION);
		if(afectaVehiculo(PROBABILIDAD_AUTO)){
			unAuto.demorar();
		}
	}
	
}
