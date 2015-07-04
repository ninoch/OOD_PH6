package medicalinfo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class BodyInfo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String docUser;
	private String patUser;
	private int height;
	private int weight;
	private double bloodPressure;
	private int bloodSugar;
	private String date;
	
	public BodyInfo(String _docUser, String _patUser, int _height, int _weight
			, double _bloodPressure, int _bloodSugar, String _date) {
		docUser = _docUser;
		patUser = _patUser;
		height = _height;
		weight = _weight;
		bloodPressure = _bloodPressure;
		bloodSugar = _bloodSugar;
		date = _date;
//		BodyInfoController.save(this);
	}
	public BodyInfo() {
		
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public int getBloodSugar() {
		return bloodSugar;
	}
	public void setBloodSugar(int bloodSugar) {
		this.bloodSugar = bloodSugar;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
