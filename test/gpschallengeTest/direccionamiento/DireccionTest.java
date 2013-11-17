package gpschallengeTest.direccionamiento;

import static org.junit.Assert.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.direccionamiento.*;

import org.junit.Test;

public class DireccionTest {

	private Direccion arriba = new Arriba();

	private Posicion posicionDireccion;
	
	@Test
	public void test() {
		posicionDireccion = arriba.obtenerPosicion();
		
		
		assertEquals(posicionDireccion.getX(),0);
		assertEquals(posicionDireccion.getY(),-1);
		
	}

}
