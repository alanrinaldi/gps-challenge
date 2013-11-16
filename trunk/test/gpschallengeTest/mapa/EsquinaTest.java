package gpschallengeTest.mapa;

import static org.junit.Assert.*;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.direccionamiento.*;
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
	
	@Test
	public void deberiaMoverseALaSiguienteEsquina(){
		
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Esquina otraEsquina = new Esquina(otraPosicion);
		
		Calle unaCalle = new Calle(unaEsquina,otraEsquina);
		Direccion arriba = new Arriba();
		Direccion abajo = new Abajo();
		unaEsquina.agregarCalle(arriba , unaCalle);
		otraEsquina.agregarCalle(abajo, unaCalle);
		
		EstadoVehiculo auto = Auto.getInstancia();
		Vehiculo vehiculo = new Vehiculo(auto);
		
		vehiculo.setPosicion(unaEsquina);
		
		assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual().getPosicion());
		
		vehiculo.moverA(arriba);
		
		assertEquals(otraEsquina.getPosicion(),vehiculo.getPosicionActual().getPosicion());
		assertEquals(1,vehiculo.getCantMovimientos());
		
		
	}
	
	@Test
	public void deberiaMoverseALaSiguienteEsquinaYAplicarObstaculo(){
		
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,3);
		Esquina unaEsquina = new Esquina(unaPosicion);
		Esquina otraEsquina = new Esquina(otraPosicion);
		
		Pozo unPozo = new Pozo();
		Calle unaCalle = new Calle(unaEsquina,otraEsquina);
		unaCalle.setAfectable(unPozo);
		Direccion arriba = new Arriba();
		Direccion abajo = new Abajo();
		unaEsquina.agregarCalle(arriba , unaCalle);
		otraEsquina.agregarCalle(abajo, unaCalle);
		
		EstadoVehiculo auto = Auto.getInstancia();
		Vehiculo vehiculo = new Vehiculo(auto);
		
		vehiculo.setPosicion(unaEsquina);
		
		assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual().getPosicion());
		
		vehiculo.moverA(arriba);
		
		assertEquals(otraEsquina.getPosicion(),vehiculo.getPosicionActual().getPosicion());
		assertEquals(4,vehiculo.getCantMovimientos());
		
		
	}


}