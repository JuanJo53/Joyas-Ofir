import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Venta {
	
	String cod;
	String cod_Cli;
	String cod_Emp;
	String emp;
	String CI;
	String joya;
	int cant;
	Date fecha;
	public Venta(String cod, String cod_Cli, String cod_Emp, String CI, String joya, int cant, Date fecha) {
		this.cod = cod;
		this.cod_Cli = cod_Cli;
		this.cod_Emp = cod_Emp;
		this.CI =CI;
		this.joya = joya;
		this.cant = cant;
		this.fecha = fecha;
	}
	public Venta(String CI, String joya, int cant, String emp) {
		this.CI =CI;
		this.joya = joya;
		this.cant = cant;
		this.emp = emp;
	}
	public Venta() {
	}
	public String getCod() {
		return cod;
	}
	public String getCod_Cli() {
		return cod_Cli;
	}
	public String getCod_Emp() {
		return cod_Emp;
	}
	public String getCI() {
		return CI;
	}
	public String getJoya() {
		return joya;
	}
	public int getCant() {
		return cant;
	}
	public Date getFecha() {
		return fecha;
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
	public void NVenta() {
		String conf=JOptionPane.showInputDialog(null, "Seguro Desea Vender este Producto?(S/N)");
		if(conf.equals("S")||conf.equals("s")) {
			try {
				MyDataAcces conexion = new MyDataAcces();
				int resultado,stock=0;
				boolean nuevoCli=true;
				String cod_Joy="";
				double precio=0,total;
				Date today=new Date(new java.util.Date().getTime());
				ResultSet precioUn = conexion.getQuery("select * from joya");
				ResultSet size = conexion.getQuery("select count(*) as total from venta;");
				int num=0;
				while(size.next()) {
					num = size.getInt("total");
				}
			    while(precioUn.next()) {
			    	if(joya.equals(precioUn.getString("nombre"))) {
			    		cod_Joy=precioUn.getString("cod_Joya");
			    		stock=precioUn.getInt("stock");
			    		precio=precioUn.getDouble("precio");
			    		break;
			    	}
			    }
			    ResultSet empleado = conexion.getQuery("select * from empleado");
			    while(empleado.next()) {
			    	if(emp.equals(empleado.getString("nombre"))) {
			    		cod_Emp=empleado.getString("cod_Empleado");
			    		break;
			    	}
			    }			   
			    
			    if(ConfClient()==false) {
			    	if(getDif()==true) {
				    	total=precio*getCant();
				    	resultado = conexion.getUpdate("INSERT INTO `venta` (`cod_Venta`, `fecha`, `Cliente_cod_Cliente`, `Joya_cod_Joya`, `Empleado_cod_Empleado`,`cantidad`,`CI`,`total`) VALUES ('V"+(num+1)+"','"+today+"','"+getCod_Cli()+"','"+cod_Joy+"','"+getCod_Emp()+"','"+getCant()+"','"+getCI()+"','"+total+"')");
					    if(resultado==1) {
					    	JOptionPane.showMessageDialog(null, "VENTA REALIZADA!");
					    	ActuData();
					    }else {
					    	JOptionPane.showMessageDialog(null, "LA VENTA NO SE REALIZO CORRECTAMENTE!");
					    }
			    	}else {
			    		JOptionPane.showMessageDialog(null, "NO EXISTE SUFICIENTE STOCK DE ESTA JOYA!");
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
			JOptionPane.showMessageDialog(null, "VENTA NO REALIZADA!");
		}
	}
	public boolean ActuData() {
		boolean ex = false;
		MyDataAcces con = new MyDataAcces();
		String cod_Prod="";
		int stock=0;
		ResultSet precioUn = con.getQuery("select * from joya");
	    try {
	    	while(precioUn.next()) {
	    		if(joya.equals(precioUn.getString("nombre"))) {
	    			cod_Prod=precioUn.getString("Cod_Joya");
	    			stock=precioUn.getInt("stock");
	    			break;
	    		}
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int resultado;
		resultado = con.getUpdate("UPDATE joya SET stock='"+(stock-getCant())+"'WHERE cod_Joya='"+cod_Prod+"'");
		if(resultado==1) {
			ex = true;
		}else {
			ex = false;
		}
		return ex;
	}
	public boolean getDif() {
		MyDataAcces conexion = new MyDataAcces();
	    double stock=0;
	    boolean disp=false;
		try {
			ResultSet precioUn = conexion.getQuery("select * from joya");
		    while(precioUn.next()) {
		    	if(joya.equals(precioUn.getString("nombre"))) {
		    		stock=precioUn.getDouble("stock");
		    		break;
		    	}
		    }
		    if((stock-getCant())>=0) {
		    	disp=true;
		    }else {
		    	disp=false;
		    }
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
		return disp;
	}
	public double getTotal() {
		MyDataAcces conexion = new MyDataAcces();
	    double precio=0;
		try {
			ResultSet precioUn = conexion.getQuery("select * from joya");
		    while(precioUn.next()) {
		    	if(joya.equals(precioUn.getString("nombre"))) {
		    		precio=precioUn.getDouble("precio");
		    		break;
		    	}
		    }
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
		return precio*getCant();
	}
	public Date getDate() {
		Date today=new Date(new java.util.Date().getTime());
		return today;
	}
}
