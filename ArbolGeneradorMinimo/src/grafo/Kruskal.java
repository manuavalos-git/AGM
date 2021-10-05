package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
		public GrafoConPeso kruskalBFS(GrafoConPeso grafo) {
			if(grafo.vertices()==0 || grafo.vertices()==1) {
				return grafo;
			}
			if(!BFS.esConexo(grafo)){
				throw new IllegalArgumentException("El grafo debe ser conexo" );
			}
			else {
				ArrayList <Arista> aristasGrafo=grafo.getListaDeAristas();
				ordenarListaPorPeso(aristasGrafo);
				int cantAristasRet=0;
				GrafoConPeso grafoRet=new GrafoConPeso(grafo.vertices());
				while(cantAristasRet<grafo.vertices()) {
					for(int i=0;i<aristasGrafo.size();i++) {
						if(!BFS.alcanzables(grafoRet,aristasGrafo.get(i).getVerticeA()).contains(aristasGrafo.get(i).getVerticeB())) {
							grafoRet.agregarArista(aristasGrafo.get(i).getVerticeA(),aristasGrafo.get(i).getVerticeB(),aristasGrafo.get(i).getPeso());
							cantAristasRet++;
						}
					}
				}
				return grafoRet;
			}
			
		}

		private void ordenarListaPorPeso(ArrayList<Arista> aristasGrafo) {
			Collections.sort(aristasGrafo,new Comparator<Arista>() {
				@Override
				public int compare(Arista a1, Arista a2) {
					if(a1.getPeso()<a2.getPeso()) {
						return -1;
					}
					if(a1.getPeso() == a2.getPeso()) {
						return 0;
					}
					return 1;
				}
			});
		}
}
