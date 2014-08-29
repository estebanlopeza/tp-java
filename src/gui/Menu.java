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
import javax.swing.JSpinner;

import entidades.Color;
import entidades.CatColor;
import entidades.Consumo;
import entidades.CatConsumo;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JSpinner spnCarga;
	private JSpinner spnResolucion;
	private JCheckBox chkSintonizadorDTD;

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
		
		JComboBox<String> cboTipoElectrodomestico = new JComboBox<String>();
		
		ActionListener tipoElectrodomesticoListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
                JComboBox<String> comboBox = (JComboBox) event.getSource();

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
		
		cboTipoElectrodomestico.setBounds(162, 36, 140, 20);
		contentPane.add(cboTipoElectrodomestico);
		cboTipoElectrodomestico.addItem("Lavarropas");
		cboTipoElectrodomestico.addItem("Television");
		
		JLabel lblPrecioBase = new JLabel("Precio base:");
		lblPrecioBase.setBounds(23, 123, 129, 14);
		contentPane.add(lblPrecioBase);
		
		JSpinner spnPrecioBase = new JSpinner();
		spnPrecioBase.setBounds(162, 120, 48, 20);
		contentPane.add(spnPrecioBase);
		
		JLabel lblUnidadPrecio = new JLabel("U$S");
		lblUnidadPrecio.setBounds(220, 123, 46, 14);
		contentPane.add(lblUnidadPrecio);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(23, 67, 129, 14);
		contentPane.add(lblColor);
		
		JComboBox<String> cboColor = new JComboBox<String>();
		cboColor.setBounds(162, 64, 140, 20);
		contentPane.add(cboColor);
		
		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(23, 95, 129, 14);
		contentPane.add(lblConsumo);
		
		JComboBox<String> cboConsumo = new JComboBox();
		cboConsumo.setBounds(162, 92, 140, 20);
		contentPane.add(cboConsumo);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(23, 151, 129, 14);
		contentPane.add(lblPeso);
		
		JLabel lblUnidadPeso = new JLabel("Kgs.");
		lblUnidadPeso.setBounds(220, 151, 46, 14);
		contentPane.add(lblUnidadPeso);
		
		JSpinner spnPeso = new JSpinner();
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
		cboTipoElectrodomestico.addActionListener(tipoElectrodomesticoListener);
		
		/*Carga de valores*/
		cboTipoElectrodomestico.setSelectedItem("Lavarropas");
		
		for(Color color : CatColor.COLOR){
			cboColor.addItem(color.getNombre());
		}
		cboColor.setSelectedItem("blanco");
		
		for(Consumo consumo : CatConsumo.CONSUMO){
			cboConsumo.addItem(Character.toString(consumo.getLetra()));
		}
		cboConsumo.setSelectedItem("F");
		
		spnPrecioBase.setValue(100);
		spnPeso.setValue(5);
		spnCarga.setValue(5);
		spnResolucion.setValue(20);
		
	}
}
