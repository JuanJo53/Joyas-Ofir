import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Cliente {
	
	String cod;
	String nombre;
	String dir;
	String telf;
	String CI;
	public Cliente(String cod, String nombre, String dir, String telf, String CI) {
		this.cod = cod; 
		this.nombre = nombre;
		this.dir = dir;
		this.telf = telf;
		this.CI = CI;
	}
	public Cliente(String CI, String nombre, String dir, String telf) { 
		this.nombre = nombre;
		this.dir = dir;
		this.telf = telf;
		this.CI = CI;
	}
	
	public String getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDir() {
		return dir;
	}

	public String getTelf() {
		return telf;
	}

	public String getCI() {
		return CI;
	}

	public boolean MostrarDatos() {
		MyDataAcces conexion = new MyDataAcces();
	    ResultSet resultado;
	    String cod_Prod="";
	    resultado = conexion.getQuery("select * from cliente");
	    boolean exist=false; 
	    try {
	    	while(resultado.next()){
	    		cod_Prod = resultado.getString("cod_Cliente");
	    		if(cod_Prod.equals(getCod())) {
	    			exist = true;
	    			cod = resultado.getString("cod_Cliente");
	    			nombre=resultado.getString("nombre");
	    			CI=resultado.getString("NIT");
	    			break;
	    		}else {
	    			exist = false;
	    		}
	    	}
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	    return exist;
	}
	public void AddClient() {
		String conf=JOptionPane.showInputDialog(null, "Seguro Desea Agregar este Cliente?(S/N)");
		if(conf.equals("S")||conf.equals("s")) {
			try {
				MyDataAcces conexion = new MyDataAcces();
			    int resultado;
			    ResultSet size = conexion.getQuery("select count(*) as total from cliente;");
				int num=0;
				while(size.next()) {
					num = size.getInt("total");
				}
			    resultado = conexion.getUpdate("INSERT INTO `cliente` (`cod_Cliente`, `nombre`, `direccion`, `telefono`, `CI`) VALUES ('C"+(num+1)+"','"+getNombre()+"','"+getDir()+"','"+getTelf()+"','"+getCI()+"')");
			    if(resultado==1)
			    	JOptionPane.showMessageDialog(null, "CLIENTE AGREGADO!");
			    else
			    	JOptionPane.showMessageDialog(null, "CLIENTE NO FUE AGREGADO CORRECTAMENTE!");
			}catch(Exception e) {
		    	e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "CLIENTE NO AÑADIDO!");
		}
	}

	public void DelClient() {
		String conf=JOptionPane.showInputDialog(null, "Seguro Desea Eliminar a este Cliente?(S/N)");
		if(conf.equals("S")||conf.equals("s")) {
			try {
				MyDataAcces conexion = new MyDataAcces();
			    int resultado;
			    resultado = conexion.getUpdate("DELETE FROM `cliente` WHERE `cod_Cliente` = '"+getCod()+"'");
			    if(resultado==1) {
			    	JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO!");	
			    }else {
			    	JOptionPane.showMessageDialog(null, "CLIENTE NO FUE ELIMINADO CORRECTAMENTE!");
			    	JOptionPane.showMessageDialog(null, "No puede borrar los datos de un cliente que halla realizado una compra!");	
			    }
			}catch(Exception ex) {
		    	ex.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "CLIENTE NO ELIMINADO!");
		}
	}
	public boolean EditData() {
		boolean ex = false;
		MyDataAcces con = new MyDataAcces();
		int resultado;
		resultado = con.getUpdate("UPDATE cliente SET nombre='"+getNombre()+"',NIT='"+getCI()+"'WHERE cod_Cliente='"+getCod()+"'");
		if(resultado==1) {
			ex = true;
		}else {
			ex = false;
		}
		return ex;
	}

}
