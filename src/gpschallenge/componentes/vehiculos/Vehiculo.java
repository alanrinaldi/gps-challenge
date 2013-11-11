package gpschallenge.componentes.vehiculos;




public class Vehiculo {
	
	private EstadoVehiculo estadoVehiculo = null;
	public Vehiculo(EstadoVehiculo estado) {
		estadoVehiculo = estado;
		
	}

	public EstadoVehiculo getEstado(){
		
		return estadoVehiculo;
		
	}
	
	public void setEstado (EstadoVehiculo nuevoEstado){
		
		estadoVehiculo = nuevoEstado;
		
	}

}
