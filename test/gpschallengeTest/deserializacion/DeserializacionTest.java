package gpschallengeTest.deserializacion;

import static org.junit.Assert.*;

import java.io.File;

import gpschallenge.componentes.obstaculos.*;
import gpschallenge.componentes.sorpresas.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.*;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DeserializacionTest {
	
	@Test
	public void DeserializaVehiculoCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		
		assertNotNull(vehiculo);
		assertTrue(vehiculo.getPosicionActual().esIgual(new Posicion(0,0)));
			
	}
	
	@Test
	public void SorpresasFavActuaCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		SorpresaFavorable sorpfav = (SorpresaFavorable)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/sorpresafavorable.xml"));
		
		vehiculo.afectar(sorpfav);
		
		assertEquals(vehiculo.getCantMovimientos(),8);
		
	}
	
	@Test
	public void SorpresasDesfavActuaCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		SorpresaDesfavorable sorpdesf = (SorpresaDesfavorable)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/sorpresadesfavorable.xml"));
		
		vehiculo.afectar(sorpdesf);
		
		assertEquals(vehiculo.getCantMovimientos(),12);
	}
	
	@Test
	public void CambioActuaCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		CambioDeVehiculo cambio = (CambioDeVehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/cambiodevehiculo.xml"));
		CuatroXCuatro camioneta = CuatroXCuatro.getInstancia();
		
		vehiculo.afectar(cambio);
		
		assertEquals(camioneta,vehiculo.getEstado());
	}
	
	@Test
	public void PozoActuaCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		Pozo pozo = (Pozo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/pozo.xml"));
	
		vehiculo.afectar(pozo);
		
		assertEquals(vehiculo.getCantMovimientos(),13);
		
	}
	
	@Test
	public void PiqueteActuaCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		Piquete piquete = (Piquete)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/piquete.xml"));
	
		vehiculo.afectar(piquete);
		
		assertEquals(vehiculo.getCantMovimientos(),10);
		assertTrue(vehiculo.getPosicionActual().esIgual(new Posicion(0,0)));
	}
	
	@Test
	public void ControlActuaCorrectamente(){
		
		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/vehiculo.xml"));
		ControlPolicial control = (ControlPolicial)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/controlpolicial.xml"));
	
		vehiculo.afectar(control);
		
		assertTrue((vehiculo.getCantMovimientos()==10)||(vehiculo.getCantMovimientos()==13));	
	}
	
	@Test
	public void PosicionDeserializaCorrectamente(){
	
		XStream xstream = new XStream(new DomDriver());
		Posicion posicion = (Posicion)xstream.fromXML(new File("C:/Users/Alan/Documents/SVN/serializacionesejemplos/posicion.xml"));
		
		assertTrue(posicion.esIgual(new Posicion(5,5)));
		
		posicion.sumarPosicion(posicion);
		
		assertTrue(posicion.esIgual(new Posicion(10,10)));
		
	}
	
}
