package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.vehiculos.Vehiculo;



public class SorpresaFavorable extends Sorpresa {
	
	int valor;
	
	public SorpresaFavorable() {
		valor=20;
	}
	
	public void aplicarIncidencia(Vehiculo vehiculo){
		
		vehiculo.restarporcentajeMovimientos(valor);
		
	}
}
