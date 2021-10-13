package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ContenedorDeGrafos {
	private ArrayList<GrafoConPeso> grafos;
	
	public ContenedorDeGrafos() {
		this.grafos=new ArrayList<GrafoConPeso>();
	}
	public Integer [][] generarGrafos(int cantGrafos){
		limpiarGrafosViejos();
		crearGrafos(cantGrafos);
		agregarAristas();
		return matrizGrafos();
	}
	public Long[][] generarTiempos() {
		Long [][] matriz =new Long[grafos.size()][2];
		for(int i=0;i<grafos.size();i++) {
			matriz[i][0]=promedioBFS(grafos.get(i));
			matriz[i][1]=promedioUnion(grafos.get(i));
		}
		return matriz;
	}
	private Long promedioBFS(GrafoConPeso g) {
		Long promedio=(long) 0;
		Kruskal kruskal=new Kruskal();
		for(int i=0;i<10;i++) {
			Long inico=System.nanoTime()/1000;
			kruskal.kruskalBFS(g);
			Long fin=System.nanoTime()/1000;
			Long tiempo=fin-inico;
			promedio+=tiempo;
		}
		return promedio/10;
	}
	private Long promedioUnion(GrafoConPeso g) {
	    Long promedio=(long) 0;
		Kruskal kruskal=new Kruskal();
		for(int i=0;i<10;i++) {
			Long inicio=System.nanoTime()/1000;
			kruskal.kruskalUnion(g);
			Long fin=System.nanoTime()/1000;//microsegundos
			Long tiempo=fin-inicio;
			promedio+=tiempo;
		}
		return promedio/10;
	}
	private void limpiarGrafosViejos() {
		this.grafos.clear();
	}
	private void crearGrafos(int cantGrafos) {
		for(int i=0;i<cantGrafos;i++) {
			grafos.add(new GrafoConPeso(new Random().nextInt(100)));
		}
		Collections.sort(grafos);
	}
	private void agregarAristas() {
		for(GrafoConPeso g: grafos) {
			conexar(g);
			int masAristas=new Random().nextInt(10)+1;
			agregarRestodeAristas(g,masAristas);
		}
		
	}
	private void conexar(GrafoConPeso g) {
		for(int i=0;i<g.vertices()-1;i++) {
			g.agregarArista(i, i+1,new Random().nextInt(40)+1);
		}
	}
	private void agregarRestodeAristas(GrafoConPeso g,int aristasFaltantes) {
		if(g.vertices()<=2) {
			return;
		}
		for(int i=0;i<aristasFaltantes;i++) {
			int verticeA=new Random().nextInt(g.vertices()-1);
			int verticeB=new Random().nextInt(g.vertices()-1);
				if(verticeA!=verticeB) {
				g.agregarArista(verticeA, verticeB, new Random().nextInt(20)+1);
				}
				else{
					i-=1;
				
				}
		}
	}
	private Integer[][] matrizGrafos() {
		Integer[][] matriz=new Integer[grafos.size()][3];
		for(int i=0;i< grafos.size();i++) {
			matriz[i][0]=i;
			matriz[i][1]=grafos.get(i).vertices();
			matriz[i][2]=grafos.get(i).getListaDeAristas().size();
		}
		return matriz;
	}
}
