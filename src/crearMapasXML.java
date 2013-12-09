import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.componentes.utililidades.XML;
import gpschallenge.motor.Mapa;

import java.util.Random;


public class crearMapasXML {
	
	static int ALTO_FACIL = 8;
	static int ALTO_MODERADO = 9;
	static int ALTO_DIFICIL = 11; 
	static Mapa mapa;
	
	public static void main(String[] args) throws Exception {
		
		
		crearMapaModo(Dificultad.DIFICIL);
		XML.guardarObjeto(mapa, "Datos/Mapas/"+Dificultad.DIFICIL+".xml");
	
		
		crearMapaModo(Dificultad.MODERADO);
		XML.guardarObjeto(mapa, "Datos/Mapas/"+Dificultad.MODERADO+".xml");
	
	
		crearMapaModo(Dificultad.FACIL);
		XML.guardarObjeto(mapa, "Datos/Mapas/"+Dificultad.FACIL+".xml");
	}
	
	private static Sentido unSentido(){
		Random random = new Random();
		int i = random.nextInt(3) + 1;
		switch (i) {
		case 1:
			return Sentido.IZQUIERDA;
		case 2:
			return Sentido.ARRIBA;
		case 3:
			return Sentido.ABAJO;
		case 4:
			return Sentido.DERECHA;
		}
		return Sentido.DERECHA;
	}
	
	private static int unaCoordenada(){
		Random random = new Random();
		int i = random.nextInt(mapa.getAltoEsquinas()) + 1;
		int j = random.nextInt(1);
		if(j == 1 && i == mapa.getAltoEsquinas()){
			i = i + 3;
		}
		return i;
	}
	
	private static void crearAfectables(int cantidad, Afectable unAfectable) throws InstantiationException, IllegalAccessException {
		for (int i = 0; i < cantidad; i++) {
			mapa.addAfectable(unAfectable, unaCoordenada(), unaCoordenada(), unSentido());
		}
	
	}
	
	private static void crearMapaModo(Dificultad dif) throws InstantiationException, IllegalAccessException {
		switch (dif) {
		case FACIL:
			mapa = new Mapa(ALTO_FACIL, ALTO_FACIL);
			crearAfectables(20, new Pozo());
			crearAfectables(30, new ControlPolicial());
			crearAfectables(30, new Piquete());
			crearAfectables(20, new SorpresaDesfavorable());
			crearAfectables(30, new SorpresaFavorable());
			crearAfectables(20, new CambioDeVehiculo());
			break;
		case MODERADO:
			mapa = new Mapa(ALTO_MODERADO, ALTO_MODERADO);
			crearAfectables(25, new Pozo());
			crearAfectables(40, new ControlPolicial());
			crearAfectables(40, new Piquete());
			crearAfectables(40, new SorpresaDesfavorable());
			crearAfectables(15, new SorpresaFavorable());
			crearAfectables(40, new CambioDeVehiculo());
			break;
		case DIFICIL:
			mapa = new Mapa(ALTO_DIFICIL, ALTO_DIFICIL);
			crearAfectables(40, new Pozo());
			crearAfectables(50, new ControlPolicial());
			crearAfectables(40, new Piquete());
			crearAfectables(70, new SorpresaDesfavorable());
			crearAfectables(10, new SorpresaFavorable());
			crearAfectables(50, new CambioDeVehiculo());
			break;
		}
	}
}
