package grafo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConsultaDeVecinosTest
{
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		Grafos grafo = new Grafos(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest()
	{
		Grafos grafo = new Grafos(5);
		grafo.vecinos(5);
	}

	@Test
	public void todosAisladosTest()
	{
		Grafos grafo = new Grafos(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	
	@Test
	public void verticeUniversalTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		
		int[] esperado = {0, 2, 3};
		Assert.iguales(esperado, grafo.vecinos(1));
	}
	@Test
	public void verticeUniversalPesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(4);
		grafo.agregarArista(1, 0,1);
		grafo.agregarArista(1, 2,2);
		grafo.agregarArista(1, 3,2);
		
		int[] esperado = {0, 2, 3};
		Assert.iguales(esperado, grafo.vecinos(1));
	}
	
	@Test
	public void verticeNormalTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		
		int[] esperados = {1, 2};
		Assert.iguales(esperados, grafo.vecinos(3));
	}
	
	@Test
	public void verticeNormalPesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 3,2);
		grafo.agregarArista(2, 3,1);
		grafo.agregarArista(2, 4,1);
		
		int[] esperados = {1, 2};
		Assert.iguales(esperados, grafo.vecinos(3));
	}
}
