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
import java.awt.Color;
import java.awt.Insets;
import java.awt.Frame;
import java.awt.Toolkit;

public class Usuario {

	private JFrame frmKruskal;
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
		this.frmKruskal = new JFrame();
		frmKruskal.setIconImage(Toolkit.getDefaultToolkit().getImage(Usuario.class.getResource("/multimedia/icono.png")));
		frmKruskal.setTitle("Kruskal");
		frmKruskal.setExtendedState(Frame.MAXIMIZED_BOTH);
//		frame.setResizable(false);
		frmKruskal.setBounds(100, 100, 1281, 672);
		frmKruskal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    this.panel = new JPanel();
	    panel.setBackground(new Color(255, 228, 225));
		frmKruskal.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		this.botonEmpezar = new JButton();
		botonEmpezar.setRolloverEnabled(false);
		botonEmpezar.setFocusable(false);
		botonEmpezar.setMargin(new Insets(7, 14, 7, 14));
		botonEmpezar.setIconTextGap(0);
		botonEmpezar.setBorder(null);
		botonEmpezar.setBackground(new Color(176, 224, 230));
		botonEmpezar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonEmpezar.setText("Empezar");
		botonEmpezar.setBounds(570, 537, 121, 39);
		panel.add(botonEmpezar);
		
		this.botonGenerarNuevosGrafos = new JButton();
		botonGenerarNuevosGrafos.setFocusable(false);
		botonGenerarNuevosGrafos.setBorder(null);
		botonGenerarNuevosGrafos.setForeground(new Color(0, 0, 0));
		botonGenerarNuevosGrafos.setBackground(new Color(176, 224, 230));
		botonGenerarNuevosGrafos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonGenerarNuevosGrafos.setText("Generar nuevos grafos\r\n");
		botonGenerarNuevosGrafos.setBounds(219, 587, 263, 32);
		panel.add(botonGenerarNuevosGrafos);
		botonGenerarNuevosGrafos.setVisible(false);
		
		this.botonGraficar = new JButton();
		botonGraficar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonGraficar.setFocusable(false);
		botonGraficar.setBorder(null);
		botonGraficar.setBackground(new Color(176, 224, 230));
		botonGraficar.setEnabled(false);
		botonGraficar.setText("Graficar tiempos");
		botonGraficar.setBounds(922, 587, 229, 32);
		panel.add(botonGraficar);
		botonGraficar.setVisible(false);
		//panel.add(table);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 240, 245));
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 61, 703, 495);
		scrollPane.getViewport().setBackground(new Color(255, 240, 245));
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		
		this.scrollPane2= new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setFocusable(false);
		scrollPane2.setWheelScrollingEnabled(false);
		scrollPane2.setBackground(new Color(255, 240, 245));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(783, 61, 483, 495);
		scrollPane2.getViewport().setBackground(new Color(255, 240, 245));
		scrollPane2.setVisible(false);
		panel.add(scrollPane2);
		
		this.lblTitulo = new JLabel("Kruskal\r\n");
		lblTitulo.setBounds(312, 201, 635, 215);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 90));
		
		this.lblValores = new JLabel("Valores de los grafos generados :");
		lblValores.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblValores.setBounds(146, 11, 414, 39);
		lblValores.setVisible(false);
		panel.add(lblValores);
		
		this.lblMicrosegundos = new JLabel("Microsegundos :");
		lblMicrosegundos.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblMicrosegundos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMicrosegundos.setBounds(922, 11, 229, 39);
		lblMicrosegundos.setVisible(false);
		panel.add(lblMicrosegundos);
	
		
		this.table = new JTable();
		table.setBackground(new Color(255, 240, 245));
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowHeight(18);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBorder(null);
		table.getTableHeader().setBackground(new Color(176, 224, 230));
		table.setRowSelectionAllowed(false);
		
		this.table2 = new JTable();
		table2.setBackground(new Color(255, 240, 245));
		table2.setFocusable(false);
		table2.setAutoscrolls(false);
		table2.setRowHeight(18);
		table2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table2.getTableHeader().setOpaque(false);
		table2.getTableHeader().setBackground(new Color(176, 224, 230));
		table2.getTableHeader().setBorder(null);
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
			return this.frmKruskal;
	}
}
