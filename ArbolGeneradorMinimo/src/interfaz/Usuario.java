package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Usuario {

	private JFrame frame;
	private JButton botonGraficar,botonEmpezar,botonGenerarNuevosGrafos;
	private JLabel lblTitulo;
	private JPanel panel;
	private JTable table,table2;
	private JScrollPane scrollPane,scrollPane2;
	private JLabel lblValores;
	private JLabel lblMicrosegundos;

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
		frame.setBounds(100, 100, 642, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    this.panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		this.botonEmpezar = new JButton();
		botonEmpezar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		botonEmpezar.setText("Empezar");
		botonEmpezar.setBounds(263, 344, 100, 20);
		panel.add(botonEmpezar);
		
		this.botonGenerarNuevosGrafos = new JButton();
		botonGenerarNuevosGrafos.setFont(new Font("Segoe UI", Font.BOLD, 11));
		botonGenerarNuevosGrafos.setText("Generar nuevos grafos\r\n");
		botonGenerarNuevosGrafos.setBounds(96, 380, 161, 20);
		panel.add(botonGenerarNuevosGrafos);
		botonGenerarNuevosGrafos.setVisible(false);
		
		this.botonGraficar = new JButton();
		botonGraficar.setEnabled(false);
		botonGraficar.setText("Graficar tiempos");
		botonGraficar.setBounds(424, 380, 146, 20);
		panel.add(botonGraficar);
		botonGraficar.setVisible(false);
		//panel.add(table);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 43, 353, 321);
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		
		this.scrollPane2= new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(378, 43, 238, 321);
		scrollPane2.setVisible(false);
		panel.add(scrollPane2);
		
		this.lblTitulo = new JLabel("Kruskal\r\n");
		lblTitulo.setBounds(225, 177, 118, 45);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 37));
		
		this.lblValores = new JLabel("Valores de los grafos generados :");
		lblValores.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblValores.setBounds(65, 11, 215, 21);
		lblValores.setVisible(false);
		panel.add(lblValores);
		
		this.lblMicrosegundos = new JLabel("Microsegundos :");
		lblMicrosegundos.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMicrosegundos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMicrosegundos.setBounds(424, 11, 146, 21);
		lblMicrosegundos.setVisible(false);
		panel.add(lblMicrosegundos);
	
		
		this.table = new JTable();
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowSelectionAllowed(false);
		
		this.table2 = new JTable();
		table2.setFocusable(false);
		table2.setAutoscrolls(false);
		table2.setRowSelectionAllowed(false);

	}
	public JLabel getLblValores() {
		return lblValores;
	}

	public JLabel getLblMicrosegundos() {
		return lblMicrosegundos;
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

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public JFrame getFrame() {
			return this.frame;
	}
}
