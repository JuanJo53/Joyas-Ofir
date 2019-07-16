import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReporteEntregados extends JInternalFrame {
	
	private JTable table;
	JScrollPane pane;
	String titles[]= {"Codigo","CI de Cliente","Nombre de Joya","Cantidad","Fecha de Emision","Fecha de Entrega"};
	
	public ReporteEntregados() {
		setTitle("Reporte de Pedidos Entregados");			
		setClosable(true);
		setBounds(100, 100, 723, 391);
		getContentPane().setLayout(null);

		MyDataAcces conexion = new MyDataAcces();
		ResultSet resultado = conexion.getQuery("select * from pedido;");
		ResultSet size = conexion.getQuery("select count(*) as total from pedido;");
		ResultSet CI;
		int tam=0,c=0;
		double total=0,precio;
		String cod_Cliente,Cliente="";
		try {
			while(size.next()) {
				tam = size.getInt("total");
			}
			String tabla[][]=new String[tam][6];
			while(resultado.next()) {
				cod_Cliente=resultado.getString("Cliente_cod_Cliente");
				CI = conexion.getQuery("select a.CI from cliente a where a.cod_Cliente='"+cod_Cliente+"'");
				while(CI.next()) {
					Cliente=CI.getString("CI");
				}
				if(resultado.getInt("statusEntrega")!=0) {
					tabla[c][0]=resultado.getString("cod_Pedido");
					tabla[c][1]=Cliente;
					tabla[c][2]=resultado.getString("nombreJoya");
					tabla[c][3]=resultado.getString("cantidad");
					tabla[c][4]=resultado.getString("fecha Emision");
					tabla[c][5]=resultado.getString("fecha Entrega");
					c++;	
				}
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
