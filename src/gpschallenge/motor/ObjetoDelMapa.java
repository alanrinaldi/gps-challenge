package gpschallenge.motor;

import gpschallenge.componentes.utililidades.Posicion;



/**
 * @author delpinor
 *
 */
public abstract class ObjetoDelMapa {
	private Posicion ubicacion;
	public void setPosicion(Posicion unaPos){
		this.ubicacion = unaPos;
	}
	public Posicion getPosicion(){
		return this.ubicacion;
	}
}
