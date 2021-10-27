package grafo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContenedorDeGrafosTest {

	@Test
	public void testGenerarGrafos() {
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		
		Integer[][] matriz=contenedor.generarGrafos();
		
		assertTrue((matriz.length==26));
	}

	@Test
	public void testGenerarTiempos() {
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		contenedor.generarGrafos();
		
		Long[][] matriz=contenedor.generarTiempos();
		
		assertTrue((matriz.length==26));
	}
	@Test
	public void tiemposSinGrafos() {
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		
		Long[][] matriz=contenedor.generarTiempos();
		
		assertTrue((matriz.length==0));
	}


}
