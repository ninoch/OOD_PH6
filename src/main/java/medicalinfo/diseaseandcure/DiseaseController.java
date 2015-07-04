package medicalinfo.diseaseandcure;

import java.util.ArrayList;
import java.util.List;

import users.LoginedUser;
import users.MedicateController;
import users.Users;

public class DiseaseController {
	static DiseaseDB ddb;
	public static void setType(String i) {
		switch (i) {
		case "file":
			ddb = new DiseaseDBFile();
			break;

		default:
			ddb = new DiseaseDBPersistent();
			break;
		}
	}

	public static ArrayList<Disease> get_all_disease(String username,
			String username2) {
		if(!MedicateController.has_access(username, username2))
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		return ddb.getAllDisease(username2);
	}

	public static void save(Disease disease) {
		if(!LoginedUser.getUser().getUsername().equals(disease.getDocUser()))
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ddb.save(disease);
	}

	public static Disease getDisease(String docUser, String patUser,
			String disName) {
		if(!LoginedUser.getUser().getUsername().equals(docUser) && 
				!LoginedUser.getUser().getUsername().equals(patUser))
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ddb.getDisease(docUser, patUser, disName);
	}
	public static ArrayList<Disease> getDiseaseByDate(String name, 
			String startDate, String endDate){
		Users a = LoginedUser.getUser();
		return ddb.getDiseaseByDate(a.getUsername(), name, startDate, endDate);
	}
	
	public static List<Drug> getAllDrugs(long disID){
		
		return ddb.getAllDrugs(disID);
	}

	 
}
