package gpschallenge.direccionamiento;

import gpschallenge.componentes.utililidades.Posicion;

public class Izquierda implements Direccion {

	int x;
	int y;
	Posicion posicion;
	
	public Izquierda() {
		x=-1;
		y=0;
		
		posicion= new Posicion (x,y);
	}
	
	@Override
	public Posicion obtenerPosicion() {
		
		return this.posicion;
	}

}
