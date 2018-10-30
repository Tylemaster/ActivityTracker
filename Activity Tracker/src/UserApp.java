import java.awt.List;
import java.util.ArrayList;

public class UserApp {
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String password;
	private ArrayList<String> friendsList;
	private ArrayList<String> sessionList;
	private ArrayList<String> deviceList;

	/**
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param password
	 * @param friendsList
	 * @param sessionList
	 * @param deviceList
	 */
	public UserApp(String firstName, String lastName, String fullName, String password, ArrayList<String> friendsList,
			ArrayList<String> sessionList, ArrayList<String> deviceList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.password = password;
		this.friendsList = friendsList;
		this.sessionList = sessionList;
		this.deviceList = deviceList;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public class FriendsList extends UserApp{
		
		private boolean viewUserList;
		private boolean viewFriendsList;
		private boolean viewProfile;
		private boolean sendRequest;
		private boolean acceptRequest;
		private boolean denyRequest;
		
		public FriendsList(String firstName, String lastName, String fullName, String password,
				ArrayList<String> friendsList, ArrayList<String> sessionList, ArrayList<String> deviceList) 
		{
			super(firstName, lastName, fullName, password, friendsList, sessionList, deviceList);
			// TODO Auto-generated constructor stub
		}
		
	}
	public class Session extends UserApp{
		
		private float calories;
		private float heartRate;
		private float aveSpeed;
		private float dehydration;
		private float cumDistance;
		private String date;
		
		public Session(String firstName, String lastName, String fullName, String password,
				ArrayList<String> friendsList, ArrayList<String> sessionList, ArrayList<String> deviceList) {
			super(firstName, lastName, fullName, password, friendsList, sessionList, deviceList);
			// TODO Auto-generated constructor stub
		}

		
		
	}
	public static void main(String[] args) {
		

	}

}
