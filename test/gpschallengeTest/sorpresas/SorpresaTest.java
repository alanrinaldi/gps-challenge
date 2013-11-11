package gpschallengeTest.sorpresas;

import static org.junit.Assert.assertEquals;
import gpschallenge.componentes.sorpresas.*;
import gpschallenge.componentes.vehiculos.*;

import org.junit.Before;
import org.junit.Test;

public class SorpresaTest {

	EstadoVehiculo auto = Auto.getInstancia();
	EstadoVehiculo cuatroxcuatro = CuatroXCuatro.getInstancia();
	Vehiculo vehiculo = new Vehiculo(auto);
	@Before
	public void setUp(){
		auto.reiniciarValoresACero();
		cuatroxcuatro.reiniciarValoresACero();
	}
	
	@Test
	public void sorpresaFavorableActuaCorrectamente() {
		
		Sorpresa sorpresa = new SorpresaFavorable();
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getEstado().getCantMovimientos(),-1);
	}

	@Test
	public void sorpresaDesfavorableActuaCorrectamente() {
		
		Sorpresa sorpresa = new SorpresaDesfavorable();
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getEstado().getCantMovimientos(),1); 
		
	} 
	
	
	@Test
	public void cambiadeEstadoCorrectamente(){
		
		Regla regla = new Regla();
		CambioDeVehiculo sorpresa = new CambioDeVehiculo();
		
		sorpresa.setRegla(regla);
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getEstado(),cuatroxcuatro);
		assertEquals (vehiculo.getEstado().getCantMovimientos(),0);
	}
}
