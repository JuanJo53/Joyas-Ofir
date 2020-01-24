import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Joya {
	
	String cod;
	String nombre;
	String metal;
	double peso;
	double precio;
	int stock;
	String tipo;
	public Joya(String nombre, String metal, double peso, double precio, int stock, String tipo) {
		this.nombre = nombre;
		this.metal = metal;
		this.peso = peso;
		this.precio = precio;
		this.stock = stock;
		this.tipo = tipo;
	}
	public Joya(String cod, String nombre, String metal, double peso, double precio, int stock, String tipo) {
		this.cod = cod;
		this.nombre = nombre;
		this.metal = metal;
		this.peso = peso;
		this.precio = precio;
		this.stock = stock;
		this.tipo = tipo;
	}
	public Joya(String nombre) {
		this.nombre = nombre;
	}

	public String getCod() {
		return cod;
	}
	public String getNombre() {
		return nombre;
	}
	public String getMetal() {
		return metal;
	}
	public double getPeso() {
		return peso;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStock() {
		return stock;
	}
	public String getTipo() {
		return tipo;
	}
	public void AddJoya() {
		String conf=JOptionPane.showInputDialog(null, "Seguro Desea Agregar esta Joya?(S/N)");
		MyDataAcces conexion = new MyDataAcces();
	    ResultSet resultado;
	    String cod_Tipo="",tipo;
	    resultado = conexion.getQuery("select * from tipo_joya"); 
	    ResultSet size = conexion.getQuery("select count(*) as total from joya;");
		int num=0;
	    try {
	    	while(size.next()) {
				num = size.getInt("total");
			}
	    	while(resultado.next()){
	    		tipo = resultado.getString("tipo");
	    		if(tipo.equals(getTipo())) {
	    			cod_Tipo = resultado.getString("cod_Tipo_Joya");
	    			break;
	    		}else {
	    			
	    		}
	    	}
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
		if(conf.equals("S")||conf.equals("s")) {
			try {
			    int res;
			    res = conexion.getUpdate("INSERT INTO `joya` (`cod_Joya`, `nombre`, `metal`, `peso`, `precio`, `stock`, `Tipo_Joya_cod_Tipo_Joya`) VALUES ('J"+(num+1)+"','"+getNombre()+"','"+getMetal()+"','"+getPeso()+"','"+getPrecio()+"','"+getStock()+"','"+cod_Tipo+"')");
			    if(res==1)
			    	JOptionPane.showMessageDialog(null, "JOYA AGREGADA!");
			    else
			    	JOptionPane.showMessageDialog(null, "JOYA NO FUE AGREGADA CORRECTAMENTE!");
			}catch(Exception e) {
		    	e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "JOYA NO AÑADIDA!");
		}
	}
	public boolean EditData() {
		boolean ex = false;
		MyDataAcces con = new MyDataAcces();
		int resultado;
		String Ntipo="",t="";
		ResultSet type = con.getQuery("select a.cod_Tipo_Joya from tipo_joya a where a.tipo='"+getTipo()+"'");
	    try {
	    	while(type.next()) {
				t = type.getString("cod_Tipo_Joya");
			}
	    	resultado = con.getUpdate("UPDATE joya SET nombre='"+getNombre()+"',metal='"+getMetal()+"',peso='"+getPeso()+"',precio='"+getPrecio()+"',stock='"+getStock()+"',Tipo_Joya_cod_Tipo_Joya='"+t+"'WHERE cod_Joya='"+getCod()+"'");
	    	if(resultado==1) {
	    		ex = true;
			}else {
				ex = false;
			}
	    }catch (SQLException e) {
	    	e.printStackTrace();
	    }
		return ex;
	}
	public boolean MostrarDatos() {
		MyDataAcces conexion = new MyDataAcces();
	    ResultSet resultado, t;
	    String nomb="",tipoJ="";
	    resultado = conexion.getQuery("select * from joya");
	    t = conexion.getQuery("select a.tipo from tipo_joya a, joya b where b.Tipo_Joya_cod_Tipo_Joya=a.cod_Tipo_Joya and b.nombre='"+getNombre()+"' GROUP BY a.tipo");
	    boolean exist=false;  
	    try {
	    	while(t.next()) {
	    		tipoJ=t.getString("tipo");
	    	}
	    	while(resultado.next()) {    		
	    		nomb = resultado.getString("nombre");
	    		if(nomb.equals(getNombre())) {
	    			exist = true;
	    			cod = resultado.getString("cod_Joya");
	    			nombre=resultado.getString("nombre");
	    			metal=resultado.getString("metal");
	    			peso=Double.parseDouble(resultado.getString("peso"));
	    			precio=Double.parseDouble(resultado.getString("precio"));
	    			stock=Integer.parseInt(resultado.getString("stock"));
	    			tipo=tipoJ;
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
}
