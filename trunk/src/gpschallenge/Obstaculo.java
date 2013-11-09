
package gpschallenge;

/**
 * @author delpinor
 *
 */
public abstract class Obstaculo extends ObjetoDelMapa {
	private int valorPenalizacion;
	public void setPenalizacion(int valor){
		this.valorPenalizacion = valor;
	}
	public int getPenalizacion(){
		return this.valorPenalizacion;
	}
}
