package gpschallenge;

public class Moto implements EstadoVehiculo {
	private static Moto unicaInstancia = null;
	private Moto(){}
	public static Moto getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new Moto();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable) {
		((AfectableAMoto)unAfectable).afectarMoto(this);
		
	}

}

