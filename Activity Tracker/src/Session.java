import java.util.ArrayList;

public class Session{
		
		private float calories;
		private float heartRate;
		private float dehydration;
		private String date;
		/**
		 * @param calories
		 * @param heartRate
		 * @param dehydration
		 * @param date
		 */
		public Session(float calories, float heartRate, float dehydration, String date) {
			this.calories = calories;
			this.heartRate = heartRate;
			this.dehydration = dehydration;
			this.date = date;
		}
		
		//this method will take in all the changed data that the user gives and update the current session
		private void updateSession(float calories, float heartRate, float dehydration, String date) {
			
		}
		
		
	}