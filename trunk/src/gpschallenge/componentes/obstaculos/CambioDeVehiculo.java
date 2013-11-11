package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.sorpresas.Regla;
import gpschallenge.componentes.sorpresas.Sorpresa;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class CambioDeVehiculo extends Sorpresa {
	
	Regla regla;
	
	EstadoVehiculo nuevoestado;
	
	public void setRegla(Regla unaRegla){
		
		regla = unaRegla;
		
	}
	
	public void aplicarIncidencia(Vehiculo vehiculo){
		
		nuevoestado = regla.obtenernuevoestado(vehiculo);
		vehiculo.setEstado(nuevoestado);
		
	}
	
}
