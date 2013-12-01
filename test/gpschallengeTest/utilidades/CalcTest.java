package gpschallengeTest.utilidades;

import gpschallenge.componentes.utililidades.Calc;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {
	@Test
	public void calculaBienElPorcentaje() {
		int valor = Calc.calcularPorcentaje(20, 100);
		assertEquals(valor, 20);
	}

}
