package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.utililidades.TipoVehiculo;
import gpschallenge.mapa.Esquina;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

//import gpschallenge.motor.Mapa;

public class Vehiculo extends Observable {
	private EstadoVehiculo estado = null;
	private Integer cantMovimientos = 0;
	private Posicion posicionActual;
	private Posicion posicionAnterior;
	private Esquina esquinaActual;
	private Esquina esquinaAnterior;
	private int cantidad;

	public Vehiculo(EstadoVehiculo unEstado) {
		this.estado = unEstado;
		this.posicionActual = new Posicion(0, 0);
		this.posicionAnterior = new Posicion(0, 0);
		this.esquinaActual = null;
	}

	public void setEstado(EstadoVehiculo unEstado) {
		this.estado = unEstado;
	}

	public EstadoVehiculo getEstado() {
		return this.estado;
	}

	public void reiniciarValoresACero() {
		/* Setea a valores iniciales(cero) */
		this.cantMovimientos = 0;
		this.posicionActual = new Posicion(0, 0);
		this.posicionAnterior = new Posicion(0, 0);
	}
	public void setValorPorMovimiento(int valor){
		this.cantidad = valor;
	}

	public void sumarMovimientos(int valor) {
		cantMovimientos += valor;
	}

	public void restarMovimientos(int valor) {
		cantMovimientos -= valor;
	}

	public void sumarPorcentajeMovimientos(int valor) {
		int auxiliar = (cantMovimientos * valor) / 100;
		this.sumarMovimientos(auxiliar);
	}

	public void restarPorcentajeMovimientos(int valor) {
		int auxiliar = (cantMovimientos * valor) / 100;
		this.restarMovimientos(auxiliar);
	}

	public Integer getCantMovimientos() {
		return cantMovimientos;
	}

	public void mover(Sentido sentido) {
		switch (sentido) {
		case ARRIBA:
			this.posicionActual.restarPosicion(0, cantidad);
			break;

		case ABAJO:
			this.posicionActual.sumarPosicion(0, cantidad);
			break;
		case IZQUIERDA:
			this.posicionActual.restarPosicion(cantidad, 0);
			break;
		case DERECHA:
			this.posicionActual.sumarPosicion(cantidad, 0);
			break;
		}
		this.afectar(this.esquinaActual.getCalleEnSentido(sentido).getAfectables());
		// detecta si un afectable lo devuelve a la posicion anterior
		if(this.posicionActual.esIgual(this.posicionAnterior)){
			this.posicionActual = new Posicion(this.posicionAnterior.getX(), this.posicionAnterior.getY());
		}else{
			this.posicionAnterior = new Posicion(posicionActual.getX(), posicionActual.getY());
		}
		this.sumarMovimientos(1);
	}

	public void setPosicion(Posicion unaPos) {
		this.posicionAnterior = this.posicionActual;
		this.posicionActual = unaPos;
	}

	public Posicion getPosicionActual() {
		/* Retorna la posición actual del Vehículo */
		return this.posicionActual;
	}

	public Posicion getPosicionAnterior() {
		/* Retorna la posición anterior del Vehículo */
		return this.posicionAnterior;
	}

	public void afectar(ArrayList<Afectable> afectables) {

		Iterator<Afectable> it = afectables.iterator();
		while (it.hasNext()) {
			estado.afectar(it.next(), this);
		}
	}

	public String soyUn() {

		return estado.soyUn();
	}

	public TipoVehiculo getTipoVehiculo() {
		return estado.getTipoVehiculo();
	}

	public Esquina getEsquinaActual() {
		return esquinaActual;
	}
	public Esquina getEsquinaAnterior() {
		return esquinaAnterior;
	}
	
	public void setEsquina(Esquina esquina) {
		this.esquinaActual = esquina;
	}
	public void actualizarObservadores(){
		setChanged();
		this.notifyObservers(this);
	}

}
