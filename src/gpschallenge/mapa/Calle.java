package gpschallenge.mapa;

import java.util.ArrayList;

import gpschallenge.componentes.obstaculos.Afectable;

public class Calle {

	private Esquina unaEsquina;
	private Esquina otraEsquina;
	private ArrayList<Afectable> afectables = new ArrayList<Afectable>();
	
	public Calle(Esquina esquina, Esquina esquina2){
		
		unaEsquina = esquina;
		otraEsquina = esquina2;
	}
	
	public void addAfectable(Afectable unAfectable){
		
		afectables.add(unAfectable);
	}
	public ArrayList<Afectable> getAfectables(){
		return this.afectables;
		
	}

	public Esquina getUnaEsquina(){
		
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
