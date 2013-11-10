package gpschallengeTest;


import static org.junit.Assert.*;

import org.junit.Test;

import gpschallenge.*
;

public class VehiculoTest {
	
	@Test
	public void deberiaInicializarVehiculo(){
		
		EstadoVehiculo auto = Auto.getInstancia();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertNotNull(vehiculo);
		
		
	}
	
	@Test
	public void deberiaCoincidirTipoVehiculo(){
		
		EstadoVehiculo auto = Auto.getInstancia();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertEquals(auto,vehiculo.getEstado());
	}
	
	@Test
	public void cambiarEstadoAUnVehiculo(){
		
		EstadoVehiculo auto = Auto.getInstancia();
		EstadoVehiculo moto = Moto.getInstancia();
		
		Vehiculo vehiculo = new Vehiculo(auto);
		
		assertEquals(auto,vehiculo.getEstado());
		
		vehiculo = new Vehiculo(moto);
		
		assertEquals(moto,vehiculo.getEstado());
		
	}

}
