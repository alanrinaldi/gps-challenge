import java.io.PrintWriter;
import java.util.Random;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.utililidades.Sentido;
import gpschallenge.motor.Mapa;

import com.thoughtworks.xstream.XStream;


public class crearMapasXML {
	
	static int ALTO_FACIL = 7;
	static int ALTO_MODERADO = 8;
	static int ALTO_DIFICIL = 10; 
	static Mapa mapa;
	
	public static void main(String[] args) throws Exception {
		
		XStream xstream = new XStream();
		
		crearMapaModo(Dificultad.DIFICIL);
		PrintWriter pw1 = new PrintWriter("Mapas/"+Dificultad.DIFICIL+".xml");
		xstream.toXML(mapa,pw1);
		pw1.close();
		
		crearMapaModo(Dificultad.MODERADO);
		PrintWriter pw2 = new PrintWriter("Mapas/"+Dificultad.MODERADO+".xml");
		xstream.toXML(mapa,pw2);
		pw2.close();
	
		crearMapaModo(Dificultad.FACIL);
		PrintWriter pw3 = new PrintWriter("Mapas/"+Dificultad.FACIL+".xml");
		xstream.toXML(mapa,pw3);
		pw3.close();
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
			crearAfectables(20, new ControlPolicial());
			crearAfectables(20, new Piquete());
			crearAfectables(10, new SorpresaDesfavorable());
			crearAfectables(30, new SorpresaFavorable());
			crearAfectables(20, new CambioDeVehiculo());
			break;
		case MODERADO:
			mapa = new Mapa(ALTO_MODERADO, ALTO_MODERADO);
			crearAfectables(25, new Pozo());
			crearAfectables(25, new ControlPolicial());
			crearAfectables(25, new Piquete());
			crearAfectables(20, new SorpresaDesfavorable());
			crearAfectables(20, new SorpresaFavorable());
			crearAfectables(35, new CambioDeVehiculo());
			break;
		case DIFICIL:
			mapa = new Mapa(ALTO_DIFICIL, ALTO_DIFICIL);
			crearAfectables(40, new Pozo());
			crearAfectables(40, new ControlPolicial());
			crearAfectables(40, new Piquete());
			crearAfectables(50, new SorpresaDesfavorable());
			crearAfectables(10, new SorpresaFavorable());
			crearAfectables(40, new CambioDeVehiculo());
			break;
		}
	}
}
