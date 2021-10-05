package grafo;

import java.util.ArrayList;

public class GrafoConPeso extends Grafos {

	private ArrayList <Arista> listaDeAristas;
	
	public GrafoConPeso(int vertices) {
		super(vertices);
		this.listaDeAristas=new ArrayList <Arista>() ;
	}
	
	public void agregarArista(int i, int j,int peso)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = true;
		A[j][i] = true;
		Arista nueva=new Arista(i,j,peso);
		if(!listaDeAristas.contains(nueva)) {
			listaDeAristas.add(nueva);
		}
	}
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = false;
		A[j][i] = false;
		
		for(Arista a: listaDeAristas) {
			if((a.getVerticeA()==i && a.getVerticeB()==j)||(a.getVerticeA()==j && a.getVerticeB()==i)) {
				listaDeAristas.remove(a);
			}
		}
		
	}
	public ArrayList<Arista> getListaDeAristas() {
	return listaDeAristas;
	}
	
}
