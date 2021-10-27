package grafo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;



public class BFStest {

	@Test (expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}
	@Test
	public void vacioTest() {
		Grafo g=new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	@Test
	public void vacioPesoTest() {
		GrafoConPeso g=new GrafoConPeso(0);
		assertTrue(BFS.esConexo(g));
	}
	@Test
	public void alcanzablesTest() {
		Grafo g=inicializarGrafo();
		Set<Integer> alcanzables = BFS.alcanzables(g,0);
		int[] esperados = {0,1,2,3};
		
		Assert.iguales(esperados, alcanzables);
	}
	@Test
	public void alcanzablesPesoTest() {
		GrafoConPeso g=inicializarGrafoPeso();
		Set<Integer> alcanzables = BFS.alcanzables(g,0);
		int[] esperados = {0,1,2,3,4};
		
		Assert.iguales(esperados, alcanzables);
	}
	@Test
	public void noConexoTest() {
		Grafo g=inicializarGrafo();
		assertFalse(BFS.esConexo(g));
	}
	@Test
	public void noConexoPesoTest() {
		GrafoConPeso g=inicializarGrafoPesoNoConexo();
		assertFalse(BFS.esConexo(g));
	}
	@Test
	public void ConexoTest() {
		Grafo g=inicializarGrafo();
		g.agregarArista(3, 4);
		
		assertTrue(BFS.esConexo(g));
	}
	@Test
	public void ConexoPesoTest() {
		GrafoConPeso g=inicializarGrafoPeso();
		g.agregarArista(3, 4, 2);
		
		assertTrue(BFS.esConexo(g));
	}
	private Grafo inicializarGrafo() {
		Grafo grafo=new Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(2, 3);
		return grafo;
	}
	private GrafoConPeso inicializarGrafoPeso() {
		GrafoConPeso grafo=new GrafoConPeso(5);
		 grafo.agregarArista(0, 1,1);
		 grafo.agregarArista(1, 2,1);
		 grafo.agregarArista(3, 4,2);
		 grafo.agregarArista(2, 3,3);
		return grafo;
	}
	private GrafoConPeso inicializarGrafoPesoNoConexo() {
		GrafoConPeso grafo=new GrafoConPeso(5);
		 grafo.agregarArista(0, 1,1);
		 grafo.agregarArista(2, 3,3);
		return grafo;
	}
}
