package medicalinfo;

import java.util.ArrayList;

import users.LoginedUser;
import users.MedicateController;

public class ExerciseController {
	static ExerciseDB edb ;
	public static void setType(String i) {
		switch (i) {
		case "file":
			edb = new ExerciseDBFile();
			break;

		default:
			edb = new ExerciseDBPersistent();
			break;
		}
	}

	public static void save(Exercise exercise) {
		//TODO if authenticated is user
		edb.save(exercise);
	}
	
	public static ArrayList<Exercise> getExerciseByDate(int low, int high, String startDate, String endDate)
	{
		ArrayList<Exercise> res = edb.getExerciseByDate(low, high, startDate, endDate);
		for(Exercise e : res){
			if(!MedicateController.is_medicating(LoginedUser.getUser().getUsername(), e.getPatUser()))
				res.remove(e);
		}
		return res;
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
