package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GrafoConPeso extends Grafos {

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
	protected void ordenarListaPorPeso(ArrayList<Arista> aristasGrafo) {
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
	public ArrayList<Arista> getListaDeAristas() {
	return listaDeAristas;
	}
}
