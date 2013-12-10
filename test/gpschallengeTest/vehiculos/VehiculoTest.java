package gpschallengeTest.vehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.obstaculos.Piquete;
import gpschallenge.componentes.obstaculos.Pozo;
import gpschallenge.componentes.utililidades.Posicion;
import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.EstadoVehiculo;
import gpschallenge.componentes.vehiculos.Moto;
import gpschallenge.componentes.vehiculos.Vehiculo;
import gpschallenge.mapa.Esquina;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VehiculoTest {
	private ArrayList<Afectable> afectables;
	private Vehiculo unVehiculo;


	@Before
	public void setUp() {
		unVehiculo = new Vehiculo();
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
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 13);

	}

	@Test
	public void vehiculoConEstadoMotofectadoPorDosObstaculos() {
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 15);

	}

	@Test
	public void vehiculoConEstadoCuatroXCuatrofectadoPorDosObstaculos() {
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.sumarMovimientos(10);
		unVehiculo.afectar(afectables);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 10);
	}
	@Test
	public void asignaPosicionActualCambiaPosicionAnterior(){
		unVehiculo.setPosicion(new Posicion(12, 12));
		assertTrue(unVehiculo.getPosicionActual().esIgual(unVehiculo.getPosicionAnterior()));

	}
	@Test
	public void asignaUnaEsquinaYcambiaLaPosicion(){
		Esquina esquina = new Esquina(new Posicion(12, 12));
		unVehiculo.setEsquina(esquina);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(12, 12)));

	}
}
