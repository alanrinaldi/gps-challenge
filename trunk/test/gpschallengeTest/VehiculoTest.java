package gpschallengeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehiculoTest {
	
	@Test
	public void deberiaInicializarVehiculo(){
		
		Estado auto = new Auto();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertNotNull(vehiculo);
		
		
	}

}