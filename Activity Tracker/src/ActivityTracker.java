import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.Box;

public class ActivityTracker {

	private JFrame frmActivityTracker;
	private JTextField createProfName;
	private JTextField createProfPass;
	private JTextField logInName;
	private JTextField logInPass;
	private JTextField newDeviceName;
	private JTable ActivityTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityTracker window = new ActivityTracker();
					window.frmActivityTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActivityTracker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmActivityTracker = new JFrame();
		frmActivityTracker.setTitle("Activity Tracker");
		frmActivityTracker.setBounds(100, 100, 700, 350);
		frmActivityTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frmActivityTracker.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new CardLayout());
		CardLayout card = (CardLayout)mainPanel.getLayout();

		
		JPanel Start = new JPanel();
		mainPanel.add(Start, "Start");
		Start.setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Log In");
			}
		});
		btnLogIn.setBounds(189, 219, 77, 23);
		Start.add(btnLogIn);
		
		JButton btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Create Profile");
			}
		});
		btnCreateProfile.setBounds(399, 219, 117, 23);
		Start.add(btnCreateProfile);
		
		JLabel lblActivityTrackerStart = new JLabel("Activity Tracker Start");
		lblActivityTrackerStart.setBounds(263, 11, 172, 14);
		Start.add(lblActivityTrackerStart);
		
		JPanel CreateProfile = new JPanel();
		mainPanel.add(CreateProfile, "Create Profile");
		CreateProfile.setLayout(null);
		
		createProfName = new JTextField();
		createProfName.setBounds(367, 77, 130, 20);
		CreateProfile.add(createProfName);
		createProfName.setColumns(10);
		
		createProfPass = new JTextField();
		createProfPass.setBounds(367, 145, 130, 20);
		CreateProfile.add(createProfPass);
		createProfPass.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Start");
			}
		});
		btnBack.setBounds(201, 227, 89, 23);
		CreateProfile.add(btnBack);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*If statement will have to be added here if the username or password is invalid, take them to invalid page, otherwise to the home screen
				 *if not invalid, user will be created with the entered createProfName and createProfPass variables and added to the external storage 
				 */
				card.show(mainPanel, "Home");
			}
		});
		btnCreate.setBounds(397, 227, 89, 23);
		CreateProfile.add(btnCreate);
		
		JLabel lblCreateProfilePage = new JLabel("Create Profile");
		lblCreateProfilePage.setBounds(312, 11, 130, 14);
		CreateProfile.add(lblCreateProfilePage);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(224, 80, 46, 14);
		CreateProfile.add(lblName);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(224, 148, 89, 14);
		CreateProfile.add(lblPassword);
		
		JPanel LogIn = new JPanel();
		mainPanel.add(LogIn, "Log In");
		LogIn.setLayout(null);
		
		JLabel lblLogInPage = new JLabel("Log In");
		lblLogInPage.setBounds(306, 11, 75, 14);
		LogIn.add(lblLogInPage);
		
		JLabel lblName_1 = new JLabel("Name: ");
		lblName_1.setBounds(192, 77, 46, 14);
		LogIn.add(lblName_1);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(192, 142, 89, 14);
		LogIn.add(lblPassword_1);
		
		logInName = new JTextField();
		logInName.setBounds(357, 74, 145, 20);
		LogIn.add(logInName);
		logInName.setColumns(10);
		
		logInPass = new JTextField();
		logInPass.setBounds(357, 139, 145, 20);
		LogIn.add(logInPass);
		logInPass.setColumns(10);
		
		JButton btnLogIn_1 = new JButton("Log In");
		btnLogIn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if statement will have to be added here, if username or password is invalid take them to invalid page.
				 * To check for validity, must see if username or password(logInName and logInPass) is null, or matched any of the stored usernames and passwords.
				 * If it does match, user is valid, and taken to homescreen. The Statistics, Friends, and Devices panels must also be redrawn, with the information from
				 * this user. (possibly add log in method)
				 */
				card.show(mainPanel, "Home");
			}
		});
		btnLogIn_1.setBounds(400, 227, 89, 23);
		LogIn.add(btnLogIn_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Start");
			}
		});
		btnBack_1.setBounds(192, 227, 89, 23);
		LogIn.add(btnBack_1);
		
		JPanel Home = new JPanel();
		mainPanel.add(Home, "Home");
		Home.setLayout(null);
		
		JButton btnImportData = new JButton("Import Data");
		btnImportData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Import Data");
			}
		});
		btnImportData.setBounds(103, 152, 113, 23);
		Home.add(btnImportData);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Statistics");
			}
		});
		btnStatistics.setBounds(477, 152, 113, 23);
		Home.add(btnStatistics);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Friends");
			}
		});
		btnFriends.setBounds(302, 152, 89, 23);
		Home.add(btnFriends);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setBounds(302, 11, 103, 14);
		Home.add(lblHomePage);
		
		JPanel InvalidLogIn = new JPanel();
		mainPanel.add(InvalidLogIn, "Inval Login");
		InvalidLogIn.setLayout(null);
		
		JLabel lblInvalidUsernameOr = new JLabel("Invalid Username or Password, Please Retry");
		lblInvalidUsernameOr.setBounds(216, 11, 307, 69);
		InvalidLogIn.add(lblInvalidUsernameOr);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Log In");
			}
		});
		btnBack_2.setBounds(290, 178, 89, 23);
		InvalidLogIn.add(btnBack_2);
		
		JPanel ImportData = new JPanel();
		mainPanel.add(ImportData, "Import Data");
		ImportData.setLayout(null);
		
		JLabel lblImportDataPage = new JLabel("Import Data");
		lblImportDataPage.setBounds(306, 11, 122, 14);
		ImportData.add(lblImportDataPage);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Home");
			}
		});
		btnBack_3.setBounds(183, 227, 89, 23);
		ImportData.add(btnBack_3);
		
		JButton btnAddDevice = new JButton("Add Device");
		btnAddDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Add Device");
			}
		});
		btnAddDevice.setBounds(381, 227, 110, 23);
		ImportData.add(btnAddDevice);
		
		//This combo box will hold all devices, will have to be updated when user 1. logs in and 2. adds a device
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(381, 93, 110, 20);
		ImportData.add(comboBox);
		
