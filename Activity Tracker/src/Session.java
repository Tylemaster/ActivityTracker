import java.util.ArrayList;

public class Session{
	private String date;	
	private ArrayList<Float> time;
	private ArrayList<Float> distance;
	private ArrayList<Float> altitude;

	public Session(String date, ArrayList<Float> Time, ArrayList<Float> distance, ArrayList<Float> altitude) {
		this.time = Time;
		this.distance = distance;
		this.altitude = altitude;
		this.date = date;
	}
	
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	public ArrayList<Float> getTime() {
		return time;
	}


	public void setTime(ArrayList<Float> time) {
		this.time = time;
	}


	public ArrayList<Float> getDistance() {
		return distance;
	}


	public void setDistance(ArrayList<Float> distance) {
		this.distance = distance;
	}


	public ArrayList<Float> getAltitude() {
		return altitude;
	}


	public void setAltitude(ArrayList<Float> altitude) {
		this.altitude = altitude;
	}


	//this method will take in all the changed data that the user gives and update the current session
	private void updateSession(ArrayList<Float> time, ArrayList<Float> distance, ArrayList<Float> altitude) {
		
	}
}
		
	//this method will take in all the changed data that the user gives and update the current session
