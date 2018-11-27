import java.util.ArrayList;

public class Swim extends Session {
	private ArrayList<Double> swimSpeed;
	private ArrayList<Double> cumDistance;
	public Swim(String date, ArrayList<Double> Time, ArrayList<Double> distance, ArrayList<Double> altitude, ArrayList<Double> swimSpeed, ArrayList<Double> cumDistance) {
		super(date, Time, distance, altitude);
		// TODO Auto-generated constructor stub
		this.swimSpeed = swimSpeed;
		this.cumDistance = cumDistance;
	}
	

}
