package mvc;

import java.awt.EventQueue;

import javax.swing.UIManager;
import interfaz.Usuario;
import controlador.Controlador;
import grafo.ContenedorDeGrafos;

public class MVC {
	public static void main(String[] args) {
		
		//inicializo objetos
		Usuario usuario=new Usuario();
		ContenedorDeGrafos contenedor=new ContenedorDeGrafos();
		Controlador controlador=new Controlador(usuario,contenedor);
		
		try
		 {
		//cambio el LookAndFeel
		 UIManager.setLookAndFeel(
		 UIManager.getSystemLookAndFeelClassName());
		 }
		catch(Exception e) { 
			e.printStackTrace();
		} 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//inicia el cotrolador
					controlador.iniciarControlador();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
