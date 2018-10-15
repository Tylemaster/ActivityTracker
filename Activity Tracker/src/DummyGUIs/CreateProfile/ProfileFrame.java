package DummyGUIs.CreateProfile;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProfileFrame extends JFrame {
	public ProfileFrame(String title) {
		super(title);
		BorderLayout thicc = new BorderLayout(0, 50);
		Container c = getContentPane();
		c.setLayout(thicc);
		
		JPanel panelBelow = new JPanel();
		JButton device = new JButton("Create Profile");
		JButton back = new JButton("Back");
		panelBelow.add(device);
		panelBelow.add(back);
		
		JPanel panelCenter = new JPanel();
		JPanel panelCenterUpper = new JPanel();
		JPanel panelCenterLower = new JPanel();
		JTextArea entName = new JTextArea("Enter Name: ");
		JTextField nameField = new JTextField(10);
		JTextArea entPass = new JTextArea("Enter Password: ");
		JTextField passField = new JTextField(10);
		panelCenterLower.add(entPass);
		panelCenterLower.add(passField);
		panelCenterUpper.add(entName);
		panelCenterUpper.add(nameField);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(BorderLayout.NORTH, panelCenterUpper);
		panelCenter.add(BorderLayout.SOUTH, panelCenterLower);
		
		JPanel panelNorth = new JPanel();
		JTextArea profName = new JTextArea("Create Profile Page");
		panelNorth.add(profName);
		
		c.add(BorderLayout.NORTH, panelNorth );
		c.add(BorderLayout.CENTER, panelCenter);
		c.add(BorderLayout.SOUTH, panelBelow);
	}
	
}
