package DummyGUIs.ImportData;
import javax.swing.JFrame;

public class DataImportDummyFrame {

	public static void main(String[] args) {
		JFrame frame = new ImportFrame("Activity Tracker");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	

	}

}
