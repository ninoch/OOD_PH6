package medicalinfo;

import java.util.ArrayList;

public interface ExerciseDB {

	void save(Exercise exercise);

	ArrayList<Exercise> getExerciseByDate(int low, int high,
			String startDate, String endDate);
	ArrayList<Exercise> getAllExercise(String username);

}
