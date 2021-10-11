package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Usuario {

	private JFrame frame;
	private JButton botonGraficar,botonEmpezar,botonGenerarNuevosGrafos;
	private JProgressBar progressBar;
	private JLabel lblTitulo;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;

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
		
		this.lblTitulo = new JLabel("Kruskal\r\n");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblTitulo.setBounds(140, 139, 300, 90);
		panel.add(lblTitulo);
		
		this.botonEmpezar = new JButton();
		botonEmpezar.setText("empezar");
		botonEmpezar.setBounds(243, 355, 100, 20);
		panel.add(botonEmpezar);
		
		this.botonGenerarNuevosGrafos = new JButton();
		botonGenerarNuevosGrafos.setText("generar nuevos grafos\r\n");
		botonGenerarNuevosGrafos.setBounds(410, 15, 161, 20);
		panel.add(botonGenerarNuevosGrafos);
		botonGenerarNuevosGrafos.setVisible(false);
		
		this.botonGraficar = new JButton();
		botonGraficar.setEnabled(false);
		botonGraficar.setText("graficar kruskal");
		botonGraficar.setBounds(425, 289, 146, 20);
		panel.add(botonGraficar);
		botonGraficar.setVisible(false);
		
		this.progressBar = new JProgressBar();
		progressBar.setBounds(58, 355, 146, 14);
		panel.add(progressBar);
		progressBar.setVisible(false);
		//panel.add(table);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 390, 155);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		
		this.table = new JTable();
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
	
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Grafo", "Cantidad de Vertice", "Cantidad de Aristas"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		
	
		
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTable() {
		return table;
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
