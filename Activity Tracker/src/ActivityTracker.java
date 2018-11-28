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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.print.attribute.standard.PrinterLocation;
import javax.swing.Box;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
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
	private JLabel lblMetres;
	private JLabel lblSecondmetre;
	private JLabel lblCalories;
	private JLabel lblMetres_1;
	private JLabel lblMetres_2;
	private JComboBox beforeBox;
	private JComboBox afterBox;
	private String[] columnNames = {"Session#", "Date", "Time(s)", "Distance(m)", "Alt Up(m)", "Alt Down(m)"};
	private Object[][] data;
	private JScrollPane TableScroll;
	private JPanel Statisitics;
	private JPanel East;

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
		frmActivityTracker.setBounds(100, 100, 721, 350);
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
		
		
		
		/*If statement here if the username or password is invalid, take them to invalid page, otherwise to the home screen
		 *if not invalid, user will be created with the entered createProfName and createProfPass variables and added to the external storage 
		 */
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
				/*iif username or password is invalid take them to invalid page.
				 * To check for validity, must see if username or password(logInName and logInPass) is null, or matched any of the stored usernames and passwords.
				 * If it does match, user is valid, and taken to homescreen. The Statistics and Devices panels must also be redrawn, with the information from
				 * this user.
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
									
									DeviceCombo(comboBox, currentUser);
									DateDayCombo(beforeBox,currentUser);
									DateDayCombo(afterBox,currentUser);
									
									
									data = newJtable(currentUser.getSessionList());
									East.removeAll();
									East.add(new JScrollPane(new JTable(data, columnNames)));
									Statisitics.repaint();
									userReadDevices.close();
									
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
		lblInvalidUsernameOr.setBounds(212, 11, 420, 69);
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
		btnBack_3.setBounds(143, 227, 169, 23);
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
		comboBox = new JComboBox();
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
						ArrayList<Double> tempTime = newSession.getTime();
						ArrayList<Double> tempDist = newSession.getDistance();
						ArrayList<Double> tempAlt = newSession.getAltitude();
						
						//Make a new WriteFile object from the CURRENT USERS FILE
						WriteFile userLogData = new WriteFile("src/Files/" + currentUser.getFullName() + "Sessions.txt", true);
						
						
						try {
							//First thing it does is write the NEW SESSIONS DATE to the file
							userLogData.writeToFile(newSession.getDate());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//for loop iterates through the length of the tempTimeList
						for(int i = 0; i < newSession.getTime().size(); i++) {
							try {
								//writes the DATA from SESSION OBJECT to the USER FILE, LINE BY LINE
								userLogData.writeToFile("(" + String.valueOf(tempTime.get(i)) + "," + String.valueOf(tempDist.get(i)) + "," + String.valueOf(tempAlt.get(i)) + ")");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						try {
							userLogData.writeToFile("e");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						DateDayCombo(beforeBox,currentUser);
						DateDayCombo(afterBox,currentUser);
						data = newJtable(currentUser.getSessionList());
						East.removeAll();
						East.add(new JScrollPane(new JTable(data, columnNames)));
						Statisitics.repaint();
					}
				}

				
				
			}
		});
		btnImport.setBounds(143, 92, 169, 23);
		ImportData.add(btnImport);
		
		JPanel AddDevice = new JPanel();
		mainPanel.add(AddDevice, "Add Device");
		AddDevice.setLayout(null);
		
		JLabel lblAddDevice = new JLabel("Add Device ");
		lblAddDevice.setBounds(293, 11, 150, 14);
		AddDevice.add(lblAddDevice);
		
		JLabel lblDeviceName = new JLabel("Device Name: ");
		lblDeviceName.setBounds(216, 101, 119, 14);
		AddDevice.add(lblDeviceName);
		
		newDeviceName = new JTextField();
		newDeviceName.setBounds(362, 98, 150, 20);
		AddDevice.add(newDeviceName);
		newDeviceName.setColumns(10);
		
		//The btnAdd listener will add the given device to the current users list of devices, and add the device name to the usernames devices txt file
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAdd.setBounds(382, 207, 130, 23);
		AddDevice.add(btnAdd);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Import Data");
			}
		});
		btnNewButton.setBounds(214, 207, 121, 23);
		AddDevice.add(btnNewButton);
		
		Statisitics = new JPanel();
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
		JButton btnViewRecords = new JButton("View Records");
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "RecordOption");
			}
		});
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
		
		East = new JPanel();
		Statisitics.add(East, BorderLayout.EAST);
		East.setLayout(new BorderLayout(0, 0));
		
		//Activity table will pull from the currently selected session of the current user and display
		Object[][] dataNew = {{"-","-","-","-","-","-"}};
		ActivityTable = new JTable(dataNew, columnNames);		
		ActivityTable.setFillsViewportHeight(true);
	
		TableScroll = new JScrollPane(ActivityTable);
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
		btnBack_6.setBounds(269, 197, 151, 23);
		InvalidCreate.add(btnBack_6);
		
		JPanel RecordOption = new JPanel();
		mainPanel.add(RecordOption, "RecordOption");
		RecordOption.setLayout(null);
		
		JButton MonthSort = new JButton("Sort By Month");
		MonthSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "byMonth");
			}
		});
		MonthSort.setBounds(68, 86, 244, 23);
		RecordOption.add(MonthSort);
		
		JButton Day_Sort = new JButton("Sort by Days");
		Day_Sort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "byDate");
			}
		});
		Day_Sort.setBounds(357, 86, 270, 23);
		RecordOption.add(Day_Sort);
		
		JButton sortBack = new JButton("Back");
		sortBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(mainPanel,  "Statistics");
			}
		});
		sortBack.setBounds(266, 191, 142, 23);
		RecordOption.add(sortBack);
		
		JPanel byMonth = new JPanel();
		mainPanel.add(byMonth, "byMonth");
		byMonth.setLayout(null);
		
		JComboBox monthCombo = new JComboBox();
		String[] months = {"1", "2","3","4","5","6","7","8","9","10", "11", "12"};
		for(int i = 0; i < months.length;i++) {
			monthCombo.addItem(months[i]);
		}
		monthCombo.setBounds(368, 114, 254, 20);
		byMonth.add(monthCombo);
		
		//The btnSelectMonth will get a list of sessions that have the same month given in the combo box, and set the records page to the record from these sessions
		JButton btnSelectMonth = new JButton("Select Month");
		btnSelectMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DecimalFormat df = new DecimalFormat("#.##");
				String monthToGet = (String) monthCombo.getSelectedItem();
				ArrayList<Session> sessionsToRecord = getSessionsFromMonth(currentUser.getSessionList(), monthToGet);
				
				double avDist = avgDistance(sessionsToRecord);
				lblMetres.setText(String.valueOf(df.format(avDist)) + " Metres");
				
				double avPace = avgPace(sessionsToRecord);
				lblSecondmetre.setText(String.valueOf(df.format(avPace)) + " Metres/Second");
				
				double calBurned = avgCaloriesBurned(sessionsToRecord);
				lblCalories.setText(String.valueOf(df.format(calBurned)) + " Calories");
				
				double altUp = avgAltitudeUp(sessionsToRecord);
				lblMetres_1.setText(String.valueOf(df.format(altUp)) + " Metres");
				
				double altDown = avgAltitudeDown(sessionsToRecord);
				lblMetres_2.setText(String.valueOf(df.format(altDown)) + " Metres");
				
				card.show(mainPanel, "Records");
			}
		});
		btnSelectMonth.setBounds(22, 113, 254, 23);
		byMonth.add(btnSelectMonth);
		
		JButton btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "RecordOption");
			}
		});
		btnBack_5.setBounds(225, 209, 215, 23);
		byMonth.add(btnBack_5);
		
		JPanel byDate = new JPanel();
		mainPanel.add(byDate, "byDate");
		byDate.setLayout(null);
		
		JLabel lblSelectDate = new JLabel("Select Date 1");
		lblSelectDate.setBounds(59, 85, 230, 14);
		byDate.add(lblSelectDate);
		
		JLabel lblSelectDate_1 = new JLabel("Select Date 2 ");
		lblSelectDate_1.setBounds(59, 130, 209, 14);
		byDate.add(lblSelectDate_1);
		
		
		//The get record button will check the combo boxes for valid dates, and if they are valid, will set the values of the record page to the values returned from the list of sessions
		// that are between the two dates(inclusive)
		JButton btnGetRecords = new JButton("Get Records");
		btnGetRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(beforeBox.getSelectedItem() != null && afterBox.getSelectedItem() != null) {
					String date1 = (String) beforeBox.getSelectedItem();
					String date2 = (String) afterBox.getSelectedItem();
					try {
						if(isBefore(date1,date2)) {
							try {
								DecimalFormat df = new DecimalFormat("#.##");
								ArrayList<Session> sessionsToRecord = getSessionsFromDays(currentUser.getSessionList(), date1, date2);
								
								double avDist = avgDistance(sessionsToRecord);
								lblMetres.setText(String.valueOf(df.format(avDist)) + " Metres");
								
								double avPace = avgPace(sessionsToRecord);
								lblSecondmetre.setText(String.valueOf(df.format(avPace)) + " Metres/Second");
								
								double calBurned = avgCaloriesBurned(sessionsToRecord);
								lblCalories.setText(String.valueOf(df.format(calBurned)) + " Calories");
								
								double altUp = avgAltitudeUp(sessionsToRecord);
								lblMetres_1.setText(String.valueOf(df.format(altUp)) + " Metres");
								
								double altDown = avgAltitudeDown(sessionsToRecord);
								lblMetres_2.setText(String.valueOf(df.format(altDown)) + " Metres");
								card.show(mainPanel, "Records");
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							card.show(mainPanel, "recordError");
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					card.show(mainPanel, "recordError");
				}
					
			}
		});
		btnGetRecords.setBounds(59, 217, 209, 23);
		byDate.add(btnGetRecords);
		
		JButton btnBack_7 = new JButton("Back");
		btnBack_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "RecordOption");
			}
		});
		btnBack_7.setBounds(363, 218, 209, 23);
		byDate.add(btnBack_7);
		
		beforeBox = new JComboBox();
		beforeBox.setBounds(299, 85, 240, 20);
		byDate.add(beforeBox);
		
		afterBox = new JComboBox();
		afterBox.setBounds(299, 127, 240, 20);
		byDate.add(afterBox);
		
		JLabel lblSelectDateInterval = new JLabel("Select Date interval, From Date 1 to Date 2");
		lblSelectDateInterval.setBounds(57, 11, 550, 14);
		byDate.add(lblSelectDateInterval);
		
		JPanel Records = new JPanel();
		mainPanel.add(Records, "Records");
		Records.setLayout(null);
		
		JLabel lblAverageDistance = new JLabel("Average Distance:");
		lblAverageDistance.setBounds(10, 11, 217, 14);
		Records.add(lblAverageDistance);
		
		JLabel lblAveragePace = new JLabel("Average Pace:");
		lblAveragePace.setBounds(10, 36, 217, 14);
		Records.add(lblAveragePace);
		
		JLabel lblCaloriesBurned = new JLabel("Calories Burned:");
		lblCaloriesBurned.setBounds(10, 61, 217, 14);
		Records.add(lblCaloriesBurned);
		
		JLabel lblAverageAltitudeUp = new JLabel("Average Altitude Up: ");
		lblAverageAltitudeUp.setBounds(10, 86, 217, 14);
		Records.add(lblAverageAltitudeUp);
		
		JLabel lblAverageAltitudeDown = new JLabel("Average Altitude Down:");
		lblAverageAltitudeDown.setBounds(10, 111, 217, 14);
		Records.add(lblAverageAltitudeDown);
		
		lblMetres = new JLabel("metres");
		lblMetres.setBounds(366, 11, 270, 14);
		Records.add(lblMetres);
		
		lblSecondmetre = new JLabel("second/metre");
		lblSecondmetre.setBounds(366, 36, 270, 14);
		Records.add(lblSecondmetre);
		
		lblCalories = new JLabel("Calories");
		lblCalories.setBounds(366, 61, 270, 14);
		Records.add(lblCalories);
		
		lblMetres_1 = new JLabel("Metres");
		lblMetres_1.setBounds(366, 86, 270, 14);
		Records.add(lblMetres_1);
		
		lblMetres_2 = new JLabel("Metres");
		lblMetres_2.setBounds(366, 111, 270, 14);
		Records.add(lblMetres_2);
		
		JButton btnBack_8 = new JButton("Back");
		btnBack_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, "Statistics");
			}
		});
		btnBack_8.setBounds(221, 221, 235, 23);
		Records.add(btnBack_8);
		
		JPanel RecordError = new JPanel();
		mainPanel.add(RecordError, "recordError");
		RecordError.setLayout(null);
		
		JLabel lblInvalidDatesSelected = new JLabel("Invalid Dates Selected");
		lblInvalidDatesSelected.setBounds(236, 11, 355, 14);
		RecordError.add(lblInvalidDatesSelected);
		
		JButton btnBack_9 = new JButton("Back");
		btnBack_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(mainPanel, "RecordOption");
			}
		});
		btnBack_9.setBounds(205, 234, 206, 23);
		RecordError.add(btnBack_9);
		

		
		

	}
	
	//public void populateTable(UserApp currentUser, JTable table) {
		//String [] datColumns = {"Time", "Distance", "Altitude"};
		//Object[][] data = {{"Calories", new Integer(30), new Integer(62), new Integer(92)}
	//}
	//this method will take in a list of sessions and return all the sessions that have the given month
	public ArrayList<Session> getSessionsFromMonth(ArrayList<Session> allSessions, String month){
		ArrayList<Session> sessionsInRange = new ArrayList<Session>();
		String[] thisDate;
		for(Session curSession:allSessions){
			thisDate = curSession.getDate().split("-");
			if(thisDate[1].equals(month)){
				sessionsInRange.add(curSession);
			}
		}
		return sessionsInRange;
	}
	
	//this method will take in two dates as strings and will return a boolean denoting whether the first date comes after the second date
	public boolean isBefore(String before, String after) throws ParseException {
		DateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		Date beforeDate = sdf.parse(before);
		Date afterDate = sdf.parse(after);
		boolean beforeBefore;
		if(beforeDate.before(afterDate)) {
			beforeBefore = true;
		}
		else {
			beforeBefore = false;
		}
		
		return beforeBefore;
	}
	
	//This method will take in a list of sessions, and two dates as strings, and return a list of sessions whos dates fall between the two
	public ArrayList<Session> getSessionsFromDays(ArrayList<Session> allSessions, String firstDate, String secondDate) throws ParseException{
		ArrayList<Session> sessionsInRange = new ArrayList<Session>();
		DateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		Date beforeDate = sdf.parse(firstDate);
		Date afterDate = sdf.parse(secondDate);
		Date thisSessionDate;
		String thisSessionString;
		
		
		for(Session curSession:allSessions){
			thisSessionString = curSession.getDate();
			thisSessionDate = sdf.parse(thisSessionString);
			if(thisSessionDate.equals(beforeDate) || thisSessionDate.equals(afterDate) || (thisSessionDate.after(beforeDate) && thisSessionDate.before(afterDate))){
				sessionsInRange.add(curSession);
			}
		}
		
		
		return sessionsInRange;
	}
	
	//This method will take in a Scanner object that is reading the data file, and will return a list of session objects gotten from parsing this file
	public static ArrayList<Session> readSessionsFromData(Scanner fileToRead){
		ArrayList<Double> tempTimeList = new ArrayList<Double>();
		ArrayList<Double> tempDistanceList= new ArrayList<Double>();
		ArrayList<Double> tempAltitudeList= new ArrayList<Double>();
		String tempDate;
		ArrayList<Session> tempSessions = new ArrayList<Session>();
		Session tempSession;
		String strToRead;
		String[] strToAssign;
		strToRead = fileToRead.nextLine();
		while(fileToRead.hasNextLine()){
			strToAssign = strToRead.split(",");
			tempDate = strToAssign[3];
			tempTimeList.add(Double.parseDouble(strToAssign[0]));
			tempDistanceList.add(Double.parseDouble(strToAssign[1]));
			tempAltitudeList.add(Double.parseDouble(strToAssign[2]));
			strToRead = fileToRead.nextLine();
			while(!(strToRead.substring(0,1).equals("0")) && fileToRead.hasNextLine()){
				strToAssign = strToRead.split(",");
				tempTimeList.add(Double.parseDouble(strToAssign[0]));
				tempDistanceList.add(Double.parseDouble(strToAssign[1]));
				tempAltitudeList.add(Double.parseDouble(strToAssign[2]));
				strToRead = fileToRead.nextLine();
			}
			
			tempSession = new Session(tempDate, tempTimeList, tempDistanceList, tempAltitudeList);
			tempSessions.add(tempSession);
			tempDate = strToAssign[3];
			tempTimeList = new ArrayList<Double>();
			tempDistanceList = new ArrayList<Double>();
			tempAltitudeList = new ArrayList<Double>();
		}
		return tempSessions;
	}
	
	//This is the method that will read in data in CSV form. To be used, the Scanner passed into it must have the NEXT LINE be the FIRST DATA POINT (e.g (0,0,0))
	//that means that before this method is used, you must parse the file you are reading from to get to the proper start, and then pass the scanner to the method when it is in the aforementioned state
	//The date passed in must be the date used as a header for the data in the user file.
	public static Session readSessionsFromUser(Scanner fileToRead, String date){
		String reportDate = date;


		ArrayList<Double> tempTimeList = new ArrayList<Double>();
		ArrayList<Double> tempDistanceList= new ArrayList<Double>();
		ArrayList<Double> tempAltitudeList= new ArrayList<Double>(); 
		Session tempSession;
		String strToRead;
		String[] strToAssign;
		while(fileToRead.hasNextLine()){
			strToRead = fileToRead.nextLine();
			//If the next string is in the proper format, read it for data, otherwise finish loop
			if(!(strToRead.charAt(0) == 'e')){
				strToRead = strToRead.substring(1, strToRead.length()-1);
				strToAssign = strToRead.split(",");
				tempTimeList.add(Double.parseDouble(strToAssign[0]));
				tempDistanceList.add(Double.parseDouble(strToAssign[1]));
				tempAltitudeList.add(Double.parseDouble(strToAssign[2]));
			}
			else{
				break;
			}

		}
		tempSession = new Session(reportDate, tempTimeList, tempDistanceList, tempAltitudeList);
		return tempSession;
	}
	
	//Method to add all dates from current users sessions to a combo box
	public void DateDayCombo(JComboBox dayBox, UserApp currentUser){
		String thisDate;
		ArrayList<String> datesAlready = new ArrayList<String>();
		dayBox.removeAllItems();
		
		for(Session thisSession : currentUser.getSessionList()){
			thisDate = (thisSession.getDate());
			if(!(datesAlready.contains(thisDate))){
				dayBox.addItem(thisDate);
				datesAlready.add(thisDate);
			}
		}
	}
	
	//Method to add all device names of current user to a combo box
	public void DeviceCombo(JComboBox deviceBox, UserApp currentUser){
		String thisDevice;
		for(Device currentDevice: currentUser.getDeviceList()){
			deviceBox.addItem(currentDevice.getDate());
		}
		
	}
	
		
	//method to get the average distance from a list of sessions
	public double avgDistance(ArrayList<Session> listOfSessions){
		double totalDistances = 0;
		int i = 0;
		while (i<listOfSessions.size()){
			//int distances.add(listOfSessions[i].getTotalDistance)
			totalDistances += listOfSessions.get(i).getTotalDistance();
			i++;
		}
		//int totalDistances = distances[1]+distances[2] + ... distances[n]
		double avgDistance = (totalDistances / listOfSessions.size());
		return avgDistance;
	}

	//method to get the average pace from a list of sessions
	public double avgPace(ArrayList<Session> listOfSessions){
		//distance / time

		double totalDistances = 0;
		double totalTimes = 0;
		int i = 0;
		while (i<listOfSessions.size()){
			//int distances.add(listOfSessions[i].getTotalDistance)
			totalDistances = (totalDistances + listOfSessions.get(i).getTotalDistance());
			totalTimes = (totalTimes + listOfSessions.get(i).getTotalTime());
			i++;
		}
		double avgPace = (totalDistances / totalTimes);
		return avgPace;
	}

	//Method to get the average calories burned from a list of sessions
	public double avgCaloriesBurned(ArrayList<Session> listOfSessions){
		//average = 60 calories per km	
		double totalDistance = 0;
		int i = 0;
		while (i<listOfSessions.size()){
			//int distances.add(listOfSessions[i].getTotalDistance)
			totalDistance = (totalDistance + listOfSessions.get(i).getTotalDistance());
			i++;
		}
		double avgCaloriesBurned = totalDistance * 0.06;
		return avgCaloriesBurned;
	}

	//Method to get the average upward altitude from a list of sessions 
	public double avgAltitudeUp(ArrayList<Session> listOfSessions){
		int i = 0;
		double totalUpAlt = 0;
		while (i<listOfSessions.size()){
			totalUpAlt = (totalUpAlt + listOfSessions.get(i).getUpAltitude());
			i++;
		}
		double avgUpAlt = 0;
		avgUpAlt = (totalUpAlt / listOfSessions.size());
		return avgUpAlt;
	}

	//Method to get the average downward altitude from a list of sessions
	public double avgAltitudeDown(ArrayList<Session> listOfSessions){
		int i = 0;
		double totalDownAlt = 0;
		while (i<listOfSessions.size()){
			totalDownAlt = (totalDownAlt + listOfSessions.get(i).getDownAltitude());
			i++;
		}
		double avgDownAlt = 0;
		avgDownAlt = (totalDownAlt / listOfSessions.size());
		return avgDownAlt;
	}
	//Method to read all data from current session that should be in the JTable, and return a 2-D array with this info
	//for all sessions
	public Object[][] newJtable( ArrayList<Session> listOfSessions) {
		String[] columnNames = {"Session#", "Date", "Time(s)", "Distance(m)", "Alt Up(m)", "Alt Down(m)"};
		Object[][] data = new Object[listOfSessions.size()][6];
		for(int i = 0; i < listOfSessions.size(); i++) {
			
			data[i][0] = i;
			data[i][1] = listOfSessions.get(i).getDate();
			data[i][2] = listOfSessions.get(i).getTotalTime();
			data[i][3] = listOfSessions.get(i).getTotalDistance();
			data[i][4] = listOfSessions.get(i).getUpAltitude();
			data[i][5] = listOfSessions.get(i).getDownAltitude();
		}
		return data;
	}

}





