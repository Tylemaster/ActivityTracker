package DummyGUIs.ViewData;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class DataFrame extends JFrame {
	public DataFrame(String title) {
		super(title);
		BorderLayout thicc = new BorderLayout(0, 50);
		Container c = getContentPane();
		c.setLayout(thicc);
		
		JPanel panelEast = new JPanel();
		String [] datColumns = {"Stat", "1Km", "2Km", "Total"};
		Object[][] data = {{"Calories", new Integer(30), new Integer(62), new Integer(92)},{"Heart Rate", "100 bpm", "112 bpm", "106 bpm"}, {"Ave. Speed", "6 km/h", "10 km/h", "8 km/h"}, {"Dehydration", "10ml", "12ml", "22ml"}, {"Cum. Distance", "1km", "2km", "2km"}};
		JTable table = new JTable(data, datColumns);
		JScrollPane scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		panelEast.add(scroll);
		
		JPanel panelWest = new JPanel();
		JPanel panelWestUpper = new JPanel();
		JPanel panelWestLower = new JPanel();
		JPanel panelWestCenter = new JPanel();
		
		JTextArea selActivity = new JTextArea("Select Activity");
		String[] activityNames = {"Running", "Swimming", "Ultimate Jump Rope"};
		JComboBox activityBox = new JComboBox(activityNames);
		
		JTextArea selDate = new JTextArea("Select Date: ");
		String[] dateNames = {"July 1, 2018", "July 21, 2018", "Aug 4, 2018"};
		JComboBox dateBox = new JComboBox(dateNames);
		
		JButton edData = new JButton("Edit Data");
		JButton back = new JButton("Back");
		

		
		panelWestCenter.add(selDate);
		panelWestCenter.add(dateBox);
		panelWestUpper.add(selActivity);
		panelWestUpper.add(activityBox);
		panelWestLower.add(edData);
		panelWestLower.add(back);
		panelWest.setLayout(new BorderLayout());
		panelWest.add(BorderLayout.NORTH, panelWestUpper);
		panelWest.add(BorderLayout.CENTER, panelWestCenter);
		panelWest.add(BorderLayout.SOUTH, panelWestLower);
		
		JPanel panelNorth = new JPanel();
		JTextArea profName = new JTextArea("View Data Page");
		panelNorth.add(profName);
		
		c.add(BorderLayout.NORTH, panelNorth );
		c.add(BorderLayout.WEST, panelWest);
		c.add(BorderLayout.EAST, panelEast);
	}
}
