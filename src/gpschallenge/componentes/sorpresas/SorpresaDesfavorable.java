package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.vehiculos.Vehiculo;


public class SorpresaDesfavorable extends Sorpresa {

	int valor;
	
	public SorpresaDesfavorable() {
		valor = 25;
	}
	
	public void aplicarIncidencia(Vehiculo vehiculo){
		
		vehiculo.sumarporcentajeMovimientos(valor);
		
	}
}
