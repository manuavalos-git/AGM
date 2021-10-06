package grafo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdicionDeAristasTest
{
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 2);
	}

	@Test
	public void aristaExistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue( grafo.existeArista(2, 3) );
	}
	@Test
	public void aristaExistentePesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		Arista arista=new Arista(2, 3, 4);
		grafo.agregarArista(2, 3,4);
		assertTrue( grafo.existeArista(2, 3) && grafo.getListaDeAristas().contains(arista));
	}
	@Test
	public void aristaOpuestaTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue( grafo.existeArista(3, 2) );
	}
	@Test
	public void aristaOpuestaPesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		Arista arista=new Arista(3, 2, 4);
		grafo.agregarArista(2, 3, 4);
		assertTrue( grafo.existeArista(3, 2) && grafo.getListaDeAristas().contains(arista) );
	}

	@Test
	public void aristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertFalse( grafo.existeArista(1, 4) );
	}
	@Test
	public void aristaInexistentePesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		Arista arista=new Arista(1, 4, 4);
		
		grafo.agregarArista(2, 3,1);
		
		assertFalse( grafo.existeArista(1, 4) || grafo.getListaDeAristas().contains(arista));
	}

	@Test
	public void agregarAristaDosVecesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 3);

		assertTrue( grafo.existeArista(2, 3) );
	}
	@Test
	public void agregarAristaPesoDosVecesTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(2, 3,1);
		grafo.agregarArista(2, 3,2);

		assertTrue( grafo.existeArista(2, 3) && grafo.getListaDeAristas().get(grafo.getListaDeAristas().size()-1).getPeso()==2 && grafo.getListaDeAristas().get(grafo.getListaDeAristas().size()-1).getPeso()!=1 );
	}
	
	@Test
	public void eliminarAristaExistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	@Test
	public void eliminarAristaExistentePesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(2, 4, 4);
		Arista arista=new Arista(2, 4, 4);
		
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) || grafo.getListaDeAristas().contains(arista));
	}

	@Test
	public void eliminarAristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	@Test
	public void eliminarAristaInexistentePesoTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	@Test
	public void eliminarAristaDosVecesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		
		grafo.eliminarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	@Test
	public void eliminarAristaPesoDosVecesTest()
	{
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(2, 4,1);
		Arista arista=new Arista(2, 4, 1);
		
		grafo.eliminarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) || grafo.getListaDeAristas().contains(arista) );
	}
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaPesoNegativo() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(2, 4,-1);
	}
}
