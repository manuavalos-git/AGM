package grafo;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
		// Representamos el grafo por su matriz de adyacencia
		protected boolean[][] A;
		
		// La cantidad de vertices esta predeterminada desde el constructor
		public Grafo(int vertices) {
			A = new boolean[vertices][vertices];
		}
		// Informa si existe la arista especificada
		protected boolean existeArista(int i, int j)
		{
			verificarVertice(i);
			verificarVertice(j);
			verificarDistintos(i, j);

			return A[i][j];
		}

		// Cantidad de vertices
		public int vertices()
		{
			return A.length;
		}
		
		// Vecinos de un vertice
		protected Set<Integer> vecinos(int i)
		{
			verificarVertice(i);
			
			Set<Integer> ret = new HashSet<Integer>();
			for(int j = 0; j < this.vertices(); ++j) if( i != j )
			{
				if( this.existeArista(i,j) )
					ret.add(j);
			}
			
			return ret;		
		}
		
		// Verifica que sea un vertice valido
		protected void verificarVertice(int i)
		{
			if( i < 0 )
				throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
			
			if( i >= A.length )
				throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
		}

		// Verifica que i y j sean distintos
		protected void verificarDistintos(int i, int j)
		{
			if( i == j )
				throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
		}
}
