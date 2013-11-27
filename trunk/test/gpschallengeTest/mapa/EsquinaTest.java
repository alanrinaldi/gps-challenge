package gpschallengeTest.mapa;

import static org.junit.Assert.*;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.direccionamiento.*;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.mapa.Calle;
import gpschallenge.mapa.Esquina;

import org.junit.Test;

public class EsquinaTest {
	
	@Test
	public void deberiaInicializarEsquina(){
		
		Posicion unaPosicion = new Posicion(1,1);
		Esquina esquina = new Esquina(unaPosicion);
		assertEquals(esquina.getPosicion(),unaPosicion);
		
	}
	@Test //[ExpectedException (typeof (EsquinasInvalidasException))]
	public void pruebaExcepcion(){	
		
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Esquina otraEsquina = new Esquina(otraPosicion);
		try {
			new Calle(unaEsquina,otraEsquina);
		}
		catch (EsquinasInvalidasException e1){
			System.out.println("La calle es incorrecta");
		}
	}
	
	/*
	@Test
	public void deberiaMoverseALaSiguienteEsquina(){
		
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,2);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Esquina otraEsquina = new Esquina(otraPosicion);
		Direccion arriba = new Arriba();
		Direccion abajo = new Abajo();
		try {
			Calle unaCalle = new Calle(unaEsquina,otraEsquina);
		
			unaEsquina.agregarCalle(arriba , unaCalle);
			otraEsquina.agregarCalle(abajo, unaCalle);
		
			EstadoVehiculo auto = Auto.getInstancia();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setEstado(auto);
			
			vehiculo.
		
			assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual());
		
		
			assertEquals(otraEsquina.getPosicion(),vehiculo.getPosicionActual());
			assertEquals(1,vehiculo.getCantMovimientos());
		}
		catch (EsquinasInvalidasException e1){}
	}
	
	@Test
	public void deberiaMoverseALaSiguienteEsquinaYAplicarObstaculo(){
		
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,2);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Esquina otraEsquina = new Esquina(otraPosicion);
		Direccion arriba = new Arriba();
		Direccion abajo = new Abajo();
		Pozo unPozo = new Pozo();
		try{
			Calle unaCalle = new Calle(unaEsquina,otraEsquina);
			unaCalle.addAfectable(unPozo);
			unaEsquina.agregarCalle(arriba , unaCalle);
			otraEsquina.agregarCalle(abajo, unaCalle);
			EstadoVehiculo auto = Auto.getInstancia();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setEstado(auto);
			
			
			assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual());
			
			
			assertEquals(otraEsquina.getPosicion(),vehiculo.getPosicionActual());
			assertEquals(4,vehiculo.getCantMovimientos());
			
		}
		catch (EsquinasInvalidasException e2){}
		
		
		
		
	}

	*/
}