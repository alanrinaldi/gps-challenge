package gpschallenge.mapa;

import gpschallenge.componentes.obstaculos.Afectable;
import gpschallenge.componentes.sorpresas.Sorpresa;
import gpschallenge.componentes.vehiculos.Vehiculo;

public class Calle {

	private Esquina unaEsquina;
	private Esquina otraEsquina;
	private Afectable unAfectable;
	private Sorpresa unaSorpresa;
	
	public Calle(Esquina esquina, Esquina esquina2){
		
		unaEsquina = esquina;
		otraEsquina = esquina2;
	}
	
	public void setAfectable(Afectable afectable){
		
		unAfectable = afectable;
	}
	
	public void setSorpresa(Sorpresa sorpresa){
		
		unaSorpresa = sorpresa;
	}
	
	public void afectarA(Vehiculo unVehiculo){
		
		unaSorpresa.aplicarIncidencia(unVehiculo);
		unVehiculo.afectar(unAfectable);
		
	}

	public Esquina getUnaEsquina(){
		
		return unaEsquina;
	}
	
	public Esquina getOtraEsquina(){
		
		return otraEsquina;
	}

	public boolean verificarQueEsquinaEs(Esquina esquina) {
		if(esquina == unaEsquina)return true;
		return false;
	}
	
}
