import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		BorderLayout thicc = new BorderLayout(0, 50);
		Container c = getContentPane();
		c.setLayout(thicc);
		
		JPanel panelBelow = new JPanel();
		JButton device = new JButton("Add New Device");
		JButton back = new JButton("Back");
		panelBelow.add(device);
		panelBelow.add(back);
		
		JPanel panelCenter = new JPanel();
		JButton importButt = new JButton("Import From Selected Device");
		String[] deviceNames = {"Apple Watch", "FitBit"};
		JComboBox deviceList = new JComboBox(deviceNames);
		panelCenter.add(importButt);
		panelCenter.add(deviceList);
		
		JPanel panelNorth = new JPanel();
		JTextArea profName = new JTextArea("Import Data Page");
		panelNorth.add(profName);
		
		c.add(BorderLayout.NORTH, panelNorth );
		c.add(BorderLayout.CENTER, panelCenter);
		c.add(BorderLayout.SOUTH, panelBelow);
	
	}

}
