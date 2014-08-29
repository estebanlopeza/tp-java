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

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import negocio.NegocioLavarropas;
import negocio.NegocioTelevision;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JSpinner spnCarga;
	private JSpinner spnResolucion;
	private JCheckBox chkSintonizadorDTD;
	private JComboBox<String> cboTipoElectrodomestico;
	private JComboBox<Color> cboColor;
	private JComboBox<Consumo> cboConsumo;
	private JSpinner spnPrecioBase;
	private JSpinner spnPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Nuevo Electrodoméstico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo de electrodoméstico:");
		lblTipo.setBounds(23, 39, 129, 14);
		contentPane.add(lblTipo);
		
		cboTipoElectrodomestico = new JComboBox<String>();
		
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
				
				if(cboTipoElectrodomestico.getSelectedItem().equals("Television")){
					Television tele = new Television(
							(int)spnResolucion.getValue(), 
							chkSintonizadorDTD.isSelected(), 
							(int)spnPrecioBase.getValue(), 
							(Color)cboColor.getSelectedItem(), 
							(Consumo)cboConsumo.getSelectedItem(),
							(int)spnPeso.getValue());
					new NegocioTelevision().registrar(tele);
				}else{
					Lavarropas lava = new Lavarropas(
							(int)spnCarga.getValue(),  
							(int)spnPrecioBase.getValue(), 
							(Color)cboColor.getSelectedItem(), 
							(Consumo)cboConsumo.getSelectedItem(),
							(int)spnPeso.getValue());
					new NegocioLavarropas().registrar(lava);
				}
			}
		};
		
		cboTipoElectrodomestico.setBounds(162, 36, 140, 20);
		contentPane.add(cboTipoElectrodomestico);
		cboTipoElectrodomestico.addItem("Lavarropas");
		cboTipoElectrodomestico.addItem("Television");
		
		JLabel lblPrecioBase = new JLabel("Precio base:");
		lblPrecioBase.setBounds(23, 123, 129, 14);
		contentPane.add(lblPrecioBase);
		
		spnPrecioBase = new JSpinner();
		spnPrecioBase.setBounds(162, 120, 48, 20);
		contentPane.add(spnPrecioBase);
		
		JLabel lblUnidadPrecio = new JLabel("U$S");
		lblUnidadPrecio.setBounds(220, 123, 46, 14);
		contentPane.add(lblUnidadPrecio);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(23, 67, 129, 14);
		contentPane.add(lblColor);
		
		cboColor = new JComboBox<Color>();
		cboColor.setBounds(162, 64, 140, 20);
		contentPane.add(cboColor);
		
		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(23, 95, 129, 14);
		contentPane.add(lblConsumo);
		
		cboConsumo = new JComboBox<Consumo>();
		cboConsumo.setBounds(162, 92, 140, 20);
		contentPane.add(cboConsumo);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(23, 151, 129, 14);
		contentPane.add(lblPeso);
		
		JLabel lblUnidadPeso = new JLabel("Kgs.");
		lblUnidadPeso.setBounds(220, 151, 46, 14);
		contentPane.add(lblUnidadPeso);
		
		spnPeso = new JSpinner();
		spnPeso.setBounds(162, 148, 48, 20);
		contentPane.add(spnPeso);
		
		JLabel lblCarga = new JLabel("Carga:");
		lblCarga.setBounds(23, 179, 129, 14);
		contentPane.add(lblCarga);
		
		spnCarga = new JSpinner();
		spnCarga.setBounds(162, 176, 48, 20);
		contentPane.add(spnCarga);
		
		JLabel lblUnidadCarga = new JLabel("Kgs.");
		lblUnidadCarga.setBounds(220, 179, 46, 14);
		contentPane.add(lblUnidadCarga);
		
		JLabel lblResolucion = new JLabel("Resolución:");
		lblResolucion.setBounds(23, 207, 129, 14);
		contentPane.add(lblResolucion);
		
		spnResolucion = new JSpinner();
		spnResolucion.setBounds(162, 204, 48, 20);
		contentPane.add(spnResolucion);
		
		JLabel lblUnidadResolucion = new JLabel("Pulgadas");
		lblUnidadResolucion.setBounds(220, 207, 82, 14);
		contentPane.add(lblUnidadResolucion);
		
		chkSintonizadorDTD = new JCheckBox("Sintonizador DTD");
		chkSintonizadorDTD.setBounds(162, 231, 140, 23);
		contentPane.add(chkSintonizadorDTD);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(430, 281, 89, 23);
		contentPane.add(btnGuardar);


		/*Listeners*/
		cboTipoElectrodomestico.addActionListener(seleccionartipoListener);
		btnGuardar.addActionListener(registrarListener);
		
		/*Carga de valores*/
		cboTipoElectrodomestico.setSelectedIndex(0);
		
		for(Color color : CatColor.COLOR){
			cboColor.addItem(color);
		}
		cboColor.setSelectedItem(Electrodomestico.COLOR);
		
		for(Consumo consumo : CatConsumo.CONSUMO){
			cboConsumo.addItem(consumo);
		}
		cboConsumo.setSelectedItem(Electrodomestico.CONSUMO);
		
		spnPrecioBase.setValue(Electrodomestico.PRECIO_BASE);
		spnPeso.setValue(Electrodomestico.PESO);
		spnCarga.setValue(Lavarropas.CARGA);
		spnResolucion.setValue(Television.RESOLUCION);
		
	}
}
