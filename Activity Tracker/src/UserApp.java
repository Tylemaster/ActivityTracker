import java.awt.List;
import java.util.ArrayList;
import java.util.*;

public class UserApp {
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String password;
	private ArrayList<Friends> friendsList;
	private ArrayList<Session> sessionList;
	private ArrayList<Device> deviceList;

	/**
	 * @return the deviceList
	 */
	public ArrayList<Device> getDeviceList() {
		return deviceList;
	}
	/**
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param password
	 * @param friendsList
	 * @param sessionList
	 * @param deviceList
	 */
	public UserApp(String firstName, String lastName, String fullName, String password, ArrayList<Friends> friendsList,
			ArrayList<Session> sessionList, ArrayList<Device> deviceList) {
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
	
	 /* @param deviceList the deviceList to set
	 */
	public void setDeviceList(ArrayList<Device> deviceList) {
		this.deviceList = deviceList;
	}
	
	
	//This method send a request to a new friend
	public void sendRequest(){
		
	}
	
	//This method enables the user to accept request
	public void acceptRequest(){
		
	}
	
	//This method enables the user to deny request
	public void denyRequest(){
		
	}
	

}
