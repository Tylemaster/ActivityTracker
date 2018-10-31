
public class RunningSession extends Session {
	private float aveSpeed;
	private float cumDistance;

	public RunningSession(float calories, float heartRate, float dehydration, String date, float aveSpeed, float cumDistance) {
		super(calories, heartRate, dehydration, date);
		this.aveSpeed = aveSpeed;
		this.cumDistance = cumDistance;
	}
	
	//this method will take in all the changed data that the user gives and update the current session
	private void updateSession(float calories, float heartRate, float dehydration, String date, float aveSpeed, float cumDistance) {
		
	}

}
