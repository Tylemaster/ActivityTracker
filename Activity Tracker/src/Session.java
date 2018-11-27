import java.util.ArrayList;

public class Session{
	private String date;	
	private ArrayList<Double> time;
	private ArrayList<Double> distance;
	private ArrayList<Double> altitude;

	public Session(String date, ArrayList<Double> Time, ArrayList<Double> distance, ArrayList<Double> altitude) {
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


	public ArrayList<Double> getTime() {
		return time;
	}


	public void setTime(ArrayList<Double> time) {
		this.time = time;
	}


	public ArrayList<Double> getDistance() {
		return distance;
	}


	public void setDistance(ArrayList<Double> distance) {
		this.distance = distance;
	}


	public ArrayList<Double> getAltitude() {
		return altitude;
	}


	public void setAltitude(ArrayList<Double> altitude) {
		this.altitude = altitude;
	}
	
	public double getTotalTime(){
		double totTime = time.get(time.size() - 1);
		return totTime;
	}
	
	public double getTotalDistance(){
		double totDist = distance.get(distance.size() - 1);
		return totDist;
	}
	
	public double getUpAltitude(){
		double lastAlt = (float) 0;
		double tempAlt = (float) 0;
		double altUp = (float) 0;
		for(int i = 1; i < altitude.size(); i++){
			tempAlt = altitude.get(i);
			if(tempAlt - lastAlt > 0){
				altUp += tempAlt - lastAlt;
			}
			lastAlt = altitude.get(i);
		}
		return altUp;
	}
	
	public double getDownAltitude(){
		double lastAlt = (float) 0;
		double tempAlt = (float) 0;
		double altDown = (float) 0;
		for(int i = 1; i < altitude.size(); i++){
			tempAlt = altitude.get(i);
			if(tempAlt - lastAlt < 0){
				altDown += -(tempAlt - lastAlt);
			}
			lastAlt = altitude.get(i);
		}
		return altDown;
	}


}
		
	//this method will take in all the changed data that the user gives and update the current session
