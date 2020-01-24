import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ReporteJoyas extends JInternalFrame {
	
	private JTable table;
	JScrollPane pane;
	String titles[]= {"Codigo","Nombre","Material","Cantidad Disponible","Precio Unitario"};
	
	public ReporteJoyas() {
		setTitle("Registro de Joyas");
		setClosable(true);
		setBounds(100, 100, 727, 417);
		getContentPane().setLayout(null);
		
		MyDataAcces conexion = new MyDataAcces();
	    ResultSet resultado = conexion.getQuery("select * from joya;");
	    ResultSet size = conexion.getQuery("select count(*) as total from joya;");
	    int tam=0,c=0;
	    try {
	    	while(size.next()) {
		    	tam = size.getInt("total");
		    }
	    	String tabla[][]=new String[tam][6];
	    	while(resultado.next()) {
	    		tabla[c][0]=resultado.getString("cod_Joya");
				tabla[c][1]=resultado.getString("nombre");
				tabla[c][2]=resultado.getString("metal");
				tabla[c][3]=resultado.getString("stock");
				tabla[c][4]=resultado.getString("precio");
				c++;
		    }

			table = new JTable(tabla,titles);
			pane=new JScrollPane(table);
			pane.setBounds(10, 37, 690, 297);
			getContentPane().add(pane);	
	    }catch(SQLException ex) {
	    	ex.printStackTrace();
	    }
	    
	}

}
