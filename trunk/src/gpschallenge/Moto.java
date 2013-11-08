package gpschallenge;

public class Moto implements Estado {

	public Moto(){}
	private Moto unicaInstancia = null;
	
	@Override
	public Moto getEstado() {
		
		if (unicaInstancia == null){
			unicaInstancia = new Moto();
		}
		return unicaInstancia;

		
	}

	@Override
	public void nuevoEstado(Estado unEstado) {
		// TODO Auto-generated method stub

	}

}
