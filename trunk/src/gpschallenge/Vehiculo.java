package gpschallenge;

public class Vehiculo {
	
	private EstadoVehiculo estadoVehiculo = null;
	public Vehiculo(EstadoVehiculo estado) {
		estadoVehiculo = estado;
		
	}

	public EstadoVehiculo getEstado(){
		
		return estadoVehiculo;
		
	}
	
	public void setEstado (EstadoVehiculo nuevoestado){
		
		estadoVehiculo = nuevoestado;
		
	}

}
