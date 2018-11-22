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
	
	public Float getTotalTime(){
		Float totTime = time.get(time.size() - 1);
		return totTime;
	}
	
	public Float getTotalDistance(){
		Float totDist = distance.get(distance.size() - 1);
		return totDist;
	}
	
	public Float getUpAltitude(){
		Float lastAlt = (float) 0;
		Float tempAlt = (float) 0;
		Float altUp = (float) 0;
		for(int i = 1; i < altitude.size(); i++){
			tempAlt = altitude.get(i);
			if(tempAlt - lastAlt > 0){
				altUp += tempAlt - lastAlt;
			}
			lastAlt = altitude.get(i);
		}
		return altUp;
	}
	
	public Float getDownAltitude(){
		Float lastAlt = (float) 0;
		Float tempAlt = (float) 0;
		Float altDown = (float) 0;
		for(int i = 1; i < altitude.size(); i++){
			tempAlt = altitude.get(i);
			if(tempAlt - lastAlt < 0){
				altDown += tempAlt - lastAlt;
			}
			lastAlt = altitude.get(i);
		}
		return altDown;
	}


}
		
	//this method will take in all the changed data that the user gives and update the current session
