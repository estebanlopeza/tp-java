package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import entidades.Color;
import entidades.CatColor;
import entidades.Consumo;
import entidades.CatConsumo;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;
import datos.Datos;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import negocio.NegocioLavarropas;
import negocio.NegocioTelevision;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.mysql.fabric.xmlrpc.base.Array;

public class Programa extends JFrame {

	private JPanel contentPane;
	private JSpinner spnCarga;
	private JSpinner spnResolucion;
	private JCheckBox chkSintonizadorDTD;
	private JComboBox<String> cboTipoElectrodomestico;
	private JComboBox<Color> cboColor;
	private JComboBox<Consumo> cboConsumo;
	private JSpinner spnPrecioBase;
	private JSpinner spnPeso;
	private JTable tableListar;
	
	private DefaultTableModel tableModel;
	private JPanel panelListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Programa() {

		setTitle("Nuevo Electrodoméstico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 681, 454);
		contentPane.add(tabbedPane);
		
		JPanel panelAgregar = new JPanel();
		tabbedPane.addTab("Agregar", null, panelAgregar, null);
		panelAgregar.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo de electrodoméstico:");
		lblTipo.setBounds(10, 11, 129, 14);
		panelAgregar.add(lblTipo);
		
		cboTipoElectrodomestico = new JComboBox<String>();
		cboTipoElectrodomestico.setBounds(149, 8, 140, 20);
		panelAgregar.add(cboTipoElectrodomestico);
		cboTipoElectrodomestico.addItem("Lavarropas");
		cboTipoElectrodomestico.addItem("Television");
		cboTipoElectrodomestico.setSelectedIndex(0);
		
		JLabel lblPrecioBase = new JLabel("Precio base:");
		lblPrecioBase.setBounds(10, 104, 129, 14);
		panelAgregar.add(lblPrecioBase);
		
		spnPrecioBase = new JSpinner();
		spnPrecioBase.setBounds(149, 101, 48, 20);
		panelAgregar.add(spnPrecioBase);
		
		spnPrecioBase.setValue(Electrodomestico.PRECIO_BASE);
		
		JLabel lblUnidadPrecio = new JLabel("U$S");
		lblUnidadPrecio.setBounds(207, 104, 46, 14);
		panelAgregar.add(lblUnidadPrecio);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 42, 129, 14);
		panelAgregar.add(lblColor);
		
		cboColor = new JComboBox<Color>();
		cboColor.setBounds(149, 39, 140, 20);
		panelAgregar.add(cboColor);
		cboColor.setSelectedItem(Electrodomestico.COLOR);
		
		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(10, 73, 129, 14);
		panelAgregar.add(lblConsumo);
		
		cboConsumo = new JComboBox<Consumo>();
		cboConsumo.setBounds(149, 70, 140, 20);
		panelAgregar.add(cboConsumo);
		cboConsumo.setSelectedItem(Electrodomestico.CONSUMO);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 135, 129, 14);
		panelAgregar.add(lblPeso);
		
		JLabel lblUnidadPeso = new JLabel("Kgs.");
		lblUnidadPeso.setBounds(207, 135, 46, 14);
		panelAgregar.add(lblUnidadPeso);
		
		spnPeso = new JSpinner();
		spnPeso.setBounds(149, 132, 48, 20);
		panelAgregar.add(spnPeso);
		spnPeso.setValue(Electrodomestico.PESO);
		
		JLabel lblCarga = new JLabel("Carga:");
		lblCarga.setBounds(10, 166, 129, 14);
		panelAgregar.add(lblCarga);
		
		spnCarga = new JSpinner();
		spnCarga.setBounds(149, 163, 48, 20);
		panelAgregar.add(spnCarga);
		spnCarga.setValue(Lavarropas.CARGA);
		
		JLabel lblUnidadCarga = new JLabel("Kgs.");
		lblUnidadCarga.setBounds(207, 166, 46, 14);
		panelAgregar.add(lblUnidadCarga);
		
		JLabel lblResolucion = new JLabel("Resolución:");
		lblResolucion.setBounds(10, 197, 129, 14);
		panelAgregar.add(lblResolucion);
		
