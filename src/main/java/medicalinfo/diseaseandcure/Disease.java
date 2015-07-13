package medicalinfo.diseaseandcure;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Disease implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String docUser;
	private String patUser;
	private String name;
	private String symptoms;
	private String date;
	
	public Disease(String doc, String pat, String name, String symp, String _date) {
		docUser = doc;
		patUser = pat;
		this.name = name;
		symptoms = symp;
		this.date = _date;
		
//		DiseaseController.save(this);
//		new Prescription(id, _date);
//		DiseaseController.save(this);
		DiseaseController.saveit(this);
		PrescriptionController.save(new Prescription(id, _date));
		
	}
	
	public Disease(){
		
	}
	public String getDocUser() {
		return docUser;
	}
	public void setDocUser(String docUser) {
		this.docUser = docUser;
	}
	public String getPatUser() {
		return patUser;
	}
	public void setPatUser(String patUser) {
		this.patUser = patUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSyptoms() {
		return symptoms;
	}
	public void setSyptoms(String syptoms) {
		this.symptoms = syptoms;
	}
	public void add_drug(String name_drug, int dose) {
		Prescription p = PrescriptionController.find(id);
		p.add_drug(name_drug, dose);
	}
	
	public void setId(Long _id) {
		this.id = _id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String toString() {
		return new StringBuffer(" id: ")
	 	   .append(String.valueOf(id))
	 	   .append(" docUser: ")
	 	   .append(this.docUser)
	 	   .append(" patUser: ")
	 	   .append(this.patUser)
	 	   .append(" name: ")
	 	   .append(this.name)
	 	   .append(" symptoms: ")
	 	   .append(this.symptoms)
	 	   .append(" date: ")
	 	   .append(this.date)
	 	   .toString();
	}
}