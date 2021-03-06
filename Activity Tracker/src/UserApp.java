import java.awt.List;
import java.util.ArrayList;
import java.util.*;

public class UserApp {
	

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

	 * @param fullName
	 * @param password
	 * @param friendsList
	 * @param sessionList.
	 * @param deviceList
	 */
	public UserApp(String fullName, String password) {
		this.fullName = fullName;
		this.password = password;
		this.friendsList = new ArrayList<Friends>();
		this.sessionList = new ArrayList<Session>();
		this.deviceList = new ArrayList<Device>();
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
	
	public ArrayList<Session> getSessionList(){
		return sessionList;
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
	
	 /* @param friendsList the friendsList to set
	 */
	public void setFriendsList(ArrayList<Friends> friendsList) {
		this.friendsList = friendsList;
	}
	
	 /* @param sessionsList the sessionsList to set
	 */
	public void setSessionsList(ArrayList<Session> sessionList) {
		this.sessionList = sessionList;
	}
	
	 /* @param deviceList the deviceList to set
	 */
	public void setDeviceList(ArrayList<Device> deviceList) {
		this.deviceList = deviceList;
	}
	
	
	//This method will send a request to a new friend
	public void sendRequest(){
		
	}
	
	//This method enables the user to accept request
	public void acceptRequest(){
		
	}
	
	//This method enables the user to deny request
	public void denyRequest(){
		
	}
	
	//add session to users session list
	public void updateSessionList(Session newSession) {
		this.sessionList.add(newSession);
	}
	
	//add device to users device list
	public void updateDeviceList(Device newDevice) {
		this.deviceList.add(newDevice);
	}

}
