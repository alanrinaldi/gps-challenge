package gpschallenge;

public class CuatroXCuatro implements EstadoVehiculo {
	private static CuatroXCuatro unicaInstancia = null;
	private CuatroXCuatro(){}
	public static CuatroXCuatro getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new CuatroXCuatro();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable) {
		((AfectableACuatroXCuatro)unAfectable).afectarCuatroXCuatro(this);
	}

}

