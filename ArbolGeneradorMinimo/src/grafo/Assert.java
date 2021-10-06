package grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Assert
{
	public static void iguales(int[] esperado, Set<Integer> obtenido)
	{
		assertEquals(esperado.length, obtenido.size());
		
		for(int i=0; i<esperado.length; ++i)
			assertTrue( obtenido.contains(esperado[i]) );
	}
	public static void grafoMinimoEsperado(GrafoConPeso grafo1,GrafoConPeso kruskal)
	{
		int peso=0;
		int peso1=0;
		assertEquals(grafo1.vertices()-1, kruskal.getListaDeAristas().size());
		assertTrue(BFS.esConexo(kruskal));
		for(Arista a: kruskal.getListaDeAristas()) {
			peso+=a.getPeso();
		}
		for(int i=0;i<grafo1.vertices();i++) {
			peso1+=grafo1.getListaDeAristas().get(i).getPeso();
		}
		assertEquals(peso, peso1);
	}
}
