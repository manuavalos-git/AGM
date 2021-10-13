package grafo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KruskalTest {

	@Test
	public void testKruskalBFS() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalBFS(grafo1);
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void noConexoKruskalBFS() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoNoConexo();
		
		kruskal.kruskalBFS(grafo1);
	}
	@Test
	public void kruskalBFSgrafo0() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=new GrafoConPeso(0);
		
		GrafoConPeso grafo2=kruskal.kruskalBFS(grafo1);
		
		assertEquals(grafo2.vertices(),0);
	}
	@Test
	public void kruskalBFSgrafo1() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=new GrafoConPeso(1);
		
		GrafoConPeso grafo2=kruskal.kruskalBFS(grafo1);
		
		assertEquals(grafo2.vertices(),1);
	}
	@Test
	public void muchasVecesKruskalBFS() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalBFS(grafo1);
		grafo2=kruskal.kruskalBFS(grafo2);
		grafo2=kruskal.kruskalBFS(grafo2);
		grafo2=kruskal.kruskalBFS(grafo2);
		grafo2=kruskal.kruskalBFS(grafo2);
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}

	@Test
	public void testKruskalUnion() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalUnion(grafo1);
		
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void noConexoKruskalUnion() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoNoConexo();
		
		kruskal.kruskalUnion(grafo1);
	}
	@Test
	public void kruskalUniongrafo0() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=new GrafoConPeso(0);
		
		GrafoConPeso grafo2=kruskal.kruskalUnion(grafo1);
		
		assertEquals(grafo2.vertices(),0);
	}
	@Test
	public void kruskalUniongrafo1() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=new GrafoConPeso(1);
		
		GrafoConPeso grafo2=kruskal.kruskalUnion(grafo1);
		
		assertEquals(grafo2.vertices(),1);
	}
	@Test
	public void muchaVecesKruskalUnion() {
		Kruskal kruskal=new Kruskal();
		GrafoConPeso grafo1=inicializarGrafoFeliz();
		
		GrafoConPeso grafo2=kruskal.kruskalUnion(grafo1);
		grafo2=kruskal.kruskalUnion(grafo2);
		grafo2=kruskal.kruskalUnion(grafo2);
		grafo2=kruskal.kruskalUnion(grafo2);
		grafo2=kruskal.kruskalUnion(grafo2);
		
		Assert.grafoMinimoEsperado(grafo1, grafo2);
	}

	private GrafoConPeso inicializarGrafoNoConexo() {
		GrafoConPeso grafo=new GrafoConPeso(5);
		
		grafo.agregarArista(0, 3, 2);
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(2, 3, 1);
		
		return grafo;
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
