package users;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Medicate implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fromDoctorUser;
	private String toDoctorUser;
	private String patientUser;
	private boolean isAccepted;
	public Medicate(String d, String p){
		fromDoctorUser = "";
		toDoctorUser = d;
		patientUser = p;
		isAccepted = false;
		MedicateController.save(this);
	}
	public Medicate(String from, String to, String patient)
	{
		fromDoctorUser = from;
		toDoctorUser = to;
		patientUser = patient;
		isAccepted = false;
		MedicateController.save(this);
	}
	
	public Medicate()
	{
		toDoctorUser = "";
		isAccepted = false;
		patientUser = "";
	}
	public boolean getIsAccepted()
	{
		return isAccepted;
	}
	public String getFromDoctor() {
		return fromDoctorUser;
	}
	public String getToDoctor() {
		return toDoctorUser;
	}
	public String getPatient() {
		return patientUser;
	}
	public void setIsAccepted(boolean b) {
		isAccepted = b;
	}
}
