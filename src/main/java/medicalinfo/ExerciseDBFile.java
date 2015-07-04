package medicalinfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDBFile implements ExerciseDB {
	int exsNum = 0;
	
	private List<Exercise> readExercise() {
		System.err.println("ExesNums: " + exsNum);
		if(exsNum == 0)
			return new ArrayList<Exercise>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("Statics/DB/Exercise.ser"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Exercise> ls = new ArrayList<Exercise>();
		for(int i = 0; i < exsNum; i++)
		{
			try {
				ls.add((Exercise) ois.readObject());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("Exercise " + ls.get(i).getCalory() + " read from DB! ");
		}
		try {
			if(ois != null)
				ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void save(Exercise exercise) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Exercise.ser", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			oos.writeObject(exercise);
			System.err.println("Exercise " + exercise.getCalory() + " " + " Added to DB!");
			exsNum ++;
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }finally {
			   if(oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
	}

	/****************** EASY *******************/
	
	@Override
	public ArrayList<Exercise> getExerciseByDate(int low, int high,
			String startDate, String endDate) {
		ArrayList<Exercise> ls = new ArrayList<Exercise>();
		for(Exercise e : readExercise())
			if(e.getStartTime().compareTo(startDate) < 0
					&& e.getEndTime().compareTo(endDate) > 0
					&& low <= e.getCalory()
					&& e.getCalory() <= high )
				ls.add(e);
		return ls;
	}

	@Override
	public ArrayList<Exercise> getAllExercise(String username) {
		ArrayList<Exercise> ls = new ArrayList<Exercise>();
		for(Exercise e : readExercise())
			if(e.getPatUser().equals(username))
				ls.add(e);
		return ls;
	}
}
