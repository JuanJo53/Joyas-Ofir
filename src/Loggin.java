import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class Loggin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	int intento=0;
	public Loggin() {
		setTitle("Ofir-Joyas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		btnSalir.setBounds(12, 191, 97, 25);
		contentPane.add(btnSalir);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(240, 50, 80, 25);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(318, 52, 227, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblConstrasea = new JLabel("Constrase\u00F1a:");
		lblConstrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConstrasea.setBounds(200, 88, 107, 30);
		contentPane.add(lblConstrasea);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = new String(passwordField.getPassword());
				if(textField.getText().equals("") && pass.equals("")){
			        JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
			        textField.setFocusable(true);
			    }else if(textField.getText().equals("")){
			        JOptionPane.showMessageDialog(null, "Usuario está vacio\nIngreselo por favor.");
			        textField.setFocusable(true);
			    }else if(pass.equals("")){
			        JOptionPane.showMessageDialog(null, "Contraseña está vacio\nIngreselo por favor.");
			        passwordField.setFocusable(true);
			    }else{
			    	if(intento<1) {
			    		Empleado user = new Empleado(textField.getText(),pass);
						if(user.Loggin()==true) {
							JOptionPane.showMessageDialog(null, "ACCESO CONSEDIDO");
							dispose();
							Inicio frame = new Inicio(textField.getText());
				    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    		frame.setLocationRelativeTo(null);
				    		frame.setResizable(false);
				    		frame.setVisible(true);
						}else{
							intento++;
							JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO\nINTENTE DE NUEVO");
						}
			    	}else {
			    		JOptionPane.showMessageDialog(null, "LIMITE DE INTENTOS!\nACCESO BLOQUEADO!");
			    		System.exit(0);
			    	}
					
			    }
				
			}
		});
		btnIngresar.setBounds(448, 142, 97, 25);
		contentPane.add(btnIngresar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(318, 93, 227, 22);
		contentPane.add(passwordField);
		
		JLabel Logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		Image mod = img.getScaledInstance(173, 155, Image.SCALE_SMOOTH);
		Logo.setIcon(new ImageIcon(mod));
		Logo.setBounds(12, 13, 173, 155);
		contentPane.add(Logo);
	}
	
}
