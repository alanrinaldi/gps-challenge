package gpschallengeTest.deserializacion;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import gpschallenge.componentes.obstaculos.*;
import gpschallenge.componentes.sorpresas.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.*;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DeserializacionTest {

	@Test
	public void DeserializaVehiculoCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		
		assertNotNull(vehiculo);
		assertTrue(vehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));

	}

	@Test
	public void SorpresasFavActuaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		SorpresaFavorable sorpfav = (SorpresaFavorable) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/sorpresafavorable.xml"));
		
		ArrayList<Afectable> afectables=new ArrayList<Afectable>();
		
		afectables.add(sorpfav);
		
		vehiculo.afectar(afectables);

		assertEquals(vehiculo.getCantMovimientos().intValue(), 8);

	}

	@Test
	public void SorpresasDesfavActuaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		SorpresaDesfavorable sorpdesf = (SorpresaDesfavorable) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/sorpresadesfavorable.xml"));

		ArrayList<Afectable> afectables=new ArrayList<Afectable>();
		
		afectables.add(sorpdesf);
		
		vehiculo.afectar(afectables);

		assertEquals(vehiculo.getCantMovimientos().intValue(), 12);
	}

	@Test
	public void CambioActuaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		CambioDeVehiculo cambio = (CambioDeVehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/cambiodevehiculo.xml"));
		CuatroXCuatro camioneta = CuatroXCuatro.getInstancia();

		ArrayList<Afectable> afectables=new ArrayList<Afectable>();
		
		afectables.add(cambio);
		
		vehiculo.afectar(afectables);

		assertEquals(camioneta, vehiculo.getEstado());
	}

	@Test
	public void PozoActuaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		Pozo pozo = (Pozo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/pozo.xml"));

		ArrayList<Afectable> afectables=new ArrayList<Afectable>();
		
		afectables.add(pozo);
		
		vehiculo.afectar(afectables);

		assertEquals(vehiculo.getCantMovimientos().intValue(), 13);

	}

	@Test
	public void PiqueteActuaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		Piquete piquete = (Piquete) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/piquete.xml"));

		ArrayList<Afectable> afectables=new ArrayList<Afectable>();
		
		afectables.add(piquete);
		
		vehiculo.afectar(afectables);

		assertEquals(vehiculo.getCantMovimientos().intValue(), 10);
		assertTrue(vehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
	}

	@Test
	public void ControlActuaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Vehiculo vehiculo = (Vehiculo) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/vehiculo.xml"));
		ControlPolicial control = (ControlPolicial) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/controlpolicial.xml"));

		ArrayList<Afectable> afectables=new ArrayList<Afectable>();
		
		afectables.add(control);
		
		vehiculo.afectar(afectables);

		assertTrue((vehiculo.getCantMovimientos() == 10)
				|| (vehiculo.getCantMovimientos() == 13));
	}

	@Test
	public void PosicionDeserializaCorrectamente() {

		XStream xstream = new XStream(new DomDriver());
		Posicion posicion = (Posicion) xstream
				.fromXML(new File(
						"Datos/serializacionesejemplos/posicion.xml"));

		assertTrue(posicion.esIgual(new Posicion(5, 5)));

		posicion.sumarPosicion(posicion);

		assertTrue(posicion.esIgual(new Posicion(10, 10)));

	}

}
