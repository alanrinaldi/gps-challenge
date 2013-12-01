package gpschallenge.mapa;

import gpschallenge.componentes.obstaculos.Afectable;

import java.util.ArrayList;

public class Calle {

	private ArrayList<Afectable> afectables = new ArrayList<Afectable>();

	public Calle() {

	}

	public void addAfectable(Afectable unAfectable) {

		afectables.add(unAfectable);
	}

	public ArrayList<Afectable> getAfectables() {
		return this.afectables;

	}

}
