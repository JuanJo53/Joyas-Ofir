import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVenta extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	String empleado;
	public AddVenta(String empleado) {
		this.empleado = empleado;
		setTitle("Formulario de Venta");
		setClosable(true);
		setBounds(100, 100, 489, 351);
		getContentPane().setLayout(null);
		
		JLabel lblNuevaVenta = new JLabel("Nueva Venta");
		lblNuevaVenta.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNuevaVenta.setBounds(126, 13, 223, 46);
		getContentPane().add(lblNuevaVenta);
		
		JLabel lblCiDeCliente = new JLabel("CI de Cliente:");
		lblCiDeCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCiDeCliente.setBounds(36, 84, 114, 16);
		getContentPane().add(lblCiDeCliente);
		
		JLabel lblJoya = new JLabel("Joya:");
		lblJoya.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblJoya.setBounds(106, 127, 56, 16);
		getContentPane().add(lblJoya);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCantidad.setBounds(70, 170, 92, 16);
		getContentPane().add(lblCantidad);
		
		JLabel lblMontoTotal = new JLabel("Monto Total:");
		lblMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMontoTotal.setBounds(44, 210, 106, 16);
		getContentPane().add(lblMontoTotal);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(364, 277, 97, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNuevo.setBounds(252, 277, 97, 25);
		getContentPane().add(btnNuevo);
		
		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venta sell = new Venta(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()),empleado);
				sell.NVenta();
			}
		});
		btnVender.setBounds(143, 277, 97, 25);
		getContentPane().add(btnVender);
		
		textField = new JTextField();
		textField.setBounds(164, 84, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 127, 158, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 170, 42, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(164, 210, 65, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venta sell = new Venta(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()),empleado);
				textField_3.setText(""+sell.getTotal());
			}
		});
		btnTotal.setBounds(364, 209, 97, 25);
		getContentPane().add(btnTotal);
		
		JLabel lblBs = new JLabel("bs.");
		lblBs.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBs.setBounds(241, 213, 25, 16);
		getContentPane().add(lblBs);

	}
}
