package grafo;

import java.util.ArrayList;

public class GrafoConPeso extends Grafo implements Comparable<GrafoConPeso>{

	private ArrayList <Arista> listaDeAristas;
	
	public GrafoConPeso(int vertices) {
		super(vertices);
		this.listaDeAristas=new ArrayList <Arista>() ;
	}
	
	public void agregarArista(int i, int j,int peso)
	{
		verificarPeso(peso);
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = true;
		A[j][i] = true;
		Arista nueva=new Arista(i,j,peso);
		if(!listaDeAristas.contains(nueva)) {
			listaDeAristas.add(nueva);
		}
		else {
			listaDeAristas.remove(nueva);
			listaDeAristas.add(nueva);
		}
	}

	private void verificarPeso(int peso) {
		if(peso<0) {
			throw new IllegalArgumentException("El peso no puede ser negativo");
		}
	}
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = false;
		A[j][i] = false;
		
		Arista aristaA=new Arista(i, j,1);
	
		if(listaDeAristas.contains(aristaA)) {
			listaDeAristas.remove(aristaA);
		}
	}
	public ArrayList<Arista> getListaDeAristas() {
	return listaDeAristas;
	}

	@Override
	public int compareTo(GrafoConPeso o) {
		if(this.vertices()<o.vertices()) {
			return -1;
		}
		if(this.vertices() == o.vertices()) {
			return 0;
		}
		return 1;
	}
}
