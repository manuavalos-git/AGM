package grafo;

import java.util.ArrayList;

public class UnionFind {
	
	private ArrayList <Vertice> A;

	 public void union(int i,int j) {
		 int sumaDeComponentes = A.get(A.get(i).getRoot()).getCantComponente() + A.get(A.get(j).getRoot()).getCantComponente();
//	 if(A.get(i).getCantComponente() == A.get(j).getCantComponente()) {
		 //kbfkjbadfkj
		 pathCompression(i,A.get(j).getRoot(),sumaDeComponentes);
//	 }
	}
	private void pathCompression(int i, int root, int sumaDeComponentes) {
		A.get(i).setPadre(root);
		A.get(i).setRoot(root);
		A.get(root).setCantComponente(sumaDeComponentes);
	}
	public boolean find(int i,int j) {
		 return root(i)==root(j);
	 }
	 private int root(int i) {
//		while(A[i]!=i) {
//			i=A[i];
//		}
//		return i;
		 return A.get(i).getRoot();
	}
	
}
