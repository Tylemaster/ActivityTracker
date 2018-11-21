import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ActivityTracker {

	private JFrame frmActivityTracker;
	private JTextField createProfName;
	private JTextField createProfPass;
	private JTextField logInName;
	private JTextField logInPass;
	private JTextField newDeviceName;
	private JTable ActivityTable;
	private JTable table;
	private UserApp currentUser;
	public JComboBox DateCombo;

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
		btnLogIn.setBounds(101, 219, 165, 23);
		Start.add(btnLogIn);
		
		JButton btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Create Profile");
			}
		});
		btnCreateProfile.setBounds(399, 219, 178, 23);
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
		btnBack.setBounds(130, 227, 160, 23);
		CreateProfile.add(btnBack);
		
		
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(createProfName.getText().equals("")) && !(createProfPass.getText().equals(""))) {
					WriteFile userLogData = new WriteFile("src/Files/username.txt", true);
					try{
						userLogData.writeToFile(createProfName.getText());
						userLogData.writeToFile(createProfPass.getText());
						
						WriteFile newUserFile = new WriteFile("src/Files/" + createProfName.getText() + ".txt", true);
						newUserFile.writeToFile("Friends");
						newUserFile.writeToFile("Sessions");
						newUserFile.writeToFile("Device");
						
						currentUser = new UserApp(createProfName.getText(), createProfPass.getText());
					}
					catch(IOException err){
						card.show(mainPanel, "Invalid Create");
					}


					
					/*If statement will have to be added here if the username or password is invalid, take them to invalid page, otherwise to the home screen
					 *if not invalid, user will be created with the entered createProfName and createProfPass variables and added to the external storage 
					 */
					card.show(mainPanel, "Home");
				}
				else {
					card.show(mainPanel, "Invalid Create");
				}

			}
		});
		btnCreate.setBounds(397, 227, 160, 23);
		CreateProfile.add(btnCreate);
		
		
		
		
		
		JLabel lblCreateProfilePage = new JLabel("Create Profile");
		lblCreateProfilePage.setBounds(301, 11, 196, 14);
		CreateProfile.add(lblCreateProfilePage);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(170, 80, 100, 14);
		CreateProfile.add(lblName);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(170, 148, 143, 14);
		CreateProfile.add(lblPassword);
		
		JPanel LogIn = new JPanel();
		mainPanel.add(LogIn, "Log In");
		LogIn.setLayout(null);
		
		JLabel lblLogInPage = new JLabel("Log In");
		lblLogInPage.setBounds(306, 11, 75, 14);
		LogIn.add(lblLogInPage);
		
		JLabel lblName_1 = new JLabel("Name: ");
		lblName_1.setBounds(192, 77, 145, 14);
		LogIn.add(lblName_1);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(192, 142, 145, 14);
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
				if(!(logInName.getText().equals("")) && !(logInPass.getText().equals(""))) {
					File currentFile = new File("src/Files/username.txt");
					Scanner textScan;
					try {
						textScan = new Scanner(currentFile);
						while(textScan.hasNextLine()){
							String str = textScan.nextLine();
							if(str.equals(logInName.getText())){
								if(textScan.nextLine().equals(logInPass.getText())){
									card.show(mainPanel, "Home");
									
									
									
									//Here is where we will read the users file to get the information for each user
									Scanner userRead = new Scanner(new File("src/Files/"+ logInName.getText() + ".txt"));
									userRead.nextLine();
									String toRead;
									String date;
									ArrayList<Friends> tempFriendList = new ArrayList<Friends>();
									ArrayList<Session> tempSessionList = new ArrayList<Session>();
									ArrayList<Device> tempDeviceList = new ArrayList<Device>();
									while(userRead.hasNextLine()) {
										toRead = userRead.nextLine();
										if(toRead.equals("Sessions")) {
											break;
										}
										else {
											//Here we will have to add a way to read each piece of information in the text file for each friend, and make a friend object
											Friends tempFriend = null;
											tempFriendList.add(tempFriend);
										}
									}
									while(userRead.hasNextLine()) {
										toRead = userRead.nextLine();
										if(toRead.equals("Device")) {
											break;
										}
										else {
											//Here we will have to add a way to read each piece of information in the text file pertaining to each session, and make a session object
											date = toRead;
											userRead.nextLine();
											Session tempSession = readSessions(userRead, date);
											tempSessionList.add(tempSession);
										}
									}
									while(userRead.hasNextLine()) {
										//Here we will have to add a way to read each piece of information in the text file pertaining to each device, and make a device object
										Device tempDevice = null;
										tempDeviceList.add(tempDevice);
									}
									
									//Initializing the current user with the info we've parsed
									currentUser = new UserApp(logInName.getText(), logInPass.getText());
									currentUser.setFriendsList(tempFriendList);
									currentUser.setSessionsList(tempSessionList);
									currentUser.setDeviceList(tempDeviceList);
									break;
								}
							}
							else{
									card.show(mainPanel, "Inval Login");
							}
						
						}
							textScan.close();
					}
					catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}	
				}
				else {
					card.show(mainPanel, "Inval Login");
				}

				DateCombo =  updateComboBox(currentUser, DateCombo);

			}
		});
		btnLogIn_1.setBounds(400, 227, 145, 23);
		LogIn.add(btnLogIn_1);
		
		
		
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Start");
			}
		});
		btnBack_1.setBounds(109, 227, 172, 23);
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
		btnImportData.setBounds(29, 152, 187, 23);
		Home.add(btnImportData);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Statistics");
			}
		});
		btnStatistics.setBounds(477, 152, 173, 23);
		Home.add(btnStatistics);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Friends");
			}
		});
		btnFriends.setBounds(268, 152, 162, 23);
		Home.add(btnFriends);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setBounds(302, 11, 103, 14);
		Home.add(lblHomePage);
		
		JPanel InvalidLogIn = new JPanel();
		mainPanel.add(InvalidLogIn, "Inval Login");
		InvalidLogIn.setLayout(null);
		
		JLabel lblInvalidUsernameOr = new JLabel("Invalid Username or Password, Please Retry");
		lblInvalidUsernameOr.setBounds(184, 11, 420, 69);
		InvalidLogIn.add(lblInvalidUsernameOr);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Log In");
			}
		});
		btnBack_2.setBounds(261, 178, 180, 23);
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
		btnBack_3.setBounds(143, 227, 129, 23);
		ImportData.add(btnBack_3);
		
		JButton btnAddDevice = new JButton("Add Device");
		btnAddDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Add Device");
			}
		});
		btnAddDevice.setBounds(381, 227, 169, 23);
		ImportData.add(btnAddDevice);
		
		//This combo box will hold all devices, will have to be updated when user 1. logs in and 2. adds a device
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(381, 93, 169, 20);
		ImportData.add(comboBox);
		
		//This button will have to read the data being given from the selected device, and add it to/redraw the statistics panel
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateCombo =  updateComboBox(currentUser, DateCombo);
				
			}
		});
		btnImport.setBounds(143, 92, 129, 23);
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
				//add code here to add device (newDeviceName) to the current user profile, and redraw the import data page with this new device
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
		
		Panel center = new Panel();
		verticalBox_1.add(center);
		center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Select Date: ");
		center.add(lblNewLabel_1);
		
		//this combobox will hold all the session dates of the currently selected user, changing this will update the table
		DateCombo = new JComboBox();
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
		
		//this button will change the table so that it can be edited, which will update the sessions
		JButton btnEditData = new JButton("Edit Data");
		lower.add(btnEditData);
		
		JPanel East = new JPanel();
		Statisitics.add(East, BorderLayout.EAST);
		East.setLayout(new BorderLayout(0, 0));
		
		
		//Activity table will pull from the currently selected session of the current user and display
		String [] datColumns = {"Time", "Distance", "Altitude"};
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
		
		//table will show list of current friends pulled from user friends list
		JList friendsList = new JList();
		JScrollPane scrollPane = new JScrollPane(friendsList);
		Friends.add(scrollPane, BorderLayout.EAST);
		
		JPanel friendOptions = new JPanel();
		Friends.add(friendOptions, BorderLayout.WEST);
		
		Box verticalBox = Box.createVerticalBox();
		friendOptions.add(verticalBox);
		
		//button will send user to view data screen which will be updated with the data sessions of the currently selected friend
		JButton btnViewFriend = new JButton("View Friend");
		btnViewFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Friend Data");
			}
		});
		verticalBox.add(btnViewFriend);
		
		JButton btnAddFriend = new JButton("Add Friend");
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Add Friend");
			}
		});
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
		
		JPanel FriendData = new JPanel();
		mainPanel.add(FriendData, "Friend Data");
		FriendData.setLayout(new BorderLayout(0, 0));
		
		JPanel FriendOptions = new JPanel();
		FriendData.add(FriendOptions, BorderLayout.WEST);
		
		Box verticalBox_2 = Box.createVerticalBox();
		FriendOptions.add(verticalBox_2);
		
		JPanel upper_1 = new JPanel();
		verticalBox_2.add(upper_1);
		
		JLabel lblSelectActivity_1 = new JLabel("Select Activity: ");
		upper_1.add(lblSelectActivity_1);
		
		//This combo box will have all the programs activities
		JComboBox friend_activity = new JComboBox();
		upper_1.add(friend_activity);
		
		JPanel center_1 = new JPanel();
		verticalBox_2.add(center_1);
		
		JLabel lblSelectDate = new JLabel("Select Date: ");
		center_1.add(lblSelectDate);
		
		//this combo box will have all the sessions of the chosen activity type in the friends data, and choosing one will update the table
		JComboBox friend_date = new JComboBox();
		center_1.add(friend_date);
		
		JPanel lower_1 = new JPanel();
		verticalBox_2.add(lower_1);
		
		JButton btnBack_7 = new JButton("Back");
		btnBack_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Friends");
			}
		});
		lower_1.add(btnBack_7);
		
		JPanel FriendEast = new JPanel();
		FriendData.add(FriendEast, BorderLayout.EAST);
		
		//this table will access the current session selected from the selested friends profile and display the data
		table = new JTable();
		JScrollPane friendTableScroll = new JScrollPane(table);
		FriendEast.add(friendTableScroll);
		
		
		
		JPanel FriendHeader = new JPanel();
		FriendData.add(FriendHeader, BorderLayout.NORTH);
		
		JLabel lblFriendStatistics = new JLabel("Friend Statistics");
		FriendHeader.add(lblFriendStatistics);
		
		JPanel AddFriends = new JPanel();
		mainPanel.add(AddFriends, "Add Friend");
		AddFriends.setLayout(new BorderLayout(0, 0));
		
		//this list will display all users on the activity tracker profile
		JList usersList = new JList();
		JScrollPane scrollPane_1 = new JScrollPane(usersList);
		AddFriends.add(scrollPane_1, BorderLayout.EAST);
		
		JPanel usersHeader = new JPanel();
		AddFriends.add(usersHeader, BorderLayout.NORTH);
		
		JLabel lblAddFriend = new JLabel("Add Friend");
		usersHeader.add(lblAddFriend);
		
		JPanel addOptions = new JPanel();
		AddFriends.add(addOptions, BorderLayout.WEST);
		
		Box verticalBox_3 = Box.createVerticalBox();
		addOptions.add(verticalBox_3);
		
		//this button will send a friend request to the currently selected user
		JButton btnSendRequest = new JButton("Send Request");
		verticalBox_3.add(btnSendRequest);
		
		JButton btnBack_8 = new JButton("Back");
		btnBack_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Friends");
			}
		});
		verticalBox_3.add(btnBack_8);
		

		
		

	}
	
	//This is the method that will read in data in CSV form. To be used, the Scanner passed into it must have the NEXT LINE be the FIRST DATA POINT (e.g (0,0,0))
	//that means that before this method is used, you must parse the file you are reading from to get to the proper start, and then pass the scanner to the method when it is in the aforementioned state
	//If you are reading from the USER FILE, the date passed in must be the date used as a header for the data in the user file.
	//If you are importing the data, an empty string "" should be passed in, and the date will be made for this session WITHIN the method.
	public static Session readSessions(Scanner fileToRead, String date){
		String reportDate;
		//if date is given (as it should be when reading from user file), then the date passed to the returned function will be that
		//if this data is being reread from a text file however, a timestamp is made and assigned to the session
		if(date.equals("")){
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = Calendar.getInstance().getTime();
			reportDate = df.format(today);
		}
		else{
			reportDate = date;
		}

		ArrayList<Float> tempTimeList = new ArrayList<Float>();
		ArrayList<Float> tempDistanceList= new ArrayList<Float>();
		ArrayList<Float> tempAltitudeList= new ArrayList<Float>(); 
		Session tempSession;
		String strToRead;
		String[] strToAssign;
		while(fileToRead.hasNextLine()){
			strToRead = fileToRead.nextLine();
			//If the next string is in the proper format, read it for data, otherwise finish loop
			if(strToRead.charAt(0) == '('){
				strToRead = strToRead.substring(1, strToRead.length()-1);
				strToAssign = strToRead.split(",");
				tempTimeList.add(Float.parseFloat(strToAssign[0]));
				tempDistanceList.add(Float.parseFloat(strToAssign[1]));
				tempAltitudeList.add(Float.parseFloat(strToAssign[2]));
			}
			else{
				break;
			}

		}
		tempSession = new Session(reportDate, tempTimeList, tempDistanceList, tempAltitudeList);
		return tempSession;
	}
	
	public JComboBox updateComboBox(UserApp currentUser, JComboBox DateCombo){
		for (Session curUser: currentUser.getSessionList()){
			DateCombo.addItem(curUser.getDate());
		}
		return DateCombo;
	}
	
/*	public void ImportData(){ 
		//This block of code will use the readSessions method to GET the session data from the text file
		Scanner ed = null;
		try {
			ed = new Scanner(new File("src/Files/sessionSample.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Data File");
		}
		Session newSession = readSessions(ed, "");
		
		//The current user is updated with the session we just read from the data file
		currentUser.updateSessionList(newSession);
		
		
		
		String file = "src/Files/" + currentUser.getFullName() + ".txt";
		File currentFile = new File(file);
		Scanner textScan;
		try {
			textScan = new Scanner(currentFile);
			while(textScan.hasNextLine()){
				String str = textScan.nextLine();
				if(str.equals("Sessions")){
					textScan.nextLine();
					
					
					//This while loop doesn't work. the i is not initialized, tempTimeList hasn't been acquired from anywhere. Have to add a loop to ITERATE THROUGH THE newSession ARRAY LISTS
					while (i < tempTimeList.length){
						//This method needs to store the data to the file in the (0,0,0) format, as it's given to us, so that we can use the same method to read it from the user file and the import data file
						file.write(file, "1", "2", "3", StandardCharsets.UTF_8);
					} 
				}
			}
		}
		finally {
			
		}
	}*/
	
}




