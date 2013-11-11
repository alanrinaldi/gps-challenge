
package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.utililidades.ObjetoDelMapa;

/**
 * @author delpinor
 *
 */
public abstract class Obstaculo extends ObjetoDelMapa {
	private int valorPenalizacion = 0;
	public void setPenalizacion(int valor){
		this.valorPenalizacion = valor;
	}
	public int getPenalizacion(){
		return this.valorPenalizacion;
	}
}
