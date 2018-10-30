import java.util.ArrayList;

public class Session{
		
		private float calories;
		private float heartRate;
		private float aveSpeed;
		private float dehydration;
		private float cumDistance;
		private String date;
		private Activity activityType;
		/**
		 * @param calories
		 * @param heartRate
		 * @param aveSpeed
		 * @param dehydration
		 * @param cumDistance
		 * @param date
		 * @param activityType
		 */
		public Session(float calories, float heartRate, float aveSpeed, float dehydration, float cumDistance,
				String date, Activity activityType) {
			this.calories = calories;
			this.heartRate = heartRate;
			this.aveSpeed = aveSpeed;
			this.dehydration = dehydration;
			this.cumDistance = cumDistance;
			this.date = date;
			this.activityType = activityType;
		}
		
		
	}