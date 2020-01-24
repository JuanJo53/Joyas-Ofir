import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class ReporteVentas extends JInternalFrame {

	private JTable table;
	JScrollPane pane;
	String titles[]= {"Codigo","CI de Cliente","Joya","Cantidad","Monto Total","Fecha"};

	public ReporteVentas() {
		setTitle("Reporte de Ventas");
		setClosable(true);
		setBounds(100, 100, 723, 391);
		getContentPane().setLayout(null);
		
		MyDataAcces conexion = new MyDataAcces();
	    ResultSet resultado = conexion.getQuery("select * from venta;");
	    ResultSet size = conexion.getQuery("select count(*) as total from venta;");
	    ResultSet Joya;
	    int tam=0,c=0;
	    double total=0,precio;
	    String cod_Joya, nomb_Joya="";
	    try {
	    	
	    	while(size.next()) {
		    	tam = size.getInt("total");
		    }
	    	String tabla[][]=new String[tam][6];
	    	while(resultado.next()) {
	    		cod_Joya=resultado.getString("Joya_cod_Joya");
	    		Joya = conexion.getQuery("select a.nombre from joya a where a.cod_Joya='"+cod_Joya+"'");
	    		while(Joya.next()) {
	    			nomb_Joya=Joya.getString("nombre");
			    }	    		
	    		tabla[c][0]=resultado.getString("cod_Venta");
				tabla[c][1]=resultado.getString("CI");
				tabla[c][2]=nomb_Joya;
				tabla[c][3]=resultado.getString("cantidad");
				tabla[c][4]=resultado.getString("total");
				tabla[c][5]=resultado.getString("fecha");
				c++;
		    }
			table = new JTable(tabla,titles);
			pane=new JScrollPane(table);
			pane.setBounds(10, 25, 690, 297);
			getContentPane().add(pane);	
	    }catch(SQLException ex) {
	    	ex.printStackTrace();
	    }
	}
}
