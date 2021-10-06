package grafo;

public class Kruskal {
		public GrafoConPeso kruskalBFS(GrafoConPeso grafo) {
			if(grafo.vertices()==0 || grafo.vertices()==1) {
				return grafo;
			}
			if(!BFS.esConexo(grafo)){
				throw new IllegalArgumentException("El grafo debe ser conexo" );
			}
			else {
				grafo.ordenarListaPorPeso(grafo.getListaDeAristas());
				int cantAristasRet=0;
				GrafoConPeso grafoRet=new GrafoConPeso(grafo.vertices());
				while(cantAristasRet<grafo.vertices()) {
					for(int i=0;i<grafo.getListaDeAristas().size();i++) {
						if(!BFS.alcanzables(grafoRet,grafo.getListaDeAristas().get(i).getVerticeA()).contains(grafo.getListaDeAristas().get(i).getVerticeB())) {
							grafoRet.agregarArista(grafo.getListaDeAristas().get(i).getVerticeA(),grafo.getListaDeAristas().get(i).getVerticeB(),grafo.getListaDeAristas().get(i).getPeso());
							i=grafo.getListaDeAristas().size();
							cantAristasRet++;
						}
					}
				}
				return grafoRet;
			}
			
		}
		public GrafoConPeso kruskalUnion(GrafoConPeso grafo) {
			if(grafo.vertices()==0 || grafo.vertices()==1) {
				return grafo;
			}
			if(!BFS.esConexo(grafo)){
				throw new IllegalArgumentException("El grafo debe ser conexo" );
			}
			else {
				grafo.ordenarListaPorPeso(grafo.getListaDeAristas());
				int cantAristasRet=0;
				GrafoConPeso grafoRet=new GrafoConPeso(grafo.vertices());
				UnionFind unionFind=new UnionFind(grafo.vertices());
				while(cantAristasRet<grafo.vertices()) {
					for(int i=0;i<grafo.getListaDeAristas().size();i++) {
						if(!unionFind.find(grafo.getListaDeAristas().get(i).getVerticeA(),grafo.getListaDeAristas().get(i).getVerticeB())) {
							unionFind.union(grafo.getListaDeAristas().get(i).getVerticeA(), grafo.getListaDeAristas().get(i).getVerticeB());
							grafoRet.agregarArista(grafo.getListaDeAristas().get(i).getVerticeA(),grafo.getListaDeAristas().get(i).getVerticeB(),grafo.getListaDeAristas().get(i).getPeso());
							i=grafo.getListaDeAristas().size();
							cantAristasRet++;
						}
					}
				}
				return grafoRet;
			}
			
		}
}
