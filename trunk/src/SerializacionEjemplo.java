import gpschallenge.componentes.obstaculos.ControlPolicial;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.sorpresas.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.utililidades.ListaJugadores;
import gpschallenge.componentes.utililidades.ListaUsuarios;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;

import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;


public class SerializacionEjemplo {
	
	public static void main(String[] args) throws Exception {
		
		XStream xstream = new XStream();
		
		//Voy a serializar la clase Vehiculo y auto
		EstadoVehiculo auto = Auto.getInstancia();		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setEstado(auto);
		vehiculo.sumarMovimientos(10);
		
		PrintWriter pw = new PrintWriter("Datos/serializacionesejemplos/auto.xml");
		xstream.toXML(auto,pw);
		pw.close();
		
		PrintWriter pw2 = new PrintWriter("Datos/serializacionesejemplos/vehiculo.xml");
		xstream.toXML(vehiculo,pw2);
		pw2.close();
	
		
		//Serializo obstaculos y sorpresas
		
		SorpresaFavorable sorpresafavorable = new SorpresaFavorable();
		SorpresaDesfavorable sorpresadesfavorable = new SorpresaDesfavorable();
		CambioDeVehiculo cambio = new CambioDeVehiculo();
		
		Pozo pozo = new Pozo();
		Piquete piquete = new Piquete();
		ControlPolicial control = new ControlPolicial();
		
		PrintWriter pw3 = new PrintWriter("Datos/serializacionesejemplos/sorpresafavorable.xml");
		xstream.toXML(sorpresafavorable,pw3);
		pw3.close();
		
		PrintWriter pw4 = new PrintWriter("Datos/serializacionesejemplos/sorpresadesfavorable.xml");
		xstream.toXML(sorpresadesfavorable,pw4);
		pw4.close();
		
		PrintWriter pw5 = new PrintWriter("Datos/serializacionesejemplos/cambiodevehiculo.xml");
		xstream.toXML(cambio,pw5);
		pw5.close();
		
		PrintWriter pw6 = new PrintWriter("Datos/serializacionesejemplos/pozo.xml");
		xstream.toXML(pozo,pw6);
		pw6.close();
		
		PrintWriter pw7 = new PrintWriter("Datos/serializacionesejemplos/piquete.xml");
		xstream.toXML(piquete,pw7);
		pw7.close();
		
		PrintWriter pw8 = new PrintWriter("Datos/serializacionesejemplos/controlpolicial.xml");
		xstream.toXML(control,pw8);
		pw8.close();
		
		//Serializo posicion
		
		Posicion posicion= new Posicion(5,5);
		
		PrintWriter pw9 = new PrintWriter("Datos/serializacionesejemplos/posicion.xml");
		xstream.toXML(posicion,pw9);
		pw9.close();
		
		ListaJugadores Lista = new ListaJugadores();
		
		PrintWriter pw10 = new PrintWriter("Datos/juegosguardados/ListaJugadores.xml");
		xstream.toXML(Lista,pw10);
		pw10.close();
		
		ListaUsuarios Lista2 = new ListaUsuarios();
		
		PrintWriter pw11 = new PrintWriter("Datos/juegosguardados/ListaUsuarios.xml");
		xstream.toXML(Lista2,pw11);
		pw11.close();
	}
}
