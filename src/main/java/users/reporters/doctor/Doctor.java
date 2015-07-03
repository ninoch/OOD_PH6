package users.reporters.doctor;

import java.util.ArrayList;
import javax.persistence.Entity;
import medicalinfo.BodyInfo;
import medicalinfo.diseaseandcure.Disease;
import medicalinfo.diseaseandcure.DiseaseController;
import users.MedicateController;
import users.Users;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
@Entity
public abstract class Doctor extends Users{
	private int DocId;
	public Doctor(int docId, String username, String password, String address, 
			String tel, String name, String familyname, String forgetQuestion,
			String forgetAnswer) throws Exception{
		super(username, password, address, tel, name, familyname, forgetQuestion, forgetAnswer);
		this.setDocId(docId);
	}
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	public void insert_body_info(String _patUser, int _height, int _weight
			, float _bloodPressure, int _bloodSugar, String _date){
		new BodyInfo(getUsername(), _patUser, _height, _weight, _bloodPressure, _bloodSugar, _date);
	}
	public void make_refr(String doc, String pat){
		MedicateController.NewRefrence(getUsername(), doc, pat);
	}
	public ArrayList<Patient> get_unaccepted_requests()
	{
		return MedicateController.patient_from_doctor(this.getUsername(), false);
	}
	public void add_disease(String patientUsername, String DiseaseName, String DiseaseSymptom, String date){
		new Disease(this.getUsername(), patientUsername, DiseaseName, DiseaseSymptom, date);
	}
	
	public boolean add_drug(String disName, String patUser, String name, int dose){
		Disease d = DiseaseController.getDisease(getUsername(), patUser, disName);
		if(!has_access_to(d))
			return false;
		d.add_drug(name, dose);
		return true;
		
	}
	
	
	private boolean has_access_to(Disease d) {
		return d.getDocUser().equals(this.getUsername());
	}
	public int getDocId() {
		return DocId;
	}

	public void setDocId(int docId) {
		DocId = docId;
	}
	
}
