package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;

public class Moto implements EstadoVehiculo {
	private static Moto unicaInstancia = null;
	private Moto(){}
	public static Moto getInstancia(){
		if (unicaInstancia == null){
			unicaInstancia = new Moto();
		}
		return unicaInstancia;
	}
	public void afectar(Afectable unAfectable, Vehiculo unVehiculo) {
		unAfectable.afectarMoto(unVehiculo);
	}
	@Override
	public String soyUn() {
		
		return "Moto";
	}
}

