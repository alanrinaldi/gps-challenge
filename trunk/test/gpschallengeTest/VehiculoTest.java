package gpschallengeTest;

import static org.junit.Assert.*;
import gpschallenge.*;

import org.junit.Test;

public class VehiculoTest {
	
	@Test
	public void deberiaInicializarVehiculo(){
		
		Estado auto = new Auto();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertNotNull(vehiculo);
		
		
	}
	
	@Test
	public void deberiaCoincidirTipoVehiculo(){
		
		Estado auto = new Auto();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertEquals(auto.getEstado(),vehiculo.getEstado());
	}
	
	@Test
	public void cambiarEstadoAUnVehiculo(){
		
		Estado auto = new Auto();
		Estado moto = new Moto();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertEquals(auto.getEstado(),vehiculo.getEstado());
		
		vehiculo = new Vehiculo(moto);
		
		assertEquals(moto.getEstado(),vehiculo.getEstado());
		
	}

}
