package grafo;

import java.util.ArrayList;

public class UnionFind {
	private ArrayList <Vertice> padres;

	 public UnionFind(int i) {
		 this.padres= new ArrayList<Vertice>();
		 inicializar(i);
	 }
	 private void inicializar(int i){
		 for(int j=0;j<i;j++) {
			 this.padres.add(new Vertice(j));
		 }
	 }
	 public void union(int i,int j) {
		 verificarIguales(i,j);
		 verificarNegativo(i,j);
		 int raizI=root(i);
		 int raizJ=root(j);
		 int sumaDeComponentes = padres.get(raizI).getCantComponente() + padres.get(raizJ).getCantComponente();
		 
		 if(padres.get(raizI).getCantComponente() <= padres.get(raizJ).getCantComponente() ) {
			 pathCompression(i,raizJ,sumaDeComponentes);
	 	}
		 else pathCompression(j,raizI,sumaDeComponentes);
	}
	private void verificarIguales(int raizI, int raizJ) {
		if(raizI==raizJ) {
			 throw new IllegalArgumentException("las argumentos no pueden ser iguales");
		 }
	}
	private void verificarNegativo(int raizI, int raizJ) {
		if(raizI<0 || raizJ<0) {
			 throw new IllegalArgumentException("los argumentos no pueden ser negativas");
		 }
	}
	 private void pathCompression(int i, int root, int sumaDeComponentes) {
		padres.get(i).setPadre(root);
		padres.get(root).setCantComponente(sumaDeComponentes);
	 }
	 public boolean find(int i,int j) {
		 verificarNegativo(i,j);
		 if(i==j) {
			 return true;
		 }
		 return root(i)==root(j);
	 }
	 private int root(int i) {
		while(padres.get(i).getPadre()!=i) {
			if(padres.get(i).getPadre()== -1) {
				return i;
			}
			i=padres.get(i).getPadre();
		}
		return i;
	}
	
}
