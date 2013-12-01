package gpschallenge.vista;

import gpschallenge.componentes.utililidades.Posicion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Posicion pos1 = new Posicion(1, 1);
		Posicion pos2 = new Posicion(2, 2);
		Posicion pos3 = new Posicion(3, 3);
		
		pos1 = pos2;
		pos1.sumarPosicion(5, 5);
		
		System.out.println(pos1);
		System.out.println(pos2);
		System.out.println(pos3);
	}

}
