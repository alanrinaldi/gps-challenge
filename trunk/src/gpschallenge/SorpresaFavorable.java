package gpschallenge;

public class SorpresaFavorable extends Sorpresa {
	
	int valor;
	
	public SorpresaFavorable() {
		valor=1;
	}
	
	public void aplicarIncidencia(Vehiculo vehiculo){
		
		vehiculo.getEstado().restarMovimientos (valor);
		
	}
}
