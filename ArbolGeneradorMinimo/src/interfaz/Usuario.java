package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Usuario {

	private JFrame frame;
	private JButton botonGraficar,botonEmpezar,botonGenerarNuevosGrafos;
	private JProgressBar progressBar;
	private JLabel lblTitulo;
	private JPanel panel;
	private JTable table,table2;
	private JScrollPane scrollPane,scrollPane2;

	/**
	 * Create the application.
	 */
	public Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		frame.setBounds(100, 100, 596, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    this.panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		this.botonEmpezar = new JButton();
		botonEmpezar.setText("empezar");
		botonEmpezar.setBounds(243, 355, 100, 20);
		panel.add(botonEmpezar);
		
		this.botonGenerarNuevosGrafos = new JButton();
		botonGenerarNuevosGrafos.setText("generar nuevos grafos\r\n");
		botonGenerarNuevosGrafos.setBounds(109, 324, 161, 20);
		panel.add(botonGenerarNuevosGrafos);
		botonGenerarNuevosGrafos.setVisible(false);
		
		this.botonGraficar = new JButton();
		botonGraficar.setEnabled(false);
		botonGraficar.setText("graficar tiempos");
		botonGraficar.setBounds(410, 324, 146, 20);
		panel.add(botonGraficar);
		botonGraficar.setVisible(false);
		
		this.progressBar = new JProgressBar();
		progressBar.setBounds(109, 288, 146, 14);
		panel.add(progressBar);
		progressBar.setVisible(false);
		//panel.add(table);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 122, 353, 155);
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		
		this.scrollPane2= new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(410, 122, 146, 155);
		scrollPane2.setVisible(false);
		panel.add(scrollPane2);
		
		this.lblTitulo = new JLabel("Kruskal\r\n");
		lblTitulo.setBounds(225, 177, 118, 45);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
	
		
		this.table = new JTable();
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowSelectionAllowed(false);
		
		this.table2 = new JTable();
		table2.setFocusable(false);
		table2.setAutoscrolls(false);
		table2.setRowSelectionAllowed(false);

	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JScrollPane getScrollPane2() {
		return scrollPane2;
	}

	public JTable getTable() {
		return table;
	}
	
	public JTable getTable2() {
		return table2;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBotonGraficar() {
		return botonGraficar;
	}

	public JButton getBotonEmpezar() {
		return botonEmpezar;
	}

	public JButton getBotonGenerarNuevosGrafos() {
		return botonGenerarNuevosGrafos;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public JFrame getFrame() {
			return this.frame;
	}
}
