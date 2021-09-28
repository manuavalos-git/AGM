package grafo;

public class Vertice {
	private int root;
	private int padre;
	private int componente;
	
	public  Vertice(int raiz) {
		this.padre=raiz;
		this.root=raiz;
		this.componente=1;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
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
