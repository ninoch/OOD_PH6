package users;

import java.util.List;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

public class UsersController {
	static UsersDB udb;
	public static void setType(String i) {
		switch (i) {
		case "file":
			udb = new UsersDBFile();
			break;

		default:
			udb = new UsersDBPersistent();
			break;
		}
	}
	public List<Doctor> getAllSpecials(){
		return udb.get_doctors_by_name("", false);
	}
	public List<Doctor> search_special_doctor(String name, String specialty){
		return udb.searchSpecialDoctors(name, specialty);
	}
	public static void save(Users user) {
		udb.save(user);
		
	}
	public static Users getByUserName(String username) {
		return udb.getByUserName(username);
	}
	public static boolean login(String text, String text2) {
		return udb.login(text, text2);
	}
	public static List<Doctor> get_doctors_by_name(String string, boolean b) {
		return udb.get_doctors_by_name(string, b);
	}
	public static List<Patient> search_patients_by_name(String string, boolean b) {
		return udb.search_patients_by_name(string, b);
	}
	public static void merge(Users rm) {
		udb.merge(rm);
	}
	public static List<Users> search_users_by_name(String string, boolean b) {
		return udb.search_users_by_name(string, b);
	}
	public static List<Patient> get_my_patient(String username, String query) {
		return udb.get_my_patient(username, query);
	}
	public static List<Doctor> searchSpecialDoctors(String text, String text2) {
		return udb.searchSpecialDoctors(text, text2);
	}
}
