import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class DummyGUI {

	public static void main(String[] args) {
		JFrame frame = new MainFrame("Activity Tracker");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

}
