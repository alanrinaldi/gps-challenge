package gpschallengeTest.obstaculos;

import static org.junit.Assert.*;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.direccionamiento.Abajo;
import gpschallenge.direccionamiento.Arriba;
import gpschallenge.direccionamiento.Direccion;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.mapa.Calle;
import gpschallenge.mapa.Esquina;

import org.junit.Before;
import org.junit.Test;

public class PiqueteTest {

	private Piquete unPiquete = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	private Vehiculo unVehiculo = new Vehiculo();
	Posicion unaPosicion = new Posicion(1,1);
	Posicion otraPosicion = new Posicion(1,2);
	Esquina unaEsquina = new Esquina(unaPosicion);
	Esquina otraEsquina = new Esquina(otraPosicion);
	Direccion arriba = new Arriba();
	Direccion abajo = new Abajo();
	
	@Before
	public void setUp(){
		unPiquete = new Piquete();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
		unVehiculo.reiniciarValoresACero();

	}
	@Test
	public void debePenalizarConDosMovimientosAMotos(){
		unVehiculo.setEstado(unaMoto);
		unVehiculo.sumarMovimientos(12);
		unVehiculo.afectar(unPiquete);
		assertEquals(unVehiculo.getCantMovimientos(), 14);
	}
	@Test
	public void NoDebePenalizarAVehiculoAutos(){
		unVehiculo.setEstado(unAuto);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(unPiquete);
		assertEquals(unVehiculo.getCantMovimientos(), 6);
	}
	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro(){
		unVehiculo.setEstado(una4x4);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(unPiquete);
		assertEquals(unVehiculo.getCantMovimientos(), 6);
	}
	
	@Test
	public void autoNoDeberiaCambiarPosicion(){
		
		try {
			Calle unaCalle = new Calle(unaEsquina,otraEsquina);
			unaCalle.addAfectable(unPiquete);
		
			unaEsquina.agregarCalle(arriba , unaCalle);
			otraEsquina.agregarCalle(abajo, unaCalle);
		
			EstadoVehiculo auto = Auto.getInstancia();
			Vehiculo vehiculo = new Vehiculo(auto);
		
			vehiculo.setPosicion(new Posicion(2,1));
		
			assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual());
			
		
			assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual());
			assertEquals(1,vehiculo.getCantMovimientos());
		}
		catch (EsquinasInvalidasException e1){ 
			System.out.println("Auto Cambia de Posicion");
		}
	}
	
	@Test
	public void cuatroXCuatroNoDeberiaCambiarPosicion(){
		
		try {
			Calle unaCalle = new Calle(unaEsquina,otraEsquina);
			unaCalle.addAfectable(unPiquete);
			
			unaEsquina.agregarCalle(arriba , unaCalle);
			otraEsquina.agregarCalle(abajo, unaCalle);
		
			EstadoVehiculo cuatroxcuatro = CuatroXCuatro.getInstancia();
			Vehiculo vehiculo = new Vehiculo(cuatroxcuatro);
		
		
			assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual());
		
			
			assertTrue(unaEsquina.getPosicion().esIgual(vehiculo.getPosicionActual()));
			assertEquals(1,vehiculo.getCantMovimientos());
			
		}
		catch (EsquinasInvalidasException e1){
			System.out.println("CuatroXCuatro Cambia de Posicion");
		}
	}
	
	@Test
	public void motoDeberiaCambiarPosicion(){
		
		try {
			Calle unaCalle = new Calle(unaEsquina,otraEsquina);
			unaCalle.addAfectable(unPiquete);
		
			unaEsquina.agregarCalle(arriba , unaCalle);
			otraEsquina.agregarCalle(abajo, unaCalle);
			
			EstadoVehiculo moto = Moto.getInstancia();
			Vehiculo vehiculo = new Vehiculo(moto);
		
		
			assertEquals(unaEsquina.getPosicion(),vehiculo.getPosicionActual());
		
		
			assertEquals(otraEsquina.getPosicion(),vehiculo.getPosicionActual());
			assertEquals(3,vehiculo.getCantMovimientos());
		}
		catch (EsquinasInvalidasException e1){
			System.out.println("Moto No Cambia de Posicion");
		}
	}
		
		
}
		
