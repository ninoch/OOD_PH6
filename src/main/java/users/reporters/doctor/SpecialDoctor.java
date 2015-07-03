package users.reporters.doctor;

import java.util.ArrayList;
import javax.persistence.Entity;
import users.Medicate;
import users.MedicateController;
import users.UsersDB;

@SuppressWarnings("serial")
@Entity
public class SpecialDoctor extends Doctor{
	private String specialty;
	
	public SpecialDoctor(String specialty, int docId, String username, String password,
			String address, String tel, String name, String familyname,
			String forgetQuestion, String forgetAnswer) throws Exception {
		
		super(docId, username, password, address, tel, name, familyname,
				forgetQuestion, forgetAnswer);
		this.setType("SepecialDoctor");
		this.specialty = specialty;
		UsersDB.save(this);
		
	}
	public SpecialDoctor(){
		
	}
	public ArrayList<Medicate> showAllRefs(){
		return MedicateController.showAllRef(this.getUsername());
	}
	public void acceptOrReject(Medicate m, boolean accept)
	{
		if(!accept){
			MedicateController.remove(m);
		}
		else
		{
			m.setIsAccepted(accept);
			MedicateController.merge(m);
		}
	}
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

}
