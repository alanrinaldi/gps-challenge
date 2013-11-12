package gpschallenge.componentes.vehiculos;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.direccionamiento.Direccion;
import gpschallenge.motor.Mapa;

public class Vehiculo {
	private Posicion ubicacionActual = new Posicion(0,0);
	private Posicion ubicacionAnterior = new Posicion(0,0);
	private EstadoVehiculo estado = null;
	private int cantMovimientos = 0;
	private Mapa mapa;
	
	public Vehiculo(){}
	
	public Vehiculo(EstadoVehiculo unEstado){
		this.estado = unEstado;
	}
	
	public void setEstado(EstadoVehiculo unEstado){
		this.estado = unEstado;
	}
	
	public EstadoVehiculo getEstado(){
		return this.estado;
	}
	
	public void reiniciarValoresACero(){
	/* Setea a valores iniciales(cero) */
		this.cantMovimientos = 0;
		this.ubicacionActual = new Posicion(0,0);
		this.ubicacionAnterior = new Posicion(0,0);
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
	public void afectar(Afectable unAfectable){
		estado.afectar(unAfectable, this);
	}
	
	public void moverA(Direccion unaDireccion){
		
		this.ubicacionAnterior = this.ubicacionActual;
		this.ubicacionActual.sumarPosicion(unaDireccion.obtenerPosicion());
		if (this.mapa.hayObjetosEnPosicion(ubicacionActual)){
			this.mapa.aplicarIncidenciasEnPosicion(ubicacionActual,this);
		}/*Falta completar el if */
		this.ubicacionActual.sumarPosicion(unaDireccion.obtenerPosicion());
		
	}
}
