package gpschallenge.componentes.vehiculos;

import java.util.ArrayList;
import java.util.Iterator;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.direccionamiento.Direccion;
import gpschallenge.mapa.Esquina;
//import gpschallenge.motor.Mapa;

public class Vehiculo {
	private Esquina ubicacionActual = new Esquina(new Posicion(0,0));
	private Esquina ubicacionAnterior = new Esquina(new Posicion(0,0));
	private EstadoVehiculo estado = null;
	private int cantMovimientos = 0;
//	private Mapa mapa;
	
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
		this.ubicacionActual = new Esquina(new Posicion(0,0));
		this.ubicacionAnterior = new Esquina(new Posicion(0,0));
	}
	
	public void sumarMovimientos(int valor){
		cantMovimientos += valor;
	}
	
	
	 public void restarMovimientos(int valor){
		cantMovimientos -= valor;
	} 
	
	 
	public void sumarPorcentajeMovimientos(int valor){
		int auxiliar = (cantMovimientos*valor)/100;
		this.sumarMovimientos(auxiliar);
	}
	
	public void restarPorcentajeMovimientos(int valor){
		int auxiliar = (cantMovimientos*valor)/100;
		this.restarMovimientos(auxiliar);
	}
	 
	public int getCantMovimientos(){
		return cantMovimientos;
	}
	
	public void setPosicion(Esquina unaEsquina){
		this.ubicacionAnterior = this.ubicacionActual;
		this.ubicacionActual = unaEsquina;
	}
	
	public Esquina getPosicionActual(){
	/* Retorna la posición actual del Vehículo */
		return this.ubicacionActual;
	}
	
	public Esquina getPosicionAnterior(){
		/* Retorna la posición anterior del Vehículo */
			return this.ubicacionAnterior;
	}
	
	public void afectar(Afectable unAfectable){
		estado.afectar(unAfectable, this);
	}
	
	public void afectar(ArrayList<Afectable> afectables){
		
		Iterator<Afectable> it = afectables.iterator();
		while(it.hasNext()){
			estado.afectar(it.next(), this);
		}
	}
	
	public void moverA(Direccion unaDireccion) {
		
		this.ubicacionAnterior = this.ubicacionActual;
		if (this.ubicacionActual.puedeMoverseADireccion(unaDireccion)){
			
			
		
			if (ubicacionActual.devolverCalleEnDireccion(unaDireccion).verificarQueEsquinaEs(ubicacionActual)){
				
				ubicacionActual = ubicacionActual.devolverCalleEnDireccion(unaDireccion).getOtraEsquina();
				this.afectar(ubicacionAnterior.devolverCalleEnDireccion(unaDireccion).getAfectables());
			}
			
			else ubicacionActual = ubicacionActual.devolverCalleEnDireccion(unaDireccion).getUnaEsquina();
		}
		
		this.sumarMovimientos(1);
		/*this.ubicacionActual.sumarPosicion(unaDireccion.obtenerPosicion());
		if (this.mapa.hayObjetosEnPosicion(ubicacionActual)){
			
		}Falta completar el if
		this.ubicacionActual.sumarPosicion(unaDireccion.obtenerPosicion());*/
			
	}
}
