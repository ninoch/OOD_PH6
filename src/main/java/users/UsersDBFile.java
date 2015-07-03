package users;

import java.util.List;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

public class UsersDBFile implements UsersDB {

	@Override
	public Users getByUserName(String username2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> search_users_by_name(String name, boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> search_patients_by_name(String name, boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Users m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(Users m) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Doctor> get_doctors_by_name(String name, boolean isGeneral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> find_the_one_contain_this_name(String name, List<E> gd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> get_my_patient(String docUser, String patName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> searchSpecialDoctors(String name, String specialty) {
		// TODO Auto-generated method stub
		return null;
	}

}
