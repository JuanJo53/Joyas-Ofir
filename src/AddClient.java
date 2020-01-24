import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public AddClient() {
		setTitle("Agregar Cliente");
		setBounds(100, 100, 423, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Cliente");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblDatosDelCliente.setBounds(93, 13, 238, 31);
		contentPane.add(lblDatosDelCliente);
		
		JLabel lblCiDelCliente = new JLabel("CI del Cliente:");
		lblCiDelCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCiDelCliente.setBounds(26, 68, 106, 31);
		contentPane.add(lblCiDelCliente);
		
		textField = new JTextField();
		textField.setBounds(144, 73, 159, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(68, 112, 64, 31);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 117, 187, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccion.setBounds(56, 157, 76, 31);
		contentPane.add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 162, 187, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(62, 201, 70, 31);
		contentPane.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setBounds(144, 206, 136, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(296, 264, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnNuevo = new JButton("Limpiar");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNuevo.setBounds(183, 264, 97, 25);
		contentPane.add(btnNuevo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cl = new Cliente(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
				cl.AddClient();
				dispose();
			}
		});
		btnAgregar.setBounds(74, 264, 97, 25);
		contentPane.add(btnAgregar);	
	}
}