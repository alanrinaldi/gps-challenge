package gpschallenge.mapa;

import java.util.ArrayList;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.excepciones.EsquinasInvalidasException;

public class Calle {

	private Esquina unaEsquina;
	private Esquina otraEsquina;
	private ArrayList<Afectable> afectables = new ArrayList<Afectable>();
	private ArrayList<Posicion> esquinasposibles = new ArrayList<Posicion>() ;

	
	public Calle(Esquina esquina, Esquina esquina2) throws EsquinasInvalidasException{
		
		esquinasposibles.add(new Posicion (2,0));
		esquinasposibles.add(new Posicion (-2,0));
		esquinasposibles.add(new Posicion (0,-2));
		esquinasposibles.add(new Posicion (0,2));
		
		unaEsquina = esquina;
		otraEsquina = esquina2;
		
		Posicion unaPosicion = unaEsquina.getPosicion().restarPosicion(otraEsquina.getPosicion());
		
		
		if (esquinasposibles.contains(unaPosicion)!= true){
			throw new EsquinasInvalidasException();
			
		}
		
	}
	
	public void addAfectable(Afectable unAfectable) {
		
		afectables.add(unAfectable);
	}
	
	public ArrayList<Afectable> getAfectables() {
		return this.afectables;
		
	}

	public Esquina getUnaEsquina() {
		
		return unaEsquina;
	}
	
	public Esquina getOtraEsquina(){
		
		return otraEsquina;
	}

	public boolean verificarQueEsquinaEs(Esquina esquina) {
		if(esquina == unaEsquina)return true;
		return false;
	}
	
}
