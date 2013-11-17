package gpschallengeTest.sorpresas;



import static org.junit.Assert.*;
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
		
		SorpresaFavorable sorpresa = new SorpresaFavorable();
		
		vehiculo.afectar(sorpresa);
		
		assertEquals (vehiculo.getCantMovimientos(),8);
	}
	
	@Test
	public void sorpresaDesfavorableActuaCorrectamente() {
		
		SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
		
		vehiculo.afectar(sorpresa);
		
		assertEquals (vehiculo.getCantMovimientos(),12); 
		
	} 
	

	@Test
	public void cambiadeEstadoCorrectamente(){
		
		CambioDeVehiculo sorpresa = new CambioDeVehiculo();
		
		
		vehiculo.afectar(sorpresa);
		
		assertEquals (vehiculo.getEstado(),cuatroXCuatro);
		assertEquals (vehiculo.getCantMovimientos(),10);
	}
}
