package gpschallenge;

public class CuatroPorCuatro implements Estado {

	public CuatroPorCuatro(){}
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
