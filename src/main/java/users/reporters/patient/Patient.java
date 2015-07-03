package users.reporters.patient;

import javax.persistence.Entity;

import medicalinfo.Exercise;
import medicalinfo.ExerciseController;
import register.RegisterList;
import users.Medicate;
import users.Users;
import users.UsersDB;

@SuppressWarnings("serial")
@Entity
public class Patient extends Users{
	
	private int PersonId;
	public Patient(int personId, String username, String password, String address, 
			String tel, String name, String familyname, String forgetQuestion, 
			String forgetAnswer) throws Exception{
		super(username, password, address, tel, name, familyname, forgetQuestion, forgetAnswer);
		this.setType("Patient");
		this.setPersonId(personId);
		RegisterList.add(this);
		UsersDB.save(this);
	}
	public Patient()
	{
		super();
	}
	public int getPersonId() {
		return PersonId;
	}
	public void setPersonId(int personId) {
		PersonId = personId;
	}
	public void choose_general_doctor(String docuser){
		new Medicate(docuser, this.getUsername());
	}
	public void addExercise(String type, int minutes, String startTime, String endTime, int calory, String date){
		ExerciseController.save(new Exercise(getUsername(), type, minutes, startTime, endTime, calory, date));
	}
}
