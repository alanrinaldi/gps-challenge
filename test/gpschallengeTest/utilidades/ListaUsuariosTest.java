package gpschallengeTest.utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

import gpschallenge.componentes.utililidades.ListaUsuarios;

public class ListaUsuariosTest {
	
	ListaUsuarios lista = new ListaUsuarios();
	
	@Test
	public void laListaNoEsNull(){
		
		assertNotNull(lista);
	}
	
	@Test
	public void agregarUsuario(){
		
		lista.agregarUsuario("Pedro");
		assertTrue(lista.obtenerListaUsuarios().contains("Pedro"));
	}
	
	@Test
	public void noDeberiaAgregarUsuarioRepetido(){
		
		lista.agregarUsuario("Pedro");
		assertEquals(lista.obtenerListaUsuarios().size(),1);
	}

}
