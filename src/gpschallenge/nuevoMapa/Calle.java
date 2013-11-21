package gpschallenge.nuevoMapa;


import gpschallenge.componentes.utililidades.Posicion;

public class Calle {
	private Posicion unaPosicion;
	
	
	public Calle(Posicion unaPos){
		unaPosicion = unaPos;

	}
	
	public Posicion getPosicion(){
		return unaPosicion;
	}


}