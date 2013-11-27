package gpschallenge.mapa;

import gpschallenge.componentes.obstaculos.Afectable;

import java.util.ArrayList;

public class CalleT {

	private ArrayList<Afectable> afectables = new ArrayList<Afectable>();
	
	public CalleT(){

	}
		
	public void addAfectable(Afectable unAfectable) {
		
		afectables.add(unAfectable);
	}
	
	public ArrayList<Afectable> getAfectables() {
		return this.afectables;
		
	}
	
}
