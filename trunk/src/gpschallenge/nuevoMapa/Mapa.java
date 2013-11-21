package gpschallenge.nuevoMapa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.nuevoMapa.Esquina;

public class Mapa {

	private int cantCallesHorizontales;
	private int cantCallesVerticales;
	private HashMap<Posicion,Esquina> mapaDeEsquinas;
	
	//CONSTRUCTOR
	/* Se le pasan como parametro la cantidad de calles horizontales y verticales
	 * y a partir de los mismos se crean las esquinas con sus respectivas posiciones
	 */
	public Mapa(int numeroCallesHorizontales, int numeroCallesVerticales){
		cantCallesHorizontales = numeroCallesHorizontales;
		cantCallesVerticales = numeroCallesVerticales;	
		mapaDeEsquinas = new HashMap<Posicion,Esquina>();
		
		//Se crean las esquinas con sus respectivas posiciones
		for (int i=0; i<numeroCallesHorizontales; i++){
			for (int j=0; j<numeroCallesVerticales; j++){
				Posicion unaPosicion = new Posicion(2*i+1,2*j+1);
				mapaDeEsquinas.put(unaPosicion,new Esquina(unaPosicion));
			}
		}
	   acomodarCallesDeEsquinas();
    }

	//A partir de aca se acomodan las calles que tienen las mismas esquinas
	private void acomodarCallesDeEsquinas(){
		for (int i=0; i<cantCallesHorizontales-1; i++){
			for (int j=0; j<cantCallesVerticales-1; j++){
				Posicion unaPosicion1 = new Posicion(2*i+1,2*j+1);
				Posicion unaPosicion2 = new Posicion(2*i+1,2*j+3);
				Posicion unaPosicion3 = new Posicion(2*i+3,2*j+1);
				Posicion unaPosicion4 = new Posicion(2*i+3,2*j+3);
				//La Esquina2 esta a la derecha de la Esquina 1
				//La Esquina3 esta debajo de la Esquina1
				//La Esquina4 esta a la derecha de la Esquina3 y debajo de la Esquina2
                Esquina unaEsquina1 = getEsquina(unaPosicion1); 
                Esquina unaEsquina2 = getEsquina(unaPosicion2); 
                Esquina unaEsquina3 = getEsquina(unaPosicion3); 
                Esquina unaEsquina4 = getEsquina(unaPosicion4); 
                
                //Aca se "enlazan" las calles con las esquinas
                unaPosicion1 = unaEsquina1.getCalleDerecha().getPosicion();
                unaEsquina1.setCalle(unaPosicion1,unaEsquina2.getCalleIzquierda());
                
                unaPosicion1 = unaEsquina2.getCalleAbajo().getPosicion();
                unaEsquina2.setCalle(unaPosicion1,unaEsquina4.getCalleArriba());
                
                unaPosicion1 = unaEsquina4.getCalleIzquierda().getPosicion();
                unaEsquina4.setCalle(unaPosicion1,unaEsquina3.getCalleDerecha());
                
                unaPosicion1 = unaEsquina3.getCalleArriba().getPosicion();
                unaEsquina3.setCalle(unaPosicion1,unaEsquina1.getCalleAbajo());
			}
		}		
	}
	
	// Devuelve una Esquina del mapa según una Posición
	public Esquina getEsquina(Posicion unaPosicion){
		Map.Entry e;
		Iterator it = mapaDeEsquinas.entrySet().iterator();
		while (it.hasNext()){
		       e = (Map.Entry)it.next();
		       if (((Posicion) e.getKey()).esIgual(unaPosicion)){
		    	   return (Esquina) e.getValue();
		       }
		}
		return null;
	}
	
	
	public HashMap<Posicion,Esquina> getHashDeEsquinas(){
		return mapaDeEsquinas;
	}


}