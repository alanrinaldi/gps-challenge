package gpschallengeTest.meta;

import static org.junit.Assert.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.motor.Meta;

import org.junit.Before;
import org.junit.Test;

public class MetaTest {
	
	Meta unaMeta;
	Posicion unaPosicion = new Posicion (5,5);
	Posicion otraPosicion;
	
	@Before
	public void setUp(){
		unaMeta = new Meta();
		unaMeta.setPosicion(unaPosicion);
	}
	
	@Test
	public void iniciaNoNUll(){
		assertNotNull(unaMeta);
	}

	@Test
	public void metaestaenunaposicion(){
		
		otraPosicion = unaMeta.getPosicion();
		
		assertTrue (unaPosicion.esIgual(otraPosicion));	
	}
	
}
