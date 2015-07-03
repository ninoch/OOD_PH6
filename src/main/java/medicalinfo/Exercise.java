package medicalinfo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Exercise implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patUser;
	private String type;
	private int minutes;
	private String startTime;
	private String endTime;
	private int calory;
	private String date;
	public Exercise(String patUser, String type, int minutes, String startTime, String endTime, int calory
			, String date){
		this.patUser=patUser;
		this.type=type;
		this.minutes=minutes;
		this.startTime=startTime;
		this.endTime=endTime;
		this.calory=calory;
		this.date=date;
		ExerciseController.save(this);
	}
	public Exercise(){
		
	}
	public String getPatUser() {
		return patUser;
	}
	public void setPatUser(String patUser) {
		this.patUser = patUser;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getCalory() {
		return calory;
	}
	public void setCalory(int calory) {
		this.calory = calory;
	}
	
	
}
