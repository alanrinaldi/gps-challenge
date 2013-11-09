package gpschallenge;

public class Moto extends EstadoVehiculo {
	private static Moto unicaInstancia = null;
	private Moto(){}
	public static Moto getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new Moto();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable) {
		unAfectable.afectarMoto(this);
	}
}

