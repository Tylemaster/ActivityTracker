import java.util.ArrayList;

public class Swim extends Session {
	private ArrayList<Float> swimSpeed;
	private ArrayList<Float> cumDistance;
	public Swim(String date, ArrayList<Float> Time, ArrayList<Float> distance, ArrayList<Float> altitude, ArrayList<Float> swimSpeed, ArrayList<Float> cumDistance) {
		super(date, Time, distance, altitude);
		// TODO Auto-generated constructor stub
		this.swimSpeed = swimSpeed;
		this.cumDistance = cumDistance;
	}
	

}
