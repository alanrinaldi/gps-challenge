package gpschallengeTest.pruebasGenerales;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.direccionamiento.Derecha;
import gpschallenge.direccionamiento.Direccion;
import gpschallenge.direccionamiento.Izquierda;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.mapa.Calle;
import gpschallenge.mapa.Esquina;
import gpschallenge.motor.Mapa;

public class PruebasGeneralesTest {
	
	private Mapa unMapa = null;
	@Before
	public void setUp(){
		unMapa = Mapa.getInstancia();
	}
	
	@Test
	public void crearMapaConEsquinasYMoverse(){
		
		Direccion derecha = new Derecha();
		Direccion izquierda = new Izquierda();
		
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,2);
		
		Esquina unaEsquina = new Esquina(unaPosicion);
		Esquina otraEsquina = new Esquina(otraPosicion);
		
		Pozo unPozo = new Pozo();
		
		try {
			Calle unaCalle = new Calle(unaEsquina,otraEsquina);
			unaCalle.addAfectable(unPozo);
			unaEsquina.agregarCalle(derecha , unaCalle);
			otraEsquina.agregarCalle(izquierda, unaCalle);
			
			unMapa.agregarEsquina(unaEsquina);
			unMapa.agregarEsquina(otraEsquina);
			
			unMapa.setEsquinaInicial(unaEsquina);
			
			EstadoVehiculo auto = Auto.getInstancia();
			Vehiculo vehiculo = new Vehiculo(auto);
			
			vehiculo.setPosicion(unMapa.getEsquinaInicial());
			
			vehiculo.moverA(derecha);
			
			assertEquals(4,vehiculo.getCantMovimientos());
			
		} catch (EsquinasInvalidasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
