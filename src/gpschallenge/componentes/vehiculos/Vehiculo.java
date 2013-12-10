package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.utililidades.TipoVehiculo;
import gpschallenge.mapa.Esquina;

import java.util.ArrayList;
import java.util.Iterator;

//import gpschallenge.motor.Mapa;

public class Vehiculo {
	private EstadoVehiculo estado = null;
	private Integer cantMovimientos = 0;
	private Posicion posicionActual;
	private Posicion posicionAnterior;
	private Esquina esquinaActual;
	private int cantidad;
	public Vehiculo() {
		this.posicionActual = new Posicion(0, 0);
		this.posicionAnterior = new Posicion(0, 0);
		this.esquinaActual = null;
		this.cantMovimientos = 0;
		this.cantidad = 0;
		this.estado = null;
	}
	public void setEstado(EstadoVehiculo unEstado) {
		this.estado = unEstado;
	}

	public EstadoVehiculo getEstado() {
		return this.estado;
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
			this.setPosicion(this.getPosicionActual());
			this.posicionActual.restarPosicion(0, cantidad);
			break;

		case ABAJO:
			this.setPosicion(this.getPosicionActual());
			this.posicionActual.sumarPosicion(0, cantidad);
			break;
		case IZQUIERDA:
			this.setPosicion(this.getPosicionActual());
			this.posicionActual.restarPosicion(cantidad, 0);
			break;
		case DERECHA:
			this.setPosicion(this.getPosicionActual());
			this.posicionActual.sumarPosicion(cantidad, 0);
			break;
		}
		this.afectar(this.esquinaActual.getCalleEnSentido(sentido).getAfectables());
		this.sumarMovimientos(1);

	}

	public void setPosicion(Posicion unaPos) {
		this.posicionAnterior = new Posicion(unaPos.getX(), unaPos.getY());
		this.posicionActual = new Posicion(unaPos.getX(), unaPos.getY());
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
		if(afectables != null){
		Iterator<Afectable> it = afectables.iterator();
		while (it.hasNext()) {
			estado.afectar(it.next(), this);
		}
		}
	}

	public TipoVehiculo getTipoVehiculo() {
		return estado.getTipoVehiculo();
	}

	public Esquina getEsquinaActual() {
		return esquinaActual;
	}
	
	public void setEsquina(Esquina esquina) {
		Posicion unaPos = esquina.getPosicion();
		this.posicionActual = new Posicion(unaPos.getX(), unaPos.getY());
		this.posicionAnterior = new Posicion(unaPos.getX(), unaPos.getY());
		this.esquinaActual = esquina;
}
}