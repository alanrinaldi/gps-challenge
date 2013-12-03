import java.io.PrintWriter;

import gpschallenge.componentes.obstaculos.*;
import gpschallenge.componentes.sorpresas.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.*;

import com.thoughtworks.xstream.XStream;


public class SerializacionEjemplo {
	
	public static void main(String[] args) throws Exception {
		
		XStream xstream = new XStream();
		
		//Voy a serializar la clase Vehiculo y auto
		EstadoVehiculo auto = Auto.getInstancia();		
		Vehiculo vehiculo = Vehiculo.getInstancia();
		vehiculo.setEstado(auto);
		vehiculo.sumarMovimientos(10);
		
		PrintWriter pw = new PrintWriter("serializacionesejemplos/auto.xml");
		xstream.toXML(auto,pw);
		pw.close();
		
		PrintWriter pw2 = new PrintWriter("serializacionesejemplos/vehiculo.xml");
		xstream.toXML(vehiculo,pw2);
		pw2.close();
	
		
		//Serializo obstaculos y sorpresas
		
		SorpresaFavorable sorpresafavorable = new SorpresaFavorable();
		SorpresaDesfavorable sorpresadesfavorable = new SorpresaDesfavorable();
		CambioDeVehiculo cambio = new CambioDeVehiculo();
		
		Pozo pozo = new Pozo();
		Piquete piquete = new Piquete();
		ControlPolicial control = new ControlPolicial();
		
		PrintWriter pw3 = new PrintWriter("serializacionesejemplos/sorpresafavorable.xml");
		xstream.toXML(sorpresafavorable,pw3);
		pw3.close();
		
		PrintWriter pw4 = new PrintWriter("serializacionesejemplos/sorpresadesfavorable.xml");
		xstream.toXML(sorpresadesfavorable,pw4);
		pw4.close();
		
		PrintWriter pw5 = new PrintWriter("serializacionesejemplos/cambiodevehiculo.xml");
		xstream.toXML(cambio,pw5);
		pw5.close();
		
		PrintWriter pw6 = new PrintWriter("serializacionesejemplos/pozo.xml");
		xstream.toXML(pozo,pw6);
		pw6.close();
		
		PrintWriter pw7 = new PrintWriter("serializacionesejemplos/piquete.xml");
		xstream.toXML(piquete,pw7);
		pw7.close();
		
		PrintWriter pw8 = new PrintWriter("serializacionesejemplos/controlpolicial.xml");
		xstream.toXML(control,pw8);
		pw8.close();
		
		//Serializo posicion
		
		Posicion posicion= new Posicion(5,5);
		
		PrintWriter pw9 = new PrintWriter("serializacionesejemplos/posicion.xml");
		xstream.toXML(posicion,pw9);
		pw9.close();
		
		
		
	}
}