		spnResolucion = new JSpinner();
		spnResolucion.setBounds(149, 194, 48, 20);
		panelAgregar.add(spnResolucion);
		spnResolucion.setValue(Television.RESOLUCION);
		
		JLabel lblUnidadResolucion = new JLabel("Pulgadas");
		lblUnidadResolucion.setBounds(207, 197, 82, 14);
		panelAgregar.add(lblUnidadResolucion);
		
		chkSintonizadorDTD = new JCheckBox("Sintonizador DTD");
		chkSintonizadorDTD.setBounds(149, 221, 140, 23);
		panelAgregar.add(chkSintonizadorDTD);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(149, 269, 89, 23);
		panelAgregar.add(btnGuardar);
		
		panelListar = new JPanel();
		tabbedPane.addTab("Listar", null, panelListar, null);
		tableModel = new DefaultTableModel();
		panelListar.setLayout(null);
		
		tableModel.setColumnIdentifiers(new Object[] {
			"Tipo", "Color", "Consumo", "Precio", "Peso", "Carga", "Resoluci\u00F3n", "Sintonizador DTD"
		});
		
		popularLista();

		tableListar = new JTable(tableModel);
		tableListar.setBounds(0, 0, 0, 0);
		tableListar.setFillsViewportHeight(true);
		tableListar.setRowSelectionAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tableListar);
		scrollPane.setBounds(10, 11, 656, 404);
		panelListar.add(scrollPane);

		/*Listeners*/
		ActionListener seleccionartipoListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
                JComboBox<String> comboBox = (JComboBox)event.getSource();

				if(event.getActionCommand().equals("comboBoxChanged")){
	                String selected = comboBox.getSelectedItem().toString();
	                if(selected.equals("Television")){
	                	spnResolucion.setEnabled(true);
	                	chkSintonizadorDTD.setEnabled(true);
	                	spnCarga.setEnabled(false);
	                }else{
	                	spnResolucion.setEnabled(false);
	                	chkSintonizadorDTD.setEnabled(false);
	                	spnCarga.setEnabled(true);
	                }
				}
			}
		};

		
		ActionListener registrarListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Electrodomestico item;
				Object[] row;
				if(cboTipoElectrodomestico.getSelectedItem().equals("Television")){
					item = new Television(
							(int)spnResolucion.getValue(), 
							chkSintonizadorDTD.isSelected(), 
							(int)spnPrecioBase.getValue(), 
							(Color)cboColor.getSelectedItem(), 
							(Consumo)cboConsumo.getSelectedItem(),
							(int)spnPeso.getValue());
					row = new NegocioTelevision().registrar((Television)item);
				}else{
					item = new Lavarropas(
							(int)spnCarga.getValue(),  
							(int)spnPrecioBase.getValue(), 
							(Color)cboColor.getSelectedItem(), 
							(Consumo)cboConsumo.getSelectedItem(),
							(int)spnPeso.getValue());
					row = new NegocioLavarropas().registrar((Lavarropas)item);
				}
				agregarALista(row);
			}
		};
		
		btnGuardar.addActionListener(registrarListener);
		cboTipoElectrodomestico.addActionListener(seleccionartipoListener);
		
		/*Carga de valores*/
		for(Color color : CatColor.COLOR){
			cboColor.addItem(color);
		}
		
		for(Consumo consumo : CatConsumo.CONSUMO){
			cboConsumo.addItem(consumo);
		}
		
		
	}

	private void popularLista(){
		Datos db = new Datos();
		ResultSet rs = db.Consultar("SELECT * FROM electrodomestico");
		try{
			while(rs.next()){
				tableModel.addRow(new Object[]{
						rs.getString("tipo"),
						rs.getString("color"),
						rs.getString("consumo"),
						rs.getFloat("precio"),
						rs.getInt("peso"),
						rs.getInt("carga"),
						rs.getInt("resolucion"),
						rs.getBoolean("sintonizadorDTD")
				});
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logró Cargar la tabla","Error",JOptionPane.ERROR_MESSAGE);
		};
		
	}

	private void agregarALista(Object[] row){
		try{
			tableModel.addRow(row);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logró Cargar el elemento en la lista","Error",JOptionPane.ERROR_MESSAGE);
		};
	}
	
}
