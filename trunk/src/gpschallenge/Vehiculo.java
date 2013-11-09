package gpschallenge;

public class Vehiculo {

	private EstadoVehiculo estadoVehiculo;
	private int cantMovimientos;
	
	public Vehiculo(EstadoVehiculo estado) {
		estadoVehiculo = estado;
	}

	public EstadoVehiculo getEstado(){
		
		return estadoVehiculo;
		
	}
	
	public int getCantMovimientos(){
		
		return cantMovimientos;
		
	}


	
	
	
}
