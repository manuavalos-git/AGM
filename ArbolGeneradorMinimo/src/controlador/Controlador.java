package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import grafo.ContenedorDeGrafos;
import interfaz.Usuario;

public class Controlador {
	private Usuario usuario;
	private ContenedorDeGrafos contenedor;
	
	public Controlador(Usuario usuario,ContenedorDeGrafos contenedor) {
		this.usuario=usuario;
		this.contenedor=contenedor;
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
				usuario.getTable().setModel(new DefaultTableModel(
					contenedor.generarGrafos(),
					new String[] {
					"Grafo", "Cantidad de Vertice", "Cantidad de Aristas"
					}
				));
				usuario.getScrollPane().setViewportView(usuario.getTable());
				usuario.getBotonGraficar().setEnabled(true);
			}
		};
		this.usuario.getBotonGenerarNuevosGrafos().addActionListener(bG);
	}

	private void controlGraficar() {
		ActionListener bGr=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usuario.getTable2().setModel(new DefaultTableModel(
						contenedor.generarTiempos(),
						new String[] {
						"Tiempo BFS", "Tiempo Union-Find"
						}
					));
					usuario.getScrollPane2().setViewportView(usuario.getTable2());
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
				usuario.getScrollPane2().setVisible(true);
				usuario.getLblMicrosegundos().setVisible(true);
				usuario.getLblValores().setVisible(true);
			}
			
		};
		this.usuario.getBotonEmpezar().addActionListener(bE);
	}
}
