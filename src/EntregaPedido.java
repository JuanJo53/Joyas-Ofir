import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntregaPedido extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;


	public EntregaPedido() {
		setTitle("Entrega de Pedido");
		setClosable(true);
		setBounds(100, 100, 450, 278);
		getContentPane().setLayout(null);
		
		JLabel lblDatosDelPedido = new JLabel("Datos del Pedido");
		lblDatosDelPedido.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblDatosDelPedido.setBounds(99, 13, 241, 50);
		getContentPane().add(lblDatosDelPedido);
		
		JLabel lblCiDelCliente = new JLabel("CI del Cliente:");
		lblCiDelCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCiDelCliente.setBounds(62, 83, 137, 16);
		getContentPane().add(lblCiDelCliente);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Joya:");
		lblNombreDeLa.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNombreDeLa.setBounds(12, 126, 190, 16);
		getContentPane().add(lblNombreDeLa);
		
		textField = new JTextField();
		textField.setBounds(210, 83, 167, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 126, 212, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(325, 204, 97, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNuevo.setBounds(216, 204, 97, 25);
		getContentPane().add(btnNuevo);
		
		JButton btnEntregar = new JButton("Entregar");
		btnEntregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedido ped = new Pedido(textField.getText(),textField_1.getText());
				ped.EntregarPedido();
			}
		});
		btnEntregar.setBounds(105, 204, 97, 25);
		getContentPane().add(btnEntregar);

	}
}
