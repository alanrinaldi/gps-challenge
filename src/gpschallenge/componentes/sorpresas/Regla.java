package gpschallenge.componentes.sorpresas;

import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;



public class Regla {
	
	EstadoVehiculo estado;
	EstadoVehiculo nuevoestado;
	EstadoVehiculo auto = Auto.getInstancia();
	EstadoVehiculo moto = Moto.getInstancia();
	EstadoVehiculo cuatroxcuatro = CuatroXCuatro.getInstancia();
	
	public EstadoVehiculo obtenerNuevoEestado (Vehiculo vehiculo) {
			
		estado = vehiculo.getEstado();
		
		if (estado == auto) {
			nuevoestado = CuatroXCuatro.getInstancia(); 
		}
		else {
			if (estado == moto){
				nuevoestado = Auto.getInstancia();
			}
			else {
				nuevoestado = CuatroXCuatro.getInstancia();
			}
		}
		
		return nuevoestado;
		
	}

}
