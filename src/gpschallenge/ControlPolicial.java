package gpschallenge;

/**
 * @author delpinor/andresp
 *
 */
public class ControlPolicial extends Obstaculo implements Afectable {
	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro) {
		
		double numeroElegido = Math.random();
		
		if (numeroElegido < 0.3){
			unaCuatroXCuatro.sumarMovimientos(3);
		}
		
			
	}
	
	public void afectarMoto(Moto unaMoto) {
		
		double numeroElegido = Math.random();
		
		if (numeroElegido < 0.8){
			unaMoto.sumarMovimientos(3);
		}
	}
		
	public void afectarAuto(Auto unAuto) {

		double numeroElegido = Math.random();
		
		if (numeroElegido < 0.5){
			unAuto.sumarMovimientos(3);
		}
	}
}
