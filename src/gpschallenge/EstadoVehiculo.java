package gpschallenge;

public abstract class EstadoVehiculo {
	
	private Posicion ubicacionActual = new Posicion(0,0);
	private Posicion ubicacionAnterior = new Posicion(0,0);
	private int cantMovimientos = 0;
	
	public abstract void afectar(Afectable unAfectable);
	
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
	/* Retorna la posici�n actual del Veh�culo */
		return this.ubicacionActual;
	}
	
	public Posicion getPosicionAnterior(){
		/* Retorna la posici�n anterior del Veh�culo */
			return this.ubicacionAnterior;
	}
}
