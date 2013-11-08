package gpschallenge;

public class Vehiculo {

	private Estado estadoVehiculo;
	private int cantMovimientos;
	
	public Vehiculo(Estado estado) {
		estadoVehiculo = estado;
	}

	public Estado getEstado(){
		
		return estadoVehiculo.getEstado();
		
	}
	
	public int getCantMovimientos(){
		
		return cantMovimientos;
		
	}


	
	
	
}
