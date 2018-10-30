import java.awt.List;

public class UserApp {
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String password;
	private List friendsList = new List();
	private List sessionList = new List();
	private List deviceList = new List();
	
	public UserApp(String firstName, String lastName, String fullName, String password, List friendsList,
			List sessionList, List deviceList) {
		super();
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
	 * @return the friendsList
	 */
	public List getFriendsList() {
		return friendsList;
	}
	/**
	 * @return the sessionList
	 */
	public List getSessionList() {
		return sessionList;
	}
	/**
	 * @return the deviceList
	 */
	public List getDeviceList() {
		return deviceList;
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
	/**
	 * @param friendsList the friendsList to set
	 */
	public void setFriendsList(List friendsList) {
		this.friendsList = friendsList;
	}
	/**
	 * @param sessionList the sessionList to set
	 */
	public void setSessionList(List sessionList) {
		this.sessionList = sessionList;
	}
	/**
	 * @param deviceList the deviceList to set
	 */
	public void setDeviceList(List deviceList) {
		this.deviceList = deviceList;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
