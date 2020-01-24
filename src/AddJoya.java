import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class AddJoya extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public AddJoya() {
		setTitle("Agregar Joya a Inventario");
		setClosable(true);
		setBounds(100, 100, 515, 427);
		getContentPane().setLayout(null);
		
		JLabel lblDatosJoya = new JLabel("Nueva Joya");
		lblDatosJoya.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDatosJoya.setBounds(149, 13, 123, 40);
		getContentPane().add(lblDatosJoya);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(23, 66, 70, 29);
		getContentPane().add(lblNombre);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaterial.setBounds(23, 114, 70, 29);
		getContentPane().add(lblMaterial);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPeso.setBounds(51, 156, 41, 29);
		getContentPane().add(lblPeso);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(40, 195, 58, 29);
		getContentPane().add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(24, 231, 81, 29);
		getContentPane().add(lblCantidad);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joya jy = new Joya(textField_1.getText(),textField_2.getText(),Double.parseDouble(textField_3.getText()),Double.parseDouble(textField_4.getText()),Integer.parseInt(textField_5.getText()),textField_6.getText());
				jy.AddJoya();
			}
		});
		btnGuardar.setBounds(98, 353, 97, 25);
		getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(390, 353, 97, 25);
		getContentPane().add(btnCancelar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 70, 135, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 118, 135, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 160, 41, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(98, 199, 70, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(98, 235, 25, 22);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo.setBounds(58, 270, 41, 29);
		getContentPane().add(lblTipo);
		
		textField_6 = new JTextField();
		textField_6.setBounds(98, 274, 70, 22);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		btnNuevo.setBounds(240, 353, 97, 25);
		getContentPane().add(btnNuevo);
		
		JLabel lblGramos = new JLabel("gramos");
		lblGramos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGramos.setBounds(149, 156, 70, 29);
		getContentPane().add(lblGramos);
		
		JLabel lblBs = new JLabel("bs.");
		lblBs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBs.setBounds(180, 195, 41, 29);
		getContentPane().add(lblBs);

	}
}
