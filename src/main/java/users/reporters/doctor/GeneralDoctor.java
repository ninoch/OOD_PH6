package users.reporters.doctor;

import javax.persistence.Entity;

import com.jvmhub.tutorial.App;

import users.Medicate;
import users.MedicateController;
import users.UsersController;
import users.reporters.patient.Patient;

@SuppressWarnings("serial")
@Entity
public class GeneralDoctor extends Doctor{
	
	public boolean isGeneral = true;
	public GeneralDoctor(int docId, String username, String password,
			String address, String tel, String name, String familyname,
			String forgetQuestion, String forgetAnswer) throws Exception {
		super(docId, username, password, address, tel, name, familyname,
				forgetQuestion, forgetAnswer);
		this.setType("GeneralDoctor");
		isGeneral = true;
		UsersController.save(this);
	}
	public GeneralDoctor(){
		super();
	}
	public boolean accept_patient(String patUser){
		System.err.println("PatUser: " + patUser);
		Patient p = (Patient) UsersController.getByUserName(patUser);
		Medicate m = MedicateController.find_medicate(this.getUsername(), p.getUsername());
		if(m == null)
		{
			return false;
		}
//		System.out.println(m.getDoctor() + "kiana jigar");
//		m.setDoctor("khare gav");
		Medicate last = MedicateController.find_general_doctor(patUser);
//		App.error("chi migi to " + last.getDoctor());
		App.error("salam azizam" + (last == null));
		if(last != null)
		{
			App.error("shenkhtam ghablio");
			MedicateController.remove(last);
		}
		m.setIsAccepted(true);

		MedicateController.merge(m);
		return true;
	}

}
