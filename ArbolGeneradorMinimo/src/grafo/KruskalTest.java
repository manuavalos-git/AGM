package grafo;

import org.junit.Test;

public class KruskalTest {

	@Test
	public void testKruskalBFS() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalBFS(grafo1);
	
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}

//	@Test
//	public void testKruskalUnion() {
//		assertTrue(1==1);
//	}

	private GrafoConPeso inicializarGrafoFeliz() {
		GrafoConPeso grafo=new GrafoConPeso(6);
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(3, 2, 1);
		grafo.agregarArista(2, 4, 1);
		grafo.agregarArista(4, 5, 1);
		grafo.agregarArista(0, 2, 4);
		grafo.agregarArista(1, 4, 2);
		grafo.agregarArista(0, 5, 2);
		grafo.agregarArista(3, 5, 2);
		
		return grafo;
	}
}
