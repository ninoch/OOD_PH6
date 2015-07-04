package medicalinfo.diseaseandcure;

import java.util.ArrayList;

import users.LoginedUser;
import users.MedicateController;
import users.Users;

public class ConsultController {
	static ConsultDB cdb;

	public static void save(Consult consult) {
		if(!MedicateController.is_medicating(consult.getTowho(), consult.getAzki()) && 
				!MedicateController.is_medicating(consult.getAzki(), consult.getTowho()) )
			try {
				throw new Exception("Doctor is not medicating thisPatient");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		cdb.save(consult);
	}

	public static void merge(Consult consult) {
		if(!MedicateController.is_medicating(consult.getTowho(), consult.getAzki()) && 
				!MedicateController.is_medicating(consult.getAzki(), consult.getTowho()) )
			try {
				throw new Exception("Doctor is not medicating thisPatient");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		cdb.merge(consult);
	}

	public static ArrayList<Consult> get_all_consult(String username) {
		Users u = LoginedUser.getUser();
		if(!u.getUsername().equals(username))
		{
			try {
				throw new Exception("You have no access");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cdb.get_all(username);
	}

	public static void setType(String i) {
		switch (i) {
		case "file":
			cdb = new ConsultDBFile();
			break;

		default:
			cdb = new ConsultDBPersistent();
			break;
		}
	}


}
