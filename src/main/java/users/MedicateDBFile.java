package users;

import java.util.ArrayList;
import java.util.List;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

public class MedicateDBFile implements MedicateDB {

	@Override
	public ArrayList<Patient> patient_from_doctor(String doctor,
			boolean isaccept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicate> get_medicate_doctor(String doctor, boolean isaccept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicate find_medicate(String doctor, String patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicate find_medicate(String from, String to, String patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Patient> get_doctor_patient(String docName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Medicate m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(Medicate m) {
		// TODO Auto-generated method stub

	}

	@Override
	public Medicate find_general_doctor(String patientUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Medicate m) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Medicate> findAllRefs(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Doctor> findAllDoctors(String patUser, boolean accepted) {
		// TODO Auto-generated method stub
		return null;
	}

}
