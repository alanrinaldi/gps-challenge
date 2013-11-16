package gpschallenge.mapa;

import java.util.HashMap;

import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.direccionamiento.Direccion;

public class Esquina {
	
	private Posicion posicion;
	private HashMap<Direccion,Calle> callesAdyacentes;
	
	public Esquina(Posicion unaPosicion){
		
		posicion = unaPosicion;
		callesAdyacentes = new HashMap<Direccion,Calle>();
		
	}
	
	public void agregarCalle(Direccion unaDireccion, Calle unaCalle){
		
		callesAdyacentes.put(unaDireccion, unaCalle);
			
	}
	
	public Posicion getPosicion(){
		
		return posicion;
		
	}
	
	public boolean puedeMoverseADireccion(Direccion unaDireccion){
		
		if(callesAdyacentes.containsKey(unaDireccion)) return true;
		
		return false;
		
	}
	
	public Calle devolverCalleEnDireccion(Direccion unaDireccion){
		
		return callesAdyacentes.get(unaDireccion);
		
	}

}
