package gpschallenge.motor;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.excepciones.ExcedeMaximoAfectablesException;
import gpschallenge.mapa.Calle;
import gpschallenge.mapa.Esquina;

public class Mapa {
	private Meta meta = null;
	private Esquina[][] esquinas;
	private int altoEsquinas;
	private int anchoEsquinas;
	private Vehiculo vehiculo;
	private int separacion;
	private int coordXprimerEsquina;
	private int coordYprimerEsquina;
	private static int X_INICIAL_VEHICULO = 1;
	private static int Y_INICIAL_VEHICULO = 1;
	public Mapa(int ancho, int alto) {
		this.coordXprimerEsquina = 1;
		this.coordYprimerEsquina = 1;
		this.anchoEsquinas = ancho;
		this.altoEsquinas = alto;		
		this.esquinas = new Esquina[anchoEsquinas+1][altoEsquinas+1];
		this.crearEsquinas();
		this.vehiculo = Vehiculo.getInstancia();
	}
	/* Asigna el valor posici�n a la esquina. Las sucesivas esquinas en la matriz de esquinas estar�n separadas por
	* el valor distanciaEntreEsquinas
	*/
	public void setPosicionPrimerEsquina(int x, int y, int distanciaEntreEsquinas){
		this.separacion = distanciaEntreEsquinas;
		this.coordXprimerEsquina = x;
		this.coordYprimerEsquina = y;
		this.actualizarPosiciones();
		if(vehiculo.getEsquinaActual() == null){
			// Posicion inicial del vehiculo
			this.ubicarVehiculo(X_INICIAL_VEHICULO, Y_INICIAL_VEHICULO);
		}else{
			// El vehiculo ya tiene una esquina asignada
			Esquina esquinaAuxiliar = this.getEsquina(vehiculo.getPosicionActual());
			this.vehiculo.setEsquina(esquinaAuxiliar);
		}
		
	}
	/*
	 * Ubica el vehiculo en la posicion de la matriz de esquinas. 
	 * x <= anchoEsquinas, y <= altoEsquinas.
	 */
	private void ubicarVehiculo(int x, int y){
		Esquina unaEsquina = esquinas[x][y];
		vehiculo.setEsquina(unaEsquina);
	}
	
	private void actualizarPosiciones() {
		for (int i = 0; i < anchoEsquinas; i++) {
			for (int j = 0; j < altoEsquinas; j++) {
				Posicion pos = esquinas[i+1][j+1].getPosicion();
				pos.setX(this.coordXprimerEsquina + i*separacion);
				pos.setY(this.coordYprimerEsquina + j*separacion);
			}
		}
		enlazarCallesVertical();
		enlazarCallesHorizontal();
	}
	/*
	 * Agrega una Afectable en una calle de la esquina indicada. y <= altoEsquinas, x <= AnchoEsquinas. En sentido indica
	 * la calle donde se colocar� el afectable. 
	 */
	public void addAfectable(Afectable afectable, int x, int y, Sentido sentido) {
		Esquina esquina = esquinas[x][y];
		Calle calle = esquina.getCalleEnSentido(sentido);
		try {
			calle.addAfectable(afectable);
		} catch (ExcedeMaximoAfectablesException e) {
			e.printStackTrace();
		}
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	/*
	 * Crea las esquinas con sus respectivas posiciones. La primer posicion de
	 * la esquina es 1,1.
	 */
	private void crearEsquinas() {
		Esquina esquina;
		for (int i = 1; i <= anchoEsquinas; i++) {
			for (int j = 1; j <= altoEsquinas; j++) {
				esquina = new Esquina(new Posicion(i*separacion, j*separacion));
				esquina.setCalleEnSentido(new Calle(), Sentido.IZQUIERDA);
				esquina.setCalleEnSentido(new Calle(), Sentido.ARRIBA);
				esquina.setCalleEnSentido(new Calle(), Sentido.DERECHA);
				esquina.setCalleEnSentido(new Calle(), Sentido.ABAJO);
				esquinas[i][j] = esquina;
			}
		}
		enlazarCallesVertical();
		enlazarCallesHorizontal();
	}

	/* Enlaza las calles horizontales de esquinas contiguas. */
	private void enlazarCallesHorizontal() {
		Esquina anterior;
		Esquina siguiente;
		for (int i = 1; i <= altoEsquinas - 1; i++) {
			for (int j = 1; j <= anchoEsquinas; j++) {
				anterior = esquinas[i][j];
				siguiente = esquinas[i + 1][j];
				anterior.setCalleEnSentido(
						siguiente.getCalleEnSentido(Sentido.IZQUIERDA),
						Sentido.DERECHA);
				siguiente.setCalleEnSentido(
						anterior.getCalleEnSentido(Sentido.DERECHA),
						Sentido.IZQUIERDA);
			}
		}
	}

	/* Enlaza las calles verticales de esquinas contiguas. */
	private void enlazarCallesVertical() {
		Esquina anterior;
		Esquina siguiente;
		for (int i = 1; i <= anchoEsquinas; i++) {
			for (int j = 1; j <= altoEsquinas - 1; j++) {
				anterior = esquinas[i][j];
				siguiente = esquinas[i][j + 1];
				anterior.setCalleEnSentido(
						siguiente.getCalleEnSentido(Sentido.ARRIBA),
						Sentido.ABAJO);
				siguiente.setCalleEnSentido(
						anterior.getCalleEnSentido(Sentido.ABAJO),
						Sentido.ARRIBA);
			}
		}
	}

	/* Devuelve la esquina en la posicion indicada del argumento */
	public Esquina getEsquina(Posicion posicion) {
		Esquina esquina = null;
		int i = 1;
		int j = 1;
		boolean encontrado = false;
		while (i <= altoEsquinas && !encontrado) {
			j = 1;
			while (j <= anchoEsquinas && !encontrado) {
				// posicion de la esquina es igual a la buscada
				if (esquinas[i][j].getPosicion().esIgual(posicion)) {
					encontrado = true;
					esquina = esquinas[i][j];
				}
				j++;
			}
			i++;
		}
		return esquina;
	}

	/* Devuelve la Esquina de la posicion x e y en una matriz de esquinas. */
	public Esquina getEsquina(int x, int y) {
		return esquinas[x][y];
	}

	public void setMeta(Meta laMeta) {

		meta = laMeta;
		meta.setPosicion(esquinas[this.anchoEsquinas][this.altoEsquinas].getPosicion());
	}

	public Meta getMeta() {

		return meta;
	}

	public int getAnchoEsquinas() {
		return this.anchoEsquinas;
	}

	public int getAltoEsquinas() {
		return this.altoEsquinas;
	}

}
