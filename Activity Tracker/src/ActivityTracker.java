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
	private UserApp currentUser;
	private JComboBox comboBox;

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
						
						WriteFile newUserSessionsFile = new WriteFile("src/Files/" + createProfName.getText() + "Sessions.txt", true);
						newUserSessionsFile.writeToFile("Sessions");
						WriteFile newUserDeviceFile = new WriteFile("src/Files/" + createProfName.getText() + "Devices.txt", true);
						newUserDeviceFile.writeToFile("Devices");
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
									Scanner userReadSessions = new Scanner(new File("src/Files/"+ logInName.getText() + "Sessions.txt"));
									String toRead;
									String date;
									userReadSessions.nextLine();
									ArrayList<Session> tempSessionList = new ArrayList<Session>();
									ArrayList<Device> tempDeviceList = new ArrayList<Device>();
									ArrayList<Friends> tempFriendList = new ArrayList<Friends>();
									while(userReadSessions.hasNextLine()) {
										toRead = userReadSessions.nextLine();
										date = toRead;
										userReadSessions.nextLine();
										Session tempSession = readSessionsFromUser(userReadSessions, date);
										tempSessionList.add(tempSession);

									}
									Scanner userReadDevices = new Scanner(new File("src/Files/" + logInName.getText() + "Devices.txt"));
									userReadDevices.nextLine();
									String newDeviceName;
									Device tempDevice;
									while(userReadDevices.hasNextLine()) {
										newDeviceName = userReadDevices.nextLine();
										tempDevice = new Device(newDeviceName);
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
		btnImportData.setBounds(123, 152, 187, 23);
		Home.add(btnImportData);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Statistics");
			}
		});
		btnStatistics.setBounds(380, 152, 173, 23);
		Home.add(btnStatistics);
		
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
				//initializing the scanner to READ DATA file
				Scanner ed = null;
				//Try catch because working with files
				if(comboBox.getItemCount() != 0){
					try {
						//This scanner takes in the SESSION DATA FILE
						//We'll have to edit this to take in different files, but for now its hardcoded
						ed = new Scanner(new File("src/Files/" + comboBox.getSelectedItem().toString()));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("No Data File");
					}
					
					//ReadSession method makes a new SESSION object from the scanner we just made
					ArrayList<Session> newSessions = readSessionsFromData(ed);
					
					for(Session newSession: newSessions){
						//update CURRENT USER with our NEW SESSION
						currentUser.updateSessionList(newSession);
						
						//Initialize 3 TEMPORARY array lists with the data from the session we just made
						ArrayList<Float> tempTime = newSession.getTime();
						ArrayList<Float> tempDist = newSession.getDistance();
						ArrayList<Float> tempAlt = newSession.getAltitude();
						
						//Make a new WriteFile object from the CURRENT USERS FILE
						WriteFile userLogData = new WriteFile("src/Files/" + currentUser.getFullName() + "Sessions.txt", true);
						
						
						try {
							//First thing it does is write the NEW SESSIONS DATE to the file
							userLogData.writeToFile(newSession.getDate());
							System.out.println(newSession.getDate());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//for loop iterates through the length of the tempTimeList
						for(int i = 0; i < newSession.getTime().size(); i++) {
							try {
								//writes the DATA from SESSION OBJECT to the USER FILE, LINE BY LINE
								userLogData.writeToFile("(" + String.valueOf(Math.round(tempTime.get(i))) + "," + String.valueOf(Math.round(tempDist.get(i))) + "," + String.valueOf(Math.round(tempAlt.get(i))) + ")");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

				
				
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
				if(!(newDeviceName.getText().equals(""))) {
					comboBox.addItem(newDeviceName.getText());
					Device newDevice = new Device(newDeviceName.getText());
					currentUser.updateDeviceList(newDevice);
					WriteFile userDeviceData = new WriteFile("src/Files/" + currentUser.getFullName() + "Devices.txt", true);
					try {
						userDeviceData.writeToFile(newDeviceName.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
		
		//this button will change the table so that it can be edited, which will update the sessions
		JButton btnViewRecords = new JButton("Edit Data");
		center.add(btnViewRecords);
		
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
	
	public static ArrayList<Session> readSessionsFromData(Scanner fileToRead){
		ArrayList<Float> tempTimeList = new ArrayList<Float>();
		ArrayList<Float> tempDistanceList= new ArrayList<Float>();
		ArrayList<Float> tempAltitudeList= new ArrayList<Float>();
		String tempDate;
		ArrayList<Session> tempSessions = new ArrayList<Session>();
		Session tempSession;
		String strToRead;
		String[] strToAssign;
		strToRead = fileToRead.nextLine();
		while(fileToRead.hasNextLine()){
			strToAssign = strToRead.split(",");
			tempDate = strToAssign[3];
			tempTimeList.add(Float.parseFloat(strToAssign[0]));
			tempDistanceList.add(Float.parseFloat(strToAssign[1]));
			tempAltitudeList.add(Float.parseFloat(strToAssign[2]));
			strToRead = fileToRead.nextLine();
			while(!(strToRead.substring(0,1).equals("0")) && fileToRead.hasNextLine()){
				strToAssign = strToRead.split(",");
				tempTimeList.add(Float.parseFloat(strToAssign[0]));
				tempDistanceList.add(Float.parseFloat(strToAssign[1]));
				tempAltitudeList.add(Float.parseFloat(strToAssign[2]));
				strToRead = fileToRead.nextLine();
			}
			
			tempSession = new Session(tempDate, tempTimeList, tempDistanceList, tempAltitudeList);
			tempSessions.add(tempSession);
			tempDate = strToAssign[3];
			tempTimeList = new ArrayList<Float>();
			tempDistanceList = new ArrayList<Float>();
			tempAltitudeList = new ArrayList<Float>();
		}
		return tempSessions;
	}
	
	//This is the method that will read in data in CSV form. To be used, the Scanner passed into it must have the NEXT LINE be the FIRST DATA POINT (e.g (0,0,0))
	//that means that before this method is used, you must parse the file you are reading from to get to the proper start, and then pass the scanner to the method when it is in the aforementioned state
	//If you are reading from the USER FILE, the date passed in must be the date used as a header for the data in the user file.
	//If you are importing the data, an empty string "" should be passed in, and the date will be made for this session WITHIN the method.
	public static Session readSessionsFromUser(Scanner fileToRead, String date){
		String reportDate = date;


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
	
	
}





