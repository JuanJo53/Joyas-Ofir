import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class AddPedido extends JInternalFrame {
	private JTextField CI;
	private JTextField Joya;
	private JTextField cantidad;
	private JDateChooser dateChooser;
	String empleado;
	
	public AddPedido(String empleado) {
		this.empleado = empleado;
		setTitle("Nuevo Pedido");
		setClosable(true);
		setBounds(100, 100, 459, 323);
		getContentPane().setLayout(null);
		
		JLabel lblDatosDelPedido = new JLabel("Datos del Pedido");
		lblDatosDelPedido.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblDatosDelPedido.setBounds(109, 13, 234, 32);
		getContentPane().add(lblDatosDelPedido);
		
		JLabel lblCiDelCliente = new JLabel("CI del Cliente:");
		lblCiDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCiDelCliente.setBounds(43, 71, 118, 23);
		getContentPane().add(lblCiDelCliente);
		
		JLabel lblNombreDeJoya = new JLabel("Nombre de Joya:");
		lblNombreDeJoya.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNombreDeJoya.setBounds(17, 118, 144, 23);
		getContentPane().add(lblNombreDeJoya);
		
		CI = new JTextField();
		CI.setBounds(173, 74, 144, 22);
		getContentPane().add(CI);
		CI.setColumns(10);
		
		Joya = new JTextField();
		Joya.setBounds(173, 121, 220, 22);
		getContentPane().add(Joya);
		Joya.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCantidad.setBounds(81, 167, 81, 23);
		getContentPane().add(lblCantidad);
		
		cantidad = new JTextField();
		cantidad.setBounds(174, 170, 60, 22);
		getContentPane().add(cantidad);
		cantidad.setColumns(10);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de Entrega:");
		lblFechaDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFechaDeEntrega.setBounds(5, 206, 156, 23);
		getContentPane().add(lblFechaDeEntrega);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(334, 249, 97, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CI.setText("");
				Joya.setText("");
				cantidad.setText("");
				dateChooser.setDate(null);
			}
		});
		btnNuevo.setBounds(220, 249, 97, 25);
		getContentPane().add(btnNuevo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(173, 207, 108, 22);
		getContentPane().add(dateChooser);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String fecha=sdf.format(dateChooser.getDate());
				Pedido order = new Pedido(CI.getText(), empleado, Joya.getText(), fecha, Integer.parseInt(cantidad.getText()));
				order.NuevoPedido();
			}
		});
		btnRegistrar.setBounds(109, 249, 97, 25);
		getContentPane().add(btnRegistrar);
		

	}
}
