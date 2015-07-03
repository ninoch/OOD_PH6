package users;

import java.util.ArrayList;

import users.reporters.doctor.Doctor;
import users.reporters.patient.Patient;

public class MedicateController {
	static MedicateDB mdb = new MedicateDBPersistent();
	public static boolean is_medicating(String doc, String pat) {
		ArrayList<Patient> listP = mdb.patient_from_doctor(doc, true);
		for(Patient p: listP)
		{
			if(p.getUsername().equals(pat))
				return true;
		}
		return false;
		
	}
	public static Medicate find_medicate(String username, String username2) {
		return mdb.find_medicate(username, username2);
	}
	public static void remove(Medicate rm) {
		mdb.remove(rm);
	}
	public static ArrayList<Patient> patient_from_doctor(String username,
			boolean b) {
		return mdb.patient_from_doctor(username, b);
	}
	public static void merge(Medicate m) {
		mdb.merge(m);
	}
	public static Medicate find_general_doctor(String patUser) {
		return mdb.find_general_doctor(patUser);
	}
	public static void save(Medicate medicate) {
		mdb.save(medicate);
	}
	public static ArrayList<Patient> get_doctor_patient(String docUser) {
		return mdb.get_doctor_patient(docUser);
	}
	public static boolean has_access(String username, String username2) {
		return MedicateController.is_medicating(username, username2) || 
				username.equals(username2) ||
				username.equals("admin");
	}
	public static void NewRefrence(String thisDoc, String other, String pat) {
		if(!is_medicating(thisDoc, pat))
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		new Medicate(thisDoc, other, pat);
	}
	public static ArrayList<Medicate> showAllRef(String username) {
		return mdb.findAllRefs(username);
	}
	
	public static ArrayList<Doctor> findAllDoctors(String patUser, boolean accepted){
		 return mdb.findAllDoctors(patUser, accepted);
	}
}
