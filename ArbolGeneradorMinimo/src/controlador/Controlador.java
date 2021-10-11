package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import grafo.GrafoConPeso;
import grafo.Kruskal;
import interfaz.Usuario;

public class Controlador {
	private Usuario usuario;
	private ArrayList <GrafoConPeso> grafos;
	
	public Controlador(Usuario usuario) {
		this.usuario=usuario;
		this.grafos=new ArrayList<GrafoConPeso>();
	}

	public void iniciarControlador() {
		//hago visible el frame
		this.usuario.getFrame().setVisible(true);
		//controla que luz o boton es pulsado
		controlListeners();
		
	}

	private void controlListeners() {
		controlEmpezar();
		controlGraficar();
		controlGenerar();
	}

	private void controlGenerar() {
		ActionListener bG=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarGrafosViejos();
				crearGrafos();
				agregarAristas();
				anotarEnTabla();
			}
			
		};
		this.usuario.getBotonGenerarNuevosGrafos().addActionListener(bG);
		
	}
	private void limpiarGrafosViejos() {
		this.grafos.clear();
	}
	private void crearGrafos() {
		for(int i=0;i<8;i++) {
			grafos.add(new GrafoConPeso(new Random().nextInt(2)+1));
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
			g.agregarArista(i, i+1,new Random().nextInt(20)+1);
		}
	}
	private void agregarRestodeAristas(GrafoConPeso g,int aristasFaltantes) {
		for(int i=0;i<aristasFaltantes;i++) {
			try {
			g.agregarArista(new Random().nextInt(g.vertices()-1), new Random().nextInt(g.vertices()-1), new Random().nextInt(20)+1);
			}catch (Exception e) {
				i-=1;
			}
		}
	}
	private void anotarEnTabla() {
		for(int i=0;i<grafos.size();i++) {
			usuario.getTable().getModel().setValueAt(i, i, 0);
			usuario.getTable().getModel().setValueAt(grafos.get(i).vertices(), i, 1);
			usuario.getTable().getModel().setValueAt(grafos.get(i).getListaDeAristas().size(), i, 2);
		}
		usuario.getBotonGraficar().setEnabled(true);
	
	}
	private void controlGraficar() {
		ActionListener bGr=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<grafos.size();i++) {
						usuario.getTable().getModel().setValueAt(promedioBFS(grafos.get(i)), i, 3);
						usuario.getTable().getModel().setValueAt(promedioUnion(grafos.get(i)), i, 4);
//					usuario.getDatos().setValue(promedioBFS(g),"BFS", "Grafo con V:"+g.vertices()+" I:"+ grafos.indexOf(g));
//					usuario.getDatos().setValue(promedioUnion(g),"BFS", "Grafo con V:"+g.vertices()+" I:"+ grafos.indexOf(g));
				}
				
			}

			private long promedioBFS(GrafoConPeso g) {
				long promedio=0;
				Kruskal kruskal=new Kruskal();
				for(int i=0;i<10;i++) {
					long inico=System.nanoTime();
					kruskal.kruskalBFS(g);
					long fin=System.nanoTime();
					long tiempo=fin-inico;
					promedio+=tiempo;
				}
				return promedio/10;
			}
			private long promedioUnion(GrafoConPeso g) {
				long promedio=0;
				Kruskal kruskal=new Kruskal();
				for(int i=0;i<10;i++) {
					long inico=System.nanoTime();
					kruskal.kruskalUnion(g);
					long fin=System.nanoTime();
					long tiempo=fin-inico;
					promedio+=tiempo;
				}
				return promedio/10;
			}
		};
		this.usuario.getBotonGraficar().addActionListener(bGr);
	}

	private void controlEmpezar() {
		ActionListener bE=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usuario.getLblTitulo().setVisible(false);
				usuario.getBotonEmpezar().setVisible(false);
				usuario.getBotonGenerarNuevosGrafos().setVisible(true);
				usuario.getBotonGraficar().setVisible(true);
				usuario.getScrollPane().setVisible(true);
			}
			
		};
		this.usuario.getBotonEmpezar().addActionListener(bE);
	}
}
