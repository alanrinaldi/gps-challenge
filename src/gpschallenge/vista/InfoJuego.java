package gpschallenge.vista;

import gpschallenge.componentes.utililidades.TipoVehiculo;

public class InfoJuego {
	private String jugador;
	private TipoVehiculo tipoVehiculo;
	private Integer desafio;
	private Integer movimientos;
	private Integer puntaje;
	public String getJugador() {
		return jugador;
	}
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public Integer getDesafio() {
		return desafio;
	}
	public void setDesafio(int desafio) {
		this.desafio = desafio;
	}
	public Integer getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	

}
