package grafo;

public class Vertice {
	private int padre;
	private int componente;
	
	public Vertice(int padre) {
		this.padre=padre;
		this.componente=1;
	}
	public int getPadre() {
		return padre;
	}
	public void setPadre(int padre) {
		this.padre = padre;
	}
	public int getCantComponente() {
		return componente;
	}
	public void setCantComponente(int componente) {
		this.componente = componente;
	}
	
}
