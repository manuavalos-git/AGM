package grafo;

import org.junit.Test;

public class KruskalTest {

	@Test
	public void testKruskalBFS() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalBFS(grafo1);
		grafo2=kruskal.kruskalBFS(grafo2);
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}

	@Test
	public void testKruskalUnion() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalUnion(grafo1);
		grafo2=kruskal.kruskalUnion(grafo2);
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}

	private GrafoConPeso inicializarGrafoFeliz() {
		GrafoConPeso grafo=new GrafoConPeso(4);
		
		grafo.agregarArista(0, 3, 2);
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(2, 3, 1);
		
		return grafo;
	}
}
