package gpschallenge;

/**
 * @author delpinor
 *
 */
public class Piquete extends Obstaculo implements Afectable{
	@Override
	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro) {
		// No hace nada, no suma movimiento y mantiene la posicion actual
		
	}

	@Override
	public void afectarMoto(Moto unaMoto) {
		
		unaMoto.sumarMovimientos(2);
		
	}

	@Override
	public void afectarAuto(Auto unAuto) {
		// No hace nada, no suma movimiento y mantiene la posicion actual
		
	}
	
}
