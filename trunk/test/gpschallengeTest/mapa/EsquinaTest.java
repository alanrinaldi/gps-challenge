package gpschallengeTest.mapa;

import static org.junit.Assert.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.mapa.Esquina;

import org.junit.Test;

public class EsquinaTest {
	
	@Test
	public void deberiaInicializarEsquina(){
		
		Posicion unaPosicion = new Posicion(1,1);
		Esquina esquina = new Esquina(unaPosicion);
		assertEquals(esquina.getPosicion(),unaPosicion);
		
	}

}