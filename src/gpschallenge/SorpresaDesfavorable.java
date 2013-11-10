package gpschallenge;

public class SorpresaDesfavorable extends Sorpresa {

	int valor;
	
	public SorpresaDesfavorable() {
		valor = 1;
	}
	
	public void aplicarIncidencia(Vehiculo vehiculo){
		
		vehiculo.getEstado().sumarMovimientos(valor);
		
	}
}
