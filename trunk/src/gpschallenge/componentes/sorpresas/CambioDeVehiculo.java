package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class CambioDeVehiculo extends Sorpresa {
	
	Regla regla;
	
	EstadoVehiculo nuevoestado;
	
	public void setRegla(Regla unaRegla){
		
		regla = unaRegla;
		
	}
	
	public void aplicarIncidencia(Vehiculo vehiculo){
		
		nuevoestado = regla.obtenerNuevoEestado(vehiculo);
		vehiculo.setEstado(nuevoestado);
		
	}
	
}
