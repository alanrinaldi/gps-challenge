package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.mapa.EsquinaT;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import gpschallenge.motor.Mapa;

public class Vehiculo extends JLabel {
	private static final long serialVersionUID = -2393117504290151547L;
	private EstadoVehiculo estado = null;
	private int cantMovimientos = 0;
	private Posicion ubicacionActual;
	private Posicion ubicacionAnterior;
	private EsquinaT esquinaActual;

	public Vehiculo() {
		this.ubicacionActual = new Posicion(0,0);
		this.ubicacionAnterior = new Posicion(0, 0);
		
		/* Esta imagne debería venir con la instancia de auto, moto o 4x4*/
		this.setIcon(new ImageIcon(getClass().getResource(
				"/gpschallenge/imagenes/auto.png")));
		this.setBackground(Color.white);
	}

	public Vehiculo(EstadoVehiculo unEstado) {
		this.estado = unEstado;
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
		this.ubicacionActual = new Posicion(0, 0);
		this.ubicacionAnterior = new Posicion(0, 0);
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

	public int getCantMovimientos() {
		return cantMovimientos;
	}

	public void setPosicion(Posicion unaPos) {
		this.ubicacionAnterior = this.ubicacionActual;
		this.ubicacionActual = unaPos;
	}

	public Posicion getPosicionActual() {
		/* Retorna la posición actual del Vehículo */
		return this.ubicacionActual;
	}

	public Posicion getPosicionAnterior() {
		/* Retorna la posición anterior del Vehículo */
		return this.ubicacionAnterior;
	}

	public void afectar(Afectable unAfectable) {
		estado.afectar(unAfectable, this);
	}

	public void afectar(ArrayList<Afectable> afectables) {

		Iterator<Afectable> it = afectables.iterator();
		while (it.hasNext()) {
			estado.afectar(it.next(), this);
		}
	}

	public EsquinaT getEsquinaActual() {
		return esquinaActual;
	}

	public void setEsquinaActual(EsquinaT esquina) {
		this.esquinaActual = esquina;
	}


}
