package medicalinfo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDBFile implements ExerciseDB {
	private List<Exercise> allExes = null;
	
	private List<Exercise> readExercise() {
		if(allExes == null)
		{
			allExes = new ArrayList<Exercise>();
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("Statics/DB/Exercise.ser"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(EOFException e){
				return allExes;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(true)
			{
				try {
					Object obj = ois.readObject(); 
					if(obj instanceof Exercise)
						allExes.add((Exercise)(ois.readObject()));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(EOFException e) {
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allExes;
	}
	
	private void SaveChanges() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("Statics/DB/Exercise.ser", false));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(allExes);
		} catch (IOException e) {
			e.printStackTrace();
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

	@Override
	public void save(Exercise exercise) {
		if(allExes == null)
			readExercise();
		allExes.add(exercise);
		System.err.println("Exercise " + exercise.getCalory() + " Added to DB! " );
		SaveChanges();	
	}

	/****************** EASY *******************/
	
	@Override
	public ArrayList<Exercise> getExerciseByDate(int low, int high,
			String startDate, String endDate) {
		ArrayList<Exercise> ls = new ArrayList<Exercise>();
		for(Exercise e : readExercise())
			if(e.getDate().compareTo(startDate) >= 0
					&& e.getDate().compareTo(endDate) <= 0
					&& e.getCalory() >= low
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
