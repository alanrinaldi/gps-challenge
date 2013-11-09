package gpschallenge;

public class Auto extends EstadoVehiculo {
	private static Auto unicaInstancia = null;
	private Auto(){}
	public static Auto getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new Auto();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable) {
		unAfectable.afectarAuto(this);
	}

}

