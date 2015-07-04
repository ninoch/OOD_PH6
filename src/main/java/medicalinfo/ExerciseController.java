package medicalinfo;

import java.util.ArrayList;
import users.MedicateController;

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
	
	public static ArrayList<Exercise> get_all_exercise(String username, String username2) 
	{
		if(!MedicateController.has_access(username, username2))
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		return edb.getAllExercise(username2);
	}
}
