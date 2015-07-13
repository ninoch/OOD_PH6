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
		PrescriptionController.save(this);
	}
	public void add_drug(String name, int dose)
	{
//		new Drug(name, dose, DiseaseId);
		DrugDBController.save(new Drug(name, dose, DiseaseId));
	}
	public Long getDiseaseId() {
		return DiseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		DiseaseId = diseaseId;
	}
	public List<Drug> getAllDrugs() {
		return DrugDBController.getAllDrugs(id);
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long _id) {
		this.id = _id;
	}
	
	public String toString() {
		
		return new StringBuffer(" id: ")
	 	   .append(String.valueOf(id))
	 	   .append(" DiseaseId: ")
	 	   .append(String.valueOf(DiseaseId))
	 	   .append(" date: ")
	 	   .append(this.date)
	 	   .toString();
	}

}