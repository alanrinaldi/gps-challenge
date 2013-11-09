package gpschallenge;

public class CuatroXCuatro extends EstadoVehiculo {
	private static CuatroXCuatro unicaInstancia = null;
	private CuatroXCuatro(){}
	public static CuatroXCuatro getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new CuatroXCuatro();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable) {
		unAfectable.afectarCuatroXCuatro(this);
	}
}

