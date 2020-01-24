import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Empleado {
	String codigo;
	String nombre;
	String CI;
	String cargo;
	String pass;
	String phone;
	public Empleado(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}
	public Empleado(String codigo, String nombre, String CI, String cargo, String pass, String phone) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.CI = CI;
		this.cargo = cargo;
		this.pass = pass;
		this.phone = phone;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCI() {
		return CI;
	}
	public String getCargo() {
		return cargo;
	}
	public String getPass() {
		return pass;
	}
	public String getPhone() {
		return phone;
	}

	public boolean Loggin() {
		String usuario,contra;
		boolean acces=false;
		MyDataAcces con = new MyDataAcces();
		ResultSet resultado;
		resultado = con.getQuery("select * from empleado");
		try {
			while(resultado.next()){
				usuario = resultado.getString("nombre");
				contra = resultado.getString("contraseña");	
				if(usuario.equals(getNombre()) && contra.equals(getPass())){
					acces = true;
					break;
				}else {
					acces = false;
				}
			}
			return acces;
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return acces;
	}
	
}