//		if (name.getName.equals() && password.getPassword.equals()){
//			j
//		}
//		else{
//			
//		}
		
		//This button will have to read the data being given from the selected device, and add it to/redraw the statistics panel
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(183, 92, 89, 23);
		ImportData.add(btnImport);
		
		JPanel AddDevice = new JPanel();
		mainPanel.add(AddDevice, "Add Device");
		AddDevice.setLayout(null);
		
		JLabel lblAddDevice = new JLabel("Add Device ");
		lblAddDevice.setBounds(293, 11, 127, 14);
		AddDevice.add(lblAddDevice);
		
		JLabel lblDeviceName = new JLabel("Device Name: ");
		lblDeviceName.setBounds(216, 101, 87, 14);
		AddDevice.add(lblDeviceName);
		
		newDeviceName = new JTextField();
		newDeviceName.setBounds(362, 98, 150, 20);
		AddDevice.add(newDeviceName);
		newDeviceName.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add code here to add device, and redraw the import data page with this new device
				card.show(mainPanel, "Import Data");
			}
		});
		btnAdd.setBounds(382, 207, 89, 23);
		AddDevice.add(btnAdd);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Import Data");
			}
		});
		btnNewButton.setBounds(214, 207, 89, 23);
		AddDevice.add(btnNewButton);
		
		JPanel Statisitics = new JPanel();
		mainPanel.add(Statisitics, "Statistics");
		Statisitics.setLayout(new BorderLayout(0, 0));
		
		JPanel Options = new JPanel();
		Statisitics.add(Options, BorderLayout.WEST);
		Options.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox_1 = Box.createVerticalBox();
		Options.add(verticalBox_1);
		
		Panel upper = new Panel();
		verticalBox_1.add(upper);
		upper.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSelectActivity = new JLabel("Select Activity: ");
		upper.add(lblSelectActivity);
		
		JComboBox ActivityComboBox = new JComboBox();
		upper.add(ActivityComboBox);
		
		Panel center = new Panel();
		verticalBox_1.add(center);
		center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Select Date: ");
		center.add(lblNewLabel_1);
		
		JComboBox DateCombo = new JComboBox();
		center.add(DateCombo);
		
		Panel lower = new Panel();
		verticalBox_1.add(lower);
		lower.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Home");
			}
		});
		lower.add(btnBack_4);
		
		JButton btnEditData = new JButton("Edit Data");
		lower.add(btnEditData);
		
		JPanel East = new JPanel();
		Statisitics.add(East, BorderLayout.EAST);
		East.setLayout(new BorderLayout(0, 0));
		
		
		String [] datColumns = {"Stat", "1Km", "2Km", "Total"};
		Object[][] data = {{"Calories", new Integer(30), new Integer(62), new Integer(92)},{"Heart Rate", "100 bpm", "112 bpm", "106 bpm"}, {"Ave. Speed", "6 km/h", "10 km/h", "8 km/h"}, {"Dehydration", "10ml", "12ml", "22ml"}, {"Cum. Distance", "1km", "2km", "2km"}};
		ActivityTable = new JTable(data, datColumns);
		ActivityTable.setFillsViewportHeight(true);
		
		JScrollPane TableScroll = new JScrollPane(ActivityTable);
		East.add(TableScroll, BorderLayout.EAST);
		
		JPanel Header = new JPanel();
		Statisitics.add(Header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Statistics");
		Header.add(lblNewLabel);
		
		JPanel Friends = new JPanel();
		mainPanel.add(Friends, "Friends");
		Friends.setLayout(new BorderLayout(0, 0));
		
		
		JList friendsList = new JList();
		JScrollPane scrollPane = new JScrollPane(friendsList);
		Friends.add(scrollPane, BorderLayout.EAST);
		
		JPanel friendOptions = new JPanel();
		Friends.add(friendOptions, BorderLayout.WEST);
		
		Box verticalBox = Box.createVerticalBox();
		friendOptions.add(verticalBox);
		
		JButton btnViewFriend = new JButton("View Friend");
		verticalBox.add(btnViewFriend);
		
		JButton btnAddFriend = new JButton("Add Friend");
		verticalBox.add(btnAddFriend);
		
		JButton btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Home");
			}
		});
		verticalBox.add(btnBack_5);
		
		JPanel header = new JPanel();
		Friends.add(header, BorderLayout.NORTH);
		
		JLabel lblFriends = new JLabel("Friends");
		header.add(lblFriends);
		
		JPanel InvalidCreate = new JPanel();
		mainPanel.add(InvalidCreate, "Invalid Create");
		InvalidCreate.setLayout(null);
		
		JLabel lblInvalidUsernameOr_1 = new JLabel("Invalid Username or Password, Please Retry");
		lblInvalidUsernameOr_1.setBounds(239, 11, 290, 14);
		InvalidCreate.add(lblInvalidUsernameOr_1);
		
		JButton btnBack_6 = new JButton("Back");
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Log In");
			}
		});
		btnBack_6.setBounds(311, 196, 89, 23);
		InvalidCreate.add(btnBack_6);
		
		

	}
		public String updateComboBox(UserApp currentUser){
			for (Session curUser: currentUser.getSessionList()){
				DateCombo.add(curUser.date);
			}
		
		
	}
}
