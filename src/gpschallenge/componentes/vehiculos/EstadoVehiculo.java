package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;

public abstract class EstadoVehiculo {
	
	private Posicion ubicacionActual = new Posicion(0,0);
	private Posicion ubicacionAnterior = new Posicion(0,0);
	private int cantMovimientos = 0;
	private boolean demorado = false;
	
	public abstract void afectar(Afectable unAfectable);
	public void reiniciarValoresACero(){
	/* Setea a valores iniciales(cero) */
		this.cantMovimientos = 0;
		this.ubicacionActual = new Posicion(0,0);
		this.ubicacionAnterior = new Posicion(0,0);
		this.demorado = false;
	}
	
	public void sumarMovimientos(int valor){
		cantMovimientos += valor;
	}
	
	public void restarMovimientos(int valor){
		cantMovimientos -= valor;
	}
	
	public int getCantMovimientos(){
		return cantMovimientos;
	}
	
	public void setPosicion(Posicion unaPos){
		this.ubicacionAnterior = this.ubicacionActual;
		this.ubicacionActual = unaPos;
	}
	
	public Posicion getPosicionActual(){
	/* Retorna la posición actual del Vehículo */
		return this.ubicacionActual;
	}
	
	public Posicion getPosicionAnterior(){
		/* Retorna la posición anterior del Vehículo */
			return this.ubicacionAnterior;
	}
	public boolean estaDemorado() {
		return demorado;
	}
	public void demorar() {
		this.demorado = true;
	}
}
