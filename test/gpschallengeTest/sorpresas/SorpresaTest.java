package gpschallengeTest.sorpresas;

import static org.junit.Assert.assertEquals;
import gpschallenge.componentes.sorpresas.*;
import gpschallenge.componentes.vehiculos.*;

import org.junit.Before;
import org.junit.Test;

public class SorpresaTest {

	Vehiculo vehiculo = new Vehiculo(Auto.getInstancia());
	CuatroXCuatro cuatroXCuatro = CuatroXCuatro.getInstancia();
	@Before
	public void setUp(){
		vehiculo.reiniciarValoresACero();
		vehiculo.sumarMovimientos(10);
	}
	
	@Test
	public void sorpresaFavorableActuaCorrectamente() {
		
		Sorpresa sorpresa = new SorpresaFavorable();
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getCantMovimientos(),8);
	}
	
	@Test
	public void sorpresaDesfavorableActuaCorrectamente() {
		
		Sorpresa sorpresa = new SorpresaDesfavorable();
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getCantMovimientos(),12); 
		
	} 
	

	@Test
	public void cambiadeEstadoCorrectamente(){
		
		Regla regla = new Regla();
		CambioDeVehiculo sorpresa = new CambioDeVehiculo();
		
		sorpresa.setRegla(regla);
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getEstado(),cuatroXCuatro);
		assertEquals (vehiculo.getCantMovimientos(),10);
	}
}
