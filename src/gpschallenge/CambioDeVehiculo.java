package gpschallenge;

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
