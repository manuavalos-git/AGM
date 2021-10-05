package grafo;

public class Grafo extends Grafos
{	
	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices) {
		super(vertices);
	}
	// Agregado de aristas
	public void agregarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = true;
		A[j][i] = true;
	}
	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = false;
		A[j][i] = false;	
	}
}
