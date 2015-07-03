package medicalinfo.diseaseandcure;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Prescription implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long DiseaseId;
	private String date;
	public Prescription() {
		// TODO Auto-generated constructor stub
	}
	public Prescription(Long disease, String _date) {
		this.DiseaseId = disease;	
		this.setDate(_date);
		PrescriptionDB.save(this);
	}
	public void add_drug(String name, int dose)
	{
		new Drug(name, dose, DiseaseId);
	}
	public Long getDiseaseId() {
		return DiseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		DiseaseId = diseaseId;
	}
	public List<Drug> getAllDrugs() {
		return DrugDB.getAllDrugs(id);
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}