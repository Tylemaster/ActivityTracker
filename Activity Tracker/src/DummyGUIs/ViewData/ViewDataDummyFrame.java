package DummyGUIs.ViewData;

import javax.swing.JFrame;

import DummyGUIs.CreateProfile.ProfileFrame;

public class ViewDataDummyFrame extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new DataFrame("Activity Tracker");
		frame.setSize(750, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

}
