package gpschallengeTest.nuevoMapa;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.nuevoMapa.*;
import org.junit.Test;

public class nuevoMapaTest {
	
	@Test
	public void dosEsquinasVecinasEnUnMapaTienenUnaCalleIgual(){
		Mapa unMapa = new Mapa(4,5);
		Posicion unaPosicion1 = new Posicion(1,1);
		Posicion unaPosicion2 = new Posicion(1,3);
		Esquina unaEsquina1 = unMapa.getEsquina(unaPosicion1);
		Esquina unaEsquina2 = unMapa.getEsquina(unaPosicion2);
		
		assertEquals(unaEsquina1.getCalleDerecha(),unaEsquina2.getCalleIzquierda());
	}
	
	@Test
	public void cadaEsquinaDeUnMapaTieneCuatroCalles(){
		Mapa unMapa = new Mapa(6,8);
		HashMap<Posicion,Esquina> hashDeEsquinas = unMapa.getHashDeEsquinas();
		// Recorre todas las esquinas de Hash y compara la cantidad de calles que tiene
		// cada esquina con 4
		Map.Entry e;
		Iterator it = hashDeEsquinas.entrySet().iterator();
		while (it.hasNext()){
			e = (Map.Entry)it.next();
			assertEquals(((Esquina)e.getValue()).getCantidadDeCalles(),4);
		}
		
	}

}
