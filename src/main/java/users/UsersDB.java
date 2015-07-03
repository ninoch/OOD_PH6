package users;

import java.util.List;


import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;


public interface UsersDB {
	
	public Users getByUserName(String username2);
	public List<Users> search_users_by_name(String name, boolean isActive);
	public List<Patient> search_patients_by_name(String name, boolean isActive);
	public void save(Users m);
	public void merge(Users m);
	public boolean login(String username, String password);
	public List<Doctor> get_doctors_by_name(String name, boolean isGeneral);
	public <E> List<E> find_the_one_contain_this_name(String name, List<E> gd);
	public List<Patient> get_my_patient(String docUser, String patName);
	public List<Doctor> searchSpecialDoctors(String name,
			 String specialty);

}
