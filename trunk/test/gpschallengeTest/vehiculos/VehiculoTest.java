package gpschallengeTest.vehiculos;

import static org.junit.Assert.*;
import gpschallenge.componentes.obstaculos.*;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VehiculoTest {
	private ArrayList<Afectable> afectables;
	private Vehiculo unVehiculo;


	@Before
	public void setUp() {
		unVehiculo = Vehiculo.getInstancia();
		afectables = new ArrayList<Afectable>();
		afectables.add(new Pozo()); // suma 3 movimientos
		afectables.add(new Piquete()); // vuelve a posicion anterior
	}
	
	@Test
	public void deberiaInicializarVehiculo() {

		assertNotNull(unVehiculo);

	}

	@Test
	public void deberiaCoincidirTipoVehiculo() {

		EstadoVehiculo auto = Auto.getInstancia();

		unVehiculo.setEstado(auto);

		assertEquals(auto, unVehiculo.getEstado());
	}

	@Test
	public void cambiarEstadoAUnVehiculo() {

		EstadoVehiculo auto = Auto.getInstancia();
		EstadoVehiculo moto = Moto.getInstancia();

		unVehiculo.setEstado(auto);

		assertEquals(auto, unVehiculo.getEstado());

		unVehiculo.setEstado(moto);

		assertEquals(moto, unVehiculo.getEstado());

	}

	@Test
	public void vehiculoConEstadoAutoAfectadoPorDosObstaculos() {
		unVehiculo.setEstado(Auto.getInstancia());
		unVehiculo.reiniciarValoresACero();
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 13);

	}

	@Test
	public void vehiculoConEstadoMotofectadoPorDosObstaculos() {
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.reiniciarValoresACero();
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 15);

	}

	@Test
	public void vehiculoConEstadoCuatroXCuatrofectadoPorDosObstaculos() {
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.reiniciarValoresACero();
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 10);
	}

}
