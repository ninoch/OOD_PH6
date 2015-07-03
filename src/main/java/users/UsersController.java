package users;

import java.util.List;
import users.reporters.doctor.Doctor;

public class UsersController {
	public List<Doctor> getAllSpecials(){
		return UsersDB.get_doctors_by_name("", false);
	}
	public List<Doctor> search_special_doctor(String name, String specialty){
		return UsersDB.searchSpecialDoctors(name, specialty);
	}
}
