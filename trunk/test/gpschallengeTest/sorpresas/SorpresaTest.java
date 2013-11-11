package gpschallengeTest.sorpresas;

import static org.junit.Assert.assertEquals;
import gpschallenge.componentes.obstaculos.CambioDeVehiculo;
import gpschallenge.componentes.sorpresas.Regla;
import gpschallenge.componentes.sorpresas.Sorpresa;
import gpschallenge.componentes.sorpresas.SorpresaDesfavorable;
import gpschallenge.componentes.sorpresas.SorpresaFavorable;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Vehiculo;

import org.junit.Test;

public class SorpresaTest {

	EstadoVehiculo auto = Auto.getInstancia();
	EstadoVehiculo cuatroxcuatro = CuatroXCuatro.getInstancia();
	Vehiculo vehiculo = new Vehiculo(auto);
	
	
	@Test
	public void sorpresaFavorableActuaCorrectamente() {
		
		Sorpresa sorpresa = new SorpresaFavorable();
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getEstado().getCantMovimientos(),-1);
	}

	@Test
	public void sorpresadesFavorableActuaCorrectamente() {
		
		Sorpresa sorpresa = new SorpresaDesfavorable();
		
		sorpresa.aplicarIncidencia(vehiculo);
		
		assertEquals (vehiculo.getEstado().getCantMovimientos(),0); 
		
		/*Esta igualado a 0 ya que quedo con -1 la cantidad de movimientos del anterior test*/
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
