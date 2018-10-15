package DummyGUIs.CreateProfile;
import javax.swing.JFrame;

import DummyGUIs.ImportData.ImportFrame;

public class CreateProfileDummyFrame {
	public static void main(String[] args) {
		JFrame frame = new ProfileFrame("Activity Tracker");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	

	}
}
