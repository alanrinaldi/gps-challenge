package gpschallenge.componentes.utililidades;
import java.util.ArrayList;


public class ListaUsuarios {
	
	private ArrayList<String> listaUsuarios;
	
	public ListaUsuarios(){
		
		listaUsuarios = new ArrayList<String>();
		
	}

	public ArrayList<String> obtenerListaUsuarios(){
		return listaUsuarios;
	}
	
	public void agregarUsuario(String user){
		if(!listaUsuarios.contains(user)){
			listaUsuarios.add(user);
		}
			
	}
}
