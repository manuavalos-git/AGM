package grafo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContenedorDeGrafosTest {

	@Test
	public void testGenerarGrafos() {
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		
		Integer[][] matriz=contenedor.generarGrafos(4);
		
		assertTrue((matriz.length==4));
	}

	@Test
	public void testGenerarTiempos() {
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		contenedor.generarGrafos(6);
		
		Long[][] matriz=contenedor.generarTiempos();
		
		assertTrue((matriz.length==6));
	}
	@Test
	public void tiemposSinGrafos() {
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		
		Long[][] matriz=contenedor.generarTiempos();
		
		assertTrue((matriz.length==0));
	}


}
