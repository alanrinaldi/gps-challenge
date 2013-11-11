package gpschallenge.direccionamiento;

import gpschallenge.componentes.utililidades.Posicion;

public class Arriba implements Direccion {

	int x;
	int y;
	Posicion posicion;
	
	public Arriba() {
		x=0;
		y=1;
		
		posicion= new Posicion (x,y);
	}
	
	@Override
	public Posicion obtenerPosicion() {
		
		return this.posicion;
	}

}
