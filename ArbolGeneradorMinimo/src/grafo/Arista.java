package grafo;

public class Arista{
	private int verticeA;
	private int verticeB;
	private int peso;
	
	public Arista(int verticeA,int verticeB,int peso) {
		this.verticeA=verticeA;
		this.verticeB=verticeB;
		this.peso=peso;
	}
	
	public int getVerticeA() {
		return verticeA;
	}

	public int getVerticeB() {
		return verticeB;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || this.getClass()!= obj.getClass()) {
			return false;
		}
		Arista otro= (Arista)obj;
		return(this.peso==otro.peso && ((this.verticeA==otro.verticeA && this.verticeB==otro.verticeB)||(this.verticeA==otro.verticeB && this.verticeB==otro.verticeA))) ;
	}
}
