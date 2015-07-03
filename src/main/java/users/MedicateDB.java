package users;

import java.util.ArrayList;
import java.util.List;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;


public interface MedicateDB {
	public ArrayList<Patient> patient_from_doctor(String doctor, boolean isaccept);
	public List<Medicate> get_medicate_doctor(String doctor, boolean isaccept);
	public Medicate find_medicate(String doctor, String patient) ;
	
	public Medicate find_medicate(String from, String to, String patient);
	public ArrayList<Patient> get_doctor_patient(String docName);

	public void save(Medicate m) ;
	public void merge(Medicate m) ;
	public Medicate find_general_doctor(String patientUser) ;
	public void remove(Medicate m) ;
	public ArrayList<Medicate> findAllRefs(String username);
	public ArrayList<Doctor> findAllDoctors(String patUser, boolean accepted);
}