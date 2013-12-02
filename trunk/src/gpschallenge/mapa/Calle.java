package gpschallenge.mapa;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.excepciones.ExcedeMaximoAfectablesException;

import java.util.ArrayList;

public class Calle {
	private static int MAX_AFECTABLES = 2;
	private ArrayList<Afectable> afectables;

	public Calle() {
		this.afectables = new ArrayList<Afectable>();

	}

	public void addAfectable(Afectable unAfectable) throws ExcedeMaximoAfectablesException {
		if(afectables.size() < MAX_AFECTABLES){
			afectables.add(unAfectable);
		}else{
			throw new ExcedeMaximoAfectablesException();
		}
	}

	public ArrayList<Afectable> getAfectables() {
		return this.afectables;

	}

}
