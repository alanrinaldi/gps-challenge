package gpschallengeTest;

public class CuatroPorCuatro implements Estado {

	CuatroPorCuatro(){}
	private CuatroPorCuatro unicaInstancia = null;
	
	@Override
	public CuatroPorCuatro getEstado() {

		if (unicaInstancia == null){
			unicaInstancia = new CuatroPorCuatro();
		}
		return unicaInstancia;		
		
	}

	@Override
	public void nuevoEstado(Estado unEstado) {
		// TODO Auto-generated method stub

	}

}
