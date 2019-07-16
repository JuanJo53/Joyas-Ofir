import java.sql.*;

public class MyDataAcces {

	private String _usuario="root";
	private String _pwd= "";
	private static String _bd="ofir-joyas";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	
	public MyDataAcces() {
		
		try{
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null){
				System.out.println("Conexion a base de datos "+_url+" . . . Ok");
			}
		}catch(SQLException ex){
			System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
		}catch(ClassNotFoundException ex){
			System.out.println(ex);
		}  
	}
	
	public ResultSet getQuery(String _query){
		Statement state = null;
		ResultSet resultado = null;
		try{
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void setQuery(String _query){
		
		Statement state = null;
		
		try{   
			state=(Statement) conn.createStatement();
			state.execute(_query);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	public int getUpdate(String _query){
		Statement state = null;
		ResultSet resultado = null;
		int conf=0;
		try{
			state = (Statement) conn.createStatement();
			conf = state.executeUpdate(_query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conf;
	}
}