import java.util.ArrayList;

public class Session{
	private String date;		
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

	private ArrayList<Float> time;
	private ArrayList<Float> distance;
	private ArrayList<Float> altitude;


	
	public Session(String date, ArrayList<Float> Time, ArrayList<Float> distance, ArrayList<Float> altitude) {
		this.time = Time;
		this.distance = distance;
		this.altitude = altitude;
		this.date = date;
	}
	
	//this method will take in all the changed data that the user gives and update the current session
	private void updateSession(ArrayList<Float> time, ArrayList<Float> distance, ArrayList<Float> altitude) {
		
	
	}
}
		
	//this method will take in all the changed data that the user gives and update the current session
