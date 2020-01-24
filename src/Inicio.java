import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JFrame {
	
	JDesktopPane desktopPane;
	String empleado;
	public Inicio(String empleado) {
		this.empleado = empleado;
		setResizable(false);
		setTitle("Ofir-Joyas");
		setBounds(100, 100, 872, 569);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setJMenuBar(menuBar);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 13, 844, 482);
		getContentPane().add(desktopPane);
		
		JMenu mnArchivo = new JMenu("Cuenta");
		Image user = new ImageIcon(this.getClass().getResource("/man-user.png")).getImage();
		mnArchivo.setIcon(new ImageIcon(user));
		mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCambiarDeUsuario = new JMenuItem("Cambiar de Usuario");
		mntmCambiarDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String conf = JOptionPane.showInputDialog("Desea Cambiar de Usuario?(S/N)");
				if(conf.equals("S")||conf.equals("s")) {
					dispose();
					Loggin frame = new Loggin();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
			}
		});
		mnArchivo.add(mntmCambiarDeUsuario);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnJoyas = new JMenu("Joyas");
		Image joy = new ImageIcon(this.getClass().getResource("/diamond.png")).getImage();
		mnJoyas.setIcon(new ImageIcon(joy));
		mnJoyas.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mnJoyas);
		
		JMenuItem mntmNuevaJoya = new JMenuItem("Nueva Joya");
		mntmNuevaJoya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddJoya rep = new AddJoya();
				desktopPane.add(rep);
				rep.setVisible(true);
				rep.setLocation(0, 0);
			}
		});
		mnJoyas.add(mntmNuevaJoya);
		
		JMenuItem mntmRegistro = new JMenuItem("Registro");
		mntmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				ReporteJoyas rep = new ReporteJoyas();
				desktopPane.add(rep);
				rep.setVisible(true);
				rep.setLocation(0, 0);
			}
		});
		mnJoyas.add(mntmRegistro);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		Image order = new ImageIcon(this.getClass().getResource("/choices.png")).getImage();
		mnPedidos.setIcon(new ImageIcon(order));
		mnPedidos.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mnPedidos);
		
		JMenuItem mntmNuevoPedido = new JMenuItem("Nuevo Pedido");
		mntmNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddPedido frame = new AddPedido(empleado);
					desktopPane.add(frame);
					frame.setVisible(true);
					frame.setLocation(0,0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnPedidos.add(mntmNuevoPedido);
		
		JMenuItem mntmPedidosPendientes = new JMenuItem("Pedidos Pendientes");
		mntmPedidosPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ReportePendientes frame = new ReportePendientes();
					desktopPane.add(frame);
					frame.setVisible(true);
					frame.setLocation(0,0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmEntregarPedido = new JMenuItem("Entregar Pedido");
		mntmEntregarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EntregaPedido frame = new EntregaPedido();
					desktopPane.add(frame);
					frame.setVisible(true);
					frame.setLocation(0,0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnPedidos.add(mntmEntregarPedido);
		mnPedidos.add(mntmPedidosPendientes);
		
		JMenuItem mntmPedidosRealizados = new JMenuItem("Pedidos Realizados");
		mntmPedidosRealizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ReporteEntregados frame = new ReporteEntregados();
					desktopPane.add(frame);
					frame.setVisible(true);
					frame.setLocation(0,0);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		mnPedidos.add(mntmPedidosRealizados);
		
		JMenu mnVentas = new JMenu("Ventas");
		Image sell = new ImageIcon(this.getClass().getResource("/shopping-bag.png")).getImage();
		mnVentas.setIcon(new ImageIcon(sell));
		mnVentas.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mnVentas);
		
		JMenuItem mntmNuevaVenta = new JMenuItem("Nueva Venta");
		mntmNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddVenta frame = new AddVenta(empleado);
					desktopPane.add(frame);
					frame.setVisible(true);
					frame.setLocation(0, 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnVentas.add(mntmNuevaVenta);
		
		JMenuItem mntmReporteDeVentas = new JMenuItem("Reporte de Ventas");
		mntmReporteDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ReporteVentas frame = new ReporteVentas();
					desktopPane.add(frame);
					frame.setVisible(true);
					frame.setLocation(0, 0);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		mnVentas.add(mntmReporteDeVentas);
		Image help = new ImageIcon(this.getClass().getResource("/information.png")).getImage();
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 13, 820, 456);
		Image back = new ImageIcon(this.getClass().getResource("/backround.jpg")).getImage();
		Image modBack = back.getScaledInstance(820, 456, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(modBack));
		desktopPane.add(label);
	
	}
}
