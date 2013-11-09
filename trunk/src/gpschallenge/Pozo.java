package gpschallenge;

/**
 * @author delpinor
 *
 */
public class Pozo extends Obstaculo implements Afectable{
	public void afectarMoto(Moto unaMoto) {
		unaMoto.sumarMovimientos(3);
	}

	public void afectarAuto(Auto unAuto) {
		unAuto.sumarMovimientos(3);
	}

	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro) {
		unaCuatroXCuatro.sumarMovimientos(0);
	}
	
}
