package medicalinfo.diseaseandcure;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Consult implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String azki;
	private String towho;
	private String date;
	private String msg;
	private boolean read;
	private String title;
	
	public Consult(String azki, String towho, String date, String msg, String title){
		this.setAzki(azki);
		this.setTowho(towho);
		this.setDate(date);
		this.setMsg(msg);
		read = (false);
		this.setTitle(title);
//		ConsultController.save(this);
	}
	public Consult(){
		
	}
	public String getAzki() {
		return azki;
	}
	public void setAzki(String azki) {
		this.azki = azki;
	}
	public String getTowho() {
		return towho;
	}
	public void setTowho(String towho) {
		this.towho = towho;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public void make_read() {
		setRead(true);
		ConsultController.merge(this);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
