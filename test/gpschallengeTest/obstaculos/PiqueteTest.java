package gpschallengeTest.obstaculos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import gpschallenge.componentes.obstaculos.*;
import gpschallenge.componentes.utililidades.*;
import gpschallenge.componentes.vehiculos.*;
import gpschallenge.excepciones.ExcedeMaximoAfectablesException;
import gpschallenge.mapa.*;

import org.junit.Before;
import org.junit.Test;

public class PiqueteTest {

	private Piquete unPiquete = null;
	private Moto unaMoto = null;
	private Auto unAuto = null;
	private CuatroXCuatro una4x4 = null;
	private Vehiculo unVehiculo;
	private Posicion unaPosicion = new Posicion(1, 1);
	private Posicion otraPosicion = new Posicion(1, 2);
	private Esquina unaEsquina = new Esquina(unaPosicion);
	private Esquina otraEsquina = new Esquina(otraPosicion);
	private ArrayList<Afectable> afectables;

	@Before
	public void setUp() {
		unPiquete = new Piquete();
		unaMoto = Moto.getInstancia();
		unAuto = Auto.getInstancia();
		una4x4 = CuatroXCuatro.getInstancia();
		unVehiculo = new Vehiculo();
		afectables = new ArrayList<Afectable>();
		afectables.add(unPiquete);
		
		
	}
	
	@Test
	public void NoDebePenalizarAVehiculoAutos() {
		
		unVehiculo.setEstado(unAuto);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 6);
	}
	
	@Test
	public void NoDebePenalizarAVehiculoCuatroXCuatro() {
		unVehiculo.setEstado(una4x4);
		unVehiculo.sumarMovimientos(6);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 6);
	}

	@Test
	public void debePenalizarConDosMovimientosAMotos() {
		unVehiculo.setEstado(unaMoto);
		unVehiculo.sumarMovimientos(12);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 14);
	}


	  @Test 
	  public void autoNoDeberiaCambiarPosicion() throws ExcedeMaximoAfectablesException{
		  try{
			  Calle unaCalle = new Calle();
			
			  
			  unaEsquina.setCalleEnSentido(unaCalle, Sentido.ABAJO);
			  otraEsquina.setCalleEnSentido(unaCalle, Sentido.ARRIBA);
			  
			  unaCalle.addAfectable(unPiquete);
			  
			  EstadoVehiculo auto = Auto.getInstancia(); 
			  unVehiculo.setEstado(auto);
			  unVehiculo.setEsquina(unaEsquina);
			  unVehiculo.setPosicion(unaPosicion);
			  unVehiculo.setValorPorMovimiento(1);
			  
			  unVehiculo.mover(Sentido.ABAJO);
			  
			  assertTrue(unVehiculo.getPosicionActual().esIgual(unaPosicion));
			  
			  assertEquals(1,unVehiculo.getCantMovimientos().intValue());  
		  }
		  catch(ExcedeMaximoAfectablesException e){}
	  }
	  
	  @Test 
	  public void cuatroporcuatroNoDeberiaCambiarPosicion() throws ExcedeMaximoAfectablesException{
		  try{
			  Calle unaCalle = new Calle();
			
			  
			  unaEsquina.setCalleEnSentido(unaCalle, Sentido.ABAJO);
			  otraEsquina.setCalleEnSentido(unaCalle, Sentido.ARRIBA);
			  
			  unaCalle.addAfectable(unPiquete);
			  
			  EstadoVehiculo cuatroxcuatro = CuatroXCuatro.getInstancia(); 
			  unVehiculo.setEstado(cuatroxcuatro);
			  unVehiculo.setEsquina(unaEsquina);
			  unVehiculo.setPosicion(unaPosicion);
			  unVehiculo.setValorPorMovimiento(1);
			  
			  unVehiculo.mover(Sentido.ABAJO);
			  
			  assertTrue(unVehiculo.getPosicionActual().esIgual(unaPosicion));
			  
			  assertEquals(1,unVehiculo.getCantMovimientos().intValue());  
		  }
		  catch(ExcedeMaximoAfectablesException e){}
	  }
	  
	  @Test 
	  public void motoDeberiaCambiarPosicion() throws ExcedeMaximoAfectablesException{
		  try{
			  Calle unaCalle = new Calle();
			
			  
			  unaEsquina.setCalleEnSentido(unaCalle, Sentido.ABAJO);
			  otraEsquina.setCalleEnSentido(unaCalle, Sentido.ARRIBA);
			  
			  unaCalle.addAfectable(unPiquete);
			  
			  EstadoVehiculo moto = Moto.getInstancia(); 
			  unVehiculo.setEstado(moto);
			  unVehiculo.setEsquina(unaEsquina);
			  unVehiculo.setPosicion(unaPosicion);
			  unVehiculo.setValorPorMovimiento(1);
			  
			  unVehiculo.mover(Sentido.ABAJO);
			  
			  assertTrue(unVehiculo.getPosicionActual().esIgual(otraPosicion));
			  
			  assertEquals(3,unVehiculo.getCantMovimientos().intValue());  
		  }
		  catch(ExcedeMaximoAfectablesException e){}
	  }
	 
}
