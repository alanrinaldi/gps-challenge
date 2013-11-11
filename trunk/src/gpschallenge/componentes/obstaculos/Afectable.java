package gpschallenge.componentes.obstaculos;

import gpschallenge.componentes.vehiculos.Auto;
import gpschallenge.componentes.vehiculos.CuatroXCuatro;
import gpschallenge.componentes.vehiculos.Moto;

public interface Afectable{
	public void afectarMoto(Moto unaMoto);
	public void afectarAuto(Auto unAuto);
	public void afectarCuatroXCuatro(CuatroXCuatro unaCuatroXCuatro);
}
