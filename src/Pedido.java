import java.sql.*;

import javax.swing.JOptionPane;

public class Pedido {
	String cod;
	String CI;
	String cod_Cli;
	String cod_Emp;
	String emp;
	String joya;
	Date fechaI;
	String fechaF;
	int cantidad;
	public Pedido(String cod, String CI, String emp, String joya,Date fechaI, String fechaF, int cantidad) {
		this.cod = cod;
		this.CI = CI;
		this.emp = emp;
		this.joya = joya;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cantidad = cantidad;
	}
	public Pedido(String CI, String emp, String joya, String fechaF, int cantidad) {
		this.CI = CI;
		this.emp = emp;
		this.joya = joya;
		this.fechaF = fechaF;
		this.cantidad = cantidad;
	}
	public Pedido(String CI, String joya) {
		this.CI = CI;
		this.joya = joya;
	}
	public String getCod() {
		return cod;
	}
	public String getCI() {
		return CI;
	}
	public String getCod_Cli() {
		return cod_Cli;
	}
	public String getCod_Emp() {
		return cod_Emp;
	}
	public String getEmp() {
		return emp;
	}
	public String getJoya() {
		return joya;
	}
	public Date getFechaI() {
		return fechaI;
	}
	public String getFechaF() {
		return fechaF;
	}
	public int getCantidad() {
		return cantidad;
	}
	public Date getDate() {
		Date today=new Date(new java.util.Date().getTime());
		return today;
	}
	
	public boolean ConfClient() {
		MyDataAcces conexion = new MyDataAcces();
		boolean nuevoCli=false;
		ResultSet cliente = conexion.getQuery("select * from cliente");
	    try {
	    	while(cliente.next()) {
		    	if(CI.equals(cliente.getString("CI"))) {
		    		cod_Cli=cliente.getString("cod_Cliente");
		    		nuevoCli=false;
		    		break;
		    	}else {
		    		nuevoCli=true;
		    	}
		    }
	    }catch(Exception e) {
	    	e.printStackTrace();
		}
	    return nuevoCli;
	}
	public void EntregarPedido() {
		MyDataAcces con = new MyDataAcces();
		String cod_Ped="",cod_Cli="",Cliente_cod_Cliente="";
		int resultado, status=0;
		ResultSet entrega = con.getQuery("select * from pedido");
		ResultSet cliente = con.getQuery("select * from cliente");
	    try {
	    	while(entrega.next()) {
	    		if(joya.equals(entrega.getString("nombreJoya"))) {
	    			cod_Ped=entrega.getString("Cod_Pedido");
	    			Cliente_cod_Cliente=entrega.getString("Cliente_cod_Cliente");
	    			System.out.println(Cliente_cod_Cliente);
	    			break;
	    		}
	    	}
	    	while(cliente.next()) {
	    		if(CI.equals(cliente.getString("CI"))) {
	    			cod_Cli=cliente.getString("cod_Cliente");
	    			break;
	    		}
	    	}
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(cod_Cli.equals(Cliente_cod_Cliente)) {
			resultado = con.getUpdate("UPDATE pedido SET statusEntrega='"+"1"+"'WHERE cod_Pedido='"+cod_Ped+"'");
			if(resultado==1) {
				JOptionPane.showMessageDialog(null, "Pedido Entregrado y Registrado Correctamente!");
			}else {
				JOptionPane.showMessageDialog(null, "El Pedido NO se Entrego ni se Registro Correctamente!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "El Pedido no corresponde al Cliente!");
		}
		
	}
	public void NuevoPedido() {
		String conf=JOptionPane.showInputDialog(null, "Seguro Desea Agregar este Pedido?(S/N)");
		if(conf.equals("S")||conf.equals("s")) {
			try {
				MyDataAcces conexion = new MyDataAcces();
				int resultado,stock=0;
				int status=0;
				String cod_Joy="";
				double precio=0,total;
				Date today=new Date(new java.util.Date().getTime());
				ResultSet precioUn = conexion.getQuery("select * from joya");
				ResultSet size = conexion.getQuery("select count(*) as total from pedido;");
				int num=0;
				while(size.next()) {
					num = size.getInt("total");
				}
			    ResultSet empleado = conexion.getQuery("select * from empleado");
			    while(empleado.next()) {
			    	if(emp.equals(empleado.getString("nombre"))) {
			    		cod_Emp=empleado.getString("cod_Empleado");
			    		break;
			    	}
			    }			   
			    
			    if(ConfClient()==false) {
			    	resultado = conexion.getUpdate("INSERT INTO `pedido` (`cod_Pedido`, `Fecha Emision`, `Fecha Entrega`, `cantidad`,  `Cliente_cod_Cliente`, `Empleado_cod_Empleado`,`statusEntrega`, `nombreJoya`) VALUES ('P"+(num+1)+"','"+today+"','"+getFechaF()+"','"+getCantidad()+"','"+getCod_Cli()+"','"+getCod_Emp()+"','"+status+"','"+getJoya()+"')");
			    	if(resultado==1) {
			    		JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO!");
			    	}else {
			    		JOptionPane.showMessageDialog(null, "EL PEDIDO NO SE REGISTRO CORRECTAMENTE!");
			    	}
			    }else{
			    	String Ncli=JOptionPane.showInputDialog("CLIENTE NUEVO, DESEA AGREGARLO?(S/N)");
			    	if(Ncli.equals("s")||Ncli.equals("S")) {
						try {
							AddClient frame = new AddClient();
							frame.setLocationRelativeTo(null);
							frame.setResizable(false);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}

			    	}
			    }
			}catch(Exception e) {
		    	e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "PEDIDO NO REGISTRADO!");
		}
	}
	
}
