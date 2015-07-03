package medicalinfo;

import java.util.ArrayList;

public class ExerciseController {
	static ExerciseDB edb = new ExerciseDBPersistent();

	public static void save(Exercise exercise) {
		//TODO if authenticated is user
		edb.save(exercise);
	}
	
	public static ArrayList<Exercise> getExerciseByDate(int low, int high, String startDate, String endDate)
	{
		return edb.getExerciseByDate(low, high, startDate, endDate);
	}
	

}
