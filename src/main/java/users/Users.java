package users;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import medicalinfo.BodyInfo;
import medicalinfo.BodyInfoController;
import medicalinfo.Exercise;
import medicalinfo.ExerciseController;
import medicalinfo.diseaseandcure.Consult;
import medicalinfo.diseaseandcure.ConsultController;
import medicalinfo.diseaseandcure.Disease;
import medicalinfo.diseaseandcure.DiseaseController;
import users.reporters.patient.*;
import users.reporters.doctor.*;

@SuppressWarnings("serial")
@Entity
public abstract class Users implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
	@Id
	private String username;
	private String password;
	private String address;
	private String name;
	private String forgetQuestion;
	private String tel;
	private String forgetAnswer;
	private String familyname;
	private boolean isActivated;
	private String type;
	
	public Users(String username, String password, String address, String tel,
			String name, String familyname,
			String forgetQuestion, String forgetAnswer) throws Exception{
		if(!validate_username(username))
			throw new Exception("Username is not in correct format.");
		if(!validate_names(name) || !validate_names(familyname))
			throw new Exception("Please write your real name / familyname.");
		if(!validate_tel(tel)) 
			throw new Exception("Tellphone have at least 6 digits.");
		
		this.username = username;
		this.password = password;
		this.address = address;
		this.name = name;
		this.forgetQuestion = forgetQuestion;
		this.tel = tel;
		this. forgetAnswer = forgetAnswer;
		this.familyname = familyname;
		this.isActivated = false;
	}
	
	public Users() {
	}
	
	public ArrayList<BodyInfo> get_all_body_info(String username){
		return BodyInfoController.get_all_body_info(getUsername(), username);
	}
	public ArrayList<Disease> get_all_disease(String username){
		return DiseaseController.get_all_disease(getUsername(), username);
	}
	
	public ArrayList<Exercise> get_all_exercise(String username) {
		return ExerciseController.get_all_exercise(getUsername(), username);
	}

	private boolean validate_names(String f) {
		for(int i = 0; i < f.length(); i++)
			if(!(('a' <= f.charAt(i) && f.charAt(i) <= 'z') || ( 'A' <= f.charAt(i) && f.charAt(i) <= 'Z')))
				return false;
		return true;
	}

	private boolean validate_tel(String tel2) {
		if(tel2.length() < 7)
			return false;
		for(int i = 0; i < tel2.length(); i++)
			if(!('0' <= tel2.charAt(i) && tel2.charAt(i) <= '9'))
				return false;
		return true;
	}

	private boolean validate_username(String username2) {
		 if(username2.length() == 0)
			 return false;
			 if('0' <= username2.charAt(0) && username2.charAt(0) <= '9')
			 return false;
			 for(int i = 0; i < username2.length(); i++)
			 if(! (('0' <= username2.charAt(i) && username2.charAt(i) <= '9') 
			 || ('a' <= username2.charAt(i) && username2.charAt(i) <= 'z') 
			 || ('A' <= username2.charAt(i) && username2.charAt(i) <= 'Z') ) )
			 return false;
		if(UsersController.getByUserName(username2) != null)
			return false;
		return true;
	}
	public void make_a_consult(String otherName, String date, String msg, String title){
		new Consult(getUsername(), otherName, date, msg, title);
	}
	public ArrayList<Consult> show_all_consult_list(){
		return ConsultController.get_all_consult(getUsername());
	}
	public void read_consult(Consult c){
		c.make_read();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForgetQuestion() {
		return forgetQuestion;
	}
	public void setForgetQuestion(String forgetQuestion) {
		this.forgetQuestion = forgetQuestion;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getForgetAnswer() {
		return forgetAnswer;
	}
	public void setForgetAnswer(String forgetAnswer) {
		this.forgetAnswer = forgetAnswer;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public void confirm() {
		this.isActivated = true;
	}

	public boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	/*
	@Id
	private String username;
	private String password;
	private String address;
	private String name;
	private String forgetQuestion;
	private String tel;
	private String forgetAnswer;
	private String familyname;
	private boolean isActivated;
	private String type;
	docId;
	isGeneral
	specialty
 */
	@Override 
	public String toString() {
		String pid = " ";
		if(this.type.equals("Patient"))
			pid = String.valueOf(((Patient)this).getPersonId());
		String isGen = String.valueOf(false);
		if(this.type.equals("GeneralDoctor"))
			isGen = String.valueOf(true);
		String esp = " ";
		if(this.type.equals("SepecialDoctor"))
			esp = ((SpecialDoctor)this).getSpecialty();
		String did = " ";
		if(this.type.equals("SepecialDoctor") || this.type.equals("GeneralDoctor"))
			did = String.valueOf(((Doctor)this).getDocId());
		
		return new StringBuffer(" username: ")
 	   .append(this.username)
 	   .append(" password: ")
 	   .append(this.password)
 	   .append(" address: ")
 	   .append(this.address)
 	   .append(" tel: ")
 	   .append(this.tel)
 	   .append(" name:" )
 	   .append(this.name)
 	   .append(" familyname: ")
 	   .append(this.familyname)
 	   .append(" forgetQuestion: ")
 	   .append(this.forgetQuestion)
 	   .append(" forgetAnswer: ")
 	   .append(this.forgetAnswer)
 	   .append(" isActivated: ")
 	   .append(String.valueOf(this.isActivated))
 	   .append(" type: ")
 	   .append(this.type)
 	   .append(" DocId: ")
 	   .append(did)
 	   .append(" isGeneral: ")
 	   .append(isGen)
 	   .append(" specialty: ")
 	   .append(esp)
 	   .append(" persondId: ")
 	   .append(pid)
 	   .toString();
	}
}


