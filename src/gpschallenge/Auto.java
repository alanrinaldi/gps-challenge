package gpschallengeTest;

public class Auto implements Estado {
	
	Auto(){}
	private Auto unicaInstancia = null;
	
	@Override
	public Auto getEstado() {

		if (unicaInstancia == null){
			unicaInstancia = new Auto();
		}
		return unicaInstancia;
		
	}

	@Override
	public void nuevoEstado(Estado unEstado) {
		// TODO Auto-generated method stub

	}

}
