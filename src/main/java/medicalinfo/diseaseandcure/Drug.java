package medicalinfo.diseaseandcure;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Drug implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int dose;
	private Long PresId;
	public Drug(String name, int dose, long presId){
		this.name = name;
		this.dose = dose;
		setPresId(presId);
		DrugDBController.save(this);
	}
	public Drug() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}
	public Long getPresId() {
		return PresId;
	}
	public void setPresId(Long presId) {
		PresId = presId;
	}
	
	public String toString() {
		return new StringBuffer(" id: ")
	 	   .append(String.valueOf(id))
	 	   .append(" name: ")
	 	   .append(this.name)
	 	   .append(" dose: ")
	 	   .append(this.dose)
	 	   .append(" PresId: ")
	 	   .append(this.PresId)
	 	   .toString();
	}
	
}
