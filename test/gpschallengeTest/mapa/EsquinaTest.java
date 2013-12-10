package gpschallengeTest.mapa;

import static org.junit.Assert.*;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.*;
import gpschallenge.componentes.vehiculos.*;
import gpschallenge.excepciones.ExcedeMaximoAfectablesException;
import gpschallenge.mapa.*;

import org.junit.Test;

public class EsquinaTest {

	@Test
	public void deberiaInicializarEsquina() {

		Posicion unaPosicion = new Posicion(1, 1);
		Esquina esquina = new Esquina(unaPosicion);
		assertEquals(esquina.getPosicion(), unaPosicion);

	}

	 @Test 
	 public void deberiaMoverseALaSiguienteEsquina(){
	  
	  Posicion unaPosicion = new Posicion(1,1); 
	  Posicion otraPosicion = new Posicion(1,2);
	  Esquina unaEsquina = new Esquina(unaPosicion); 
	  Esquina otraEsquina = new Esquina(otraPosicion); 
	  
	  Calle unaCalle = new Calle();
	  
	  unaEsquina.setCalleEnSentido(unaCalle,Sentido.ABAJO);
	  otraEsquina.setCalleEnSentido(unaCalle,Sentido.ARRIBA);
	  
	  EstadoVehiculo auto = Auto.getInstancia(); 
	  Vehiculo vehiculo = new Vehiculo();
	  vehiculo.setEstado(auto);
	  vehiculo.setEsquina(unaEsquina);
	  vehiculo.setPosicion(unaPosicion);
	  vehiculo.setValorPorMovimiento(1);
	  
	  
	  vehiculo.mover(Sentido.ABAJO);
	  
	  assertTrue(vehiculo.getPosicionActual().esIgual(otraPosicion));
	  assertEquals(1,vehiculo.getCantMovimientos().intValue()); 
	 
	 }
	  
	  @Test 
	  public void deberiaMoverseALaSiguienteEsquinaYAplicarObstaculo() throws ExcedeMaximoAfectablesException{
		 
		  try{
			  Posicion unaPosicion = new Posicion(1,1); 
			  Posicion otraPosicion = new Posicion(1,2); 
			  Esquina unaEsquina = new Esquina(unaPosicion); 
			  Esquina otraEsquina = new Esquina(otraPosicion); 
			  Pozo unPozo = new Pozo(); 
			  Calle unaCalle = new Calle();
			  unaCalle.addAfectable(unPozo); 
			  unaEsquina.setCalleEnSentido(unaCalle,Sentido.ABAJO); 
			  otraEsquina.setCalleEnSentido(unaCalle,Sentido.ARRIBA); 
			  
			  EstadoVehiculo auto = Auto.getInstancia(); 
			  Vehiculo vehiculo = new Vehiculo();
			  vehiculo.setEstado(auto);
			  vehiculo.setEsquina(unaEsquina);
			  vehiculo.setPosicion(unaPosicion);
			  vehiculo.setValorPorMovimiento(1);
			  			  
			  vehiculo.mover(Sentido.ABAJO);
			  
			  assertTrue(vehiculo.getPosicionAnterior().esIgual(unaPosicion));
			  assertTrue(vehiculo.getPosicionActual().esIgual(otraPosicion));
			  assertEquals(4,vehiculo.getCantMovimientos().intValue());
		  }
		  catch(ExcedeMaximoAfectablesException e){}
	  
	
	  }
}