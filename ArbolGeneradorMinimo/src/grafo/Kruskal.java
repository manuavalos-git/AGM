package grafo;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
		public GrafoConPeso kruskalBFS(GrafoConPeso grafo) {
			if(grafo.vertices()==0 || grafo.vertices()==1) {
				return grafo;
			}
			if(!BFS.esConexo(grafo)){
				throw new IllegalArgumentException("El grafo debe ser conexo" );
			}
			else {
				ArrayList <Arista> copia= new ArrayList <Arista>();
				Collections.sort(grafo.getListaDeAristas());
				copiarContenido(copia,grafo.getListaDeAristas());
				int cantAristasRet=0;
				GrafoConPeso grafoRet=new GrafoConPeso(grafo.vertices());
				while(cantAristasRet<grafo.vertices()-1) {
					int i=0;
					while(i<copia.size()) {
						if(!BFS.alcanzables(grafoRet,copia.get(i).getVerticeA()).contains(copia.get(i).getVerticeB())) {
							grafoRet.agregarArista(copia.get(i).getVerticeA(),copia.get(i).getVerticeB(),copia.get(i).getPeso());
							copia.remove(i);
							i=copia.size();
							cantAristasRet++;
						}
						else{
							i++;
						}	
					}
				}
				return grafoRet;
			}
			
		}
		private void copiarContenido(ArrayList<Arista> ret, ArrayList<Arista> listaDeAristas) {
			for(Arista a: listaDeAristas){
				ret.add(a);
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
				ArrayList <Arista> copia= new ArrayList <Arista>();
				Collections.sort(grafo.getListaDeAristas());
				copiarContenido(copia,grafo.getListaDeAristas());
				int cantAristasRet=0;
				GrafoConPeso grafoRet=new GrafoConPeso(grafo.vertices());
				UnionFind unionFind=new UnionFind(grafo.vertices());
				while(cantAristasRet<grafo.vertices()-1) {
					int i=0;
					while(i<copia.size()) {
						if(!unionFind.find(copia.get(i).getVerticeA(),copia.get(i).getVerticeB())) {
							unionFind.union(copia.get(i).getVerticeA(), copia.get(i).getVerticeB());
							grafoRet.agregarArista(copia.get(i).getVerticeA(),copia.get(i).getVerticeB(),copia.get(i).getPeso());
							copia.remove(i);
							i=copia.size();
							cantAristasRet++;
						}
					}
					
				}
				return grafoRet;
			}
			
		}
}
