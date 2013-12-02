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

import org.junit.Test;

public class VehiculoTest {
	private ArrayList<Afectable> afectables = new ArrayList<Afectable>();
	private Vehiculo unVehiculo = new Vehiculo(Auto.getInstancia());

	@Test
	public void deberiaInicializarVehiculo() {

		EstadoVehiculo auto = Auto.getInstancia();

		Vehiculo vehiculo = new Vehiculo(auto);

		assertNotNull(vehiculo);

	}

	@Test
	public void deberiaCoincidirTipoVehiculo() {

		EstadoVehiculo auto = Auto.getInstancia();

		Vehiculo vehiculo = new Vehiculo(auto);

		assertEquals(auto, vehiculo.getEstado());
	}

	@Test
	public void cambiarEstadoAUnVehiculo() {

		EstadoVehiculo auto = Auto.getInstancia();
		EstadoVehiculo moto = Moto.getInstancia();

		Vehiculo vehiculo = new Vehiculo(auto);

		assertEquals(auto, vehiculo.getEstado());

		vehiculo = new Vehiculo(moto);

		assertEquals(moto, vehiculo.getEstado());

	}

	@Test
	public void vehiculoConEstadoAutofectadoPorDosObstaculos() {
		unVehiculo.setEstado(Auto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		afectables.add(new Pozo()); // suma 3 movimientos
		afectables.add(new Piquete()); // vuelve a posicion anterior
		unVehiculo.afectar(afectables);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 13);

	}

	@Test
	public void vehiculoConEstadoMotofectadoPorDosObstaculos() {
		unVehiculo.setEstado(Moto.getInstancia());
		unVehiculo.sumarMovimientos(10);
		afectables.add(new Pozo()); // suma 3 movimientos
		afectables.add(new Piquete()); // Suma 2 movimientos
		unVehiculo.afectar(afectables);
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 15);

	}

	@Test
	public void vehiculoConEstadoCuatroXCuatrofectadoPorDosObstaculos() {
		unVehiculo.setEstado(CuatroXCuatro.getInstancia());
		unVehiculo.sumarMovimientos(10);
		afectables.add(new Pozo()); // suma 0 movimientos
		afectables.add(new Piquete()); // vuelve a posicion anterior
		unVehiculo.afectar(afectables);
		assertTrue(unVehiculo.getPosicionActual().esIgual(new Posicion(0, 0)));
		assertEquals(unVehiculo.getCantMovimientos().intValue(), 10);
	}
	@Test
	public void setPosicionActualCoincideConLaAnterior(){
		unVehiculo.reiniciarValoresACero();
		unVehiculo.setPosicion(new Posicion(1, 1));
		assertTrue(unVehiculo.getPosicionActual().esIgual(unVehiculo.getPosicionAnterior()));
	}
	@Test
	public void posicionDeVehiculoCoincideConPosicionEsquina(){
		Esquina esquina = new Esquina(new Posicion(1,1));
		unVehiculo.setEsquina(esquina);
		assertTrue(unVehiculo.getPosicionActual().esIgual(esquina.getPosicion()));
		assertTrue(unVehiculo.getPosicionAnterior().esIgual(esquina.getPosicion()));
	}

}
