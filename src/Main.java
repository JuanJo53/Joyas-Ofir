import javax.swing.JFrame;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Main {

	public static void main(String[] args) {
		try {
			Loggin frame = new Loggin();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
